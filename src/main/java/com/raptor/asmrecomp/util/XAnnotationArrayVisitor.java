package com.raptor.asmrecomp.util;

import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;

public class XAnnotationArrayVisitor {
	protected AnnotationVisitor visitor;
	
	public XAnnotationArrayVisitor(AnnotationVisitor visitor) {
		this.visitor = visitor;
	}
	
	/**
	 * Visits a primitive value of the annotation.
	 *
	 * @param value the actual value, whose type must be {@link Byte}, {@link Boolean}, {@link
	 *     Character}, {@link Short}, {@link Integer} , {@link Long}, {@link Float}, {@link Double},
	 *     {@link String} or {@link Type} of {@link Type#OBJECT} or {@link Type#ARRAY} sort. This
	 *     value can also be an array of byte, boolean, short, char, int, long, float or double values
	 *     (this is equivalent to using {@link #visitArray} and visiting each array element in turn,
	 *     but is more convenient).
	 */
	public XAnnotationArrayVisitor visit(Object value) {
		visitor.visit(null, value);
		return this;
	}
	
	/**
	 * Visits an enumeration value of the annotation.
	 *
	 * @param descriptor the class descriptor of the enumeration class.
	 * @param value the actual enumeration value.
	 */
	public XAnnotationArrayVisitor visitEnum(String descriptor, String value) {
		visitor.visitEnum(null, descriptor, value);
		return this;
	}
	
	/**
	 * Visits a nested annotation value of the annotation.
	 *
	 * @param name the value name.
	 * @param descriptor the class descriptor of the nested annotation class.
	 * @param callback A callback which accepts a visitor to visit the actual nested annotation value, or {@literal null} if this
	 *     visitor is not interested in visiting this nested annotation.
	 */
	public XAnnotationArrayVisitor visitAnnotation(
		String descriptor,
		Consumer<? super XAnnotationVisitor> callback
	) {
		var av = new XAnnotationVisitor(this.visitor.visitAnnotation(null, descriptor));
		if (callback != null) callback.accept(av);
		av.visitEnd();
		return this;
	}
	
	/**
	 * Visits an array value of the annotation. Note that arrays of primitive
	 * types (such as byte, boolean, short, char, int, long, float or double)
	 * can be passed as value to {@link #visit visit}. This is what
	 * {@link ClassReader} does.
	 *
	 * @param callback A callback which accepts a visitor to visit the actual array value elements, or
	 *         {@literal null} if this visitor is not interested in visiting
	 *         these values.
	 */
	public XAnnotationArrayVisitor visitArray(Consumer<? super XAnnotationArrayVisitor> callback) {
		var aav = new XAnnotationArrayVisitor(this.visitor.visitArray(null));
		if (callback != null) callback.accept(aav);
		aav.visitEnd();
		return this;
	}

	/** Visits the end of the annotation. */
	public void visitEnd() {
		visitor.visitEnd();
	}
	
}
