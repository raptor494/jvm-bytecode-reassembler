package com.raptor.asmrecomp;

import java.io.File;

import org.junit.jupiter.api.Test;


class Test01 {
	//private static final CustomClassLoader cl = new CustomClassLoader();

	@Test
	void test02() throws Exception {
		var source = ASMRecompiler.preprocess(new File("testfiles/Test02.jvmasm"));
		var nameAndBytes = ASMRecompiler.reassemble(source, "testfiles/Test02.jvmasm", true);
		var clazz = ASMRecompiler.load(nameAndBytes.a, nameAndBytes.b);
//		
//		System.out.println(clazz);
//		System.out.println(Arrays.toString(clazz.getTypeParameters()));
		
		clazz.getMethod("run").invoke(null);

	}

}
