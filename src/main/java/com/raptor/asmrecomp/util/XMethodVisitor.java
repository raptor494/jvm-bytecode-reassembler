package com.raptor.asmrecomp.util;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class XMethodVisitor {
	protected MethodVisitor visitor;
	
	public XMethodVisitor(MethodVisitor methodVisitor) {
		this.visitor = methodVisitor;
	}
	
	public void visitEnd() {
		visitor.visitEnd();
	}

}
