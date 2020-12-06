package com.raptor.asmrecomp.util;

import java.util.function.Consumer;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.TypeReference;

public class XRecordComponentVisitor {
	protected RecordComponentVisitor visitor;
	
	public XRecordComponentVisitor(RecordComponentVisitor recordComponentVisitor) {
		this.visitor = recordComponentVisitor;
	}

	/**
	 * Visits an annotation of the record component.
	 *
	 * @param descriptor
	 *            the class descriptor of the annotation class.
	 * @param visible
	 *            {@literal true} if the annotation is visible at runtime.
	 * @param callback
	 *            A callback which accepts a visitor to visit the annotation
	 *            values, or {@literal null} if this visitor is not interested
	 *            in visiting this annotation.
	 */
	public XRecordComponentVisitor visitAnnotation(
		String descriptor,
		boolean visible,
		Consumer<? super XAnnotationVisitor> callback
	) {
		var av = new XAnnotationVisitor(visitor.visitAnnotation(descriptor, visible));
		if (callback != null) callback.accept(av);
		av.visitEnd();
		return this;
	}

	/**
	 * Visits an annotation on a type in the record component signature.
	 *
	 * @param typeRef
	 *            a reference to the annotated type. The sort of this type
	 *            reference must be {@link TypeReference#CLASS_TYPE_PARAMETER},
	 *            {@link TypeReference#CLASS_TYPE_PARAMETER_BOUND} or
	 *            {@link TypeReference#CLASS_EXTENDS}. See
	 *            {@link TypeReference}.
	 * @param typePath
	 *            the path to the annotated type argument, wildcard bound, array
	 *            element type, or static inner type within 'typeRef'. May be
	 *            {@literal null} if the annotation targets 'typeRef' as a
	 *            whole.
	 * @param descriptor
	 *            the class descriptor of the annotation class.
	 * @param visible
	 *            {@literal true} if the annotation is visible at runtime.
	 * @param callback
	 *            A callback which accepts a visitor to visit the annotation
	 *            values, or {@literal null} if this visitor is not interested
	 *            in visiting this annotation.
	 */
	public XRecordComponentVisitor visitTypeAnnotation(
		int typeRef,
		TypePath typePath,
		String descriptor,
		boolean visible,
		Consumer<? super XAnnotationVisitor> callback
	) {
		var av = new XAnnotationVisitor(visitor.visitTypeAnnotation(typeRef, typePath, descriptor, visible));
		if (callback != null) callback.accept(av);
		return this;
	}
	
	/**
	 * Visits a non standard attribute of the record component.
	 *
	 * @param attribute
	 *            an attribute.
	 */
	public XRecordComponentVisitor visitAttribute(Attribute attribute) {
		visitor.visitAttribute(attribute);
		return this;
	}

	/**
	 * Visits the end of the record component. This method, which is the last
	 * one to be called, is used to inform the visitor that everything have been
	 * visited.
	 */
	public void visitEnd() {
		visitor.visitEnd();
	}
	
}
