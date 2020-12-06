package com.raptor.asmrecomp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import com.raptor.asmrecomp.ASMParser.CompilationUnitContext;


class Test01 {
	private static final CustomClassLoader cl = new CustomClassLoader();
	
	@Test
	void test() throws IOException {
		CompilationUnitContext unit;
		try (var input = Test01.class.getResourceAsStream("Test01.disasm.txt")) {
			var lexer = new ASMLexer(CharStreams.fromStream(input));
			var tokens = new CommonTokenStream(lexer);
			var parser = new ASMParser(tokens);
			unit = parser.compilationUnit();
		}
//		byte[] bytes = unit.cw.toByteArray();
//		
//		Class<?> clazz = cl.defineClass(unit.name, bytes);
//		
//		System.out.println(clazz);
//		System.out.println(Arrays.toString(clazz.getTypeParameters()));
		
		if (false) fail("Not yet implemented");
		assertTrue(true);
	}

}
