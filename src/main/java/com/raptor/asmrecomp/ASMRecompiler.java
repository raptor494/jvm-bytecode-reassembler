package com.raptor.asmrecomp;

import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V14;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import org.anarres.cpp.DefaultPreprocessorListener;
import org.anarres.cpp.Feature;
import org.anarres.cpp.FileLexerSource;
import org.anarres.cpp.InputLexerSource;
import org.anarres.cpp.LexerException;
import org.anarres.cpp.Preprocessor;
import org.anarres.cpp.Source;
import org.anarres.cpp.StringLexerSource;
import org.anarres.cpp.Token;
import org.anarres.cpp.Warning;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.Pair;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.util.TraceClassVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import joptsimple.OptionParser;

public class ASMRecompiler {
	private static final Logger LOG = LoggerFactory.getLogger(ASMRecompiler.class);
	private static final CustomClassLoader cl = new CustomClassLoader();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		var optionParser = new OptionParser();
		var helpOption = optionParser.accepts("help", "Displays command-line help.").forHelp();
		var versionOption = optionParser.acceptsAll(Arrays.asList("version"), "Displays the product version and exits.").forHelp();

		var debugOption = optionParser.acceptsAll(Arrays.asList("debug"), "Enables debug output.");

		var defineOption = optionParser.acceptsAll(Arrays.asList("define", "D"), "Defines the given macro.")
			.withRequiredArg().ofType(String.class).describedAs("name[=definition]");
		var undefineOption = optionParser
			.acceptsAll(Arrays.asList("undefine", "U"),
				"Undefines the given macro, previously either builtin or defined using -D.")
			.withRequiredArg().describedAs("name");
		var includeOption = optionParser
			.accepts("include",
				"Process file as if \"#" + "include \"file\"\" appeared as the first line of the primary source file.")
			.withRequiredArg().ofType(File.class).describedAs("file");
		var incdirOption = optionParser
			.acceptsAll(Arrays.asList("incdir", "I"),
				"Adds the directory dir to the list of directories to be searched for header files.")
			.withRequiredArg().ofType(File.class).describedAs("dir");
		var iquoteOption = optionParser.acceptsAll(Arrays.asList("iquote"),
			"Adds the directory dir to the list of directories to be searched for header files included using \"\".")
			.withRequiredArg().ofType(File.class).describedAs("dir");
		var warningOption = optionParser
			.acceptsAll(Arrays.asList("warning", "W"), "Enables the named warning class (" + getWarnings() + ").")
			.withRequiredArg().ofType(String.class).describedAs("warning");
		var noWarningOption = optionParser.acceptsAll(Arrays.asList("no-warnings", "w"), "Disables ALL warnings.");
		var outputOption = optionParser.acceptsAll(Arrays.asList("out", "o"), "Output file").withRequiredArg()
			.ofType(File.class).describedAs("file");

		var inputsOption = optionParser.nonOptions().ofType(File.class).describedAs("Files to process.");

		var options = optionParser.parse(args);

		if (options.has(helpOption)) {
			optionParser.printHelpOn(System.out);
			return;
		}

		if (options.has(versionOption)) {
			version(System.out);
			return;
		}

		String source;
		Source inputSource = null;
		try (var pp = new Preprocessor()) {
			pp.addFeature(Feature.DIGRAPHS);
			pp.addFeature(Feature.TRIGRAPHS);
			pp.addWarning(Warning.IMPORT);
			var listener = new DefaultPreprocessorListener();
			pp.setListener(listener);

			if (options.has(debugOption))
				pp.addFeature(Feature.DEBUG);

			if (options.has(noWarningOption))
				pp.getWarnings().clear();

			for (String warning : options.valuesOf(warningOption)) {
				warning = warning.toUpperCase();
				warning = warning.replace('-', '_');
				if (warning.equals("ALL"))
					pp.addWarnings(EnumSet.allOf(Warning.class));
				else pp.addWarning(Enum.valueOf(Warning.class, warning));
			}

			addDefaultMacros(pp);
			for (String arg : options.valuesOf(defineOption)) {
				int idx = arg.indexOf('=');
				if (idx == -1)
					pp.addMacro(arg);
				else pp.addMacro(arg.substring(0, idx), arg.substring(idx + 1));
			}
			for (String arg : options.valuesOf(undefineOption)) {
				pp.getMacros().remove(arg);
			}

			for (File dir : options.valuesOf(incdirOption))
				pp.getSystemIncludePath().add(dir.getAbsolutePath());
			for (File dir : options.valuesOf(iquoteOption))
				pp.getQuoteIncludePath().add(dir.getAbsolutePath());
			for (File file : options.valuesOf(includeOption))
				// Comply exactly with spec.
				pp.addInput(new StringLexerSource("#" + "include \"" + file + "\"\n"));

			List<File> inputs = options.valuesOf(inputsOption);

			if (inputs.isEmpty()) {
				pp.addInput(inputSource = new InputLexerSource(System.in));
			}
			else {
				for (File input : inputs) {
					var src = new FileLexerSource(input);
					if (inputSource == null)
						inputSource = src;
					pp.addInput(src);
				}
			}

			if (pp.getFeature(Feature.DEBUG)) {
				LOG.info("#" + "include \"...\" search starts here:");
				for (String dir : pp.getQuoteIncludePath())
					LOG.info("  " + dir);
				LOG.info("#" + "include <...> search starts here:");
				for (String dir : pp.getSystemIncludePath())
					LOG.info("  " + dir);
				LOG.info("End of search list.");
			}

			var sb = new StringBuilder();

			try {
				for (;;) {
					Token tok = pp.token();
					if (tok == null)
						break;
					if (tok.getType() == Token.EOF)
						break;
					if (listener.getErrors() > 0) {
						System.exit(1);
						return;
					}
					sb.append(tok.getText());
				}
			}
			catch (Exception e) {
				LOG.error("Preprocessor failed", e);
				System.exit(1);
				return;
			}

			source = sb.toString();
		}

		var lexer = new ASMLexer(CharStreams.fromString(source, inputSource.getName()));
		lexer.addErrorListener(new DiagnosticThrowingErrorListener());
		var tokens = new CommonTokenStream(lexer);
		var parser = new ASMParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		if (options.has(debugOption)) {
			parser.debugEnabled(true);
			System.out.println("Debug enabled.");
		}

		var unit = parser.compilationUnit();
		var bytes = unit.cw.toByteArray();
		cl.defineClass(unit.name, bytes);

		OutputStream output;
		if (options.has(outputOption)) {
			output = new BufferedOutputStream(new FileOutputStream(options.valueOf(outputOption)));
		} else {
			var path = inputSource.getPath();
			if (path == null) {
				output = System.out;
			} else {
				output = new BufferedOutputStream(new FileOutputStream(path));
			}
		}
		
		try (output) {
			output.write(bytes);
		}

//		var Test_class = createTestClass();
//		
//		System.out.println(Test_class);
//		
//		var Test$foo = Test_class.getMethod("foo", List.class);
//		
//		Test$foo.invoke(null, List.of(1, 2, 3, 4));

//		var Container_class = createContainerClass();
//		
//		System.out.println(Container_class);
//		
//		var Container$constructor = Container_class.getConstructor(Object.class);
//		var Container$set_method = Container_class.getMethod("set", Object.class);
//		var Container$get_method = Container_class.getMethod("get");
//		
//		var container = Container$constructor.newInstance("Hello, world!");
//		System.out.println(Container$get_method.invoke(container));
//		
//		Container$set_method.invoke(container, "Goodbye, world!");
//		System.out.println(Container$get_method.invoke(container));

	}

	private static void addDefaultMacros(Preprocessor pp) throws LexerException {
		pp.addMacro("LAMBDA_METAFACTORY", "invokestatic java.lang.invoke.LambdaMetafactory.metafactory: (java.lang.invoke.MethodHandles$Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.invoke.MethodType, java.lang.invoke.MethodHandle, java.lang.invoke.MethodType) java.lang.invoke.CallSite");
		pp.addMacro("ALT_LAMBDA_METAFACTORY", "invokestatic java.lang.invoke.LambdaMetafactory.altMetafactory: (java.lang.invoke.MethodHandles$Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.invoke.CallSite");
	}

	private static class DiagnosticThrowingErrorListener extends DiagnosticErrorListener {

		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
			throw e;
		}

	}

	public static String preprocess(String source) throws IOException, LexerException {
		var pp = new Preprocessor();
		pp.addInput(new InputLexerSource(new StringReader(source)));
		return preprocess(pp);
	}

	public static String preprocess(File sourceFile) throws IOException, LexerException {
		var pp = new Preprocessor();
		pp.addInput(sourceFile);
		return preprocess(pp);
	}

	public static String preprocess(Source source) throws IOException, LexerException {
		var pp = new Preprocessor(source);
		pp.addInput(source);
		return preprocess(pp);
	}

	private static String preprocess(Preprocessor pp) throws IOException, LexerException {
		addDefaultMacros(pp);
		pp.addFeature(Feature.DIGRAPHS);
		pp.addFeature(Feature.TRIGRAPHS);
		pp.addWarning(Warning.IMPORT);
		var listener = new DefaultPreprocessorListener();
		pp.setListener(listener);

		var sb = new StringBuilder();

		for (;;) {
			Token tok = pp.token();
			if (tok == null)
				break;
			if (tok.getType() == Token.EOF)
				break;
			if (listener.getErrors() > 0) {
				throw new RuntimeException("Preprocessor failed: " + listener.getErrors() + " errors.");
			}
			sb.append(tok.getText());
		}

		return sb.toString();
	}

	public static Pair<String /* name */, byte[]> reassemble(String source, String sourceName, boolean debugEnabled) {
		var lexer = new ASMLexer(CharStreams.fromString(source, sourceName));
		return reassemble(lexer, debugEnabled);
	}

	public static Pair<String /* name */, byte[]> reassemble(String source, String sourceName) {
		return reassemble(source, sourceName, false);
	}

	public static Pair<String /* name */, byte[]> reassemble(String source) {
		return reassemble(source, null, false);
	}

	public static Pair<String /* name */, byte[]> reassemble(File source, boolean debugEnabled) throws IOException {
		var lexer = new ASMLexer(CharStreams.fromPath(source.toPath()));
		return reassemble(lexer, debugEnabled);
	}

	public static Pair<String /* name */, byte[]> reassemble(File source) throws IOException {
		return reassemble(source, false);
	}

	public static Pair<String /* name */, byte[]> reassemble(InputStream source, boolean debugEnabled) throws IOException {
		var lexer = new ASMLexer(CharStreams.fromStream(source));
		return reassemble(lexer, debugEnabled);
	}

	public static Pair<String /* name */, byte[]> reassemble(InputStream source) throws IOException {
		return reassemble(source, false);
	}

	private static Pair<String /* name */, byte[]> reassemble(ASMLexer lexer, boolean debugEnabled) {
		lexer.addErrorListener(new DiagnosticThrowingErrorListener());
		var tokens = new CommonTokenStream(lexer);
		var parser = new ASMParser(tokens);
		parser.setErrorHandler(new BailErrorStrategy());
		parser.debugEnabled(debugEnabled);
		
		var unit = parser.compilationUnit();
		return new Pair<>(unit.name, unit.cw.toByteArray());
	}

	public static Class<?> load(String name, byte[] bytes) {
		return cl.defineClass(name, bytes);
	}

	@Nonnull
	private static CharSequence getWarnings() {
		StringBuilder buf = new StringBuilder();
		for (Warning w : Warning.values()) {
			if (buf.length() > 0)
				buf.append(", ");
			String name = w.name().toLowerCase();
			buf.append(name.replace('_', '-'));
		}
		return buf;
	}

	private static void version(@Nonnull PrintStream out) {
		out.println("ASMRecompiler version 0.0.1");
	}

	private static Class<?> createTestClass() throws NoSuchMethodException, SecurityException {
		var cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
		var cv = new TraceClassVisitor(cw, new PrintWriter(System.out));

		// public class test/Test
		{
			cv.visit(
				// version
				V14,
				// access
				ACC_PUBLIC,
				// name
				"test/Test",
				// signature
				null,
				// superName
				Type.getInternalName(Object.class),
				// interfaces
				new String[0]);
		}

		// public void <init>();
		{
			var mv = cv.visitMethod(
				// access
				ACC_PUBLIC,
				// name
				"<init>",
				// descriptor
				Type.getMethodDescriptor(Type.VOID_TYPE),
				// signature
				null,
				// exceptions
				new String[0]);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(Object.class), "<init>",
				Type.getConstructorDescriptor(Object.class.getConstructor()), false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}

		// public static void foo(List);
		{
			var sw = new SignatureWriter();
			sw.visitParameterType().visitClassType(Type.getInternalName(List.class));
			sw.visitTypeArgument('+').visitClassType(Type.getInternalName(Number.class));
			sw.visitEnd();
			sw.visitEnd();
			sw.visitReturnType().visitBaseType('V');
			System.out.println(sw.toString());
			var mv = cv.visitMethod(
				// access
				ACC_PUBLIC | ACC_STATIC,
				// name
				"foo",
				// descriptor
				Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(List.class)),
				// signature
				sw.toString(),
				// exceptions
				new String[0]);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitInvokeDynamicInsn(
				// name
				"accept",
				// descriptor
				Type.getMethodDescriptor(Type.getType(Consumer.class)),
				// bootstrapMethodHandle
				new Handle(H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
					"(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
					false),
				// bootstrapMethodArguments
				new Object[] { Type.getMethodType(Type.VOID_TYPE, Type.getType(Object.class)),
					new Handle(H_INVOKESTATIC, "test/Test", "lambda$0",
						Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Number.class)), false),
					Type.getMethodType(Type.VOID_TYPE, Type.getType(Number.class)) });
			mv.visitMethodInsn(INVOKEINTERFACE, Type.getInternalName(List.class), "forEach",
				Type.getMethodDescriptor(List.class.getMethod("forEach", Consumer.class)), true);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}

		// private static synthetic void lambda$0(Number);
		{
			var mv = cv.visitMethod(
				// access
				ACC_PRIVATE | ACC_STATIC | ACC_SYNTHETIC,
				// name
				"lambda$0",
				// descriptor
				Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Number.class)),
				// signature
				null,
				// exceptions
				new String[0]);
			mv.visitParameter("num", 0);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, Type.getInternalName(System.class), "out",
				Type.getDescriptor(PrintStream.class));
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(PrintStream.class), "println",
				Type.getMethodDescriptor(PrintStream.class.getMethod("println", Object.class)), false);
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}

		cv.visitEnd();

		byte[] bytes = cw.toByteArray();

		return cl.defineClass("test.Test", bytes);
	}

	private static Class<?> createContainerClass() throws NoSuchMethodException, SecurityException {
		var cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
		var cv = new TraceClassVisitor(cw, new PrintWriter(System.out));

		// public class test/Container<T extends java/lang/Object> extends
		// java/lang/Object;
		{
			var sw = new SignatureWriter();
			sw.visitFormalTypeParameter("T");
			sw.visitSuperclass().visitClassType(Type.getInternalName(Object.class));
			sw.visitEnd();
			cv.visit(
				// version
				V14,
				// access
				ACC_PUBLIC,
				// name
				"test/Container",
				// signature
				sw.toString(),
				// superName
				Type.getInternalName(Object.class),
				// interfaces
				new String[0]);
		}

		// private T value;
		{
			var sw = new SignatureWriter();
			sw.visitTypeVariable("T");
			cv.visitField(
				// access
				ACC_PRIVATE,
				// name
				"value",
				// descriptor
				Type.getDescriptor(Object.class),
				// signature
				sw.toString(),
				// value
				null).visitEnd();
		}

		// public void <init>(T value);
		{
			var sw = new SignatureWriter();
			sw.visitParameterType().visitTypeVariable("T");
			sw.visitReturnType().visitBaseType('V');
			var mv = cv.visitMethod(
				// access
				ACC_PUBLIC,
				// name
				"<init>",
				// descriptor
				Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Object.class)),
				// signature
				sw.toString(),
				// exceptions
				new String[0]);
			mv.visitParameter("value", ACC_FINAL);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(Object.class), "<init>",
				Type.getConstructorDescriptor(Object.class.getConstructor()), false);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitFieldInsn(PUTFIELD, "test/Container", "value", Type.getDescriptor(Object.class));
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}

		// public T get();
		{
			var sw = new SignatureWriter();
			sw.visitReturnType().visitTypeVariable("T");
			var mv = cv.visitMethod(
				// access
				ACC_PUBLIC,
				// name
				"get",
				// descriptor
				Type.getMethodDescriptor(Type.getType(Object.class)),
				// signature
				sw.toString(),
				// exceptions
				new String[0]);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETFIELD, "test/Container", "value", Type.getDescriptor(Object.class));
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}

		// public void set(T newvalue);
		{
			var sw = new SignatureWriter();
			sw.visitParameterType().visitTypeVariable("T");
			sw.visitReturnType().visitBaseType('V');
			var mv = cv.visitMethod(
				// access
				ACC_PUBLIC,
				// name
				"set",
				// descriptor
				Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Object.class)),
				// signature
				sw.toString(),
				// exceptions
				new String[0]);
			mv.visitParameter("newvalue", ACC_FINAL);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitFieldInsn(PUTFIELD, "test/Container", "value", Type.getDescriptor(Object.class));
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}

		cv.visitEnd();

		byte[] bytes = cw.toByteArray();

		return cl.defineClass("test.Container", bytes);
	}

}
