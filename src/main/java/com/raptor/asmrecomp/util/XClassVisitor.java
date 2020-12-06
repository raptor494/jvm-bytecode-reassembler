package com.raptor.asmrecomp.util;

import java.util.function.Consumer;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureWriter;

public class XClassVisitor {
	protected ClassVisitor visitor;
	
	public XClassVisitor(ClassVisitor classVisitor) {
		this.visitor = classVisitor;
	}
	
	private static String signature(Consumer<? super SignatureWriter> signatureCallback) {
		if (signatureCallback == null) return null;
		var sw = new SignatureWriter();
		signatureCallback.accept(sw);
		return sw.toString();
	}
	
	/**
	 * Visits the header of the class.
	 *
	 * @param version
	 *            the class version. The minor version is stored in the 16 most
	 *            significant bits, and the major version in the 16 least
	 *            significant bits.
	 * @param access
	 *            the class's access flags (see {@link Opcodes}). This parameter
	 *            also indicates if the class is deprecated
	 *            {@link Opcodes#ACC_DEPRECATED} or a record
	 *            {@link Opcodes#ACC_RECORD}.
	 * @param name
	 *            the internal name of the class (see
	 *            {@link Type#getInternalName()}).
	 * @param signature
	 *            the signature of this class. May be {@literal null} if the
	 *            class is not a generic one, and does not extend or implement
	 *            generic classes or interfaces.
	 * @param superName
	 *            the internal of name of the super class (see
	 *            {@link Type#getInternalName()}). For interfaces, the super
	 *            class is {@link Object}. May be {@literal null}, but only for
	 *            the {@link Object} class.
	 * @param interfaces
	 *            the internal names of the class's interfaces (see
	 *            {@link Type#getInternalName()}). May be {@literal null}.
	 */
	public XClassVisitor visit(
		int version,
		int access,
		String name,
		Consumer<? super SignatureWriter> signatureCallback,
		String superName,
		String... interfaces
	) {
		visitor.visit(version, access, superName, signature(signatureCallback), superName, interfaces);
		return this;
	}

	/**
	 * Visits a method of the class. This method <i>must</i> return a new
	 * {@link MethodVisitor} instance (or {@literal null}) each time it is
	 * called, i.e., it should not return a previously returned visitor.
	 *
	 * @param access
	 *            the method's access flags (see {@link Opcodes}). This
	 *            parameter also indicates if the method is synthetic and/or
	 *            deprecated.
	 * @param name
	 *            the method's name.
	 * @param descriptor
	 *            the method's descriptor (see {@link Type}).
	 * @param signature
	 *            the method's signature. May be {@literal null} if the method
	 *            parameters, return type and exceptions do not use generic
	 *            types.
	 * @param exceptions
	 *            the internal names of the method's exception classes (see
	 *            {@link Type#getInternalName()}). May be {@literal null}.
	 * @param callback A callback which accepts an object to visit the byte code of the method, or
	 *         {@literal null} if this class visitor is not interested in
	 *         visiting the code of this method.
	 */
	public XClassVisitor visitMethod(
		int access,
		String name,
		String descriptor,
		Consumer<? super SignatureWriter> signatureCallback,
		String[] exceptions,
		Consumer<? super XMethodVisitor> callback
	) {
		var mv = new XMethodVisitor(visitor.visitMethod(access, name, descriptor, signature(signatureCallback), exceptions));
		if (callback != null) callback.accept(mv);
		mv.visitEnd();
		return this;
	}

	/**
	 * Visits a field of the class.
	 *
	 * @param access
	 *            the field's access flags (see {@link Opcodes}). This parameter
	 *            also indicates if the field is synthetic and/or deprecated.
	 * @param name
	 *            the field's name.
	 * @param descriptor
	 *            the field's descriptor (see {@link Type}).
	 * @param signature
	 *            the field's signature. May be {@literal null} if the field's
	 *            type does not use generic types.
	 * @param value
	 *            the field's initial value. This parameter, which may be
	 *            {@literal null} if the field does not have an initial value,
	 *            must be an {@link Integer}, a {@link Float}, a {@link Long}, a
	 *            {@link Double} or a {@link String} (for {@code int},
	 *            {@code float}, {@code long} or {@code String} fields
	 *            respectively). <i>This parameter is only used for static
	 *            fields</i>. Its value is ignored for non static fields, which
	 *            must be initialized through bytecode instructions in
	 *            constructors or methods.
	 * @param callback
	 *            A callback which accepts a visitor to visit field annotations
	 *            and attributes, or {@literal null} if this class visitor is
	 *            not interested in visiting these annotations and attributes.
	 */
	public XClassVisitor visitField(
		int access,
		String name,
		String descriptor,
		Consumer<? super SignatureWriter> signatureCallback,
		Object value,
		Consumer<? super XFieldVisitor> callback
	) {
		var fv = new XFieldVisitor(visitor.visitField(access, name, descriptor, signature(signatureCallback), value));
		if (callback != null) callback.accept(fv);
		fv.visitEnd();
		return this;
	}

	/**
	 * Visits a record component of the class.
	 *
	 * @param name
	 *            the record component name.
	 * @param descriptor
	 *            the record component descriptor (see {@link Type}).
	 * @param signature
	 *            the record component signature. May be {@literal null} if the
	 *            record component type does not use generic types.
	 * @param callback A callback which accepts a visitor to visit this record component annotations and
	 *         attributes, or {@literal null} if this class visitor is not
	 *         interested in visiting these annotations and attributes.
	 */
	public XClassVisitor visitRecordComponent(
		String name,
		String descriptor,
		Consumer<? super SignatureWriter> signatureCallback,
		Consumer<? super XRecordComponentVisitor> callback
	) {
		var rcv = new XRecordComponentVisitor(visitor.visitRecordComponent(name, descriptor, signature(signatureCallback)));
		if (callback != null) callback.accept(rcv);
		rcv.visitEnd();
		return this;
	}
	
	/**
	 * Visits information about an inner class. This inner class is not
	 * necessarily a member of the class being visited.
	 *
	 * @param name
	 *            the internal name of an inner class (see
	 *            {@link Type#getInternalName()}).
	 * @param outerName
	 *            the internal name of the class to which the inner class
	 *            belongs (see {@link Type#getInternalName()}). May be
	 *            {@literal null} for not member classes.
	 * @param innerName
	 *            the (simple) name of the inner class inside its enclosing
	 *            class. May be {@literal null} for anonymous inner classes.
	 * @param access
	 *            the access flags of the inner class as originally declared in
	 *            the enclosing class.
	 */
	public XClassVisitor visitInnerClass(
		String name,
		String outerName,
		String innerName,
		int access
	) {
		visitor.visitInnerClass(name, outerName, innerName, access);
		return this;
	}

	/**
	 * Visits a permitted subclasses. A permitted subclass is one of the allowed
	 * subclasses of the current class.
	 *
	 * @param permittedSubclass
	 *            the internal name of a permitted subclass.
	 */
	public XClassVisitor visitPermittedSubclass(String permittedSubclass) {
		visitor.visitPermittedSubclass(permittedSubclass);
		return this;
	}

	/**
	 * Visits a member of the nest. A nest is a set of classes of the same
	 * package that share access to their private members. One of these classes,
	 * called the host, lists the other members of the nest, which in turn
	 * should link to the host of their nest. This method must be called only if
	 * the visited class is the host of a nest. A nest host is implicitly a
	 * member of its own nest, so it's invalid to call this method with the
	 * visited class name as argument.
	 *
	 * @param nestMember
	 *            the internal name of a nest member.
	 */
	public XClassVisitor visitNestMember(String nestMember) {
		visitor.visitNestMember(nestMember);
		return this;
	}
	
	/**
	 * Visits a non standard attribute of the class.
	 *
	 * @param attribute
	 *            an attribute.
	 */
	public XClassVisitor visitAttribute(Attribute attribute) {
		visitor.visitAttribute(attribute);
		return this;
	}
	
	/**
	 * Visits the end of the class. This method, which is the last one to be
	 * called, is used to inform the visitor that all the fields and methods of
	 * the class have been visited.
	 */
	public void visitEnd() {
		visitor.visitEnd();
	}
	
	public static byte[] classWriter(Consumer<? super ClassWriter> processor) {
		return classWriter(0, processor);
	}
	
	public static byte[] classWriter(int flags, Consumer<? super ClassWriter> processor) {
		var cw = new ClassWriter(flags);
		processor.accept(cw);
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	public static String signatureWriter(Consumer<? super SignatureWriter> processor) {
		var sw = new SignatureWriter();
		processor.accept(sw);
		return sw.toString();
	}

}
