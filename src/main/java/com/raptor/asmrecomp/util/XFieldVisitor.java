package com.raptor.asmrecomp.util;

import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

public class XFieldVisitor extends FieldVisitor {
	
	public XFieldVisitor(FieldVisitor fieldVisitor) {
		super(Opcodes.ASM9, fieldVisitor);
	}
	
	public XFieldVisitor(int api, FieldVisitor fieldVisitor) {
		super(api, fieldVisitor);
	}
	
}
