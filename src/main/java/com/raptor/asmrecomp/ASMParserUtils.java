package com.raptor.asmrecomp;

import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.text.StringEscapeUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureWriter;

import com.raptor.asmrecomp.ASMParser.*;

public class ASMParserUtils {
	
	private static abstract class BaseSignatureVisitor extends ASMParserBaseVisitor<SignatureWriter> {
		protected final SignatureWriter sw;
		
		public BaseSignatureVisitor(SignatureWriter sw) {
			this.sw = (sw != null)? sw : new SignatureWriter();
		}
		
		@Override
		protected SignatureWriter defaultResult() {
			return sw;
		}
		
		@Override
		public SignatureWriter visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
			var typeParameters = ctx.typeParameters();
			if (typeParameters != null) {
				typeParameters.accept(this);
			}
			var formalParameterList = ctx.formalParameterList();
			if (formalParameterList != null) {
				formalParameterList.accept(this);
			}
			sw.visitReturnType().visitBaseType('V');
			var exceptions = ctx.exceptions();
			if (exceptions != null) {
				exceptions.accept(this);
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitFormalParameter(FormalParameterContext ctx) {
			sw.visitParameterType();
			return ctx.type().accept(this);
		}
		
		@Override
		public SignatureWriter visitMethodDeclaration(MethodDeclarationContext ctx) {
			var typeParameters = ctx.typeParameters();
			if (typeParameters != null) {
				typeParameters.accept(this);
			}
			var formalParameterList = ctx.formalParameterList();
			if (formalParameterList != null) {
				formalParameterList.accept(this);
			}
			sw.visitReturnType();
			ctx.typeOrVoid().accept(this);
			var exceptions = ctx.exceptions();
			if (exceptions != null) {
				exceptions.accept(this);
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitExceptionType(ExceptionTypeContext ctx) {
			sw.visitExceptionType();
			return super.visitExceptionType(ctx);
		}
		
		@Override
		public SignatureWriter visitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
			var typeParameters = ctx.typeParameters();
			if (typeParameters != null) {
				typeParameters.accept(this);
			}
			var superclass = ctx.superclass();
			if (superclass != null) {
				superclass.accept(this);
			} else {
				sw.visitSuperclass().visitClassType(Type.getInternalName(Object.class));
				sw.visitEnd();
			}
			var superinterfaces = ctx.superinterfaces();
			if (superinterfaces != null) {
				superinterfaces.accept(this);
			}
			return sw;
		}
		
		
		@Override
		public SignatureWriter visitNormalInterfaceDeclaration(NormalInterfaceDeclarationContext ctx) {
			var typeParameters = ctx.typeParameters();
			if (typeParameters != null) {
				typeParameters.accept(this);
			}
			var superinterfaces = ctx.superinterfaces();
			if (superinterfaces != null) {
				for (var superinterface : superinterfaces.interfaceTypeList().classOrInterfaceType()) {
					sw.visitSuperclass();
					superinterface.accept(this);
				}
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitTypeParameter(TypeParameterContext typeParameter) {
			sw.visitFormalTypeParameter(typeParameter.typeIdentifier().getText());
            var typeBound = typeParameter.typeBound();
            if (typeBound != null) {
                typeBound.accept(this);
            } else {
            	sw.visitClassBound().visitClassType(Type.getInternalName(Object.class));
            }
            sw.visitEnd();
            return sw;
		}
		
		@Override
		public SignatureWriter visitTypeBound(TypeBoundContext typeBound) {
			var classOrInterfaceType = typeBound.classOrInterfaceType();
            if (classOrInterfaceType != null) {
            	sw.visitClassBound();
            	classOrInterfaceType.accept(this);
            }
            for (var additionalBound : typeBound.additionalBound()) {
            	sw.visitInterfaceBound();
            	additionalBound.classOrInterfaceType().accept(this);
            }
            return sw;
		}
		
		@Override
		public SignatureWriter visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
			String name = ctx.qualifiedTypeIdentifier().str;
			{
				sw.visitClassType(dottedNameToSlashedName(name));
				var typeArguments = ctx.typeArguments();
				if (typeArguments != null)
					typeArguments.accept(this);
				sw.visitEnd();
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitTypeArgument(TypeArgumentContext ctx) {
			if (ctx.referenceType() != null) {
				sw.visitTypeArgument('=');
			}
			return super.visitTypeArgument(ctx);
		}
		
		@Override
		public SignatureWriter visitWildcard(WildcardContext ctx) {
			if (ctx.wildcardBounds() == null) {
				sw.visitTypeArgument();
			} else {
				ctx.wildcardBounds().accept(this);
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitWildcardBounds(WildcardBoundsContext ctx) {
			if (ctx.isSuperBound) {
				sw.visitTypeArgument('-');
			} else {
				sw.visitTypeArgument('+');
			}
			return super.visitWildcardBounds(ctx);
		}
		
		@Override
		public SignatureWriter visitVoidType(VoidTypeContext ctx) {
			sw.visitBaseType('V');
			return sw;
		}
		
		@Override
		public SignatureWriter visitPrimitiveType(PrimitiveTypeContext ctx) {
			sw.visitBaseType(ctx.descriptor);
			return sw;
		}
		
		@Override
		public SignatureWriter visitIntegralType(IntegralTypeContext ctx) {
			sw.visitBaseType(ctx.descriptor);
			return sw;
		}
		
		@Override
		public SignatureWriter visitFloatingPointType(FloatingPointTypeContext ctx) {
			sw.visitBaseType(ctx.descriptor);
			return sw;
		}
		
		@Override
		public SignatureWriter visitArrayType(ArrayTypeContext ctx) {
			for (int i = ctx.dims().dim().size(); i > 0; i--) {
				sw.visitArrayType();
			}
			return super.visitArrayType(ctx);
		}
		
		@Override
		public SignatureWriter visitTypeVariable(TypeVariableContext ctx) {
			sw.visitTypeVariable(ctx.typeIdentifier().str);
			return sw;
		}
		
		@Override
		public SignatureWriter visitDims(DimsContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitDim(DimContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitMethodType(MethodTypeContext ctx) {
			if (ctx.typeList() != null) {
				for (var parameterType : ctx.typeList().type()) {
					sw.visitParameterType();
					parameterType.accept(this);
				}
			}
			sw.visitReturnType();
			return ctx.typeOrVoid().accept(this);
		}
		
		@Override
		public SignatureWriter visitSuperclass(SuperclassContext ctx) {
			sw.visitSuperclass();
			return super.visitSuperclass(ctx);
		}
		
		@Override
		public SignatureWriter visitSuperinterfaces(SuperinterfacesContext ctx) {
			for (var _interface : ctx.interfaceTypeList().classOrInterfaceType()) {
				sw.visitInterface();
				_interface.accept(this);
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitFieldRef(FieldRefContext ctx) {
			return ctx.type().accept(this);
		}
		
		@Override
		public SignatureWriter visitMethodRef(MethodRefContext ctx) {
			return ctx.methodType().accept(this);
		}
		
		@Override
		@Deprecated
		public SignatureWriter visitInterfaceTypeList(InterfaceTypeListContext ctx) {
			throw new IllegalStateException();
		}
		
		@Override
		@Deprecated
		public SignatureWriter visitIdentifier(IdentifierContext ctx) {
			throw new IllegalStateException();
		}
		
		@Override
		@Deprecated
		public SignatureWriter visitQualifiedIdentifier(QualifiedIdentifierContext ctx) {
			throw new IllegalStateException();
		}
		
		@Override
		@Deprecated
		public SignatureWriter visitQualifiedTypeIdentifier(QualifiedTypeIdentifierContext ctx) {
			throw new IllegalStateException();
		}
		
		@Override
		@Deprecated
		public SignatureWriter visitTypeIdentifier(TypeIdentifierContext ctx) {
			throw new IllegalStateException();
		}
		
	}
	
	public static class SignatureVisitor extends BaseSignatureVisitor {
		private final Predicate<String> typeParameterPredicate;
		
		public SignatureVisitor(Predicate<String> typeParameterPredicate) {
			this(null, typeParameterPredicate);
		}
		
		public SignatureVisitor(SignatureWriter sw, Predicate<String> typeParameterPredicate) {
			super(sw);
			this.typeParameterPredicate = (typeParameterPredicate == null)? (str) -> false : typeParameterPredicate;
		}
		
		protected boolean isTypeVariable(String name) {
			return typeParameterPredicate.test(name);
		}
		
		@Override
		public SignatureWriter visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
			String name = ctx.qualifiedTypeIdentifier().str;
			if (isTypeVariable(name)) {
				sw.visitTypeVariable(name);
			} else {
				sw.visitClassType(dottedNameToSlashedName(name));
				var typeArguments = ctx.typeArguments();
				if (typeArguments != null)
					typeArguments.accept(this);
				sw.visitEnd();
			}
			return sw;
		}
		
	}
	
	public static class DescriptorVisitor extends BaseSignatureVisitor {
		private final Function<? super String, ? extends TypeParameterContext> typeParameterLookup;
		
		public DescriptorVisitor(Function<? super String, ? extends ASMParser.TypeParameterContext> function) {
			this(null, function);
		}
		
		public DescriptorVisitor(SignatureWriter sw, Function<? super String, ? extends TypeParameterContext> typeParameterLookup) {
			super(sw);
			this.typeParameterLookup = (typeParameterLookup == null)? (str) -> null : typeParameterLookup;
		}
		
		protected TypeParameterContext lookupTypeParameter(String name) {
			return typeParameterLookup.apply(name);
		}
		
		@Override
		public SignatureWriter visitTypeParameters(TypeParametersContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitTypeParameterList(TypeParameterListContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitTypeArguments(TypeArgumentsContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitTypeArgumentList(TypeArgumentListContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitExceptions(ExceptionsContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitExceptionTypeList(ExceptionTypeListContext ctx) {
			return sw;
		}
		
		@Override
		public SignatureWriter visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
			String name = ctx.qualifiedTypeIdentifier().str;
			TypeParameterContext typeParameter = lookupTypeParameter(name);
			if (typeParameter != null) {
				var typeBound = typeParameter.typeBound();
				if (typeBound == null) {
					sw.visitClassType(Type.getInternalName(Object.class));
					sw.visitEnd();
				} else if (typeBound.classOrInterfaceType() != null) {
					typeBound.classOrInterfaceType().accept(this);
				} else {
					typeBound.additionalBound(0).classOrInterfaceType().accept(this);
				}
			} else {
				sw.visitClassType(dottedNameToSlashedName(name));
				var typeArguments = ctx.typeArguments();
				if (typeArguments != null)
					typeArguments.accept(this);
				sw.visitEnd();
			}
			return sw;
		}
		
		@Override
		public SignatureWriter visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
			super.visitConstructorDeclaration(ctx);
			return sw;
		}

		@Override
		public SignatureWriter visitMethodDeclaration(MethodDeclarationContext ctx) {
			
			return super.visitMethodDeclaration(ctx);
		}

	}
	
	/*public static class InternalNameVisitor extends ASMParserBaseVisitor<String> {
		private final Function<String, TypeParameterContext> typeParameterLookup;
		private final boolean doTypeParameters;
		
		public InternalNameVisitor() {
			this(false, null);
		}
		
		public InternalNameVisitor(boolean doTypeParameters, Function<String, TypeParameterContext> typeParameterLookup) {
			this.doTypeParameters = doTypeParameters;
			this.typeParameterLookup = typeParameterLookup == null? (str) -> null : typeParameterLookup;
		}
		
		protected TypeParameterContext lookupTypeParameter(String name) {
			return typeParameterLookup.apply(name);
		}
		
		public String visitArrayType(ArrayTypeContext ctx) {
			String name;
			if (ctx.primitiveType() != null) {
				name = ctx.primitiveType().accept(this);
			} else {
				name = ctx.classOrInterfaceType().accept(this);
			}
			int count = ctx.dims().dim().size();
			var sb = new StringBuilder(name.length() + count);
			for (int i = 0; i < count; i++) sb.append('[');
			sb.append(name);
			return sb.toString();
		}
		
		public String visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
			String name = ctx.qualifiedTypeIdentifier().str;
			var typeParameter = lookupTypeParameter(name);
			if (typeParameter == )
			return 'L' + dottedNameToSlashedName(ctx.qualifiedTypeIdentifier().str) + ';';
		}
		
	};*/
	
	public static String getInternalName(ClassOrInterfaceTypeContext ctx) {
		return dottedNameToSlashedName(ctx.qualifiedTypeIdentifier().str);
	}
	
	public static String dottedNameToSlashedName(String str) {
		return str.replace('.', '/');
	}
	
	@FunctionalInterface
	public static interface NumberParser<N extends Number> {
		N parseNumber(String str, int radix);
	}
	
	public static final NumberParser<Integer> PARSE_INT = ASMParserUtils::PARSE_INT;
	
	public static Integer PARSE_INT(String str, int radix) {
		if (str.isEmpty()) throw new NumberFormatException("For input string: " + str);
		switch (str.charAt(str.length() - 1)) {
			case 'l', 'L' -> throw new NumberFormatException("Expected integer literal");
		}
		return Integer.parseInt(str, radix);
	}
	
	public static Long PARSE_LONG(String str, int radix) {
		if (str.isEmpty()) throw new NumberFormatException("For input string: " + str);
		switch (str.charAt(str.length() - 1)) {
			case 'l', 'L' -> str = str.substring(0, str.length() - 1);
		}
		return Long.parseLong(str, radix);
	}

	public static byte parseByteLiteral(String str) {
		str = str.replace("_", "");
		int base;
		if (str.length() > 1 && str.charAt(0) == '0') {
			if (str.length() > 2) {
				switch (str.charAt(1)) {
					case 'x', 'X' -> {
						str = str.substring(2);
						base = 16;
					}
					case 'b', 'B' -> {
						str = str.substring(2);
						base = 2;
					}
					case '0','1','2','3','4','5','6','7','8','9' -> {
						str = str.substring(1);
						base = 8;
					}
					default -> {
						base = 10;
					}
				}
			} else {
				str = str.substring(1);
				base = 8;
			}
		} else {
			base = 10;
		}
		return Byte.parseByte(str, base);
	}
	
	public static short parseShortLiteral(String str) {
		str = str.replace("_", "");
		int base;
		if (str.length() > 1 && str.charAt(0) == '0') {
			if (str.length() > 2) {
				switch (str.charAt(1)) {
					case 'x', 'X' -> {
						str = str.substring(2);
						base = 16;
					}
					case 'b', 'B' -> {
						str = str.substring(2);
						base = 2;
					}
					case '0','1','2','3','4','5','6','7','8','9' -> {
						str = str.substring(1);
						base = 8;
					}
					default -> {
						base = 10;
					}
				}
			} else {
				str = str.substring(1);
				base = 8;
			}
		} else {
			base = 10;
		}
		return Short.parseShort(str, base);
	}
	
	public static int parseIntegerLiteral(String str) {
		str = str.replace("_", "");
		int base;
		if (str.length() > 1 && str.charAt(0) == '0') {
			if (str.length() > 2) {
				switch (str.charAt(1)) {
					case 'x', 'X' -> {
						str = str.substring(2);
						base = 16;
					}
					case 'b', 'B' -> {
						str = str.substring(2);
						base = 2;
					}
					case '0','1','2','3','4','5','6','7','8','9' -> {
						str = str.substring(1);
						base = 8;
					}
					default -> {
						base = 10;
					}
				}
			} else {
				str = str.substring(1);
				base = 8;
			}
		} else {
			base = 10;
		}
		return Integer.parseInt(str, base);
	}
	
	public static long parseLongLiteral(String str) {
		str = str.replace("_", "");
		if (str.endsWith("l") || str.endsWith("L")) {
			str = str.substring(0, str.length() - 1);
		}
		int base;
		if (str.length() > 1 && str.charAt(0) == '0') {
			if (str.length() > 2) {
				switch (str.charAt(1)) {
					case 'x', 'X' -> {
						str = str.substring(2);
						base = 16;
					}
					case 'b', 'B' -> {
						str = str.substring(2);
						base = 2;
					}
					case '0','1','2','3','4','5','6','7','8','9' -> {
						str = str.substring(1);
						base = 8;
					}
					default -> {
						base = 10;
					}
				}
			} else {
				str = str.substring(1);
				base = 8;
			}
		} else {
			base = 10;
		}
		return Long.parseLong(str, base);
	}
	
	public static float parseFloatLiteral(String str) {
		str = str.replace("_", "");
		if (str.endsWith("f") || str.endsWith("F")) {
			str = str.substring(0, str.length() - 1);
		}
		return Float.valueOf(str);
	}
	
	public static double parseDoubleLiteral(String str) {
		str = str.replace("_", "");
		if (str.endsWith("d") || str.endsWith("D")) {
			str = str.substring(0, str.length() - 1);
		}
		return Double.valueOf(str);
	}
	
	public static char parseCharacterLiteral(String str) {
		if (str.length() < 2 || !(str.startsWith("'") && str.endsWith("'"))) {
			throw new IllegalArgumentException();
		}
		return StringEscapeUtils.unescapeJava(str.substring(1, str.length() - 1)).charAt(0);
	}
	
	public static String parseStringLiteral(String str) {
		if (str.length() < 2 || !(str.startsWith("\"") && str.endsWith("\""))) {
			throw new IllegalArgumentException();
		}
		return StringEscapeUtils.unescapeJava(str.substring(1, str.length() - 1));
	}
	
	public static int arrayDimCount(ArrayTypeContext ctx) {
		return ctx.dims().dim().size();
	}
	
	public static boolean isPrimitive(TypeOrVoidContext ctx, char type) {
		if (type == 'V') return ctx.voidType() != null;
		if (ctx.primitiveType() == null) return false;
		return ctx.primitiveType().descriptor == type;
	}
	
	public static boolean isPrimitive(TypeContext ctx, char type) {
		if (ctx.primitiveType() == null) return false;
		return ctx.primitiveType().descriptor == type;
	}
	
	public static boolean isInt(TypeContext ctx) {
		return isPrimitive(ctx, 'I');
	}
	
	public static boolean isBoolean(TypeContext ctx) {
		return isPrimitive(ctx, 'Z');
	}
	
	public static boolean isByte(TypeContext ctx) {
		return isPrimitive(ctx, 'B');
	}
	
	public static boolean isShort(TypeContext ctx) {
		return isPrimitive(ctx, 'S');
	}
	
	public static boolean isChar(TypeContext ctx) {
		return isPrimitive(ctx, 'C');
	}
	
	public static boolean isLong(TypeContext ctx) {
		return isPrimitive(ctx, 'J');
	}
	
	public static boolean isFloat(TypeContext ctx) {
		return isPrimitive(ctx, 'F');
	}
	
	public static boolean isDouble(TypeContext ctx) {
		return isPrimitive(ctx, 'D');
	}
	
	public static boolean isReference(TypeContext ctx) {
		return ctx.referenceType() != null;
	}
	
	public static boolean isString(TypeContext ctx) {
		var refType = ctx.referenceType();
		if (refType == null) return false;
		var clType = refType.classOrInterfaceType();
		if (clType == null) return false;
		return clType.qualifiedTypeIdentifier().str.equals("java.lang.String");
	}
	
}
