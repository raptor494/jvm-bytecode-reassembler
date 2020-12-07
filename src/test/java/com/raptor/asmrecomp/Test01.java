package com.raptor.asmrecomp;

import java.io.FileInputStream;
import java.io.IOException;

import com.raptor.asmrecomp.ASMParser.CompilationUnitContext;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.junit.jupiter.api.Test;


class Test01 {
	private static final CustomClassLoader cl = new CustomClassLoader();
	
	@Test
	void test() throws IOException {
		CompilationUnitContext unit;
		try (var input = new FileInputStream("testfiles/Test02.jvmasm")) {
			var lexer = new ASMLexer(CharStreams.fromStream(input));
			lexer.addErrorListener(new DiagnosticErrorListener(){

				@Override
				public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
					throw e;
				}

			});
			var tokens = new CommonTokenStream(lexer);
			var parser = new ASMParser(tokens);
			parser.setErrorHandler(new BailErrorStrategy());
			// parser.addErrorListener();
			parser.debugEnabled(true);
			unit = parser.compilationUnit();
		}
//		byte[] bytes = unit.cw.toByteArray();
//		
//		Class<?> clazz = cl.defineClass(unit.name, bytes);
//		
//		System.out.println(clazz);
//		System.out.println(Arrays.toString(clazz.getTypeParameters()));
		
	}

}
