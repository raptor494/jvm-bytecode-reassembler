package com.raptor.asmrecomp;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.raptor.asmrecomp.ASMParser.CompilationUnitContext;

public class Test02 {
	private static final CustomClassLoader cl = new CustomClassLoader();
	
	public static void main(String[] args) throws Exception {
		Class<?> Test01 = compileClass("Test01.disasm.txt");
		Class<?> Test02 = compileClass("Test02.disasm.txt");
		
		var obj = Test02.getDeclaredMethod("foo").invoke(null);
		System.out.println(obj);
		System.out.println(obj.getClass());
		
//		var test02 = Test02.newInstance();
		
//		System.out.println(Test02.getDeclaredField("x").getInt(test02));
		
//		System.out.println(Test01);
//		Arrays.stream(Test01.getTypeParameters()).forEach(System.out::println);
//		Arrays.stream(Test01.getDeclaredFields()).forEach(System.out::println);
//		Arrays.stream(Test01.getDeclaredConstructors()).forEach(System.out::println);
//		Arrays.stream(Test01.getDeclaredMethods()).forEach(System.out::println);
		
	}
	
	private static Class<?> compileClass(String resourceName) throws Exception {
		CompilationUnitContext unit;
		try (var input = Test01.class.getResourceAsStream(resourceName)) {
			var lexer = new ASMLexer(CharStreams.fromStream(input));
			var tokens = new CommonTokenStream(lexer);
			var parser = new ASMParser(tokens);
			parser.setErrorHandler(new BailErrorStrategy());
			unit = parser.compilationUnit();
		}
		byte[] bytes = unit.cw.toByteArray();
		var clazz = cl.defineClass(unit.name, bytes);
		var path = Paths.get(clazz.getName().replace('.', '/') + ".class");
		path.getParent().toFile().mkdirs();
		Files.write(path, bytes);
		var pb = new ProcessBuilder("cmd", "/c", "javap14 -c -v -p " + clazz.getName());
		pb.redirectOutput(ProcessBuilder.Redirect.to(new File(path + ".disasm.txt")));
		var p = pb.start();
		p.waitFor();
		return clazz;
	}
}
