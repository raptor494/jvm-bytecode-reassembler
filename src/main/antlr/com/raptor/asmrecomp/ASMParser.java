// Generated from c:\Users\flyin\Documents\Java\asm-recompiler\src\main\java\com\raptor\asmrecomp\ASMParser.g4 by ANTLR 4.8

package com.raptor.asmrecomp;

import static org.objectweb.asm.ClassWriter.*;
import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import org.objectweb.asm.Label;
import org.objectweb.asm.signature.SignatureWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.util.*;
import java.util.stream.Collectors;

import static com.raptor.asmrecomp.ASMParserUtils.*;
import com.raptor.asmrecomp.ASMParserUtils.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ASMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LongLiteral=1, DoubleLiteral=2, NegativeLongLiteral=3, INDENT=4, DEDENT=5, 
		KW_ABSTRACT=6, KW_ASSERT=7, KW_BOOLEAN=8, KW_BREAK=9, KW_BYTE=10, KW_CASE=11, 
		KW_CATCH=12, KW_CHAR=13, KW_CLASS=14, KW_CONST=15, KW_CONTINUE=16, KW_DEFAULT=17, 
		KW_DO=18, KW_DOUBLE=19, KW_ELSE=20, KW_ENUM=21, KW_EXTENDS=22, KW_FALSE=23, 
		KW_FINAL=24, KW_FINALLY=25, KW_FLOAT=26, KW_FOR=27, KW_IF=28, KW_GOTO=29, 
		KW_IMPLEMENTS=30, KW_IMPORT=31, KW_INSTANCEOF=32, KW_INT=33, KW_INTERFACE=34, 
		KW_LONG=35, KW_NATIVE=36, KW_NEW=37, KW_NULL=38, KW_PACKAGE=39, KW_PRIVATE=40, 
		KW_PROTECTED=41, KW_PUBLIC=42, KW_RETURN=43, KW_SHORT=44, KW_STATIC=45, 
		KW_STRICTFP=46, KW_SUPER=47, KW_SWITCH=48, KW_SYNCHRONIZED=49, KW_THIS=50, 
		KW_THROW=51, KW_THROWS=52, KW_TRANSIENT=53, KW_TRUE=54, KW_TRY=55, KW_VOID=56, 
		KW_VOLATILE=57, KW_WHILE=58, KW_UNDER_SCORE=59, KW_SYNTHETIC=60, KW_MANDATED=61, 
		KW_BRIDGE=62, KW_DEPRECATED=63, KW_CODE=64, INIT=65, KW_AASTORE=66, KW_ACONST_NULL=67, 
		KW_ALOAD=68, KW_ALOAD_0=69, KW_ALOAD_1=70, KW_ALOAD_2=71, KW_ALOAD_3=72, 
		KW_ANEWARRAY=73, KW_ARETURN=74, KW_ARRAYLENGTH=75, KW_ASTORE=76, KW_ASTORE_0=77, 
		KW_ASTORE_1=78, KW_ASTORE_2=79, KW_ASTORE_3=80, KW_ATHROW=81, KW_BALOAD=82, 
		KW_BASTORE=83, KW_BIPUSH=84, KW_CALOAD=85, KW_CASTORE=86, KW_CHECKCAST=87, 
		KW_D2F=88, KW_D2I=89, KW_D2L=90, KW_DADD=91, KW_DALOAD=92, KW_DASTORE=93, 
		KW_DCMPG=94, KW_DCMPL=95, KW_DCONST_0=96, KW_DCONST_1=97, KW_DDIV=98, 
		KW_DLOAD=99, KW_DLOAD_0=100, KW_DLOAD_1=101, KW_DLOAD_2=102, KW_DLOAD_3=103, 
		KW_DMUL=104, KW_DNEG=105, KW_DREM=106, KW_DRETURN=107, KW_DSTORE=108, 
		KW_DSTORE_0=109, KW_DSTORE_1=110, KW_DSTORE_2=111, KW_DSTORE_3=112, KW_DSUB=113, 
		KW_DUP=114, KW_DUP_X1=115, KW_DUP_X2=116, KW_DUP2=117, KW_DUP2_X1=118, 
		KW_DUP2_X2=119, KW_F2D=120, KW_F2I=121, KW_F2L=122, KW_FADD=123, KW_FALOAD=124, 
		KW_FASTORE=125, KW_FCMPG=126, KW_FCMPL=127, KW_FCONST_0=128, KW_FCONST_1=129, 
		KW_FCONST_2=130, KW_FDIV=131, KW_FLOAD=132, KW_FLOAD_0=133, KW_FLOAD_1=134, 
		KW_FLOAD_2=135, KW_FLOAD_3=136, KW_FMUL=137, KW_FNEG=138, KW_FREM=139, 
		KW_FRETURN=140, KW_FSTORE=141, KW_FSTORE_0=142, KW_FSTORE_1=143, KW_FSTORE_2=144, 
		KW_FSTORE_3=145, KW_FSUB=146, KW_GETFIELD=147, KW_GETSTATIC=148, KW_GOTO_W=149, 
		KW_I2B=150, KW_I2C=151, KW_I2D=152, KW_I2F=153, KW_I2L=154, KW_I2S=155, 
		KW_IADD=156, KW_IALOAD=157, KW_IAND=158, KW_IASTORE=159, KW_ICONST_M1=160, 
		KW_ICONST_0=161, KW_ICONST_1=162, KW_ICONST_2=163, KW_ICONST_3=164, KW_ICONST_4=165, 
		KW_ICONST_5=166, KW_IDIV=167, KW_IF_ACMPEQ=168, KW_IF_ACMPNE=169, KW_IF_ICMPEQ=170, 
		KW_IF_ICMPNE=171, KW_IF_ICMPLT=172, KW_IF_ICMPGE=173, KW_IF_ICMPGT=174, 
		KW_IF_ICMPLE=175, KW_IFEQ=176, KW_IFNE=177, KW_IFLT=178, KW_IFGE=179, 
		KW_IFGT=180, KW_IFLE=181, KW_IFNONNULL=182, KW_IFNULL=183, KW_IINC=184, 
		KW_ILOAD=185, KW_ILOAD_0=186, KW_ILOAD_1=187, KW_ILOAD_2=188, KW_ILOAD_3=189, 
		KW_IMUL=190, KW_INEG=191, KW_INVOKEDYNAMIC=192, KW_INVOKEINTERFACE=193, 
		KW_INVOKESPECIAL=194, KW_INVOKESTATIC=195, KW_INVOKEVIRTUAL=196, KW_IOR=197, 
		KW_IREM=198, KW_IRETURN=199, KW_ISHL=200, KW_ISHR=201, KW_ISTORE=202, 
		KW_ISTORE_0=203, KW_ISTORE_1=204, KW_ISTORE_2=205, KW_ISTORE_3=206, KW_ISUB=207, 
		KW_IUSHR=208, KW_IXOR=209, KW_JSR=210, KW_JSR_W=211, KW_L2D=212, KW_L2F=213, 
		KW_L2I=214, KW_LADD=215, KW_LALOAD=216, KW_LAND=217, KW_LASTORE=218, KW_LCMP=219, 
		KW_LCONST_0=220, KW_LCONST_1=221, KW_LDC=222, KW_LDC_W=223, KW_LDC2_W=224, 
		KW_LDIV=225, KW_LLOAD=226, KW_LLOAD_0=227, KW_LLOAD_1=228, KW_LLOAD_2=229, 
		KW_LLOAD_3=230, KW_LMUL=231, KW_LNEG=232, KW_LOOKUPSWITCH=233, KW_LOR=234, 
		KW_LREM=235, KW_LRETURN=236, KW_LSHL=237, KW_LSHR=238, KW_LSTORE=239, 
		KW_LSTORE_0=240, KW_LSTORE_1=241, KW_LSTORE_2=242, KW_LSTORE_3=243, KW_LSUB=244, 
		KW_LUSHR=245, KW_LXOR=246, KW_MONITORENTER=247, KW_MONITOREXIT=248, KW_MULTIANEWARRAY=249, 
		KW_NEWARRAY=250, KW_NOP=251, KW_POP=252, KW_POP2=253, KW_PUTFIELD=254, 
		KW_PUTSTATIC=255, KW_RET=256, KW_SALOAD=257, KW_SASTORE=258, KW_SIPUSH=259, 
		KW_SWAP=260, KW_TABLESWITCH=261, KW_WIDE=262, LPAREN=263, RPAREN=264, 
		LBRACE=265, RBRACE=266, LBRACK=267, RBRACK=268, SEMI=269, COLON=270, COMMA=271, 
		DOT=272, AT=273, ELLIPSIS=274, LT=275, GT=276, AMP=277, BAR=278, QUES=279, 
		STAR=280, EQ=281, Identifier=282, NL=283, WS=284, COMMENT=285, LINE_COMMENT=286, 
		NegativeIntegerLiteral=287, IntegerLiteral=288, FloatingPointLiteral=289, 
		CharacterLiteral=290, StringLiteral=291;
	public static final int
		RULE_compilationUnit = 0, RULE_typeDeclaration = 1, RULE_classDeclaration = 2, 
		RULE_normalClassDeclaration = 3, RULE_classModifier = 4, RULE_interfaceDeclaration = 5, 
		RULE_normalInterfaceDeclaration = 6, RULE_interfaceModifier = 7, RULE_typeParameters = 8, 
		RULE_typeParameterList = 9, RULE_typeParameter = 10, RULE_superclass = 11, 
		RULE_superinterfaces = 12, RULE_interfaceTypeList = 13, RULE_classBody = 14, 
		RULE_interfaceBody = 15, RULE_classBodyDeclaration = 16, RULE_interfaceBodyDeclaration = 17, 
		RULE_constructorDeclaration = 18, RULE_constructorModifier = 19, RULE_methodDeclaration = 20, 
		RULE_methodModifier = 21, RULE_fieldDeclaration = 22, RULE_fieldModifier = 23, 
		RULE_formalParameterList = 24, RULE_formalParameters = 25, RULE_formalParameter = 26, 
		RULE_variableModifier = 27, RULE_lastFormalParameter = 28, RULE_variadicParameter = 29, 
		RULE_exceptions = 30, RULE_exceptionTypeList = 31, RULE_exceptionType = 32, 
		RULE_methodBody = 33, RULE_statement = 34, RULE_labelDeclaration = 35, 
		RULE_instruction = 36, RULE_fieldRef = 37, RULE_methodRef = 38, RULE_callSiteRef = 39, 
		RULE_bootstrapRef = 40, RULE_handle = 41, RULE_bootstrapArgs = 42, RULE_typeList = 43, 
		RULE_loadableConstant = 44, RULE_lookupSwitchArg = 45, RULE_lookupSwitchCase = 46, 
		RULE_tableSwitchArg = 47, RULE_tableSwitchCase = 48, RULE_switchDefault = 49, 
		RULE_type = 50, RULE_typeOrVoid = 51, RULE_methodType = 52, RULE_voidType = 53, 
		RULE_primitiveType = 54, RULE_numericType = 55, RULE_integralType = 56, 
		RULE_floatingPointType = 57, RULE_referenceType = 58, RULE_classOrInterfaceType = 59, 
		RULE_typeVariable = 60, RULE_arrayType = 61, RULE_dims = 62, RULE_dim = 63, 
		RULE_typeBound = 64, RULE_additionalBound = 65, RULE_typeArguments = 66, 
		RULE_typeArgumentList = 67, RULE_typeArgument = 68, RULE_wildcard = 69, 
		RULE_wildcardBounds = 70, RULE_typeIdentifier = 71, RULE_qualifiedTypeIdentifier = 72, 
		RULE_qualifiedIdentifier = 73, RULE_labelIdentifier = 74, RULE_identifier = 75, 
		RULE_signedByteLiteral = 76, RULE_signedShortLiteral = 77, RULE_integerLiteral = 78, 
		RULE_signedIntegerLiteral = 79, RULE_longLiteral = 80, RULE_signedLongLiteral = 81, 
		RULE_floatLiteral = 82, RULE_doubleLiteral = 83, RULE_characterLiteral = 84, 
		RULE_stringLiteral = 85;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "typeDeclaration", "classDeclaration", "normalClassDeclaration", 
			"classModifier", "interfaceDeclaration", "normalInterfaceDeclaration", 
			"interfaceModifier", "typeParameters", "typeParameterList", "typeParameter", 
			"superclass", "superinterfaces", "interfaceTypeList", "classBody", "interfaceBody", 
			"classBodyDeclaration", "interfaceBodyDeclaration", "constructorDeclaration", 
			"constructorModifier", "methodDeclaration", "methodModifier", "fieldDeclaration", 
			"fieldModifier", "formalParameterList", "formalParameters", "formalParameter", 
			"variableModifier", "lastFormalParameter", "variadicParameter", "exceptions", 
			"exceptionTypeList", "exceptionType", "methodBody", "statement", "labelDeclaration", 
			"instruction", "fieldRef", "methodRef", "callSiteRef", "bootstrapRef", 
			"handle", "bootstrapArgs", "typeList", "loadableConstant", "lookupSwitchArg", 
			"lookupSwitchCase", "tableSwitchArg", "tableSwitchCase", "switchDefault", 
			"type", "typeOrVoid", "methodType", "voidType", "primitiveType", "numericType", 
			"integralType", "floatingPointType", "referenceType", "classOrInterfaceType", 
			"typeVariable", "arrayType", "dims", "dim", "typeBound", "additionalBound", 
			"typeArguments", "typeArgumentList", "typeArgument", "wildcard", "wildcardBounds", 
			"typeIdentifier", "qualifiedTypeIdentifier", "qualifiedIdentifier", "labelIdentifier", 
			"identifier", "signedByteLiteral", "signedShortLiteral", "integerLiteral", 
			"signedIntegerLiteral", "longLiteral", "signedLongLiteral", "floatLiteral", 
			"doubleLiteral", "characterLiteral", "stringLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'abstract'", "'assert'", "'boolean'", 
			"'break'", "'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", 
			"'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", "'extends'", 
			"'false'", "'final'", "'finally'", "'float'", "'for'", "'if'", "'goto'", 
			"'implements'", "'import'", "'instanceof'", "'int'", "'interface'", "'long'", 
			"'native'", "'new'", "'null'", "'package'", "'private'", "'protected'", 
			"'public'", "'return'", "'short'", "'static'", "'strictfp'", "'super'", 
			"'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", "'transient'", 
			"'true'", "'try'", "'void'", "'volatile'", "'while'", "'_'", "'synthetic'", 
			"'mandated'", "'bridge'", "'deprecated'", "'Code'", "'<init>'", "'aastore'", 
			"'aconst_null'", "'aload'", "'aload_0'", "'aload_1'", "'aload_2'", "'aload_3'", 
			"'anewarray'", "'areturn'", "'arraylength'", "'astore'", "'astore_0'", 
			"'astore_1'", "'astore_2'", "'astore_3'", "'athrow'", "'baload'", "'bastore'", 
			"'bipush'", "'caload'", "'castore'", "'checkcast'", "'d2f'", "'d2i'", 
			"'d2l'", "'dadd'", "'daload'", "'dastore'", "'dcmpg'", "'dcmpl'", "'dconst_0'", 
			"'dconst_1'", "'ddiv'", "'dload'", "'dload_0'", "'dload_1'", "'dload_2'", 
			"'dload_3'", "'dmul'", "'dneg'", "'drem'", "'dreturn'", "'dstore'", "'dstore_0'", 
			"'dstore_1'", "'dstore_2'", "'dstore_3'", "'dsub'", "'dup'", "'dup_x1'", 
			"'dup_x2'", "'dup2'", "'dup2_x1'", "'dup2_x2'", "'f2d'", "'f2i'", "'f2l'", 
			"'fadd'", "'faload'", "'fastore'", "'fcmpg'", "'fcmpl'", "'fconst_0'", 
			"'fconst_1'", "'fconst_2'", "'fdiv'", "'fload'", "'fload_0'", "'fload_1'", 
			"'fload_2'", "'fload_3'", "'fmul'", "'fneg'", "'frem'", "'freturn'", 
			"'fstore'", "'fstore_0'", "'fstore_1'", "'fstore_2'", "'fstore_3'", "'fsub'", 
			"'getfield'", "'getstatic'", "'goto_w'", "'i2b'", "'i2c'", "'i2d'", "'i2f'", 
			"'i2l'", "'i2s'", "'iadd'", "'iaload'", "'iand'", "'iastore'", "'iconst_m1'", 
			"'iconst_0'", "'iconst_1'", "'iconst_2'", "'iconst_3'", "'iconst_4'", 
			"'iconst_5'", "'idiv'", "'if_acmpeq'", "'if_acmpne'", "'if_icmpeq'", 
			"'if_icmpne'", "'if_icmplt'", "'if_icmpge'", "'if_icmpgt'", "'if_icmple'", 
			"'ifeq'", "'ifne'", "'iflt'", "'ifge'", "'ifgt'", "'ifle'", "'ifnonnull'", 
			"'ifnull'", "'iinc'", "'iload'", "'iload_0'", "'iload_1'", "'iload_2'", 
			"'iload_3'", "'imul'", "'ineg'", "'invokedynamic'", "'invokeinterface'", 
			"'invokespecial'", "'invokestatic'", "'invokevirtual'", "'ior'", "'irem'", 
			"'ireturn'", "'ishl'", "'ishr'", "'istore'", "'istore_0'", "'istore_1'", 
			"'istore_2'", "'istore_3'", "'isub'", "'iushr'", "'ixor'", "'jsr'", "'jsr_w'", 
			"'l2d'", "'l2f'", "'l2i'", "'ladd'", "'laload'", "'land'", "'lastore'", 
			"'lcmp'", "'lconst_0'", "'lconst_1'", "'ldc'", "'ldc_w'", "'ldc2_w'", 
			"'ldiv'", "'lload'", "'lload_0'", "'lload_1'", "'lload_2'", "'lload_3'", 
			"'lmul'", "'lneg'", "'lookupswitch'", "'lor'", "'lrem'", "'lreturn'", 
			"'lshl'", "'lshr'", "'lstore'", "'lstore_0'", "'lstore_1'", "'lstore_2'", 
			"'lstore_3'", "'lsub'", "'lushr'", "'lxor'", "'monitorenter'", "'monitorexit'", 
			"'multianewarray'", "'newarray'", "'nop'", "'pop'", "'pop2'", "'putfield'", 
			"'putstatic'", "'ret'", "'saload'", "'sastore'", "'sipush'", "'swap'", 
			"'tableswitch'", "'wide'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "':'", "','", "'.'", "'@'", "'...'", "'<'", "'>'", "'&'", "'|'", 
			"'?'", "'*'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LongLiteral", "DoubleLiteral", "NegativeLongLiteral", "INDENT", 
			"DEDENT", "KW_ABSTRACT", "KW_ASSERT", "KW_BOOLEAN", "KW_BREAK", "KW_BYTE", 
			"KW_CASE", "KW_CATCH", "KW_CHAR", "KW_CLASS", "KW_CONST", "KW_CONTINUE", 
			"KW_DEFAULT", "KW_DO", "KW_DOUBLE", "KW_ELSE", "KW_ENUM", "KW_EXTENDS", 
			"KW_FALSE", "KW_FINAL", "KW_FINALLY", "KW_FLOAT", "KW_FOR", "KW_IF", 
			"KW_GOTO", "KW_IMPLEMENTS", "KW_IMPORT", "KW_INSTANCEOF", "KW_INT", "KW_INTERFACE", 
			"KW_LONG", "KW_NATIVE", "KW_NEW", "KW_NULL", "KW_PACKAGE", "KW_PRIVATE", 
			"KW_PROTECTED", "KW_PUBLIC", "KW_RETURN", "KW_SHORT", "KW_STATIC", "KW_STRICTFP", 
			"KW_SUPER", "KW_SWITCH", "KW_SYNCHRONIZED", "KW_THIS", "KW_THROW", "KW_THROWS", 
			"KW_TRANSIENT", "KW_TRUE", "KW_TRY", "KW_VOID", "KW_VOLATILE", "KW_WHILE", 
			"KW_UNDER_SCORE", "KW_SYNTHETIC", "KW_MANDATED", "KW_BRIDGE", "KW_DEPRECATED", 
			"KW_CODE", "INIT", "KW_AASTORE", "KW_ACONST_NULL", "KW_ALOAD", "KW_ALOAD_0", 
			"KW_ALOAD_1", "KW_ALOAD_2", "KW_ALOAD_3", "KW_ANEWARRAY", "KW_ARETURN", 
			"KW_ARRAYLENGTH", "KW_ASTORE", "KW_ASTORE_0", "KW_ASTORE_1", "KW_ASTORE_2", 
			"KW_ASTORE_3", "KW_ATHROW", "KW_BALOAD", "KW_BASTORE", "KW_BIPUSH", "KW_CALOAD", 
			"KW_CASTORE", "KW_CHECKCAST", "KW_D2F", "KW_D2I", "KW_D2L", "KW_DADD", 
			"KW_DALOAD", "KW_DASTORE", "KW_DCMPG", "KW_DCMPL", "KW_DCONST_0", "KW_DCONST_1", 
			"KW_DDIV", "KW_DLOAD", "KW_DLOAD_0", "KW_DLOAD_1", "KW_DLOAD_2", "KW_DLOAD_3", 
			"KW_DMUL", "KW_DNEG", "KW_DREM", "KW_DRETURN", "KW_DSTORE", "KW_DSTORE_0", 
			"KW_DSTORE_1", "KW_DSTORE_2", "KW_DSTORE_3", "KW_DSUB", "KW_DUP", "KW_DUP_X1", 
			"KW_DUP_X2", "KW_DUP2", "KW_DUP2_X1", "KW_DUP2_X2", "KW_F2D", "KW_F2I", 
			"KW_F2L", "KW_FADD", "KW_FALOAD", "KW_FASTORE", "KW_FCMPG", "KW_FCMPL", 
			"KW_FCONST_0", "KW_FCONST_1", "KW_FCONST_2", "KW_FDIV", "KW_FLOAD", "KW_FLOAD_0", 
			"KW_FLOAD_1", "KW_FLOAD_2", "KW_FLOAD_3", "KW_FMUL", "KW_FNEG", "KW_FREM", 
			"KW_FRETURN", "KW_FSTORE", "KW_FSTORE_0", "KW_FSTORE_1", "KW_FSTORE_2", 
			"KW_FSTORE_3", "KW_FSUB", "KW_GETFIELD", "KW_GETSTATIC", "KW_GOTO_W", 
			"KW_I2B", "KW_I2C", "KW_I2D", "KW_I2F", "KW_I2L", "KW_I2S", "KW_IADD", 
			"KW_IALOAD", "KW_IAND", "KW_IASTORE", "KW_ICONST_M1", "KW_ICONST_0", 
			"KW_ICONST_1", "KW_ICONST_2", "KW_ICONST_3", "KW_ICONST_4", "KW_ICONST_5", 
			"KW_IDIV", "KW_IF_ACMPEQ", "KW_IF_ACMPNE", "KW_IF_ICMPEQ", "KW_IF_ICMPNE", 
			"KW_IF_ICMPLT", "KW_IF_ICMPGE", "KW_IF_ICMPGT", "KW_IF_ICMPLE", "KW_IFEQ", 
			"KW_IFNE", "KW_IFLT", "KW_IFGE", "KW_IFGT", "KW_IFLE", "KW_IFNONNULL", 
			"KW_IFNULL", "KW_IINC", "KW_ILOAD", "KW_ILOAD_0", "KW_ILOAD_1", "KW_ILOAD_2", 
			"KW_ILOAD_3", "KW_IMUL", "KW_INEG", "KW_INVOKEDYNAMIC", "KW_INVOKEINTERFACE", 
			"KW_INVOKESPECIAL", "KW_INVOKESTATIC", "KW_INVOKEVIRTUAL", "KW_IOR", 
			"KW_IREM", "KW_IRETURN", "KW_ISHL", "KW_ISHR", "KW_ISTORE", "KW_ISTORE_0", 
			"KW_ISTORE_1", "KW_ISTORE_2", "KW_ISTORE_3", "KW_ISUB", "KW_IUSHR", "KW_IXOR", 
			"KW_JSR", "KW_JSR_W", "KW_L2D", "KW_L2F", "KW_L2I", "KW_LADD", "KW_LALOAD", 
			"KW_LAND", "KW_LASTORE", "KW_LCMP", "KW_LCONST_0", "KW_LCONST_1", "KW_LDC", 
			"KW_LDC_W", "KW_LDC2_W", "KW_LDIV", "KW_LLOAD", "KW_LLOAD_0", "KW_LLOAD_1", 
			"KW_LLOAD_2", "KW_LLOAD_3", "KW_LMUL", "KW_LNEG", "KW_LOOKUPSWITCH", 
			"KW_LOR", "KW_LREM", "KW_LRETURN", "KW_LSHL", "KW_LSHR", "KW_LSTORE", 
			"KW_LSTORE_0", "KW_LSTORE_1", "KW_LSTORE_2", "KW_LSTORE_3", "KW_LSUB", 
			"KW_LUSHR", "KW_LXOR", "KW_MONITORENTER", "KW_MONITOREXIT", "KW_MULTIANEWARRAY", 
			"KW_NEWARRAY", "KW_NOP", "KW_POP", "KW_POP2", "KW_PUTFIELD", "KW_PUTSTATIC", 
			"KW_RET", "KW_SALOAD", "KW_SASTORE", "KW_SIPUSH", "KW_SWAP", "KW_TABLESWITCH", 
			"KW_WIDE", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"SEMI", "COLON", "COMMA", "DOT", "AT", "ELLIPSIS", "LT", "GT", "AMP", 
			"BAR", "QUES", "STAR", "EQ", "Identifier", "NL", "WS", "COMMENT", "LINE_COMMENT", 
			"NegativeIntegerLiteral", "IntegerLiteral", "FloatingPointLiteral", "CharacterLiteral", 
			"StringLiteral"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ASMParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    protected LinkedList<HashMap<String, TypeParameterContext>> typeParameters = new LinkedList<>();
	    {typeParameters.add(new HashMap<>());}
	    
	    protected HashMap<String, Label> labels;
	    
	    protected ArrayList<String> varnames;
	    protected int localVarMode;
	    protected boolean addedThisLocalVar, methodIsStatic;
	    protected static final int MODE_INDICES = 1, MODE_NAMES = 2, MODE_UNDECIDED = 0;

	    protected String currentClassName;
	    
	    protected boolean debug = false;
	    
	    protected void enterScope() {
	        typeParameters.add(new HashMap<>());
	    }
	    
	    protected void exitScope() {
	        typeParameters.removeLast();
	    }
	    
	    protected boolean hasTypeParameter(String name) {
	        for (var iter = typeParameters.descendingIterator(); iter.hasNext();) {
	            if (iter.next().containsKey(name)) return true;
	        }
	        return false;
	    }
	    
	    protected void addTypeParameter(String name, TypeParameterContext ctx) {
	        typeParameters.getLast().put(name, ctx);
	    }
	    
	    protected TypeParameterContext lookupTypeParameter(String name) {
	        for (var iter = typeParameters.descendingIterator(); iter.hasNext();) {
	            var res = iter.next().get(name);
	            if (res != null) return res;
	        }
	        return null;
	    }
	    
	    protected String[] getDescriptorsArray(SuperinterfacesContext ctx) {
	        return ctx == null? new String[0] : ctx.interfaceTypeList().classOrInterfaceType().stream().map(classOrInterfaceType -> classOrInterfaceType.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString()).toArray(String[]::new);
	    }
	    
	    protected String[] getDescriptorsArray(ExceptionsContext ctx) {
	        return ctx == null? new String[0] : ctx.exceptionTypeList().exceptionType().stream().map(exceptionType -> exceptionType.classOrInterfaceType().accept(new DescriptorVisitor(this::lookupTypeParameter)).toString()).toArray(String[]::new);
	    }
	    
	    protected Label getLabel(String name) {
	        return labels.computeIfAbsent(name, unused -> new Label());
	    }    

	    protected int getVariable(String name) {
	        switch (localVarMode) {
	            case MODE_UNDECIDED -> localVarMode = MODE_NAMES;
	            case MODE_INDICES -> throw new IllegalStateException("Invalid mixture of index and variable names");
	        }
	        var names = this.varnames;
	        if (names == null) {
	            this.varnames = names = new ArrayList<>();
	        }
	        if (names.isEmpty()) {
	            if (!methodIsStatic && !addedThisLocalVar) {
	                names.add("this");
	                addedThisLocalVar = true;
	            }
	        }
	        int i = names.indexOf(name);
	        if (i == -1) {
	            i = names.size();
	            names.add(name);
	        }
	        return i;
	    }
	    
	    protected String getDescriptor(RuleContext ctx) {
	        return ctx.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString();
	    }
	    
	    protected String getSignature(RuleContext ctx) {
	        return ctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString();
	    }

	    protected String getOwner(FieldRefContext ctx) {
	        if (ctx.classOrInterfaceType() != null) return dottedNameToSlashedName(ctx.classOrInterfaceType().qualifiedTypeIdentifier().str);
	        return dottedNameToSlashedName(currentClassName);
	    }

	    protected String getOwner(MethodRefContext ctx) {
	        if (ctx.classOrInterfaceType() != null) return dottedNameToSlashedName(ctx.classOrInterfaceType().qualifiedTypeIdentifier().str);
	        return dottedNameToSlashedName(currentClassName);
	    }

	    protected Handle getHandle(HandleContext ctx) {
	        int tag = switch (ctx.name.getType()) {
	            case KW_GETFIELD -> H_GETFIELD;
	            case KW_GETSTATIC -> H_GETSTATIC;
	            case KW_PUTFIELD -> H_PUTFIELD;
	            case KW_PUTSTATIC -> H_PUTSTATIC;
	            case KW_INVOKEVIRTUAL -> H_INVOKEVIRTUAL;
	            case KW_INVOKESTATIC -> H_INVOKESTATIC;
	            case KW_INVOKESPECIAL -> ctx.KW_NEW() == null? H_INVOKESPECIAL : H_NEWINVOKESPECIAL;
	            case KW_INVOKEINTERFACE -> H_INVOKEINTERFACE;
	            default -> throw new IllegalArgumentException();
	        };
	        String owner, name, descriptor;
	        switch (ctx.name.getType()) {
	        case KW_GETFIELD, KW_GETSTATIC, KW_PUTFIELD, KW_PUTSTATIC:
	            var fieldRef = ctx.fieldRef();
	            owner = getOwner(fieldRef);
	            name = fieldRef.name;
	            descriptor = getDescriptor(fieldRef);
	            break;
	        case KW_INVOKEVIRTUAL, KW_INVOKESTATIC, KW_INVOKESPECIAL, KW_INVOKEINTERFACE:
	            var methodRef = ctx.methodRef();
	            owner = getOwner(methodRef);
	            name = methodRef.name;
	            descriptor = getDescriptor(methodRef);
	            break;
	        default:
	            throw new AssertionError();
	        }
	        return new Handle(tag, owner, name, descriptor);
	    }
	    
	    public void debugEnabled(boolean debug) {
	        this.debug = debug;
	    }
	    

	public ASMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public TypeDeclarationContext typeDeclaration;
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ASMParser.EOF, 0); }
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((CompilationUnitContext)_localctx).typeDeclaration = typeDeclaration();
			((CompilationUnitContext)_localctx).cw =  ((CompilationUnitContext)_localctx).typeDeclaration.cw; ((CompilationUnitContext)_localctx).name =  ((CompilationUnitContext)_localctx).typeDeclaration.name;
			setState(174);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public ClassDeclarationContext classDeclaration;
		public InterfaceDeclarationContext interfaceDeclaration;
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeDeclaration);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((TypeDeclarationContext)_localctx).classDeclaration = classDeclaration();
				((TypeDeclarationContext)_localctx).cw =  ((TypeDeclarationContext)_localctx).classDeclaration.cw;     ((TypeDeclarationContext)_localctx).name =  ((TypeDeclarationContext)_localctx).classDeclaration.name;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				((TypeDeclarationContext)_localctx).interfaceDeclaration = interfaceDeclaration();
				((TypeDeclarationContext)_localctx).cw =  ((TypeDeclarationContext)_localctx).interfaceDeclaration.cw; ((TypeDeclarationContext)_localctx).name =  ((TypeDeclarationContext)_localctx).interfaceDeclaration.name;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public NormalClassDeclarationContext normalClassDeclaration;
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((ClassDeclarationContext)_localctx).normalClassDeclaration = normalClassDeclaration();
			((ClassDeclarationContext)_localctx).cw =  ((ClassDeclarationContext)_localctx).normalClassDeclaration.cw; ((ClassDeclarationContext)_localctx).name =  ((ClassDeclarationContext)_localctx).normalClassDeclaration.name;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalClassDeclarationContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public int flags;
		public ClassModifierContext classModifier;
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier;
		public TerminalNode KW_CLASS() { return getToken(ASMParser.KW_CLASS, 0); }
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier() {
			return getRuleContext(QualifiedTypeIdentifierContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public SuperclassContext superclass() {
			return getRuleContext(SuperclassContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public NormalClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterNormalClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitNormalClassDeclaration(this);
		}
	}

	public final NormalClassDeclarationContext normalClassDeclaration() throws RecognitionException {
		NormalClassDeclarationContext _localctx = new NormalClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_normalClassDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((NormalClassDeclarationContext)_localctx).flags =  0;
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ABSTRACT) | (1L << KW_FINAL) | (1L << KW_PRIVATE) | (1L << KW_PROTECTED) | (1L << KW_PUBLIC) | (1L << KW_STATIC) | (1L << KW_SYNTHETIC) | (1L << KW_DEPRECATED))) != 0)) {
				{
				{
				setState(188);
				((NormalClassDeclarationContext)_localctx).classModifier = classModifier(_localctx.flags);
				_localctx.flags |= ((NormalClassDeclarationContext)_localctx).classModifier.flag;
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(KW_CLASS);
			setState(197);
			((NormalClassDeclarationContext)_localctx).qualifiedTypeIdentifier = qualifiedTypeIdentifier();
			((NormalClassDeclarationContext)_localctx).name =  currentClassName = ((NormalClassDeclarationContext)_localctx).qualifiedTypeIdentifier.str;
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(199);
				typeParameters();
				enterScope();
				}
				break;
			}
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(204);
				superclass();
				}
				break;
			}
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(207);
				superinterfaces(false);
				}
				break;
			}

			            ((NormalClassDeclarationContext)_localctx).cw =  new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
			            var cv = debug? new TraceClassVisitor(_localctx.cw, new java.io.PrintWriter(System.out)) : _localctx.cw;
			            cv.visit(
			                // version
			                V14,
			                // access
			                _localctx.flags,
			                // name
			                dottedNameToSlashedName(((NormalClassDeclarationContext)_localctx).qualifiedTypeIdentifier.str),
			                // signature
			                _localctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
			                // superName
			                (_localctx.superclass() == null)? Type.getInternalName(Object.class) : getInternalName(_localctx.superclass().classOrInterfaceType()),
			                // interfaces
			                getDescriptorsArray(_localctx.superinterfaces())                
			            );
			        
			setState(211);
			classBody(cv);

			            if (_localctx.typeParameters() != null) exitScope();
			            cv.visitEnd();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_PUBLIC() { return getToken(ASMParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PROTECTED() { return getToken(ASMParser.KW_PROTECTED, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(ASMParser.KW_PRIVATE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(ASMParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_STATIC() { return getToken(ASMParser.KW_STATIC, 0); }
		public TerminalNode KW_FINAL() { return getToken(ASMParser.KW_FINAL, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitClassModifier(this);
		}
	}

	public final ClassModifierContext classModifier(int flags) throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 8, RULE_classModifier);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(KW_PUBLIC);
				((ClassModifierContext)_localctx).flag =  ACC_PUBLIC;
				setState(216);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Duplicate flag \"public\"");
				setState(217);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incomatible flags \"public\", \"protected\"");
				setState(218);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"public\", \"private\"");
				}
				break;
			case KW_PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(KW_PROTECTED);
				((ClassModifierContext)_localctx).flag =  ACC_PROTECTED;
				setState(221);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Duplicate flag \"protected\"");
				setState(222);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"protected\", \"public\"");
				setState(223);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"protected\", \"private\"");
				}
				break;
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(KW_PRIVATE);
				((ClassModifierContext)_localctx).flag =  ACC_PRIVATE;
				setState(226);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Duplicate flag \"private\"");
				setState(227);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"private\", \"public\"");
				setState(228);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incompatible flags \"private\", \"protected\"");
				}
				break;
			case KW_ABSTRACT:
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				match(KW_ABSTRACT);
				((ClassModifierContext)_localctx).flag =  ACC_ABSTRACT;
				setState(231);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Duplicate flag \"abstract\"");
				setState(232);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Incompatible flags \"abstract\", \"final\"");
				setState(233);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Incompatible flags \"abstract\", \"static\"");
				}
				break;
			case KW_STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				match(KW_STATIC);
				((ClassModifierContext)_localctx).flag =  ACC_STATIC;
				setState(236);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Duplicate flag \"static\"");
				setState(237);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"static\", \"abstract\"");
				}
				break;
			case KW_FINAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(238);
				match(KW_FINAL);
				((ClassModifierContext)_localctx).flag =  ACC_FINAL;
				setState(240);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Duplicate flag \"final\"");
				setState(241);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"final\", \"abstract\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 7);
				{
				setState(242);
				match(KW_SYNTHETIC);
				((ClassModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(244);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 8);
				{
				setState(245);
				match(KW_DEPRECATED);
				((ClassModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(247);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration;
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_interfaceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			((InterfaceDeclarationContext)_localctx).normalInterfaceDeclaration = normalInterfaceDeclaration();
			((InterfaceDeclarationContext)_localctx).cw =  ((InterfaceDeclarationContext)_localctx).normalInterfaceDeclaration.cw; ((InterfaceDeclarationContext)_localctx).name =  ((InterfaceDeclarationContext)_localctx).normalInterfaceDeclaration.name;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public ClassWriter cw;
		public String name;
		public int flags;
		public InterfaceModifierContext interfaceModifier;
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier;
		public TerminalNode KW_INTERFACE() { return getToken(ASMParser.KW_INTERFACE, 0); }
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier() {
			return getRuleContext(QualifiedTypeIdentifierContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitNormalInterfaceDeclaration(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((NormalInterfaceDeclarationContext)_localctx).flags =  0;
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ABSTRACT) | (1L << KW_PRIVATE) | (1L << KW_PROTECTED) | (1L << KW_PUBLIC) | (1L << KW_STATIC) | (1L << KW_SYNTHETIC) | (1L << KW_DEPRECATED))) != 0)) {
				{
				{
				setState(254);
				((NormalInterfaceDeclarationContext)_localctx).interfaceModifier = interfaceModifier(_localctx.flags);
				_localctx.flags |= ((NormalInterfaceDeclarationContext)_localctx).interfaceModifier.flag;
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
			match(KW_INTERFACE);
			setState(263);
			((NormalInterfaceDeclarationContext)_localctx).qualifiedTypeIdentifier = qualifiedTypeIdentifier();
			((NormalInterfaceDeclarationContext)_localctx).name =  currentClassName = ((NormalInterfaceDeclarationContext)_localctx).qualifiedTypeIdentifier.str;
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(265);
				typeParameters();
				enterScope();
				}
				break;
			}
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(270);
				superinterfaces(true);
				}
				break;
			}

			            _localctx.flags |= ACC_INTERFACE | ACC_ABSTRACT;
			            ((NormalInterfaceDeclarationContext)_localctx).cw =  new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
			            var cv = debug? new TraceClassVisitor(_localctx.cw, new java.io.PrintWriter(System.out)) : _localctx.cw;
			            cv.visit(
			                // version
			                V14,
			                // access
			                _localctx.flags,
			                // name
			                dottedNameToSlashedName(((NormalInterfaceDeclarationContext)_localctx).qualifiedTypeIdentifier.str),
			                // signature
			                _localctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
			                // superName
			                null,
			                // interfaces
			                getDescriptorsArray(_localctx.superinterfaces())
			            );
			        
			setState(274);
			interfaceBody(cv);

			            if (_localctx.typeParameters() != null) exitScope();
			            cv.visitEnd();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_PUBLIC() { return getToken(ASMParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PROTECTED() { return getToken(ASMParser.KW_PROTECTED, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(ASMParser.KW_PRIVATE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(ASMParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_STATIC() { return getToken(ASMParser.KW_STATIC, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public InterfaceModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InterfaceModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_interfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInterfaceModifier(this);
		}
	}

	public final InterfaceModifierContext interfaceModifier(int flags) throws RecognitionException {
		InterfaceModifierContext _localctx = new InterfaceModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 14, RULE_interfaceModifier);
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(KW_PUBLIC);
				((InterfaceModifierContext)_localctx).flag =  ACC_PUBLIC;
				setState(279);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Duplicate flag \"public\"");
				setState(280);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incomatible flags \"public\", \"protected\"");
				setState(281);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"public\", \"private\"");
				}
				break;
			case KW_PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(KW_PROTECTED);
				((InterfaceModifierContext)_localctx).flag =  ACC_PROTECTED;
				setState(284);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Duplicate flag \"protected\"");
				setState(285);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"protected\", \"public\"");
				setState(286);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"protected\", \"private\"");
				}
				break;
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(KW_PRIVATE);
				((InterfaceModifierContext)_localctx).flag =  ACC_PRIVATE;
				setState(289);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Duplicate flag \"private\"");
				setState(290);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"private\", \"public\"");
				setState(291);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incompatible flags \"private\", \"protected\"");
				}
				break;
			case KW_ABSTRACT:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				match(KW_ABSTRACT);
				((InterfaceModifierContext)_localctx).flag =  ACC_ABSTRACT;
				setState(294);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Duplicate flag \"abstract\"");
				setState(295);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Incompatible flags \"abstract\", \"final\"");
				setState(296);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Incompatible flags \"abstract\", \"static\"");
				}
				break;
			case KW_STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(297);
				match(KW_STATIC);
				((InterfaceModifierContext)_localctx).flag =  ACC_STATIC;
				setState(299);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Duplicate flag \"static\"");
				setState(300);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"static\", \"abstract\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(KW_SYNTHETIC);
				((InterfaceModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(303);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 7);
				{
				setState(304);
				match(KW_DEPRECATED);
				((InterfaceModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(306);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ASMParser.LT, 0); }
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ASMParser.GT, 0); }
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(LT);
			setState(310);
			typeParameterList();
			setState(311);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeParameterList(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			typeParameter();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(314);
				match(COMMA);
				setState(315);
				typeParameter();
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier;
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			((TypeParameterContext)_localctx).typeIdentifier = typeIdentifier();
			addTypeParameter((((TypeParameterContext)_localctx).typeIdentifier!=null?_input.getText(((TypeParameterContext)_localctx).typeIdentifier.start,((TypeParameterContext)_localctx).typeIdentifier.stop):null), _localctx);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_EXTENDS) {
				{
				setState(323);
				typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperclassContext extends ParserRuleContext {
		public TerminalNode KW_EXTENDS() { return getToken(ASMParser.KW_EXTENDS, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public SuperclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSuperclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSuperclass(this);
		}
	}

	public final SuperclassContext superclass() throws RecognitionException {
		SuperclassContext _localctx = new SuperclassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_superclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(KW_EXTENDS);
			setState(327);
			classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperinterfacesContext extends ParserRuleContext {
		public boolean isImplements;
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public TerminalNode KW_IMPLEMENTS() { return getToken(ASMParser.KW_IMPLEMENTS, 0); }
		public TerminalNode KW_EXTENDS() { return getToken(ASMParser.KW_EXTENDS, 0); }
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState, boolean isImplements) {
			super(parent, invokingState);
			this.isImplements = isImplements;
		}
		@Override public int getRuleIndex() { return RULE_superinterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSuperinterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSuperinterfaces(this);
		}
	}

	public final SuperinterfacesContext superinterfaces(boolean isImplements) throws RecognitionException {
		SuperinterfacesContext _localctx = new SuperinterfacesContext(_ctx, getState(), isImplements);
		enterRule(_localctx, 24, RULE_superinterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(329);
				if (!(_localctx.isImplements)) throw new FailedPredicateException(this, "$isImplements");
				setState(330);
				match(KW_IMPLEMENTS);
				}
				break;
			case 2:
				{
				setState(331);
				if (!(!_localctx.isImplements)) throw new FailedPredicateException(this, "!$isImplements");
				setState(332);
				match(KW_EXTENDS);
				}
				break;
			}
			setState(335);
			interfaceTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceTypeListContext extends ParserRuleContext {
		public List<ClassOrInterfaceTypeContext> classOrInterfaceType() {
			return getRuleContexts(ClassOrInterfaceTypeContext.class);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType(int i) {
			return getRuleContext(ClassOrInterfaceTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public InterfaceTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInterfaceTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInterfaceTypeList(this);
		}
	}

	public final InterfaceTypeListContext interfaceTypeList() throws RecognitionException {
		InterfaceTypeListContext _localctx = new InterfaceTypeListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_interfaceTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			classOrInterfaceType();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(338);
				match(COMMA);
				setState(339);
				classOrInterfaceType();
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public ClassVisitor cw;
		public TerminalNode LBRACE() { return getToken(ASMParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ASMParser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ClassBodyContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody(ClassVisitor cw) throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState(), cw);
		enterRule(_localctx, 28, RULE_classBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(LBRACE);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(346);
					classBodyDeclaration(_localctx.cw);
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(352);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public ClassVisitor cw;
		public TerminalNode LBRACE() { return getToken(ASMParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ASMParser.RBRACE, 0); }
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody(ClassVisitor cw) throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState(), cw);
		enterRule(_localctx, 30, RULE_interfaceBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(LBRACE);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(355);
					interfaceBodyDeclaration(_localctx.cw);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(361);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassVisitor cw;
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration(ClassVisitor cw) throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState(), cw);
		enterRule(_localctx, 32, RULE_classBodyDeclaration);
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				constructorDeclaration(_localctx.cw);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				methodDeclaration(_localctx.cw);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				fieldDeclaration(_localctx.cw);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public ClassVisitor cw;
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInterfaceBodyDeclaration(this);
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration(ClassVisitor cw) throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState(), cw);
		enterRule(_localctx, 34, RULE_interfaceBodyDeclaration);
		try {
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				methodDeclaration(_localctx.cw);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				fieldDeclaration(_localctx.cw);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ClassVisitor cw;
		public int flags;
		public ConstructorModifierContext constructorModifier;
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier;
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier() {
			return getRuleContext(QualifiedTypeIdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ASMParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ASMParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(ASMParser.SEMI, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<ConstructorModifierContext> constructorModifier() {
			return getRuleContexts(ConstructorModifierContext.class);
		}
		public ConstructorModifierContext constructorModifier(int i) {
			return getRuleContext(ConstructorModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ExceptionsContext exceptions() {
			return getRuleContext(ExceptionsContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitConstructorDeclaration(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration(ClassVisitor cw) throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState(), cw);
		enterRule(_localctx, 36, RULE_constructorDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ConstructorDeclarationContext)_localctx).flags =  0;
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(373);
					((ConstructorDeclarationContext)_localctx).constructorModifier = constructorModifier(_localctx.flags);
					_localctx.flags |= ((ConstructorDeclarationContext)_localctx).constructorModifier.flag;
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(381);
				typeParameters();
				enterScope();
				}
				break;
			}
			setState(386);
			((ConstructorDeclarationContext)_localctx).qualifiedTypeIdentifier = qualifiedTypeIdentifier();
			setState(387);
			if (!(((ConstructorDeclarationContext)_localctx).qualifiedTypeIdentifier.str.equals(currentClassName))) throw new FailedPredicateException(this, "$qualifiedTypeIdentifier.str.equals(currentClassName)", "Invalid constructor name, must be "+currentClassName);
			setState(388);
			match(LPAREN);
			localVarMode = MODE_UNDECIDED;
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(390);
				formalParameterList();
				}
				break;
			}
			setState(393);
			match(RPAREN);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THROWS) {
				{
				setState(394);
				exceptions();
				}
			}

			setState(397);
			match(SEMI);

			            var formalParameterList = _localctx.formalParameterList();
			            if (formalParameterList != null && formalParameterList.lastFormalParameter().variadicParameter() != null) {
			                _localctx.flags |= ACC_VARARGS;
			            }
			            var mv = cw.visitMethod(
			                // access
			                _localctx.flags,
			                // name
			                "<init>",
			                // descriptor
			                _localctx.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString(),
			                // signature
			                _localctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
			                // exceptions
			                getDescriptorsArray(_localctx.exceptions())
			            );
			            
			            addedThisLocalVar = false;
			            methodIsStatic = (_localctx.flags & ACC_STATIC) != 0;

			            if (localVarMode == MODE_NAMES) {
			                if (!methodIsStatic) {
			                    addedThisLocalVar = true;
			                    getVariable("this");
			                }
			                if (formalParameterList != null && formalParameterList.formalParameters() != null) {
			                    for (var formalParameter : formalParameterList.formalParameters().formalParameter()) {
			                        mv.visitParameter(formalParameter.name, formalParameter.flags);
			                        getVariable(formalParameter.name);
			                    }
			                    var lastFormalParameter = formalParameterList.lastFormalParameter();
			                    mv.visitParameter(lastFormalParameter.name, lastFormalParameter.flags);
			                    getVariable(lastFormalParameter.name);
			                }
			            }
			        
			setState(399);
			methodBody(mv, (_localctx.flags & (ACC_ABSTRACT | ACC_NATIVE)) == 0);

			            
			            if (_localctx.typeParameters() != null) exitScope();
			            if (localVarMode == MODE_NAMES) varnames = null;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_PUBLIC() { return getToken(ASMParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PROTECTED() { return getToken(ASMParser.KW_PROTECTED, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(ASMParser.KW_PRIVATE, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public ConstructorModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConstructorModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_constructorModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterConstructorModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitConstructorModifier(this);
		}
	}

	public final ConstructorModifierContext constructorModifier(int flags) throws RecognitionException {
		ConstructorModifierContext _localctx = new ConstructorModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 38, RULE_constructorModifier);
		try {
			setState(423);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				match(KW_PUBLIC);
				((ConstructorModifierContext)_localctx).flag =  ACC_PUBLIC;
				setState(404);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Duplicate flag \"public\"");
				setState(405);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incomatible flags \"public\", \"protected\"");
				setState(406);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"public\", \"private\"");
				}
				break;
			case KW_PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(KW_PROTECTED);
				((ConstructorModifierContext)_localctx).flag =  ACC_PROTECTED;
				setState(409);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Duplicate flag \"protected\"");
				setState(410);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"protected\", \"public\"");
				setState(411);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"protected\", \"private\"");
				}
				break;
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(412);
				match(KW_PRIVATE);
				((ConstructorModifierContext)_localctx).flag =  ACC_PRIVATE;
				setState(414);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Duplicate flag \"private\"");
				setState(415);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"private\", \"public\"");
				setState(416);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incompatible flags \"private\", \"protected\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 4);
				{
				setState(417);
				match(KW_SYNTHETIC);
				((ConstructorModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(419);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 5);
				{
				setState(420);
				match(KW_DEPRECATED);
				((ConstructorModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(422);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public ClassVisitor cw;
		public int flags;
		public MethodModifierContext methodModifier;
		public IdentifierContext identifier;
		public TypeOrVoidContext typeOrVoid() {
			return getRuleContext(TypeOrVoidContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ASMParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ASMParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(ASMParser.SEMI, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ExceptionsContext exceptions() {
			return getRuleContext(ExceptionsContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration(ClassVisitor cw) throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState(), cw);
		enterRule(_localctx, 40, RULE_methodDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((MethodDeclarationContext)_localctx).flags =  0;
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(426);
					((MethodDeclarationContext)_localctx).methodModifier = methodModifier(_localctx.flags);
					_localctx.flags |= ((MethodDeclarationContext)_localctx).methodModifier.flag;
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(434);
				typeParameters();
				enterScope();
				}
				break;
			}
			setState(439);
			typeOrVoid();
			setState(440);
			((MethodDeclarationContext)_localctx).identifier = identifier();
			setState(441);
			match(LPAREN);
			localVarMode = MODE_UNDECIDED;
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(443);
				formalParameterList();
				}
				break;
			}
			setState(446);
			match(RPAREN);
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THROWS) {
				{
				setState(447);
				exceptions();
				}
			}

			setState(450);
			match(SEMI);

			            var formalParameterList = _localctx.formalParameterList();
			            if (formalParameterList != null && formalParameterList.lastFormalParameter().variadicParameter() != null) {
			                _localctx.flags |= ACC_VARARGS;
			            }
			            var mv = cw.visitMethod(
			                // access
			                _localctx.flags,
			                // name
			                ((MethodDeclarationContext)_localctx).identifier.str,
			                // descriptor
			                _localctx.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString(),
			                // signature
			                _localctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
			                // exceptions
			                getDescriptorsArray(_localctx.exceptions())
			            );
			            
			            addedThisLocalVar = false;
			            methodIsStatic = (_localctx.flags & ACC_STATIC) != 0;

			            if (localVarMode == MODE_NAMES) {
			                if (!methodIsStatic) {
			                    addedThisLocalVar = true;
			                    getVariable("this");
			                }
			                if (formalParameterList != null && formalParameterList.formalParameters() != null) {
			                    for (var formalParameter : formalParameterList.formalParameters().formalParameter()) {
			                        mv.visitParameter(formalParameter.name, formalParameter.flags);
			                        getVariable(formalParameter.name);
			                    }
			                    var lastFormalParameter = formalParameterList.lastFormalParameter();
			                    mv.visitParameter(lastFormalParameter.name, lastFormalParameter.flags);
			                    getVariable(lastFormalParameter.name);
			                }
			            }
			        
			setState(452);
			methodBody(mv, (_localctx.flags & (ACC_ABSTRACT | ACC_NATIVE)) == 0);

			            
			            if (_localctx.typeParameters() != null) exitScope();
			            if (localVarMode == MODE_NAMES) varnames = null;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_PUBLIC() { return getToken(ASMParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PROTECTED() { return getToken(ASMParser.KW_PROTECTED, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(ASMParser.KW_PRIVATE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(ASMParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_STATIC() { return getToken(ASMParser.KW_STATIC, 0); }
		public TerminalNode KW_FINAL() { return getToken(ASMParser.KW_FINAL, 0); }
		public TerminalNode KW_SYNCHRONIZED() { return getToken(ASMParser.KW_SYNCHRONIZED, 0); }
		public TerminalNode KW_NATIVE() { return getToken(ASMParser.KW_NATIVE, 0); }
		public TerminalNode KW_STRICTFP() { return getToken(ASMParser.KW_STRICTFP, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public TerminalNode KW_BRIDGE() { return getToken(ASMParser.KW_BRIDGE, 0); }
		public TerminalNode KW_MANDATED() { return getToken(ASMParser.KW_MANDATED, 0); }
		public MethodModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MethodModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitMethodModifier(this);
		}
	}

	public final MethodModifierContext methodModifier(int flags) throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 42, RULE_methodModifier);
		try {
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(KW_PUBLIC);
				((MethodModifierContext)_localctx).flag =  ACC_PUBLIC;
				setState(457);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Duplicate flag \"public\"");
				setState(458);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incomatible flags \"public\", \"protected\"");
				setState(459);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"public\", \"private\"");
				}
				break;
			case KW_PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				match(KW_PROTECTED);
				((MethodModifierContext)_localctx).flag =  ACC_PROTECTED;
				setState(462);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Duplicate flag \"protected\"");
				setState(463);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"protected\", \"public\"");
				setState(464);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"protected\", \"private\"");
				}
				break;
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(465);
				match(KW_PRIVATE);
				((MethodModifierContext)_localctx).flag =  ACC_PRIVATE;
				setState(467);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Duplicate flag \"private\"");
				setState(468);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"private\", \"public\"");
				setState(469);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incompatible flags \"private\", \"protected\"");
				}
				break;
			case KW_ABSTRACT:
				enterOuterAlt(_localctx, 4);
				{
				setState(470);
				match(KW_ABSTRACT);
				((MethodModifierContext)_localctx).flag =  ACC_ABSTRACT;
				setState(472);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Duplicate flag \"abstract\"");
				setState(473);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Incompatible flags \"abstract\", \"final\"");
				setState(474);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Incompatible flags \"abstract\", \"static\"");
				setState(475);
				if (!((_localctx.flags & ACC_SYNCHRONIZED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNCHRONIZED) == 0", "Incompatible flags \"abstract\", \"synchronized\"");
				setState(476);
				if (!((_localctx.flags & ACC_NATIVE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_NATIVE) == 0", "Incompatible flags \"abstract\", \"native\"");
				setState(477);
				if (!((_localctx.flags & ACC_STRICT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STRICT) == 0", "Incompatible flags \"abstract\", \"strictfp\"");
				}
				break;
			case KW_STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(478);
				match(KW_STATIC);
				((MethodModifierContext)_localctx).flag =  ACC_STATIC;
				setState(480);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Duplicate flag \"static\"");
				setState(481);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"static\", \"abstract\"");
				}
				break;
			case KW_FINAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(482);
				match(KW_FINAL);
				((MethodModifierContext)_localctx).flag =  ACC_FINAL;
				setState(484);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Duplicate flag \"final\"");
				setState(485);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"final\", \"abstract\"");
				}
				break;
			case KW_SYNCHRONIZED:
				enterOuterAlt(_localctx, 7);
				{
				setState(486);
				match(KW_SYNCHRONIZED);
				((MethodModifierContext)_localctx).flag =  ACC_SYNCHRONIZED;
				setState(488);
				if (!((_localctx.flags & ACC_SYNCHRONIZED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNCHRONIZED) == 0", "Duplicate flag \"synchronized\"");
				setState(489);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"synchronized\", \"abstract\"");
				}
				break;
			case KW_NATIVE:
				enterOuterAlt(_localctx, 8);
				{
				setState(490);
				match(KW_NATIVE);
				((MethodModifierContext)_localctx).flag =  ACC_NATIVE;
				setState(492);
				if (!((_localctx.flags & ACC_NATIVE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_NATIVE) == 0", "Duplicate flag \"native\"");
				setState(493);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"native\", \"abstract\"");
				setState(494);
				if (!((_localctx.flags & ACC_STRICT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STRICT) == 0", "Incompatible flags \"native\", \"strictfp\"");
				}
				break;
			case KW_STRICTFP:
				enterOuterAlt(_localctx, 9);
				{
				setState(495);
				match(KW_STRICTFP);
				((MethodModifierContext)_localctx).flag =  ACC_STRICT;
				setState(497);
				if (!((_localctx.flags & ACC_STRICT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STRICT) == 0", "Duplicate flag \"strictfp\"");
				setState(498);
				if (!((_localctx.flags & ACC_ABSTRACT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_ABSTRACT) == 0", "Incompatible flags \"strictfp\", \"abstract\"");
				setState(499);
				if (!((_localctx.flags & ACC_NATIVE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_NATIVE) == 0", "Incompatible flags \"strictfp\", \"native\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 10);
				{
				setState(500);
				match(KW_SYNTHETIC);
				((MethodModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(502);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 11);
				{
				setState(503);
				match(KW_DEPRECATED);
				((MethodModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(505);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			case KW_BRIDGE:
				enterOuterAlt(_localctx, 12);
				{
				setState(506);
				match(KW_BRIDGE);
				((MethodModifierContext)_localctx).flag =  ACC_BRIDGE;
				setState(508);
				if (!((_localctx.flags & ACC_BRIDGE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_BRIDGE) == 0", "Duplicate flag \"bridge\"");
				}
				break;
			case KW_MANDATED:
				enterOuterAlt(_localctx, 13);
				{
				setState(509);
				match(KW_MANDATED);
				((MethodModifierContext)_localctx).flag =  ACC_MANDATED;
				setState(511);
				if (!((_localctx.flags & ACC_MANDATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_MANDATED) == 0", "Duplicate flag \"mandated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public ClassVisitor cw;
		public int flags;
		public FieldModifierContext fieldModifier;
		public IdentifierContext identifier;
		public StringLiteralContext stringLiteral;
		public SignedByteLiteralContext signedByteLiteral;
		public SignedShortLiteralContext signedShortLiteral;
		public CharacterLiteralContext characterLiteral;
		public SignedIntegerLiteralContext signedIntegerLiteral;
		public SignedLongLiteralContext signedLongLiteral;
		public FloatLiteralContext floatLiteral;
		public DoubleLiteralContext doubleLiteral;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ASMParser.SEMI, 0); }
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ASMParser.EQ, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public SignedByteLiteralContext signedByteLiteral() {
			return getRuleContext(SignedByteLiteralContext.class,0);
		}
		public SignedShortLiteralContext signedShortLiteral() {
			return getRuleContext(SignedShortLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public SignedIntegerLiteralContext signedIntegerLiteral() {
			return getRuleContext(SignedIntegerLiteralContext.class,0);
		}
		public SignedLongLiteralContext signedLongLiteral() {
			return getRuleContext(SignedLongLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public DoubleLiteralContext doubleLiteral() {
			return getRuleContext(DoubleLiteralContext.class,0);
		}
		public TerminalNode KW_NULL() { return getToken(ASMParser.KW_NULL, 0); }
		public TerminalNode KW_TRUE() { return getToken(ASMParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(ASMParser.KW_FALSE, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState, ClassVisitor cw) {
			super(parent, invokingState);
			this.cw = cw;
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration(ClassVisitor cw) throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState(), cw);
		enterRule(_localctx, 44, RULE_fieldDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((FieldDeclarationContext)_localctx).flags =  0;
			setState(520);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(515);
					((FieldDeclarationContext)_localctx).fieldModifier = fieldModifier(_localctx.flags);
					_localctx.flags |= ((FieldDeclarationContext)_localctx).fieldModifier.flag;
					}
					} 
				}
				setState(522);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(523);
			type();
			setState(524);
			((FieldDeclarationContext)_localctx).identifier = identifier();
			Object initialValue = null;
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(526);
				if (!((_localctx.flags & ACC_STATIC) != 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) != 0");
				setState(527);
				match(EQ);
				setState(568);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(528);
					if (!(isString(_localctx.type()))) throw new FailedPredicateException(this, "isString($ctx.type())");
					setState(529);
					((FieldDeclarationContext)_localctx).stringLiteral = stringLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).stringLiteral.value;
					}
					break;
				case 2:
					{
					setState(532);
					if (!(isBoolean(_localctx.type()))) throw new FailedPredicateException(this, "isBoolean($ctx.type())");
					setState(537);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_TRUE:
						{
						setState(533);
						match(KW_TRUE);
						initialValue = true;
						}
						break;
					case KW_FALSE:
						{
						setState(535);
						match(KW_FALSE);
						initialValue = false;
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 3:
					{
					setState(539);
					if (!(isByte(_localctx.type()))) throw new FailedPredicateException(this, "isByte($ctx.type())");
					setState(540);
					((FieldDeclarationContext)_localctx).signedByteLiteral = signedByteLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).signedByteLiteral.value;
					}
					break;
				case 4:
					{
					setState(543);
					if (!(isShort(_localctx.type()))) throw new FailedPredicateException(this, "isShort($ctx.type())");
					setState(544);
					((FieldDeclarationContext)_localctx).signedShortLiteral = signedShortLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).signedShortLiteral.value;
					}
					break;
				case 5:
					{
					setState(547);
					if (!(isChar(_localctx.type()))) throw new FailedPredicateException(this, "isChar($ctx.type())");
					setState(548);
					((FieldDeclarationContext)_localctx).characterLiteral = characterLiteral();
					initialValue = (int)((FieldDeclarationContext)_localctx).characterLiteral.value;
					}
					break;
				case 6:
					{
					setState(551);
					if (!(isInt(_localctx.type()))) throw new FailedPredicateException(this, "isInt($ctx.type())");
					setState(552);
					((FieldDeclarationContext)_localctx).signedIntegerLiteral = signedIntegerLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).signedIntegerLiteral.value;
					}
					break;
				case 7:
					{
					setState(555);
					if (!(isLong(_localctx.type()))) throw new FailedPredicateException(this, "isLong($ctx.type())");
					setState(556);
					((FieldDeclarationContext)_localctx).signedLongLiteral = signedLongLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).signedLongLiteral.value;
					}
					break;
				case 8:
					{
					setState(559);
					if (!(isFloat(_localctx.type()))) throw new FailedPredicateException(this, "isFloat($ctx.type())");
					setState(560);
					((FieldDeclarationContext)_localctx).floatLiteral = floatLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).floatLiteral.value;
					}
					break;
				case 9:
					{
					setState(563);
					if (!(isDouble(_localctx.type()))) throw new FailedPredicateException(this, "isDouble($ctx.type())");
					setState(564);
					((FieldDeclarationContext)_localctx).doubleLiteral = doubleLiteral();
					initialValue = ((FieldDeclarationContext)_localctx).doubleLiteral.value;
					}
					break;
				case 10:
					{
					setState(567);
					match(KW_NULL);
					}
					break;
				}
				}
				break;
			}
			setState(572);
			match(SEMI);

			            var fv = cw.visitField(
			                // access
			                _localctx.flags,
			                // name
			                ((FieldDeclarationContext)_localctx).identifier.str,
			                // descriptor
			                getDescriptor(_localctx.type()),
			                // signature
			                getSignature(_localctx.type()),
			                // value
			                initialValue
			            );
			            fv.visitEnd();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_PUBLIC() { return getToken(ASMParser.KW_PUBLIC, 0); }
		public TerminalNode KW_PROTECTED() { return getToken(ASMParser.KW_PROTECTED, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(ASMParser.KW_PRIVATE, 0); }
		public TerminalNode KW_STATIC() { return getToken(ASMParser.KW_STATIC, 0); }
		public TerminalNode KW_FINAL() { return getToken(ASMParser.KW_FINAL, 0); }
		public TerminalNode KW_TRANSIENT() { return getToken(ASMParser.KW_TRANSIENT, 0); }
		public TerminalNode KW_VOLATILE() { return getToken(ASMParser.KW_VOLATILE, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public TerminalNode KW_MANDATED() { return getToken(ASMParser.KW_MANDATED, 0); }
		public FieldModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FieldModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFieldModifier(this);
		}
	}

	public final FieldModifierContext fieldModifier(int flags) throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 46, RULE_fieldModifier);
		try {
			setState(611);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				match(KW_PUBLIC);
				((FieldModifierContext)_localctx).flag =  ACC_PUBLIC;
				setState(577);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Duplicate flag \"public\"");
				setState(578);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incomatible flags \"public\", \"protected\"");
				setState(579);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"public\", \"private\"");
				}
				break;
			case KW_PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(580);
				match(KW_PROTECTED);
				((FieldModifierContext)_localctx).flag =  ACC_PROTECTED;
				setState(582);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Duplicate flag \"protected\"");
				setState(583);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"protected\", \"public\"");
				setState(584);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Incompatible flags \"protected\", \"private\"");
				}
				break;
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				match(KW_PRIVATE);
				((FieldModifierContext)_localctx).flag =  ACC_PRIVATE;
				setState(587);
				if (!((_localctx.flags & ACC_PRIVATE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PRIVATE) == 0", "Duplicate flag \"private\"");
				setState(588);
				if (!((_localctx.flags & ACC_PUBLIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PUBLIC) == 0", "Incompatible flags \"private\", \"public\"");
				setState(589);
				if (!((_localctx.flags & ACC_PROTECTED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_PROTECTED) == 0", "Incompatible flags \"private\", \"protected\"");
				}
				break;
			case KW_STATIC:
				enterOuterAlt(_localctx, 4);
				{
				setState(590);
				match(KW_STATIC);
				((FieldModifierContext)_localctx).flag =  ACC_STATIC;
				setState(592);
				if (!((_localctx.flags & ACC_STATIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_STATIC) == 0", "Duplicate flag \"static\"");
				}
				break;
			case KW_FINAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(593);
				match(KW_FINAL);
				((FieldModifierContext)_localctx).flag =  ACC_FINAL;
				setState(595);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Duplicate flag \"final\"");
				}
				break;
			case KW_TRANSIENT:
				enterOuterAlt(_localctx, 6);
				{
				setState(596);
				match(KW_TRANSIENT);
				((FieldModifierContext)_localctx).flag =  ACC_TRANSIENT;
				setState(598);
				if (!((_localctx.flags & ACC_TRANSIENT) == 0)) throw new FailedPredicateException(this, "($flags & ACC_TRANSIENT) == 0", "Duplicate flag \"transient\"");
				}
				break;
			case KW_VOLATILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(599);
				match(KW_VOLATILE);
				((FieldModifierContext)_localctx).flag =  ACC_VOLATILE;
				setState(601);
				if (!((_localctx.flags & ACC_VOLATILE) == 0)) throw new FailedPredicateException(this, "($flags & ACC_VOLATILE) == 0", "Duplicate flag \"volatile\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 8);
				{
				setState(602);
				match(KW_SYNTHETIC);
				((FieldModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(604);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 9);
				{
				setState(605);
				match(KW_DEPRECATED);
				((FieldModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(607);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			case KW_MANDATED:
				enterOuterAlt(_localctx, 10);
				{
				setState(608);
				match(KW_MANDATED);
				((FieldModifierContext)_localctx).flag =  ACC_MANDATED;
				setState(610);
				if (!((_localctx.flags & ACC_MANDATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_MANDATED) == 0", "Duplicate flag \"mandated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ASMParser.COMMA, 0); }
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_formalParameterList);
		try {
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				formalParameters();
				setState(614);
				match(COMMA);
				setState(615);
				lastFormalParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_formalParameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			formalParameter();
			setState(625);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(621);
					match(COMMA);
					setState(622);
					formalParameter();
					}
					} 
				}
				setState(627);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public int flags;
		public String name;
		public VariableModifierContext variableModifier;
		public IdentifierContext identifier;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_formalParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((FormalParameterContext)_localctx).flags =  0;
			setState(634);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(629);
					((FormalParameterContext)_localctx).variableModifier = variableModifier(_localctx.flags);
					_localctx.flags |= ((FormalParameterContext)_localctx).variableModifier.flag;
					}
					} 
				}
				setState(636);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(637);
			type();
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(638);
				if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
				setState(639);
				((FormalParameterContext)_localctx).identifier = identifier();
				localVarMode = MODE_NAMES; ((FormalParameterContext)_localctx).name =  ((FormalParameterContext)_localctx).identifier.str;
				}
				break;
			case 2:
				{
				setState(642);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				localVarMode = MODE_INDICES;
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public int flags;
		public int flag;
		public TerminalNode KW_FINAL() { return getToken(ASMParser.KW_FINAL, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public TerminalNode KW_MANDATED() { return getToken(ASMParser.KW_MANDATED, 0); }
		public VariableModifierContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public VariableModifierContext(ParserRuleContext parent, int invokingState, int flags) {
			super(parent, invokingState);
			this.flags = flags;
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitVariableModifier(this);
		}
	}

	public final VariableModifierContext variableModifier(int flags) throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState(), flags);
		enterRule(_localctx, 54, RULE_variableModifier);
		try {
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_FINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				match(KW_FINAL);
				((VariableModifierContext)_localctx).flag =  ACC_FINAL;
				setState(648);
				if (!((_localctx.flags & ACC_FINAL) == 0)) throw new FailedPredicateException(this, "($flags & ACC_FINAL) == 0", "Duplicate flag \"final\"");
				}
				break;
			case KW_SYNTHETIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				match(KW_SYNTHETIC);
				((VariableModifierContext)_localctx).flag =  ACC_SYNTHETIC;
				setState(651);
				if (!((_localctx.flags & ACC_SYNTHETIC) == 0)) throw new FailedPredicateException(this, "($flags & ACC_SYNTHETIC) == 0", "Duplicate flag \"synthetic\"");
				}
				break;
			case KW_DEPRECATED:
				enterOuterAlt(_localctx, 3);
				{
				setState(652);
				match(KW_DEPRECATED);
				((VariableModifierContext)_localctx).flag =  ACC_DEPRECATED;
				setState(654);
				if (!((_localctx.flags & ACC_DEPRECATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_DEPRECATED) == 0", "Duplicate flag \"deprecated\"");
				}
				break;
			case KW_MANDATED:
				enterOuterAlt(_localctx, 4);
				{
				setState(655);
				match(KW_MANDATED);
				((VariableModifierContext)_localctx).flag =  ACC_MANDATED;
				setState(657);
				if (!((_localctx.flags & ACC_MANDATED) == 0)) throw new FailedPredicateException(this, "($flags & ACC_MANDATED) == 0", "Duplicate flag \"mandated\"");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LastFormalParameterContext extends ParserRuleContext {
		public int flags;
		public String name;
		public VariadicParameterContext variadicParameter;
		public FormalParameterContext formalParameter;
		public VariadicParameterContext variadicParameter() {
			return getRuleContext(VariadicParameterContext.class,0);
		}
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLastFormalParameter(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_lastFormalParameter);
		try {
			setState(666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				((LastFormalParameterContext)_localctx).variadicParameter = variadicParameter();
				((LastFormalParameterContext)_localctx).flags =  ((LastFormalParameterContext)_localctx).variadicParameter.flags; ((LastFormalParameterContext)_localctx).name =  ((LastFormalParameterContext)_localctx).variadicParameter.name;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				((LastFormalParameterContext)_localctx).formalParameter = formalParameter();
				((LastFormalParameterContext)_localctx).flags =  ((LastFormalParameterContext)_localctx).formalParameter.flags;   ((LastFormalParameterContext)_localctx).name =  ((LastFormalParameterContext)_localctx).formalParameter.name;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariadicParameterContext extends ParserRuleContext {
		public int flags;
		public String name;
		public VariableModifierContext variableModifier;
		public IdentifierContext identifier;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(ASMParser.ELLIPSIS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public VariadicParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variadicParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterVariadicParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitVariadicParameter(this);
		}
	}

	public final VariadicParameterContext variadicParameter() throws RecognitionException {
		VariadicParameterContext _localctx = new VariadicParameterContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variadicParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((VariadicParameterContext)_localctx).flags =  0;
			setState(674);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(669);
					((VariadicParameterContext)_localctx).variableModifier = variableModifier(_localctx.flags);
					_localctx.flags |= ((VariadicParameterContext)_localctx).variableModifier.flag;
					}
					} 
				}
				setState(676);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(677);
			type();
			setState(678);
			match(ELLIPSIS);
			_localctx.flags |= ACC_VARARGS;
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(680);
				if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
				setState(681);
				((VariadicParameterContext)_localctx).identifier = identifier();
				localVarMode = MODE_NAMES; ((VariadicParameterContext)_localctx).name =  ((VariadicParameterContext)_localctx).identifier.str;
				}
				break;
			case 2:
				{
				setState(684);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				localVarMode = MODE_INDICES;
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionsContext extends ParserRuleContext {
		public TerminalNode KW_THROWS() { return getToken(ASMParser.KW_THROWS, 0); }
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public ExceptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterExceptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitExceptions(this);
		}
	}

	public final ExceptionsContext exceptions() throws RecognitionException {
		ExceptionsContext _localctx = new ExceptionsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_exceptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(KW_THROWS);
			setState(689);
			exceptionTypeList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterExceptionTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitExceptionTypeList(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			exceptionType();
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(692);
				match(COMMA);
				setState(693);
				exceptionType();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitExceptionType(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exceptionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public MethodVisitor mv;
		public boolean hasCode;
		public TerminalNode KW_CODE() { return getToken(ASMParser.KW_CODE, 0); }
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState, MethodVisitor mv, boolean hasCode) {
			super(parent, invokingState);
			this.mv = mv;
			this.hasCode = hasCode;
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody(MethodVisitor mv,boolean hasCode) throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState(), mv, hasCode);
		enterRule(_localctx, 66, RULE_methodBody);
		try {
			int _alt;
			setState(714);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(701);
				match(KW_CODE);
				setState(702);
				match(COLON);
				setState(703);
				if (!(_localctx.hasCode)) throw new FailedPredicateException(this, "$hasCode", "This method may not define a body");
				_localctx.mv.visitCode(); labels = new HashMap<>();
				setState(706); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(705);
						statement(_localctx.mv);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(708); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				_localctx.mv.visitMaxs(1, 2); _localctx.mv.visitEnd(); labels = null;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(712);
				if (!(!_localctx.hasCode)) throw new FailedPredicateException(this, "!$hasCode", "This method must define a body");
				_localctx.mv.visitEnd();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public MethodVisitor mv;
		public LabelDeclarationContext labelDeclaration() {
			return getRuleContext(LabelDeclarationContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, MethodVisitor mv) {
			super(parent, invokingState);
			this.mv = mv;
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement(MethodVisitor mv) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), mv);
		enterRule(_localctx, 68, RULE_statement);
		try {
			setState(718);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SYNTHETIC:
			case KW_MANDATED:
			case KW_BRIDGE:
			case KW_DEPRECATED:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(716);
				labelDeclaration(_localctx.mv);
				}
				break;
			case KW_GOTO:
			case KW_INSTANCEOF:
			case KW_NEW:
			case KW_RETURN:
			case KW_AASTORE:
			case KW_ACONST_NULL:
			case KW_ALOAD:
			case KW_ALOAD_0:
			case KW_ALOAD_1:
			case KW_ALOAD_2:
			case KW_ALOAD_3:
			case KW_ANEWARRAY:
			case KW_ARETURN:
			case KW_ARRAYLENGTH:
			case KW_ASTORE:
			case KW_ASTORE_0:
			case KW_ASTORE_1:
			case KW_ASTORE_2:
			case KW_ASTORE_3:
			case KW_ATHROW:
			case KW_BALOAD:
			case KW_BASTORE:
			case KW_BIPUSH:
			case KW_CALOAD:
			case KW_CASTORE:
			case KW_CHECKCAST:
			case KW_D2F:
			case KW_D2I:
			case KW_D2L:
			case KW_DADD:
			case KW_DALOAD:
			case KW_DASTORE:
			case KW_DCMPG:
			case KW_DCMPL:
			case KW_DCONST_0:
			case KW_DCONST_1:
			case KW_DDIV:
			case KW_DLOAD:
			case KW_DLOAD_0:
			case KW_DLOAD_1:
			case KW_DLOAD_2:
			case KW_DLOAD_3:
			case KW_DMUL:
			case KW_DNEG:
			case KW_DREM:
			case KW_DRETURN:
			case KW_DSTORE:
			case KW_DSTORE_0:
			case KW_DSTORE_1:
			case KW_DSTORE_2:
			case KW_DSTORE_3:
			case KW_DSUB:
			case KW_DUP:
			case KW_DUP_X1:
			case KW_DUP_X2:
			case KW_DUP2:
			case KW_DUP2_X1:
			case KW_DUP2_X2:
			case KW_F2D:
			case KW_F2I:
			case KW_F2L:
			case KW_FADD:
			case KW_FALOAD:
			case KW_FASTORE:
			case KW_FCMPG:
			case KW_FCMPL:
			case KW_FCONST_0:
			case KW_FCONST_1:
			case KW_FCONST_2:
			case KW_FDIV:
			case KW_FLOAD:
			case KW_FLOAD_0:
			case KW_FLOAD_1:
			case KW_FLOAD_2:
			case KW_FLOAD_3:
			case KW_FMUL:
			case KW_FNEG:
			case KW_FREM:
			case KW_FRETURN:
			case KW_FSTORE:
			case KW_FSTORE_0:
			case KW_FSTORE_1:
			case KW_FSTORE_2:
			case KW_FSTORE_3:
			case KW_FSUB:
			case KW_GETFIELD:
			case KW_GETSTATIC:
			case KW_GOTO_W:
			case KW_I2B:
			case KW_I2C:
			case KW_I2D:
			case KW_I2F:
			case KW_I2L:
			case KW_I2S:
			case KW_IADD:
			case KW_IALOAD:
			case KW_IAND:
			case KW_IASTORE:
			case KW_ICONST_M1:
			case KW_ICONST_0:
			case KW_ICONST_1:
			case KW_ICONST_2:
			case KW_ICONST_3:
			case KW_ICONST_4:
			case KW_ICONST_5:
			case KW_IDIV:
			case KW_IF_ACMPEQ:
			case KW_IF_ACMPNE:
			case KW_IF_ICMPEQ:
			case KW_IF_ICMPNE:
			case KW_IF_ICMPLT:
			case KW_IF_ICMPGE:
			case KW_IF_ICMPGT:
			case KW_IF_ICMPLE:
			case KW_IFEQ:
			case KW_IFNE:
			case KW_IFLT:
			case KW_IFGE:
			case KW_IFGT:
			case KW_IFLE:
			case KW_IFNONNULL:
			case KW_IFNULL:
			case KW_IINC:
			case KW_ILOAD:
			case KW_ILOAD_0:
			case KW_ILOAD_1:
			case KW_ILOAD_2:
			case KW_ILOAD_3:
			case KW_IMUL:
			case KW_INEG:
			case KW_INVOKEDYNAMIC:
			case KW_INVOKEINTERFACE:
			case KW_INVOKESPECIAL:
			case KW_INVOKESTATIC:
			case KW_INVOKEVIRTUAL:
			case KW_IOR:
			case KW_IREM:
			case KW_IRETURN:
			case KW_ISHL:
			case KW_ISHR:
			case KW_ISTORE:
			case KW_ISTORE_0:
			case KW_ISTORE_1:
			case KW_ISTORE_2:
			case KW_ISTORE_3:
			case KW_ISUB:
			case KW_IUSHR:
			case KW_IXOR:
			case KW_JSR:
			case KW_JSR_W:
			case KW_L2D:
			case KW_L2F:
			case KW_L2I:
			case KW_LADD:
			case KW_LALOAD:
			case KW_LAND:
			case KW_LASTORE:
			case KW_LCMP:
			case KW_LCONST_0:
			case KW_LCONST_1:
			case KW_LDC:
			case KW_LDC_W:
			case KW_LDC2_W:
			case KW_LDIV:
			case KW_LLOAD:
			case KW_LLOAD_0:
			case KW_LLOAD_1:
			case KW_LLOAD_2:
			case KW_LLOAD_3:
			case KW_LMUL:
			case KW_LNEG:
			case KW_LOOKUPSWITCH:
			case KW_LOR:
			case KW_LREM:
			case KW_LRETURN:
			case KW_LSHL:
			case KW_LSHR:
			case KW_LSTORE:
			case KW_LSTORE_0:
			case KW_LSTORE_1:
			case KW_LSTORE_2:
			case KW_LSTORE_3:
			case KW_LSUB:
			case KW_LUSHR:
			case KW_LXOR:
			case KW_MONITORENTER:
			case KW_MONITOREXIT:
			case KW_MULTIANEWARRAY:
			case KW_NEWARRAY:
			case KW_NOP:
			case KW_POP:
			case KW_POP2:
			case KW_PUTFIELD:
			case KW_PUTSTATIC:
			case KW_RET:
			case KW_SALOAD:
			case KW_SASTORE:
			case KW_SIPUSH:
			case KW_SWAP:
			case KW_TABLESWITCH:
			case KW_WIDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(717);
				instruction(_localctx.mv);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelDeclarationContext extends ParserRuleContext {
		public MethodVisitor mv;
		public LabelIdentifierContext labelIdentifier;
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public LabelDeclarationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LabelDeclarationContext(ParserRuleContext parent, int invokingState, MethodVisitor mv) {
			super(parent, invokingState);
			this.mv = mv;
		}
		@Override public int getRuleIndex() { return RULE_labelDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLabelDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLabelDeclaration(this);
		}
	}

	public final LabelDeclarationContext labelDeclaration(MethodVisitor mv) throws RecognitionException {
		LabelDeclarationContext _localctx = new LabelDeclarationContext(_ctx, getState(), mv);
		enterRule(_localctx, 70, RULE_labelDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			((LabelDeclarationContext)_localctx).labelIdentifier = labelIdentifier();
			setState(721);
			match(COLON);
			_localctx.mv.visitLabel(getLabel(((LabelDeclarationContext)_localctx).labelIdentifier.str));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public MethodVisitor mv;
		public Token name;
		public IntegerLiteralContext integerLiteral;
		public IdentifierContext identifier;
		public SignedByteLiteralContext signedByteLiteral;
		public FieldRefContext fieldRef;
		public LabelIdentifierContext labelIdentifier;
		public SignedIntegerLiteralContext signedIntegerLiteral;
		public MethodRefContext methodRef;
		public LoadableConstantContext loadableConstant;
		public PrimitiveTypeContext primitiveType;
		public SignedShortLiteralContext signedShortLiteral;
		public TerminalNode KW_AASTORE() { return getToken(ASMParser.KW_AASTORE, 0); }
		public TerminalNode KW_ACONST_NULL() { return getToken(ASMParser.KW_ACONST_NULL, 0); }
		public TerminalNode KW_ALOAD() { return getToken(ASMParser.KW_ALOAD, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public TerminalNode KW_WIDE() { return getToken(ASMParser.KW_WIDE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode KW_THIS() { return getToken(ASMParser.KW_THIS, 0); }
		public TerminalNode KW_ALOAD_0() { return getToken(ASMParser.KW_ALOAD_0, 0); }
		public TerminalNode KW_ALOAD_1() { return getToken(ASMParser.KW_ALOAD_1, 0); }
		public TerminalNode KW_ALOAD_2() { return getToken(ASMParser.KW_ALOAD_2, 0); }
		public TerminalNode KW_ALOAD_3() { return getToken(ASMParser.KW_ALOAD_3, 0); }
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode KW_ANEWARRAY() { return getToken(ASMParser.KW_ANEWARRAY, 0); }
		public TerminalNode KW_ARETURN() { return getToken(ASMParser.KW_ARETURN, 0); }
		public TerminalNode KW_ARRAYLENGTH() { return getToken(ASMParser.KW_ARRAYLENGTH, 0); }
		public TerminalNode KW_ASTORE() { return getToken(ASMParser.KW_ASTORE, 0); }
		public TerminalNode KW_ASTORE_0() { return getToken(ASMParser.KW_ASTORE_0, 0); }
		public TerminalNode KW_ASTORE_1() { return getToken(ASMParser.KW_ASTORE_1, 0); }
		public TerminalNode KW_ASTORE_2() { return getToken(ASMParser.KW_ASTORE_2, 0); }
		public TerminalNode KW_ASTORE_3() { return getToken(ASMParser.KW_ASTORE_3, 0); }
		public TerminalNode KW_ATHROW() { return getToken(ASMParser.KW_ATHROW, 0); }
		public TerminalNode KW_BALOAD() { return getToken(ASMParser.KW_BALOAD, 0); }
		public TerminalNode KW_BASTORE() { return getToken(ASMParser.KW_BASTORE, 0); }
		public SignedByteLiteralContext signedByteLiteral() {
			return getRuleContext(SignedByteLiteralContext.class,0);
		}
		public TerminalNode KW_BIPUSH() { return getToken(ASMParser.KW_BIPUSH, 0); }
		public TerminalNode KW_CALOAD() { return getToken(ASMParser.KW_CALOAD, 0); }
		public TerminalNode KW_CASTORE() { return getToken(ASMParser.KW_CASTORE, 0); }
		public TerminalNode KW_CHECKCAST() { return getToken(ASMParser.KW_CHECKCAST, 0); }
		public TerminalNode KW_D2F() { return getToken(ASMParser.KW_D2F, 0); }
		public TerminalNode KW_D2I() { return getToken(ASMParser.KW_D2I, 0); }
		public TerminalNode KW_D2L() { return getToken(ASMParser.KW_D2L, 0); }
		public TerminalNode KW_DADD() { return getToken(ASMParser.KW_DADD, 0); }
		public TerminalNode KW_DALOAD() { return getToken(ASMParser.KW_DALOAD, 0); }
		public TerminalNode KW_DASTORE() { return getToken(ASMParser.KW_DASTORE, 0); }
		public TerminalNode KW_DCMPG() { return getToken(ASMParser.KW_DCMPG, 0); }
		public TerminalNode KW_DCMPL() { return getToken(ASMParser.KW_DCMPL, 0); }
		public TerminalNode KW_DCONST_0() { return getToken(ASMParser.KW_DCONST_0, 0); }
		public TerminalNode KW_DCONST_1() { return getToken(ASMParser.KW_DCONST_1, 0); }
		public TerminalNode KW_DDIV() { return getToken(ASMParser.KW_DDIV, 0); }
		public TerminalNode KW_DLOAD() { return getToken(ASMParser.KW_DLOAD, 0); }
		public TerminalNode KW_DLOAD_0() { return getToken(ASMParser.KW_DLOAD_0, 0); }
		public TerminalNode KW_DLOAD_1() { return getToken(ASMParser.KW_DLOAD_1, 0); }
		public TerminalNode KW_DLOAD_2() { return getToken(ASMParser.KW_DLOAD_2, 0); }
		public TerminalNode KW_DLOAD_3() { return getToken(ASMParser.KW_DLOAD_3, 0); }
		public TerminalNode KW_DMUL() { return getToken(ASMParser.KW_DMUL, 0); }
		public TerminalNode KW_DNEG() { return getToken(ASMParser.KW_DNEG, 0); }
		public TerminalNode KW_DREM() { return getToken(ASMParser.KW_DREM, 0); }
		public TerminalNode KW_DRETURN() { return getToken(ASMParser.KW_DRETURN, 0); }
		public TerminalNode KW_DSTORE() { return getToken(ASMParser.KW_DSTORE, 0); }
		public TerminalNode KW_DSTORE_0() { return getToken(ASMParser.KW_DSTORE_0, 0); }
		public TerminalNode KW_DSTORE_1() { return getToken(ASMParser.KW_DSTORE_1, 0); }
		public TerminalNode KW_DSTORE_2() { return getToken(ASMParser.KW_DSTORE_2, 0); }
		public TerminalNode KW_DSTORE_3() { return getToken(ASMParser.KW_DSTORE_3, 0); }
		public TerminalNode KW_DSUB() { return getToken(ASMParser.KW_DSUB, 0); }
		public TerminalNode KW_DUP() { return getToken(ASMParser.KW_DUP, 0); }
		public TerminalNode KW_DUP_X1() { return getToken(ASMParser.KW_DUP_X1, 0); }
		public TerminalNode KW_DUP_X2() { return getToken(ASMParser.KW_DUP_X2, 0); }
		public TerminalNode KW_DUP2() { return getToken(ASMParser.KW_DUP2, 0); }
		public TerminalNode KW_DUP2_X1() { return getToken(ASMParser.KW_DUP2_X1, 0); }
		public TerminalNode KW_DUP2_X2() { return getToken(ASMParser.KW_DUP2_X2, 0); }
		public TerminalNode KW_F2D() { return getToken(ASMParser.KW_F2D, 0); }
		public TerminalNode KW_F2I() { return getToken(ASMParser.KW_F2I, 0); }
		public TerminalNode KW_F2L() { return getToken(ASMParser.KW_F2L, 0); }
		public TerminalNode KW_FADD() { return getToken(ASMParser.KW_FADD, 0); }
		public TerminalNode KW_FALOAD() { return getToken(ASMParser.KW_FALOAD, 0); }
		public TerminalNode KW_FASTORE() { return getToken(ASMParser.KW_FASTORE, 0); }
		public TerminalNode KW_FCMPG() { return getToken(ASMParser.KW_FCMPG, 0); }
		public TerminalNode KW_FCMPL() { return getToken(ASMParser.KW_FCMPL, 0); }
		public TerminalNode KW_FCONST_0() { return getToken(ASMParser.KW_FCONST_0, 0); }
		public TerminalNode KW_FCONST_1() { return getToken(ASMParser.KW_FCONST_1, 0); }
		public TerminalNode KW_FCONST_2() { return getToken(ASMParser.KW_FCONST_2, 0); }
		public TerminalNode KW_FDIV() { return getToken(ASMParser.KW_FDIV, 0); }
		public TerminalNode KW_FLOAD() { return getToken(ASMParser.KW_FLOAD, 0); }
		public TerminalNode KW_FLOAD_0() { return getToken(ASMParser.KW_FLOAD_0, 0); }
		public TerminalNode KW_FLOAD_1() { return getToken(ASMParser.KW_FLOAD_1, 0); }
		public TerminalNode KW_FLOAD_2() { return getToken(ASMParser.KW_FLOAD_2, 0); }
		public TerminalNode KW_FLOAD_3() { return getToken(ASMParser.KW_FLOAD_3, 0); }
		public TerminalNode KW_FMUL() { return getToken(ASMParser.KW_FMUL, 0); }
		public TerminalNode KW_FNEG() { return getToken(ASMParser.KW_FNEG, 0); }
		public TerminalNode KW_FREM() { return getToken(ASMParser.KW_FREM, 0); }
		public TerminalNode KW_FRETURN() { return getToken(ASMParser.KW_FRETURN, 0); }
		public TerminalNode KW_FSTORE() { return getToken(ASMParser.KW_FSTORE, 0); }
		public TerminalNode KW_FSTORE_0() { return getToken(ASMParser.KW_FSTORE_0, 0); }
		public TerminalNode KW_FSTORE_1() { return getToken(ASMParser.KW_FSTORE_1, 0); }
		public TerminalNode KW_FSTORE_2() { return getToken(ASMParser.KW_FSTORE_2, 0); }
		public TerminalNode KW_FSTORE_3() { return getToken(ASMParser.KW_FSTORE_3, 0); }
		public TerminalNode KW_FSUB() { return getToken(ASMParser.KW_FSUB, 0); }
		public FieldRefContext fieldRef() {
			return getRuleContext(FieldRefContext.class,0);
		}
		public TerminalNode KW_GETFIELD() { return getToken(ASMParser.KW_GETFIELD, 0); }
		public TerminalNode KW_GETSTATIC() { return getToken(ASMParser.KW_GETSTATIC, 0); }
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public TerminalNode KW_GOTO() { return getToken(ASMParser.KW_GOTO, 0); }
		public TerminalNode KW_GOTO_W() { return getToken(ASMParser.KW_GOTO_W, 0); }
		public TerminalNode KW_I2B() { return getToken(ASMParser.KW_I2B, 0); }
		public TerminalNode KW_I2C() { return getToken(ASMParser.KW_I2C, 0); }
		public TerminalNode KW_I2D() { return getToken(ASMParser.KW_I2D, 0); }
		public TerminalNode KW_I2F() { return getToken(ASMParser.KW_I2F, 0); }
		public TerminalNode KW_I2L() { return getToken(ASMParser.KW_I2L, 0); }
		public TerminalNode KW_I2S() { return getToken(ASMParser.KW_I2S, 0); }
		public TerminalNode KW_IADD() { return getToken(ASMParser.KW_IADD, 0); }
		public TerminalNode KW_IALOAD() { return getToken(ASMParser.KW_IALOAD, 0); }
		public TerminalNode KW_IAND() { return getToken(ASMParser.KW_IAND, 0); }
		public TerminalNode KW_IASTORE() { return getToken(ASMParser.KW_IASTORE, 0); }
		public TerminalNode KW_ICONST_M1() { return getToken(ASMParser.KW_ICONST_M1, 0); }
		public TerminalNode KW_ICONST_0() { return getToken(ASMParser.KW_ICONST_0, 0); }
		public TerminalNode KW_ICONST_1() { return getToken(ASMParser.KW_ICONST_1, 0); }
		public TerminalNode KW_ICONST_2() { return getToken(ASMParser.KW_ICONST_2, 0); }
		public TerminalNode KW_ICONST_3() { return getToken(ASMParser.KW_ICONST_3, 0); }
		public TerminalNode KW_ICONST_4() { return getToken(ASMParser.KW_ICONST_4, 0); }
		public TerminalNode KW_ICONST_5() { return getToken(ASMParser.KW_ICONST_5, 0); }
		public TerminalNode KW_IDIV() { return getToken(ASMParser.KW_IDIV, 0); }
		public TerminalNode KW_IF_ACMPEQ() { return getToken(ASMParser.KW_IF_ACMPEQ, 0); }
		public TerminalNode KW_IF_ACMPNE() { return getToken(ASMParser.KW_IF_ACMPNE, 0); }
		public TerminalNode KW_IF_ICMPEQ() { return getToken(ASMParser.KW_IF_ICMPEQ, 0); }
		public TerminalNode KW_IF_ICMPNE() { return getToken(ASMParser.KW_IF_ICMPNE, 0); }
		public TerminalNode KW_IF_ICMPLT() { return getToken(ASMParser.KW_IF_ICMPLT, 0); }
		public TerminalNode KW_IF_ICMPGE() { return getToken(ASMParser.KW_IF_ICMPGE, 0); }
		public TerminalNode KW_IF_ICMPGT() { return getToken(ASMParser.KW_IF_ICMPGT, 0); }
		public TerminalNode KW_IF_ICMPLE() { return getToken(ASMParser.KW_IF_ICMPLE, 0); }
		public TerminalNode KW_IFEQ() { return getToken(ASMParser.KW_IFEQ, 0); }
		public TerminalNode KW_IFNE() { return getToken(ASMParser.KW_IFNE, 0); }
		public TerminalNode KW_IFLT() { return getToken(ASMParser.KW_IFLT, 0); }
		public TerminalNode KW_IFGE() { return getToken(ASMParser.KW_IFGE, 0); }
		public TerminalNode KW_IFGT() { return getToken(ASMParser.KW_IFGT, 0); }
		public TerminalNode KW_IFLE() { return getToken(ASMParser.KW_IFLE, 0); }
		public TerminalNode KW_IFNONNULL() { return getToken(ASMParser.KW_IFNONNULL, 0); }
		public TerminalNode KW_IFNULL() { return getToken(ASMParser.KW_IFNULL, 0); }
		public TerminalNode COMMA() { return getToken(ASMParser.COMMA, 0); }
		public SignedIntegerLiteralContext signedIntegerLiteral() {
			return getRuleContext(SignedIntegerLiteralContext.class,0);
		}
		public TerminalNode KW_IINC() { return getToken(ASMParser.KW_IINC, 0); }
		public TerminalNode KW_ILOAD() { return getToken(ASMParser.KW_ILOAD, 0); }
		public TerminalNode KW_ILOAD_0() { return getToken(ASMParser.KW_ILOAD_0, 0); }
		public TerminalNode KW_ILOAD_1() { return getToken(ASMParser.KW_ILOAD_1, 0); }
		public TerminalNode KW_ILOAD_2() { return getToken(ASMParser.KW_ILOAD_2, 0); }
		public TerminalNode KW_ILOAD_3() { return getToken(ASMParser.KW_ILOAD_3, 0); }
		public TerminalNode KW_IMUL() { return getToken(ASMParser.KW_IMUL, 0); }
		public TerminalNode KW_INEG() { return getToken(ASMParser.KW_INEG, 0); }
		public TerminalNode KW_INSTANCEOF() { return getToken(ASMParser.KW_INSTANCEOF, 0); }
		public CallSiteRefContext callSiteRef() {
			return getRuleContext(CallSiteRefContext.class,0);
		}
		public TerminalNode KW_INVOKEDYNAMIC() { return getToken(ASMParser.KW_INVOKEDYNAMIC, 0); }
		public MethodRefContext methodRef() {
			return getRuleContext(MethodRefContext.class,0);
		}
		public TerminalNode KW_INVOKEINTERFACE() { return getToken(ASMParser.KW_INVOKEINTERFACE, 0); }
		public TerminalNode KW_INVOKESPECIAL() { return getToken(ASMParser.KW_INVOKESPECIAL, 0); }
		public TerminalNode KW_INVOKESTATIC() { return getToken(ASMParser.KW_INVOKESTATIC, 0); }
		public TerminalNode KW_INVOKEVIRTUAL() { return getToken(ASMParser.KW_INVOKEVIRTUAL, 0); }
		public TerminalNode KW_IOR() { return getToken(ASMParser.KW_IOR, 0); }
		public TerminalNode KW_IREM() { return getToken(ASMParser.KW_IREM, 0); }
		public TerminalNode KW_IRETURN() { return getToken(ASMParser.KW_IRETURN, 0); }
		public TerminalNode KW_ISHL() { return getToken(ASMParser.KW_ISHL, 0); }
		public TerminalNode KW_ISHR() { return getToken(ASMParser.KW_ISHR, 0); }
		public TerminalNode KW_ISTORE() { return getToken(ASMParser.KW_ISTORE, 0); }
		public TerminalNode KW_ISTORE_0() { return getToken(ASMParser.KW_ISTORE_0, 0); }
		public TerminalNode KW_ISTORE_1() { return getToken(ASMParser.KW_ISTORE_1, 0); }
		public TerminalNode KW_ISTORE_2() { return getToken(ASMParser.KW_ISTORE_2, 0); }
		public TerminalNode KW_ISTORE_3() { return getToken(ASMParser.KW_ISTORE_3, 0); }
		public TerminalNode KW_ISUB() { return getToken(ASMParser.KW_ISUB, 0); }
		public TerminalNode KW_IUSHR() { return getToken(ASMParser.KW_IUSHR, 0); }
		public TerminalNode KW_IXOR() { return getToken(ASMParser.KW_IXOR, 0); }
		public TerminalNode KW_JSR() { return getToken(ASMParser.KW_JSR, 0); }
		public TerminalNode KW_JSR_W() { return getToken(ASMParser.KW_JSR_W, 0); }
		public TerminalNode KW_L2D() { return getToken(ASMParser.KW_L2D, 0); }
		public TerminalNode KW_L2F() { return getToken(ASMParser.KW_L2F, 0); }
		public TerminalNode KW_L2I() { return getToken(ASMParser.KW_L2I, 0); }
		public TerminalNode KW_LADD() { return getToken(ASMParser.KW_LADD, 0); }
		public TerminalNode KW_LALOAD() { return getToken(ASMParser.KW_LALOAD, 0); }
		public TerminalNode KW_LAND() { return getToken(ASMParser.KW_LAND, 0); }
		public TerminalNode KW_LASTORE() { return getToken(ASMParser.KW_LASTORE, 0); }
		public TerminalNode KW_LCMP() { return getToken(ASMParser.KW_LCMP, 0); }
		public TerminalNode KW_LCONST_0() { return getToken(ASMParser.KW_LCONST_0, 0); }
		public TerminalNode KW_LCONST_1() { return getToken(ASMParser.KW_LCONST_1, 0); }
		public LoadableConstantContext loadableConstant() {
			return getRuleContext(LoadableConstantContext.class,0);
		}
		public TerminalNode KW_LDC() { return getToken(ASMParser.KW_LDC, 0); }
		public TerminalNode KW_LDC_W() { return getToken(ASMParser.KW_LDC_W, 0); }
		public TerminalNode KW_LDC2_W() { return getToken(ASMParser.KW_LDC2_W, 0); }
		public TerminalNode KW_TRUE() { return getToken(ASMParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(ASMParser.KW_FALSE, 0); }
		public TerminalNode KW_NULL() { return getToken(ASMParser.KW_NULL, 0); }
		public TerminalNode KW_LDIV() { return getToken(ASMParser.KW_LDIV, 0); }
		public TerminalNode KW_LLOAD() { return getToken(ASMParser.KW_LLOAD, 0); }
		public TerminalNode KW_LLOAD_0() { return getToken(ASMParser.KW_LLOAD_0, 0); }
		public TerminalNode KW_LLOAD_1() { return getToken(ASMParser.KW_LLOAD_1, 0); }
		public TerminalNode KW_LLOAD_2() { return getToken(ASMParser.KW_LLOAD_2, 0); }
		public TerminalNode KW_LLOAD_3() { return getToken(ASMParser.KW_LLOAD_3, 0); }
		public TerminalNode KW_LMUL() { return getToken(ASMParser.KW_LMUL, 0); }
		public TerminalNode KW_LNEG() { return getToken(ASMParser.KW_LNEG, 0); }
		public LookupSwitchArgContext lookupSwitchArg() {
			return getRuleContext(LookupSwitchArgContext.class,0);
		}
		public TerminalNode KW_LOOKUPSWITCH() { return getToken(ASMParser.KW_LOOKUPSWITCH, 0); }
		public TerminalNode KW_LOR() { return getToken(ASMParser.KW_LOR, 0); }
		public TerminalNode KW_LREM() { return getToken(ASMParser.KW_LREM, 0); }
		public TerminalNode KW_LRETURN() { return getToken(ASMParser.KW_LRETURN, 0); }
		public TerminalNode KW_LSHL() { return getToken(ASMParser.KW_LSHL, 0); }
		public TerminalNode KW_LSHR() { return getToken(ASMParser.KW_LSHR, 0); }
		public TerminalNode KW_LSTORE() { return getToken(ASMParser.KW_LSTORE, 0); }
		public TerminalNode KW_LSTORE_0() { return getToken(ASMParser.KW_LSTORE_0, 0); }
		public TerminalNode KW_LSTORE_1() { return getToken(ASMParser.KW_LSTORE_1, 0); }
		public TerminalNode KW_LSTORE_2() { return getToken(ASMParser.KW_LSTORE_2, 0); }
		public TerminalNode KW_LSTORE_3() { return getToken(ASMParser.KW_LSTORE_3, 0); }
		public TerminalNode KW_LSUB() { return getToken(ASMParser.KW_LSUB, 0); }
		public TerminalNode KW_LUSHR() { return getToken(ASMParser.KW_LUSHR, 0); }
		public TerminalNode KW_LXOR() { return getToken(ASMParser.KW_LXOR, 0); }
		public TerminalNode KW_MONITORENTER() { return getToken(ASMParser.KW_MONITORENTER, 0); }
		public TerminalNode KW_MONITOREXIT() { return getToken(ASMParser.KW_MONITOREXIT, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode KW_MULTIANEWARRAY() { return getToken(ASMParser.KW_MULTIANEWARRAY, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode KW_NEW() { return getToken(ASMParser.KW_NEW, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode KW_NEWARRAY() { return getToken(ASMParser.KW_NEWARRAY, 0); }
		public TerminalNode KW_NOP() { return getToken(ASMParser.KW_NOP, 0); }
		public TerminalNode KW_POP() { return getToken(ASMParser.KW_POP, 0); }
		public TerminalNode KW_POP2() { return getToken(ASMParser.KW_POP2, 0); }
		public TerminalNode KW_PUTFIELD() { return getToken(ASMParser.KW_PUTFIELD, 0); }
		public TerminalNode KW_PUTSTATIC() { return getToken(ASMParser.KW_PUTSTATIC, 0); }
		public TerminalNode KW_RET() { return getToken(ASMParser.KW_RET, 0); }
		public TerminalNode KW_RETURN() { return getToken(ASMParser.KW_RETURN, 0); }
		public TerminalNode KW_SALOAD() { return getToken(ASMParser.KW_SALOAD, 0); }
		public TerminalNode KW_SASTORE() { return getToken(ASMParser.KW_SASTORE, 0); }
		public SignedShortLiteralContext signedShortLiteral() {
			return getRuleContext(SignedShortLiteralContext.class,0);
		}
		public TerminalNode KW_SIPUSH() { return getToken(ASMParser.KW_SIPUSH, 0); }
		public TerminalNode KW_SWAP() { return getToken(ASMParser.KW_SWAP, 0); }
		public TableSwitchArgContext tableSwitchArg() {
			return getRuleContext(TableSwitchArgContext.class,0);
		}
		public TerminalNode KW_TABLESWITCH() { return getToken(ASMParser.KW_TABLESWITCH, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InstructionContext(ParserRuleContext parent, int invokingState, MethodVisitor mv) {
			super(parent, invokingState);
			this.mv = mv;
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction(MethodVisitor mv) throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState(), mv);
		enterRule(_localctx, 72, RULE_instruction);
		int _la;
		try {
			setState(1474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(724);
				((InstructionContext)_localctx).name = match(KW_AASTORE);
				mv.visitInsn(AASTORE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				((InstructionContext)_localctx).name = match(KW_ACONST_NULL);
				mv.visitInsn(ACONST_NULL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(728);
					match(KW_WIDE);
					}
				}

				setState(731);
				((InstructionContext)_localctx).name = match(KW_ALOAD);
				int value = -1;
				setState(746);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(733);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(734);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(737);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(743);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(738);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(741);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(ALOAD, value);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(749);
				((InstructionContext)_localctx).name = match(KW_ALOAD_0);
				setState(750);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ALOAD, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(752);
				((InstructionContext)_localctx).name = match(KW_ALOAD_1);
				setState(753);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ALOAD, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(755);
				((InstructionContext)_localctx).name = match(KW_ALOAD_2);
				setState(756);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ALOAD, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(758);
				((InstructionContext)_localctx).name = match(KW_ALOAD_3);
				setState(759);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ALOAD, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(761);
				((InstructionContext)_localctx).name = match(KW_ANEWARRAY);
				setState(762);
				referenceType();

				            var referenceType = _localctx.referenceType();
				            var arrayType = referenceType.arrayType();
				            mv.visitTypeInsn(ANEWARRAY, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(765);
				((InstructionContext)_localctx).name = match(KW_ARETURN);
				mv.visitInsn(ARETURN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(767);
				((InstructionContext)_localctx).name = match(KW_ARRAYLENGTH);
				mv.visitInsn(ARRAYLENGTH);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(770);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(769);
					match(KW_WIDE);
					}
				}

				setState(772);
				((InstructionContext)_localctx).name = match(KW_ASTORE);
				int value = -1;
				setState(787);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(774);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(775);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(778);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(784);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(779);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(782);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(ASTORE, value);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(790);
				((InstructionContext)_localctx).name = match(KW_ASTORE_0);
				setState(791);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ASTORE, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(793);
				((InstructionContext)_localctx).name = match(KW_ASTORE_1);
				setState(794);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ASTORE, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(796);
				((InstructionContext)_localctx).name = match(KW_ASTORE_2);
				setState(797);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ASTORE, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(799);
				((InstructionContext)_localctx).name = match(KW_ASTORE_3);
				setState(800);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ASTORE, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(802);
				((InstructionContext)_localctx).name = match(KW_ATHROW);
				mv.visitInsn(ATHROW);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(804);
				((InstructionContext)_localctx).name = match(KW_BALOAD);
				mv.visitInsn(BALOAD);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(806);
				((InstructionContext)_localctx).name = match(KW_BASTORE);
				mv.visitInsn(BASTORE);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(808);
				((InstructionContext)_localctx).name = match(KW_BIPUSH);
				setState(809);
				((InstructionContext)_localctx).signedByteLiteral = signedByteLiteral();
				mv.visitIntInsn(BIPUSH, ((InstructionContext)_localctx).signedByteLiteral.value);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(812);
				((InstructionContext)_localctx).name = match(KW_CALOAD);
				mv.visitInsn(CALOAD);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(814);
				((InstructionContext)_localctx).name = match(KW_CASTORE);
				mv.visitInsn(CASTORE);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(816);
				((InstructionContext)_localctx).name = match(KW_CHECKCAST);
				setState(817);
				referenceType();

				            var referenceType = _localctx.referenceType();
				            var arrayType = referenceType.arrayType();
				            mv.visitTypeInsn(CHECKCAST, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
				        
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(820);
				((InstructionContext)_localctx).name = match(KW_D2F);
				mv.visitInsn(D2F);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(822);
				((InstructionContext)_localctx).name = match(KW_D2I);
				mv.visitInsn(D2I);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(824);
				((InstructionContext)_localctx).name = match(KW_D2L);
				mv.visitInsn(D2L);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(826);
				((InstructionContext)_localctx).name = match(KW_DADD);
				mv.visitInsn(DADD);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(828);
				((InstructionContext)_localctx).name = match(KW_DALOAD);
				mv.visitInsn(DALOAD);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(830);
				((InstructionContext)_localctx).name = match(KW_DASTORE);
				mv.visitInsn(DASTORE);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(832);
				((InstructionContext)_localctx).name = match(KW_DCMPG);
				mv.visitInsn(DCMPG);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(834);
				((InstructionContext)_localctx).name = match(KW_DCMPL);
				mv.visitInsn(DCMPL);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(836);
				((InstructionContext)_localctx).name = match(KW_DCONST_0);
				mv.visitInsn(DCONST_0);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(838);
				((InstructionContext)_localctx).name = match(KW_DCONST_1);
				mv.visitInsn(DCONST_1);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(840);
				((InstructionContext)_localctx).name = match(KW_DDIV);
				mv.visitInsn(DDIV);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(843);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(842);
					match(KW_WIDE);
					}
				}

				setState(845);
				((InstructionContext)_localctx).name = match(KW_DLOAD);
				int value = -1;
				setState(860);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(847);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(848);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(851);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(857);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(852);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(855);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(DLOAD, value);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(863);
				((InstructionContext)_localctx).name = match(KW_DLOAD_0);
				setState(864);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DLOAD, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(866);
				((InstructionContext)_localctx).name = match(KW_DLOAD_1);
				setState(867);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DLOAD, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(869);
				((InstructionContext)_localctx).name = match(KW_DLOAD_2);
				setState(870);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DLOAD, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(872);
				((InstructionContext)_localctx).name = match(KW_DLOAD_3);
				setState(873);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DLOAD, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(875);
				((InstructionContext)_localctx).name = match(KW_DMUL);
				mv.visitInsn(DMUL);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(877);
				((InstructionContext)_localctx).name = match(KW_DNEG);
				mv.visitInsn(DNEG);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(879);
				((InstructionContext)_localctx).name = match(KW_DREM);
				mv.visitInsn(DREM);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(881);
				((InstructionContext)_localctx).name = match(KW_DRETURN);
				mv.visitInsn(DRETURN);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(884);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(883);
					match(KW_WIDE);
					}
				}

				setState(886);
				((InstructionContext)_localctx).name = match(KW_DSTORE);
				int value = -1;
				setState(901);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(888);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(889);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(892);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(898);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(893);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(896);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(DSTORE, value);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(904);
				((InstructionContext)_localctx).name = match(KW_DSTORE_0);
				setState(905);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DSTORE, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(907);
				((InstructionContext)_localctx).name = match(KW_DSTORE_1);
				setState(908);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DSTORE, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(910);
				((InstructionContext)_localctx).name = match(KW_DSTORE_2);
				setState(911);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DSTORE, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 47);
				{
				setState(913);
				((InstructionContext)_localctx).name = match(KW_DSTORE_3);
				setState(914);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(DSTORE, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 48);
				{
				setState(916);
				((InstructionContext)_localctx).name = match(KW_DSUB);
				mv.visitInsn(DSUB);
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 49);
				{
				setState(918);
				((InstructionContext)_localctx).name = match(KW_DUP);
				mv.visitInsn(DUP);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 50);
				{
				setState(920);
				((InstructionContext)_localctx).name = match(KW_DUP_X1);
				mv.visitInsn(DUP_X1);
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 51);
				{
				setState(922);
				((InstructionContext)_localctx).name = match(KW_DUP_X2);
				mv.visitInsn(DUP_X2);
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 52);
				{
				setState(924);
				((InstructionContext)_localctx).name = match(KW_DUP2);
				mv.visitInsn(DUP2);
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 53);
				{
				setState(926);
				((InstructionContext)_localctx).name = match(KW_DUP2_X1);
				mv.visitInsn(DUP2_X1);
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 54);
				{
				setState(928);
				((InstructionContext)_localctx).name = match(KW_DUP2_X2);
				mv.visitInsn(DUP2_X2);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 55);
				{
				setState(930);
				((InstructionContext)_localctx).name = match(KW_F2D);
				mv.visitInsn(F2D);
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 56);
				{
				setState(932);
				((InstructionContext)_localctx).name = match(KW_F2I);
				mv.visitInsn(F2I);
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 57);
				{
				setState(934);
				((InstructionContext)_localctx).name = match(KW_F2L);
				mv.visitInsn(F2L);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 58);
				{
				setState(936);
				((InstructionContext)_localctx).name = match(KW_FADD);
				mv.visitInsn(FADD);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 59);
				{
				setState(938);
				((InstructionContext)_localctx).name = match(KW_FALOAD);
				mv.visitInsn(FALOAD);
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 60);
				{
				setState(940);
				((InstructionContext)_localctx).name = match(KW_FASTORE);
				mv.visitInsn(FASTORE);
				}
				break;
			case 61:
				enterOuterAlt(_localctx, 61);
				{
				setState(942);
				((InstructionContext)_localctx).name = match(KW_FCMPG);
				mv.visitInsn(FCMPG);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 62);
				{
				setState(944);
				((InstructionContext)_localctx).name = match(KW_FCMPL);
				mv.visitInsn(FCMPL);
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 63);
				{
				setState(946);
				((InstructionContext)_localctx).name = match(KW_FCONST_0);
				mv.visitInsn(FCONST_0);
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 64);
				{
				setState(948);
				((InstructionContext)_localctx).name = match(KW_FCONST_1);
				mv.visitInsn(FCONST_1);
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 65);
				{
				setState(950);
				((InstructionContext)_localctx).name = match(KW_FCONST_2);
				mv.visitInsn(FCONST_2);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 66);
				{
				setState(952);
				((InstructionContext)_localctx).name = match(KW_FDIV);
				mv.visitInsn(FDIV);
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 67);
				{
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(954);
					match(KW_WIDE);
					}
				}

				setState(957);
				((InstructionContext)_localctx).name = match(KW_FLOAD);
				int value = -1;
				setState(972);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(959);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(960);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(963);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(969);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(964);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(967);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(FLOAD, value);
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 68);
				{
				setState(975);
				((InstructionContext)_localctx).name = match(KW_FLOAD_0);
				setState(976);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FLOAD, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 69);
				{
				setState(978);
				((InstructionContext)_localctx).name = match(KW_FLOAD_1);
				setState(979);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FLOAD, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 70);
				{
				setState(981);
				((InstructionContext)_localctx).name = match(KW_FLOAD_2);
				setState(982);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FLOAD, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 71);
				{
				setState(984);
				((InstructionContext)_localctx).name = match(KW_FLOAD_3);
				setState(985);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FLOAD, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 72);
				{
				setState(987);
				((InstructionContext)_localctx).name = match(KW_FMUL);
				mv.visitInsn(FMUL);
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 73);
				{
				setState(989);
				((InstructionContext)_localctx).name = match(KW_FNEG);
				mv.visitInsn(FNEG);
				}
				break;
			case 74:
				enterOuterAlt(_localctx, 74);
				{
				setState(991);
				((InstructionContext)_localctx).name = match(KW_FREM);
				mv.visitInsn(FREM);
				}
				break;
			case 75:
				enterOuterAlt(_localctx, 75);
				{
				setState(993);
				((InstructionContext)_localctx).name = match(KW_FRETURN);
				mv.visitInsn(FRETURN);
				}
				break;
			case 76:
				enterOuterAlt(_localctx, 76);
				{
				setState(996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(995);
					match(KW_WIDE);
					}
				}

				setState(998);
				((InstructionContext)_localctx).name = match(KW_FSTORE);
				int value = -1;
				setState(1013);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(1000);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1001);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1004);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1010);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1005);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1008);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(FSTORE, value);
				}
				break;
			case 77:
				enterOuterAlt(_localctx, 77);
				{
				setState(1016);
				((InstructionContext)_localctx).name = match(KW_FSTORE_0);
				setState(1017);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FSTORE, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 78:
				enterOuterAlt(_localctx, 78);
				{
				setState(1019);
				((InstructionContext)_localctx).name = match(KW_FSTORE_1);
				setState(1020);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FSTORE, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 79:
				enterOuterAlt(_localctx, 79);
				{
				setState(1022);
				((InstructionContext)_localctx).name = match(KW_FSTORE_2);
				setState(1023);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FSTORE, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 80:
				enterOuterAlt(_localctx, 80);
				{
				setState(1025);
				((InstructionContext)_localctx).name = match(KW_FSTORE_3);
				setState(1026);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(FSTORE, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 81:
				enterOuterAlt(_localctx, 81);
				{
				setState(1028);
				((InstructionContext)_localctx).name = match(KW_FSUB);
				mv.visitInsn(FSUB);
				}
				break;
			case 82:
				enterOuterAlt(_localctx, 82);
				{
				setState(1030);
				((InstructionContext)_localctx).name = match(KW_GETFIELD);
				setState(1031);
				((InstructionContext)_localctx).fieldRef = fieldRef();
				mv.visitFieldInsn(GETFIELD, getOwner(_localctx.fieldRef()), ((InstructionContext)_localctx).fieldRef.name, getDescriptor(_localctx.fieldRef()));
				}
				break;
			case 83:
				enterOuterAlt(_localctx, 83);
				{
				setState(1034);
				((InstructionContext)_localctx).name = match(KW_GETSTATIC);
				setState(1035);
				((InstructionContext)_localctx).fieldRef = fieldRef();
				mv.visitFieldInsn(GETSTATIC, getOwner(_localctx.fieldRef()), ((InstructionContext)_localctx).fieldRef.name, getDescriptor(_localctx.fieldRef()));
				}
				break;
			case 84:
				enterOuterAlt(_localctx, 84);
				{
				setState(1038);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==KW_GOTO || _la==KW_GOTO_W) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1039);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(GOTO, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 85:
				enterOuterAlt(_localctx, 85);
				{
				setState(1042);
				((InstructionContext)_localctx).name = match(KW_I2B);
				mv.visitInsn(I2B);
				}
				break;
			case 86:
				enterOuterAlt(_localctx, 86);
				{
				setState(1044);
				((InstructionContext)_localctx).name = match(KW_I2C);
				mv.visitInsn(I2C);
				}
				break;
			case 87:
				enterOuterAlt(_localctx, 87);
				{
				setState(1046);
				((InstructionContext)_localctx).name = match(KW_I2D);
				mv.visitInsn(I2D);
				}
				break;
			case 88:
				enterOuterAlt(_localctx, 88);
				{
				setState(1048);
				((InstructionContext)_localctx).name = match(KW_I2F);
				mv.visitInsn(I2F);
				}
				break;
			case 89:
				enterOuterAlt(_localctx, 89);
				{
				setState(1050);
				((InstructionContext)_localctx).name = match(KW_I2L);
				mv.visitInsn(I2L);
				}
				break;
			case 90:
				enterOuterAlt(_localctx, 90);
				{
				setState(1052);
				((InstructionContext)_localctx).name = match(KW_I2S);
				mv.visitInsn(I2S);
				}
				break;
			case 91:
				enterOuterAlt(_localctx, 91);
				{
				setState(1054);
				((InstructionContext)_localctx).name = match(KW_IADD);
				mv.visitInsn(IADD);
				}
				break;
			case 92:
				enterOuterAlt(_localctx, 92);
				{
				setState(1056);
				((InstructionContext)_localctx).name = match(KW_IALOAD);
				mv.visitInsn(IALOAD);
				}
				break;
			case 93:
				enterOuterAlt(_localctx, 93);
				{
				setState(1058);
				((InstructionContext)_localctx).name = match(KW_IAND);
				mv.visitInsn(IAND);
				}
				break;
			case 94:
				enterOuterAlt(_localctx, 94);
				{
				setState(1060);
				((InstructionContext)_localctx).name = match(KW_IASTORE);
				mv.visitInsn(IASTORE);
				}
				break;
			case 95:
				enterOuterAlt(_localctx, 95);
				{
				setState(1062);
				((InstructionContext)_localctx).name = match(KW_ICONST_M1);
				mv.visitInsn(ICONST_M1);
				}
				break;
			case 96:
				enterOuterAlt(_localctx, 96);
				{
				setState(1064);
				((InstructionContext)_localctx).name = match(KW_ICONST_0);
				mv.visitInsn(ICONST_0);
				}
				break;
			case 97:
				enterOuterAlt(_localctx, 97);
				{
				setState(1066);
				((InstructionContext)_localctx).name = match(KW_ICONST_1);
				mv.visitInsn(ICONST_1);
				}
				break;
			case 98:
				enterOuterAlt(_localctx, 98);
				{
				setState(1068);
				((InstructionContext)_localctx).name = match(KW_ICONST_2);
				mv.visitInsn(ICONST_2);
				}
				break;
			case 99:
				enterOuterAlt(_localctx, 99);
				{
				setState(1070);
				((InstructionContext)_localctx).name = match(KW_ICONST_3);
				mv.visitInsn(ICONST_3);
				}
				break;
			case 100:
				enterOuterAlt(_localctx, 100);
				{
				setState(1072);
				((InstructionContext)_localctx).name = match(KW_ICONST_4);
				mv.visitInsn(ICONST_4);
				}
				break;
			case 101:
				enterOuterAlt(_localctx, 101);
				{
				setState(1074);
				((InstructionContext)_localctx).name = match(KW_ICONST_5);
				mv.visitInsn(ICONST_5);
				}
				break;
			case 102:
				enterOuterAlt(_localctx, 102);
				{
				setState(1076);
				((InstructionContext)_localctx).name = match(KW_IDIV);
				mv.visitInsn(IDIV);
				}
				break;
			case 103:
				enterOuterAlt(_localctx, 103);
				{
				setState(1078);
				((InstructionContext)_localctx).name = match(KW_IF_ACMPEQ);
				setState(1079);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ACMPEQ, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 104:
				enterOuterAlt(_localctx, 104);
				{
				setState(1082);
				((InstructionContext)_localctx).name = match(KW_IF_ACMPNE);
				setState(1083);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ACMPNE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 105:
				enterOuterAlt(_localctx, 105);
				{
				setState(1086);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPEQ);
				setState(1087);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPEQ, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 106:
				enterOuterAlt(_localctx, 106);
				{
				setState(1090);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPNE);
				setState(1091);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPNE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 107:
				enterOuterAlt(_localctx, 107);
				{
				setState(1094);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPLT);
				setState(1095);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPLT, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 108:
				enterOuterAlt(_localctx, 108);
				{
				setState(1098);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPGE);
				setState(1099);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPGE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 109:
				enterOuterAlt(_localctx, 109);
				{
				setState(1102);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPGT);
				setState(1103);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPGT, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 110:
				enterOuterAlt(_localctx, 110);
				{
				setState(1106);
				((InstructionContext)_localctx).name = match(KW_IF_ICMPLE);
				setState(1107);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IF_ICMPLE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 111:
				enterOuterAlt(_localctx, 111);
				{
				setState(1110);
				((InstructionContext)_localctx).name = match(KW_IFEQ);
				setState(1111);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFEQ, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 112:
				enterOuterAlt(_localctx, 112);
				{
				setState(1114);
				((InstructionContext)_localctx).name = match(KW_IFNE);
				setState(1115);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFNE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 113:
				enterOuterAlt(_localctx, 113);
				{
				setState(1118);
				((InstructionContext)_localctx).name = match(KW_IFLT);
				setState(1119);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFLT, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 114:
				enterOuterAlt(_localctx, 114);
				{
				setState(1122);
				((InstructionContext)_localctx).name = match(KW_IFGE);
				setState(1123);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFGE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 115:
				enterOuterAlt(_localctx, 115);
				{
				setState(1126);
				((InstructionContext)_localctx).name = match(KW_IFGT);
				setState(1127);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFGT, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 116:
				enterOuterAlt(_localctx, 116);
				{
				setState(1130);
				((InstructionContext)_localctx).name = match(KW_IFLE);
				setState(1131);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFLE, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 117:
				enterOuterAlt(_localctx, 117);
				{
				setState(1134);
				((InstructionContext)_localctx).name = match(KW_IFNONNULL);
				setState(1135);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFNONNULL, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 118:
				enterOuterAlt(_localctx, 118);
				{
				setState(1138);
				((InstructionContext)_localctx).name = match(KW_IFNULL);
				setState(1139);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(IFNULL, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 119:
				enterOuterAlt(_localctx, 119);
				{
				setState(1143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1142);
					match(KW_WIDE);
					}
				}

				setState(1145);
				((InstructionContext)_localctx).name = match(KW_IINC);
				int value = -1;
				setState(1160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(1147);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1148);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1151);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1157);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1152);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1155);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				setState(1162);
				match(COMMA);
				setState(1163);
				((InstructionContext)_localctx).signedIntegerLiteral = signedIntegerLiteral();
				mv.visitIincInsn(value, ((InstructionContext)_localctx).signedIntegerLiteral.value);
				}
				break;
			case 120:
				enterOuterAlt(_localctx, 120);
				{
				setState(1167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1166);
					match(KW_WIDE);
					}
				}

				setState(1169);
				((InstructionContext)_localctx).name = match(KW_ILOAD);
				int value = -1;
				setState(1184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(1171);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1172);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1175);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1181);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1176);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1179);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(ILOAD, value);
				}
				break;
			case 121:
				enterOuterAlt(_localctx, 121);
				{
				setState(1187);
				((InstructionContext)_localctx).name = match(KW_ILOAD_0);
				setState(1188);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ILOAD, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 122:
				enterOuterAlt(_localctx, 122);
				{
				setState(1190);
				((InstructionContext)_localctx).name = match(KW_ILOAD_1);
				setState(1191);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ILOAD, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 123:
				enterOuterAlt(_localctx, 123);
				{
				setState(1193);
				((InstructionContext)_localctx).name = match(KW_ILOAD_2);
				setState(1194);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ILOAD, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 124:
				enterOuterAlt(_localctx, 124);
				{
				setState(1196);
				((InstructionContext)_localctx).name = match(KW_ILOAD_3);
				setState(1197);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ILOAD, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 125:
				enterOuterAlt(_localctx, 125);
				{
				setState(1199);
				((InstructionContext)_localctx).name = match(KW_IMUL);
				mv.visitInsn(IMUL);
				}
				break;
			case 126:
				enterOuterAlt(_localctx, 126);
				{
				setState(1201);
				((InstructionContext)_localctx).name = match(KW_INEG);
				mv.visitInsn(INEG);
				}
				break;
			case 127:
				enterOuterAlt(_localctx, 127);
				{
				setState(1203);
				((InstructionContext)_localctx).name = match(KW_INSTANCEOF);
				setState(1204);
				referenceType();

				            var referenceType = _localctx.referenceType();
				            var arrayType = referenceType.arrayType();
				            mv.visitTypeInsn(INSTANCEOF, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
				        
				}
				break;
			case 128:
				enterOuterAlt(_localctx, 128);
				{
				setState(1207);
				((InstructionContext)_localctx).name = match(KW_INVOKEDYNAMIC);
				setState(1208);
				callSiteRef();

				            var callSite = _localctx.callSiteRef();
				            var bootstrap = callSite.bootstrapRef();
				            var bootstrapArgs = bootstrap.bootstrapArgs();
				            mv.visitInvokeDynamicInsn(
				                // name
				                callSite.identifier().str,
				                // descriptor
				                getDescriptor(callSite.methodType()),
				                // bootstrapMethodHandle
				                getHandle(bootstrap.handle()),
				                // bootstrapMethodArguments
				                getDescriptor(bootstrapArgs.methodType(0)),
				                getHandle(bootstrapArgs.handle()),
				                getSignature(bootstrapArgs.methodType(1))
				            );
				        
				}
				break;
			case 129:
				enterOuterAlt(_localctx, 129);
				{
				setState(1211);
				((InstructionContext)_localctx).name = match(KW_INVOKEINTERFACE);
				setState(1212);
				((InstructionContext)_localctx).methodRef = methodRef();
				mv.visitMethodInsn(INVOKEINTERFACE, getOwner(_localctx.methodRef()), ((InstructionContext)_localctx).methodRef.name, getDescriptor(_localctx.methodRef()));
				}
				break;
			case 130:
				enterOuterAlt(_localctx, 130);
				{
				setState(1215);
				((InstructionContext)_localctx).name = match(KW_INVOKESPECIAL);
				setState(1216);
				((InstructionContext)_localctx).methodRef = methodRef();
				mv.visitMethodInsn(INVOKESPECIAL, getOwner(_localctx.methodRef()), ((InstructionContext)_localctx).methodRef.name, getDescriptor(_localctx.methodRef()));
				}
				break;
			case 131:
				enterOuterAlt(_localctx, 131);
				{
				setState(1219);
				((InstructionContext)_localctx).name = match(KW_INVOKESTATIC);
				setState(1220);
				((InstructionContext)_localctx).methodRef = methodRef();
				mv.visitMethodInsn(INVOKESTATIC, getOwner(_localctx.methodRef()), ((InstructionContext)_localctx).methodRef.name, getDescriptor(_localctx.methodRef()));
				}
				break;
			case 132:
				enterOuterAlt(_localctx, 132);
				{
				setState(1223);
				((InstructionContext)_localctx).name = match(KW_INVOKEVIRTUAL);
				setState(1224);
				((InstructionContext)_localctx).methodRef = methodRef();
				mv.visitMethodInsn(INVOKEVIRTUAL, getOwner(_localctx.methodRef()), ((InstructionContext)_localctx).methodRef.name, getDescriptor(_localctx.methodRef()));
				}
				break;
			case 133:
				enterOuterAlt(_localctx, 133);
				{
				setState(1227);
				((InstructionContext)_localctx).name = match(KW_IOR);
				mv.visitInsn(IOR);
				}
				break;
			case 134:
				enterOuterAlt(_localctx, 134);
				{
				setState(1229);
				((InstructionContext)_localctx).name = match(KW_IREM);
				mv.visitInsn(IREM);
				}
				break;
			case 135:
				enterOuterAlt(_localctx, 135);
				{
				setState(1231);
				((InstructionContext)_localctx).name = match(KW_IRETURN);
				mv.visitInsn(IRETURN);
				}
				break;
			case 136:
				enterOuterAlt(_localctx, 136);
				{
				setState(1233);
				((InstructionContext)_localctx).name = match(KW_ISHL);
				mv.visitInsn(ISHL);
				}
				break;
			case 137:
				enterOuterAlt(_localctx, 137);
				{
				setState(1235);
				((InstructionContext)_localctx).name = match(KW_ISHR);
				mv.visitInsn(ISHR);
				}
				break;
			case 138:
				enterOuterAlt(_localctx, 138);
				{
				setState(1238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1237);
					match(KW_WIDE);
					}
				}

				setState(1240);
				((InstructionContext)_localctx).name = match(KW_ISTORE);
				int value = -1;
				setState(1255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(1242);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1243);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1246);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1252);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1247);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1250);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(ISTORE, value);
				}
				break;
			case 139:
				enterOuterAlt(_localctx, 139);
				{
				setState(1258);
				((InstructionContext)_localctx).name = match(KW_ISTORE_0);
				setState(1259);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ISTORE, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 140:
				enterOuterAlt(_localctx, 140);
				{
				setState(1261);
				((InstructionContext)_localctx).name = match(KW_ISTORE_1);
				setState(1262);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ISTORE, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 141:
				enterOuterAlt(_localctx, 141);
				{
				setState(1264);
				((InstructionContext)_localctx).name = match(KW_ISTORE_2);
				setState(1265);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ISTORE, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 142:
				enterOuterAlt(_localctx, 142);
				{
				setState(1267);
				((InstructionContext)_localctx).name = match(KW_ISTORE_3);
				setState(1268);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(ISTORE, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 143:
				enterOuterAlt(_localctx, 143);
				{
				setState(1270);
				((InstructionContext)_localctx).name = match(KW_ISUB);
				mv.visitInsn(ISUB);
				}
				break;
			case 144:
				enterOuterAlt(_localctx, 144);
				{
				setState(1272);
				((InstructionContext)_localctx).name = match(KW_IUSHR);
				mv.visitInsn(IUSHR);
				}
				break;
			case 145:
				enterOuterAlt(_localctx, 145);
				{
				setState(1274);
				((InstructionContext)_localctx).name = match(KW_IXOR);
				mv.visitInsn(IXOR);
				}
				break;
			case 146:
				enterOuterAlt(_localctx, 146);
				{
				setState(1276);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==KW_JSR || _la==KW_JSR_W) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1277);
				((InstructionContext)_localctx).labelIdentifier = labelIdentifier();
				mv.visitJumpInsn(JSR, getLabel(((InstructionContext)_localctx).labelIdentifier.str));
				}
				break;
			case 147:
				enterOuterAlt(_localctx, 147);
				{
				setState(1280);
				((InstructionContext)_localctx).name = match(KW_L2D);
				mv.visitInsn(L2D);
				}
				break;
			case 148:
				enterOuterAlt(_localctx, 148);
				{
				setState(1282);
				((InstructionContext)_localctx).name = match(KW_L2F);
				mv.visitInsn(L2F);
				}
				break;
			case 149:
				enterOuterAlt(_localctx, 149);
				{
				setState(1284);
				((InstructionContext)_localctx).name = match(KW_L2I);
				mv.visitInsn(L2I);
				}
				break;
			case 150:
				enterOuterAlt(_localctx, 150);
				{
				setState(1286);
				((InstructionContext)_localctx).name = match(KW_LADD);
				mv.visitInsn(LADD);
				}
				break;
			case 151:
				enterOuterAlt(_localctx, 151);
				{
				setState(1288);
				((InstructionContext)_localctx).name = match(KW_LALOAD);
				mv.visitInsn(LALOAD);
				}
				break;
			case 152:
				enterOuterAlt(_localctx, 152);
				{
				setState(1290);
				((InstructionContext)_localctx).name = match(KW_LAND);
				mv.visitInsn(LAND);
				}
				break;
			case 153:
				enterOuterAlt(_localctx, 153);
				{
				setState(1292);
				((InstructionContext)_localctx).name = match(KW_LASTORE);
				mv.visitInsn(LASTORE);
				}
				break;
			case 154:
				enterOuterAlt(_localctx, 154);
				{
				setState(1294);
				((InstructionContext)_localctx).name = match(KW_LCMP);
				mv.visitInsn(LCMP);
				}
				break;
			case 155:
				enterOuterAlt(_localctx, 155);
				{
				setState(1296);
				((InstructionContext)_localctx).name = match(KW_LCONST_0);
				mv.visitInsn(LCONST_0);
				}
				break;
			case 156:
				enterOuterAlt(_localctx, 156);
				{
				setState(1298);
				((InstructionContext)_localctx).name = match(KW_LCONST_1);
				mv.visitInsn(LCONST_1);
				}
				break;
			case 157:
				enterOuterAlt(_localctx, 157);
				{
				setState(1300);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (KW_LDC - 222)) | (1L << (KW_LDC_W - 222)) | (1L << (KW_LDC2_W - 222)))) != 0)) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1301);
				((InstructionContext)_localctx).loadableConstant = loadableConstant();

				            var constValue = ((InstructionContext)_localctx).loadableConstant.value;
				            if (constValue instanceof Integer value) {
				                switch (value) {
				                    case -1 -> mv.visitInsn(ICONST_M1);
				                    case 0 -> mv.visitInsn(ICONST_0);
				                    case 1 -> mv.visitInsn(ICONST_1);
				                    case 2 -> mv.visitInsn(ICONST_2);
				                    case 3 -> mv.visitInsn(ICONST_3);
				                    case 4 -> mv.visitInsn(ICONST_4);
				                    case 5 -> mv.visitInsn(ICONST_5);
				                    default -> mv.visitLdcInsn(value);
				                }
				            }
				            else if (constValue instanceof Long value) {
				                if (value == 0) mv.visitInsn(LCONST_0);
				                else if (value == 1) mv.visitInsn(LCONST_1);
				                else mv.visitLdcInsn(value);
				            }
				            else if (constValue instanceof Float value) {
				                if (value == 0.0f) mv.visitInsn(FCONST_0);
				                else if (value == 1.0f) mv.visitInsn(FCONST_1);
				                else if (value == 2.0f) mv.visitInsn(FCONST_2);
				                else mv.visitLdcInsn(value);
				            }
				            else if (constValue instanceof Double value) {
				                if (value == 0.0) mv.visitInsn(DCONST_0);
				                else if (value == 1.0) mv.visitInsn(DCONST_1);
				                else mv.visitLdcInsn(value);
				            }
				            else if (constValue instanceof String value) {
				                mv.visitLdcInsn(value);
				            }
				            else if (constValue instanceof TypeOrVoidContext typeOrVoid) {
				                mv.visitLdcInsn(Type.getType(getDescriptor(typeOrVoid)));
				            }
				            else if (constValue instanceof MethodTypeContext methodType) {
				                mv.visitLdcInsn(Type.getType(getDescriptor(methodType)));
				            }
				            else if (constValue instanceof HandleContext handle) {
				                mv.visitLdcInsn(getHandle(handle));
				            }
				            else {
				                throw new AssertionError("Invalid constant value type: " + constValue.getClass());
				            }
				        
				}
				break;
			case 158:
				enterOuterAlt(_localctx, 158);
				{
				setState(1304);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (KW_LDC - 222)) | (1L << (KW_LDC_W - 222)) | (1L << (KW_LDC2_W - 222)))) != 0)) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1305);
				match(KW_TRUE);
				mv.visitInsn(ICONST_1);
				}
				break;
			case 159:
				enterOuterAlt(_localctx, 159);
				{
				setState(1307);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (KW_LDC - 222)) | (1L << (KW_LDC_W - 222)) | (1L << (KW_LDC2_W - 222)))) != 0)) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1308);
				match(KW_FALSE);
				mv.visitInsn(ICONST_0);
				}
				break;
			case 160:
				enterOuterAlt(_localctx, 160);
				{
				setState(1310);
				((InstructionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (KW_LDC - 222)) | (1L << (KW_LDC_W - 222)) | (1L << (KW_LDC2_W - 222)))) != 0)) ) {
					((InstructionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1311);
				match(KW_NULL);
				mv.visitInsn(ACONST_NULL);
				}
				break;
			case 161:
				enterOuterAlt(_localctx, 161);
				{
				setState(1313);
				((InstructionContext)_localctx).name = match(KW_LDIV);
				mv.visitInsn(LDIV);
				}
				break;
			case 162:
				enterOuterAlt(_localctx, 162);
				{
				setState(1316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1315);
					match(KW_WIDE);
					}
				}

				setState(1318);
				((InstructionContext)_localctx).name = match(KW_LLOAD);
				int value = -1;
				setState(1333);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(1320);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1321);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1324);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1330);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1325);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1328);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(LLOAD, value);
				}
				break;
			case 163:
				enterOuterAlt(_localctx, 163);
				{
				setState(1336);
				((InstructionContext)_localctx).name = match(KW_LLOAD_0);
				setState(1337);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LLOAD, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 164:
				enterOuterAlt(_localctx, 164);
				{
				setState(1339);
				((InstructionContext)_localctx).name = match(KW_LLOAD_1);
				setState(1340);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LLOAD, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 165:
				enterOuterAlt(_localctx, 165);
				{
				setState(1342);
				((InstructionContext)_localctx).name = match(KW_LLOAD_2);
				setState(1343);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LLOAD, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 166:
				enterOuterAlt(_localctx, 166);
				{
				setState(1345);
				((InstructionContext)_localctx).name = match(KW_LLOAD_3);
				setState(1346);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LLOAD, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 167:
				enterOuterAlt(_localctx, 167);
				{
				setState(1348);
				((InstructionContext)_localctx).name = match(KW_LMUL);
				mv.visitInsn(LMUL);
				}
				break;
			case 168:
				enterOuterAlt(_localctx, 168);
				{
				setState(1350);
				((InstructionContext)_localctx).name = match(KW_LNEG);
				mv.visitInsn(LNEG);
				}
				break;
			case 169:
				enterOuterAlt(_localctx, 169);
				{
				setState(1352);
				((InstructionContext)_localctx).name = match(KW_LOOKUPSWITCH);
				setState(1353);
				lookupSwitchArg();

				            var switchArg = _localctx.lookupSwitchArg();
				            var pairs = switchArg.lookupSwitchCase().stream()
				                    .sorted((x1, x2) -> Integer.compare(x1.value, x2.value))
				                    .collect(Collectors.toList());
				            var keys = new int[pairs.size()];
				            var labels = new Label[keys.length];
				            for (int i = 0; i < keys.length; i++) {
				                var pair = pairs.get(i);
				                keys[i] = pair.value;
				                labels[i] = getLabel(pair.label);
				            }
				            mv.visitLookupSwitchInsn(getLabel(switchArg.switchDefault().label), keys, labels);
				        
				}
				break;
			case 170:
				enterOuterAlt(_localctx, 170);
				{
				setState(1356);
				((InstructionContext)_localctx).name = match(KW_LOR);
				mv.visitInsn(LOR);
				}
				break;
			case 171:
				enterOuterAlt(_localctx, 171);
				{
				setState(1358);
				((InstructionContext)_localctx).name = match(KW_LREM);
				mv.visitInsn(LREM);
				}
				break;
			case 172:
				enterOuterAlt(_localctx, 172);
				{
				setState(1360);
				((InstructionContext)_localctx).name = match(KW_LRETURN);
				mv.visitInsn(LRETURN);
				}
				break;
			case 173:
				enterOuterAlt(_localctx, 173);
				{
				setState(1362);
				((InstructionContext)_localctx).name = match(KW_LSHL);
				mv.visitInsn(LSHL);
				}
				break;
			case 174:
				enterOuterAlt(_localctx, 174);
				{
				setState(1364);
				((InstructionContext)_localctx).name = match(KW_LSHR);
				mv.visitInsn(LSHR);
				}
				break;
			case 175:
				enterOuterAlt(_localctx, 175);
				{
				setState(1367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1366);
					match(KW_WIDE);
					}
				}

				setState(1369);
				((InstructionContext)_localctx).name = match(KW_LSTORE);
				int value = -1;
				setState(1384);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(1371);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1372);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1375);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1381);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1376);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1379);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(LSTORE, value);
				}
				break;
			case 176:
				enterOuterAlt(_localctx, 176);
				{
				setState(1387);
				((InstructionContext)_localctx).name = match(KW_LSTORE_0);
				setState(1388);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LSTORE, 0); localVarMode = MODE_INDICES;
				}
				break;
			case 177:
				enterOuterAlt(_localctx, 177);
				{
				setState(1390);
				((InstructionContext)_localctx).name = match(KW_LSTORE_1);
				setState(1391);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LSTORE, 1); localVarMode = MODE_INDICES;
				}
				break;
			case 178:
				enterOuterAlt(_localctx, 178);
				{
				setState(1393);
				((InstructionContext)_localctx).name = match(KW_LSTORE_2);
				setState(1394);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LSTORE, 2); localVarMode = MODE_INDICES;
				}
				break;
			case 179:
				enterOuterAlt(_localctx, 179);
				{
				setState(1396);
				((InstructionContext)_localctx).name = match(KW_LSTORE_3);
				setState(1397);
				if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
				mv.visitVarInsn(LSTORE, 3); localVarMode = MODE_INDICES;
				}
				break;
			case 180:
				enterOuterAlt(_localctx, 180);
				{
				setState(1399);
				((InstructionContext)_localctx).name = match(KW_LSUB);
				mv.visitInsn(LSUB);
				}
				break;
			case 181:
				enterOuterAlt(_localctx, 181);
				{
				setState(1401);
				((InstructionContext)_localctx).name = match(KW_LUSHR);
				mv.visitInsn(LUSHR);
				}
				break;
			case 182:
				enterOuterAlt(_localctx, 182);
				{
				setState(1403);
				((InstructionContext)_localctx).name = match(KW_LXOR);
				mv.visitInsn(LXOR);
				}
				break;
			case 183:
				enterOuterAlt(_localctx, 183);
				{
				setState(1405);
				((InstructionContext)_localctx).name = match(KW_MONITORENTER);
				mv.visitInsn(MONITORENTER);
				}
				break;
			case 184:
				enterOuterAlt(_localctx, 184);
				{
				setState(1407);
				((InstructionContext)_localctx).name = match(KW_MONITOREXIT);
				mv.visitInsn(MONITOREXIT);
				}
				break;
			case 185:
				enterOuterAlt(_localctx, 185);
				{
				setState(1409);
				((InstructionContext)_localctx).name = match(KW_MULTIANEWARRAY);
				setState(1410);
				arrayType();
				setState(1411);
				((InstructionContext)_localctx).integerLiteral = integerLiteral();
				setState(1412);
				if (!(((InstructionContext)_localctx).integerLiteral.value <= arrayDimCount(_localctx.arrayType()))) throw new FailedPredicateException(this, "$integerLiteral.value <= arrayDimCount($ctx.arrayType())");
				mv.visitMultiANewArrayInsn(getDescriptor(_localctx.arrayType()), ((InstructionContext)_localctx).integerLiteral.value);
				}
				break;
			case 186:
				enterOuterAlt(_localctx, 186);
				{
				setState(1415);
				((InstructionContext)_localctx).name = match(KW_NEW);
				setState(1416);
				classOrInterfaceType();
				mv.visitTypeInsn(NEW, getDescriptor(_localctx.classOrInterfaceType()));
				}
				break;
			case 187:
				enterOuterAlt(_localctx, 187);
				{
				setState(1419);
				((InstructionContext)_localctx).name = match(KW_NEWARRAY);
				setState(1420);
				((InstructionContext)_localctx).primitiveType = primitiveType();
				mv.visitIntInsn(NEWARRAY, switch(((InstructionContext)_localctx).primitiveType.descriptor) {
				            case 'Z' -> T_BOOLEAN;
				            case 'B' -> T_BYTE;
				            case 'C' -> T_CHAR;
				            case 'S' -> T_SHORT;
				            case 'L' -> T_LONG;
				            case 'I' -> T_INT;
				            case 'F' -> T_FLOAT;
				            case 'D' -> T_DOUBLE;
				            default -> throw new AssertionError();
				        });
				}
				break;
			case 188:
				enterOuterAlt(_localctx, 188);
				{
				setState(1423);
				((InstructionContext)_localctx).name = match(KW_NOP);
				mv.visitInsn(NOP);
				}
				break;
			case 189:
				enterOuterAlt(_localctx, 189);
				{
				setState(1425);
				((InstructionContext)_localctx).name = match(KW_POP);
				mv.visitInsn(POP);
				}
				break;
			case 190:
				enterOuterAlt(_localctx, 190);
				{
				setState(1427);
				((InstructionContext)_localctx).name = match(KW_POP2);
				mv.visitInsn(POP2);
				}
				break;
			case 191:
				enterOuterAlt(_localctx, 191);
				{
				setState(1429);
				((InstructionContext)_localctx).name = match(KW_PUTFIELD);
				setState(1430);
				((InstructionContext)_localctx).fieldRef = fieldRef();
				mv.visitFieldInsn(PUTFIELD, getOwner(_localctx.fieldRef()), ((InstructionContext)_localctx).fieldRef.name, getDescriptor(_localctx.fieldRef()));
				}
				break;
			case 192:
				enterOuterAlt(_localctx, 192);
				{
				setState(1433);
				((InstructionContext)_localctx).name = match(KW_PUTSTATIC);
				setState(1434);
				((InstructionContext)_localctx).fieldRef = fieldRef();
				mv.visitFieldInsn(PUTSTATIC, getOwner(_localctx.fieldRef()), ((InstructionContext)_localctx).fieldRef.name, getDescriptor(_localctx.fieldRef()));
				}
				break;
			case 193:
				enterOuterAlt(_localctx, 193);
				{
				setState(1438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_WIDE) {
					{
					setState(1437);
					match(KW_WIDE);
					}
				}

				setState(1440);
				((InstructionContext)_localctx).name = match(KW_RET);
				int value = -1;
				setState(1455);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(1442);
					if (!(localVarMode != MODE_NAMES)) throw new FailedPredicateException(this, "localVarMode != MODE_NAMES");
					setState(1443);
					((InstructionContext)_localctx).integerLiteral = integerLiteral();
					value = ((InstructionContext)_localctx).integerLiteral.value; localVarMode = MODE_INDICES;
					}
					break;
				case 2:
					{
					setState(1446);
					if (!(localVarMode != MODE_INDICES)) throw new FailedPredicateException(this, "localVarMode != MODE_INDICES");
					setState(1452);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case KW_SYNTHETIC:
					case KW_MANDATED:
					case KW_BRIDGE:
					case KW_DEPRECATED:
					case KW_CODE:
					case KW_AASTORE:
					case KW_ACONST_NULL:
					case KW_ALOAD:
					case KW_ALOAD_0:
					case KW_ALOAD_1:
					case KW_ALOAD_2:
					case KW_ALOAD_3:
					case KW_ANEWARRAY:
					case KW_ARETURN:
					case KW_ARRAYLENGTH:
					case KW_ASTORE:
					case KW_ASTORE_0:
					case KW_ASTORE_1:
					case KW_ASTORE_2:
					case KW_ASTORE_3:
					case KW_ATHROW:
					case KW_BALOAD:
					case KW_BASTORE:
					case KW_BIPUSH:
					case KW_CALOAD:
					case KW_CASTORE:
					case KW_CHECKCAST:
					case KW_D2F:
					case KW_D2I:
					case KW_D2L:
					case KW_DADD:
					case KW_DALOAD:
					case KW_DASTORE:
					case KW_DCMPG:
					case KW_DCMPL:
					case KW_DCONST_0:
					case KW_DCONST_1:
					case KW_DDIV:
					case KW_DLOAD:
					case KW_DLOAD_0:
					case KW_DLOAD_1:
					case KW_DLOAD_2:
					case KW_DLOAD_3:
					case KW_DMUL:
					case KW_DNEG:
					case KW_DREM:
					case KW_DRETURN:
					case KW_DSTORE:
					case KW_DSTORE_0:
					case KW_DSTORE_1:
					case KW_DSTORE_2:
					case KW_DSTORE_3:
					case KW_DSUB:
					case KW_DUP:
					case KW_DUP_X1:
					case KW_DUP_X2:
					case KW_DUP2:
					case KW_DUP2_X1:
					case KW_DUP2_X2:
					case KW_F2D:
					case KW_F2I:
					case KW_F2L:
					case KW_FADD:
					case KW_FALOAD:
					case KW_FASTORE:
					case KW_FCMPG:
					case KW_FCMPL:
					case KW_FCONST_0:
					case KW_FCONST_1:
					case KW_FCONST_2:
					case KW_FDIV:
					case KW_FLOAD:
					case KW_FLOAD_0:
					case KW_FLOAD_1:
					case KW_FLOAD_2:
					case KW_FLOAD_3:
					case KW_FMUL:
					case KW_FNEG:
					case KW_FREM:
					case KW_FRETURN:
					case KW_FSTORE:
					case KW_FSTORE_0:
					case KW_FSTORE_1:
					case KW_FSTORE_2:
					case KW_FSTORE_3:
					case KW_FSUB:
					case KW_GETFIELD:
					case KW_GETSTATIC:
					case KW_GOTO_W:
					case KW_I2B:
					case KW_I2C:
					case KW_I2D:
					case KW_I2F:
					case KW_I2L:
					case KW_I2S:
					case KW_IADD:
					case KW_IALOAD:
					case KW_IAND:
					case KW_IASTORE:
					case KW_ICONST_M1:
					case KW_ICONST_0:
					case KW_ICONST_1:
					case KW_ICONST_2:
					case KW_ICONST_3:
					case KW_ICONST_4:
					case KW_ICONST_5:
					case KW_IDIV:
					case KW_IF_ACMPEQ:
					case KW_IF_ACMPNE:
					case KW_IF_ICMPEQ:
					case KW_IF_ICMPNE:
					case KW_IF_ICMPLT:
					case KW_IF_ICMPGE:
					case KW_IF_ICMPGT:
					case KW_IF_ICMPLE:
					case KW_IFEQ:
					case KW_IFNE:
					case KW_IFLT:
					case KW_IFGE:
					case KW_IFGT:
					case KW_IFLE:
					case KW_IFNONNULL:
					case KW_IFNULL:
					case KW_IINC:
					case KW_ILOAD:
					case KW_ILOAD_0:
					case KW_ILOAD_1:
					case KW_ILOAD_2:
					case KW_ILOAD_3:
					case KW_IMUL:
					case KW_INEG:
					case KW_INVOKEDYNAMIC:
					case KW_INVOKEINTERFACE:
					case KW_INVOKESPECIAL:
					case KW_INVOKESTATIC:
					case KW_INVOKEVIRTUAL:
					case KW_IOR:
					case KW_IREM:
					case KW_IRETURN:
					case KW_ISHL:
					case KW_ISHR:
					case KW_ISTORE:
					case KW_ISTORE_0:
					case KW_ISTORE_1:
					case KW_ISTORE_2:
					case KW_ISTORE_3:
					case KW_ISUB:
					case KW_IUSHR:
					case KW_IXOR:
					case KW_JSR:
					case KW_JSR_W:
					case KW_L2D:
					case KW_L2F:
					case KW_L2I:
					case KW_LADD:
					case KW_LALOAD:
					case KW_LAND:
					case KW_LASTORE:
					case KW_LCMP:
					case KW_LCONST_0:
					case KW_LCONST_1:
					case KW_LDC:
					case KW_LDC_W:
					case KW_LDC2_W:
					case KW_LDIV:
					case KW_LLOAD:
					case KW_LLOAD_0:
					case KW_LLOAD_1:
					case KW_LLOAD_2:
					case KW_LLOAD_3:
					case KW_LMUL:
					case KW_LNEG:
					case KW_LOOKUPSWITCH:
					case KW_LOR:
					case KW_LREM:
					case KW_LRETURN:
					case KW_LSHL:
					case KW_LSHR:
					case KW_LSTORE:
					case KW_LSTORE_0:
					case KW_LSTORE_1:
					case KW_LSTORE_2:
					case KW_LSTORE_3:
					case KW_LSUB:
					case KW_LUSHR:
					case KW_LXOR:
					case KW_MONITORENTER:
					case KW_MONITOREXIT:
					case KW_MULTIANEWARRAY:
					case KW_NEWARRAY:
					case KW_NOP:
					case KW_POP:
					case KW_POP2:
					case KW_PUTFIELD:
					case KW_PUTSTATIC:
					case KW_RET:
					case KW_SALOAD:
					case KW_SASTORE:
					case KW_SIPUSH:
					case KW_SWAP:
					case KW_TABLESWITCH:
					case KW_WIDE:
					case Identifier:
						{
						setState(1447);
						((InstructionContext)_localctx).identifier = identifier();
						value = getVariable(((InstructionContext)_localctx).identifier.str);
						}
						break;
					case KW_THIS:
						{
						setState(1450);
						match(KW_THIS);
						value = getVariable("this");
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					localVarMode = MODE_NAMES;
					}
					break;
				}
				mv.visitVarInsn(RET, value);
				}
				break;
			case 194:
				enterOuterAlt(_localctx, 194);
				{
				setState(1458);
				((InstructionContext)_localctx).name = match(KW_RETURN);
				mv.visitInsn(RETURN);
				}
				break;
			case 195:
				enterOuterAlt(_localctx, 195);
				{
				setState(1460);
				((InstructionContext)_localctx).name = match(KW_SALOAD);
				mv.visitInsn(SALOAD);
				}
				break;
			case 196:
				enterOuterAlt(_localctx, 196);
				{
				setState(1462);
				((InstructionContext)_localctx).name = match(KW_SASTORE);
				mv.visitInsn(SASTORE);
				}
				break;
			case 197:
				enterOuterAlt(_localctx, 197);
				{
				setState(1464);
				((InstructionContext)_localctx).name = match(KW_SIPUSH);
				setState(1465);
				((InstructionContext)_localctx).signedShortLiteral = signedShortLiteral();
				mv.visitIntInsn(SIPUSH, ((InstructionContext)_localctx).signedShortLiteral.value);
				}
				break;
			case 198:
				enterOuterAlt(_localctx, 198);
				{
				setState(1468);
				((InstructionContext)_localctx).name = match(KW_SWAP);
				mv.visitInsn(SWAP);
				}
				break;
			case 199:
				enterOuterAlt(_localctx, 199);
				{
				setState(1470);
				((InstructionContext)_localctx).name = match(KW_TABLESWITCH);
				setState(1471);
				tableSwitchArg();

				            var switchArg = _localctx.tableSwitchArg();
				            var labels = new ArrayList<Label>();
				            labels.add(getLabel(switchArg.lookupSwitchCase().label));
				            switchArg.tableSwitchCase().forEach(tableSwitchCase -> labels.add(getLabel(tableSwitchCase.label)));
				            mv.visitTableSwitchInsn(switchArg.min, switchArg.max, getLabel(switchArg.switchDefault().label), labels.toArray(Label[]::new));
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldRefContext extends ParserRuleContext {
		public String name;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ASMParser.DOT, 0); }
		public FieldRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFieldRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFieldRef(this);
		}
	}

	public final FieldRefContext fieldRef() throws RecognitionException {
		FieldRefContext _localctx = new FieldRefContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fieldRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(1476);
				classOrInterfaceType();
				setState(1477);
				match(DOT);
				}
				break;
			}
			setState(1481);
			((FieldRefContext)_localctx).identifier = identifier();
			((FieldRefContext)_localctx).name =  ((FieldRefContext)_localctx).identifier.str;
			setState(1483);
			match(COLON);
			setState(1484);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodRefContext extends ParserRuleContext {
		public String name;
		public IdentifierContext identifier;
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INIT() { return getToken(ASMParser.INIT, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ASMParser.DOT, 0); }
		public MethodRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterMethodRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitMethodRef(this);
		}
	}

	public final MethodRefContext methodRef() throws RecognitionException {
		MethodRefContext _localctx = new MethodRefContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_methodRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				{
				setState(1486);
				classOrInterfaceType();
				setState(1487);
				match(DOT);
				}
				break;
			}
			setState(1496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SYNTHETIC:
			case KW_MANDATED:
			case KW_BRIDGE:
			case KW_DEPRECATED:
			case KW_CODE:
			case KW_AASTORE:
			case KW_ACONST_NULL:
			case KW_ALOAD:
			case KW_ALOAD_0:
			case KW_ALOAD_1:
			case KW_ALOAD_2:
			case KW_ALOAD_3:
			case KW_ANEWARRAY:
			case KW_ARETURN:
			case KW_ARRAYLENGTH:
			case KW_ASTORE:
			case KW_ASTORE_0:
			case KW_ASTORE_1:
			case KW_ASTORE_2:
			case KW_ASTORE_3:
			case KW_ATHROW:
			case KW_BALOAD:
			case KW_BASTORE:
			case KW_BIPUSH:
			case KW_CALOAD:
			case KW_CASTORE:
			case KW_CHECKCAST:
			case KW_D2F:
			case KW_D2I:
			case KW_D2L:
			case KW_DADD:
			case KW_DALOAD:
			case KW_DASTORE:
			case KW_DCMPG:
			case KW_DCMPL:
			case KW_DCONST_0:
			case KW_DCONST_1:
			case KW_DDIV:
			case KW_DLOAD:
			case KW_DLOAD_0:
			case KW_DLOAD_1:
			case KW_DLOAD_2:
			case KW_DLOAD_3:
			case KW_DMUL:
			case KW_DNEG:
			case KW_DREM:
			case KW_DRETURN:
			case KW_DSTORE:
			case KW_DSTORE_0:
			case KW_DSTORE_1:
			case KW_DSTORE_2:
			case KW_DSTORE_3:
			case KW_DSUB:
			case KW_DUP:
			case KW_DUP_X1:
			case KW_DUP_X2:
			case KW_DUP2:
			case KW_DUP2_X1:
			case KW_DUP2_X2:
			case KW_F2D:
			case KW_F2I:
			case KW_F2L:
			case KW_FADD:
			case KW_FALOAD:
			case KW_FASTORE:
			case KW_FCMPG:
			case KW_FCMPL:
			case KW_FCONST_0:
			case KW_FCONST_1:
			case KW_FCONST_2:
			case KW_FDIV:
			case KW_FLOAD:
			case KW_FLOAD_0:
			case KW_FLOAD_1:
			case KW_FLOAD_2:
			case KW_FLOAD_3:
			case KW_FMUL:
			case KW_FNEG:
			case KW_FREM:
			case KW_FRETURN:
			case KW_FSTORE:
			case KW_FSTORE_0:
			case KW_FSTORE_1:
			case KW_FSTORE_2:
			case KW_FSTORE_3:
			case KW_FSUB:
			case KW_GETFIELD:
			case KW_GETSTATIC:
			case KW_GOTO_W:
			case KW_I2B:
			case KW_I2C:
			case KW_I2D:
			case KW_I2F:
			case KW_I2L:
			case KW_I2S:
			case KW_IADD:
			case KW_IALOAD:
			case KW_IAND:
			case KW_IASTORE:
			case KW_ICONST_M1:
			case KW_ICONST_0:
			case KW_ICONST_1:
			case KW_ICONST_2:
			case KW_ICONST_3:
			case KW_ICONST_4:
			case KW_ICONST_5:
			case KW_IDIV:
			case KW_IF_ACMPEQ:
			case KW_IF_ACMPNE:
			case KW_IF_ICMPEQ:
			case KW_IF_ICMPNE:
			case KW_IF_ICMPLT:
			case KW_IF_ICMPGE:
			case KW_IF_ICMPGT:
			case KW_IF_ICMPLE:
			case KW_IFEQ:
			case KW_IFNE:
			case KW_IFLT:
			case KW_IFGE:
			case KW_IFGT:
			case KW_IFLE:
			case KW_IFNONNULL:
			case KW_IFNULL:
			case KW_IINC:
			case KW_ILOAD:
			case KW_ILOAD_0:
			case KW_ILOAD_1:
			case KW_ILOAD_2:
			case KW_ILOAD_3:
			case KW_IMUL:
			case KW_INEG:
			case KW_INVOKEDYNAMIC:
			case KW_INVOKEINTERFACE:
			case KW_INVOKESPECIAL:
			case KW_INVOKESTATIC:
			case KW_INVOKEVIRTUAL:
			case KW_IOR:
			case KW_IREM:
			case KW_IRETURN:
			case KW_ISHL:
			case KW_ISHR:
			case KW_ISTORE:
			case KW_ISTORE_0:
			case KW_ISTORE_1:
			case KW_ISTORE_2:
			case KW_ISTORE_3:
			case KW_ISUB:
			case KW_IUSHR:
			case KW_IXOR:
			case KW_JSR:
			case KW_JSR_W:
			case KW_L2D:
			case KW_L2F:
			case KW_L2I:
			case KW_LADD:
			case KW_LALOAD:
			case KW_LAND:
			case KW_LASTORE:
			case KW_LCMP:
			case KW_LCONST_0:
			case KW_LCONST_1:
			case KW_LDC:
			case KW_LDC_W:
			case KW_LDC2_W:
			case KW_LDIV:
			case KW_LLOAD:
			case KW_LLOAD_0:
			case KW_LLOAD_1:
			case KW_LLOAD_2:
			case KW_LLOAD_3:
			case KW_LMUL:
			case KW_LNEG:
			case KW_LOOKUPSWITCH:
			case KW_LOR:
			case KW_LREM:
			case KW_LRETURN:
			case KW_LSHL:
			case KW_LSHR:
			case KW_LSTORE:
			case KW_LSTORE_0:
			case KW_LSTORE_1:
			case KW_LSTORE_2:
			case KW_LSTORE_3:
			case KW_LSUB:
			case KW_LUSHR:
			case KW_LXOR:
			case KW_MONITORENTER:
			case KW_MONITOREXIT:
			case KW_MULTIANEWARRAY:
			case KW_NEWARRAY:
			case KW_NOP:
			case KW_POP:
			case KW_POP2:
			case KW_PUTFIELD:
			case KW_PUTSTATIC:
			case KW_RET:
			case KW_SALOAD:
			case KW_SASTORE:
			case KW_SIPUSH:
			case KW_SWAP:
			case KW_TABLESWITCH:
			case KW_WIDE:
			case Identifier:
				{
				setState(1491);
				((MethodRefContext)_localctx).identifier = identifier();
				((MethodRefContext)_localctx).name =  ((MethodRefContext)_localctx).identifier.str;
				}
				break;
			case INIT:
				{
				setState(1494);
				match(INIT);
				((MethodRefContext)_localctx).name =  "<init>";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1498);
			match(COLON);
			setState(1499);
			methodType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallSiteRefContext extends ParserRuleContext {
		public BootstrapRefContext bootstrapRef() {
			return getRuleContext(BootstrapRefContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(ASMParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ASMParser.COLON, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public CallSiteRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callSiteRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterCallSiteRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitCallSiteRef(this);
		}
	}

	public final CallSiteRefContext callSiteRef() throws RecognitionException {
		CallSiteRefContext _localctx = new CallSiteRefContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_callSiteRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1501);
			bootstrapRef();
			setState(1502);
			match(COLON);
			setState(1503);
			identifier();
			setState(1504);
			match(COLON);
			setState(1505);
			methodType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BootstrapRefContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ASMParser.LBRACE, 0); }
		public HandleContext handle() {
			return getRuleContext(HandleContext.class,0);
		}
		public BootstrapArgsContext bootstrapArgs() {
			return getRuleContext(BootstrapArgsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ASMParser.RBRACE, 0); }
		public BootstrapRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bootstrapRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterBootstrapRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitBootstrapRef(this);
		}
	}

	public final BootstrapRefContext bootstrapRef() throws RecognitionException {
		BootstrapRefContext _localctx = new BootstrapRefContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_bootstrapRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1507);
			match(LBRACE);
			setState(1508);
			handle();
			setState(1509);
			bootstrapArgs();
			setState(1510);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HandleContext extends ParserRuleContext {
		public Token name;
		public FieldRefContext fieldRef() {
			return getRuleContext(FieldRefContext.class,0);
		}
		public TerminalNode KW_GETFIELD() { return getToken(ASMParser.KW_GETFIELD, 0); }
		public TerminalNode KW_GETSTATIC() { return getToken(ASMParser.KW_GETSTATIC, 0); }
		public TerminalNode KW_PUTFIELD() { return getToken(ASMParser.KW_PUTFIELD, 0); }
		public TerminalNode KW_PUTSTATIC() { return getToken(ASMParser.KW_PUTSTATIC, 0); }
		public MethodRefContext methodRef() {
			return getRuleContext(MethodRefContext.class,0);
		}
		public TerminalNode KW_INVOKEVIRTUAL() { return getToken(ASMParser.KW_INVOKEVIRTUAL, 0); }
		public TerminalNode KW_INVOKESTATIC() { return getToken(ASMParser.KW_INVOKESTATIC, 0); }
		public TerminalNode KW_INVOKESPECIAL() { return getToken(ASMParser.KW_INVOKESPECIAL, 0); }
		public TerminalNode KW_INVOKEINTERFACE() { return getToken(ASMParser.KW_INVOKEINTERFACE, 0); }
		public TerminalNode KW_NEW() { return getToken(ASMParser.KW_NEW, 0); }
		public HandleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterHandle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitHandle(this);
		}
	}

	public final HandleContext handle() throws RecognitionException {
		HandleContext _localctx = new HandleContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_handle);
		int _la;
		try {
			setState(1519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_GETFIELD:
			case KW_GETSTATIC:
			case KW_PUTFIELD:
			case KW_PUTSTATIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(1512);
				((HandleContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==KW_GETFIELD || _la==KW_GETSTATIC || _la==KW_PUTFIELD || _la==KW_PUTSTATIC) ) {
					((HandleContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1513);
				fieldRef();
				}
				break;
			case KW_INVOKEINTERFACE:
			case KW_INVOKESPECIAL:
			case KW_INVOKESTATIC:
			case KW_INVOKEVIRTUAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1514);
				((HandleContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (KW_INVOKEINTERFACE - 193)) | (1L << (KW_INVOKESPECIAL - 193)) | (1L << (KW_INVOKESTATIC - 193)) | (1L << (KW_INVOKEVIRTUAL - 193)))) != 0)) ) {
					((HandleContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1515);
				methodRef();
				}
				break;
			case KW_NEW:
				enterOuterAlt(_localctx, 3);
				{
				setState(1516);
				match(KW_NEW);
				setState(1517);
				((HandleContext)_localctx).name = match(KW_INVOKESPECIAL);
				setState(1518);
				methodRef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BootstrapArgsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ASMParser.LPAREN, 0); }
		public List<MethodTypeContext> methodType() {
			return getRuleContexts(MethodTypeContext.class);
		}
		public MethodTypeContext methodType(int i) {
			return getRuleContext(MethodTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public HandleContext handle() {
			return getRuleContext(HandleContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ASMParser.RPAREN, 0); }
		public BootstrapArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bootstrapArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterBootstrapArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitBootstrapArgs(this);
		}
	}

	public final BootstrapArgsContext bootstrapArgs() throws RecognitionException {
		BootstrapArgsContext _localctx = new BootstrapArgsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_bootstrapArgs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			match(LPAREN);
			setState(1522);
			methodType();
			setState(1523);
			match(COMMA);
			setState(1524);
			handle();
			setState(1525);
			match(COMMA);
			setState(1526);
			methodType();
			setState(1527);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1529);
			type();
			setState(1534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1530);
				match(COMMA);
				setState(1531);
				type();
				}
				}
				setState(1536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadableConstantContext extends ParserRuleContext {
		public Object value;
		public SignedIntegerLiteralContext signedIntegerLiteral;
		public SignedLongLiteralContext signedLongLiteral;
		public FloatLiteralContext floatLiteral;
		public DoubleLiteralContext doubleLiteral;
		public StringLiteralContext stringLiteral;
		public CharacterLiteralContext characterLiteral;
		public SignedIntegerLiteralContext signedIntegerLiteral() {
			return getRuleContext(SignedIntegerLiteralContext.class,0);
		}
		public SignedLongLiteralContext signedLongLiteral() {
			return getRuleContext(SignedLongLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public DoubleLiteralContext doubleLiteral() {
			return getRuleContext(DoubleLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public TypeOrVoidContext typeOrVoid() {
			return getRuleContext(TypeOrVoidContext.class,0);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public HandleContext handle() {
			return getRuleContext(HandleContext.class,0);
		}
		public LoadableConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadableConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLoadableConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLoadableConstant(this);
		}
	}

	public final LoadableConstantContext loadableConstant() throws RecognitionException {
		LoadableConstantContext _localctx = new LoadableConstantContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_loadableConstant);
		try {
			setState(1564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1537);
				((LoadableConstantContext)_localctx).signedIntegerLiteral = signedIntegerLiteral();
				((LoadableConstantContext)_localctx).value =  ((LoadableConstantContext)_localctx).signedIntegerLiteral.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1540);
				((LoadableConstantContext)_localctx).signedLongLiteral = signedLongLiteral();
				((LoadableConstantContext)_localctx).value =  ((LoadableConstantContext)_localctx).signedLongLiteral.value;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1543);
				((LoadableConstantContext)_localctx).floatLiteral = floatLiteral();
				((LoadableConstantContext)_localctx).value =  ((LoadableConstantContext)_localctx).floatLiteral.value;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1546);
				((LoadableConstantContext)_localctx).doubleLiteral = doubleLiteral();
				((LoadableConstantContext)_localctx).value =  ((LoadableConstantContext)_localctx).doubleLiteral.value;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1549);
				((LoadableConstantContext)_localctx).stringLiteral = stringLiteral();
				((LoadableConstantContext)_localctx).value =  ((LoadableConstantContext)_localctx).stringLiteral.value;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1552);
				((LoadableConstantContext)_localctx).characterLiteral = characterLiteral();
				((LoadableConstantContext)_localctx).value =  (int)((LoadableConstantContext)_localctx).characterLiteral.value;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1555);
				typeOrVoid();
				((LoadableConstantContext)_localctx).value =  _localctx.typeOrVoid();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1558);
				methodType();
				((LoadableConstantContext)_localctx).value =  _localctx.methodType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1561);
				handle();
				((LoadableConstantContext)_localctx).value =  _localctx.handle();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LookupSwitchArgContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ASMParser.LBRACE, 0); }
		public SwitchDefaultContext switchDefault() {
			return getRuleContext(SwitchDefaultContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ASMParser.RBRACE, 0); }
		public List<LookupSwitchCaseContext> lookupSwitchCase() {
			return getRuleContexts(LookupSwitchCaseContext.class);
		}
		public LookupSwitchCaseContext lookupSwitchCase(int i) {
			return getRuleContext(LookupSwitchCaseContext.class,i);
		}
		public LookupSwitchArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupSwitchArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLookupSwitchArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLookupSwitchArg(this);
		}
	}

	public final LookupSwitchArgContext lookupSwitchArg() throws RecognitionException {
		LookupSwitchArgContext _localctx = new LookupSwitchArgContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_lookupSwitchArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			match(LBRACE);
			setState(1568); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1567);
				lookupSwitchCase();
				}
				}
				setState(1570); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 287)) & ~0x3f) == 0 && ((1L << (_la - 287)) & ((1L << (NegativeIntegerLiteral - 287)) | (1L << (IntegerLiteral - 287)) | (1L << (CharacterLiteral - 287)))) != 0) );
			setState(1572);
			switchDefault();
			setState(1573);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LookupSwitchCaseContext extends ParserRuleContext {
		public int value;
		public String label;
		public SignedIntegerLiteralContext signedIntegerLiteral;
		public CharacterLiteralContext characterLiteral;
		public LabelIdentifierContext labelIdentifier;
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public SignedIntegerLiteralContext signedIntegerLiteral() {
			return getRuleContext(SignedIntegerLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public LookupSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookupSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLookupSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLookupSwitchCase(this);
		}
	}

	public final LookupSwitchCaseContext lookupSwitchCase() throws RecognitionException {
		LookupSwitchCaseContext _localctx = new LookupSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_lookupSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1581);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NegativeIntegerLiteral:
			case IntegerLiteral:
				{
				setState(1575);
				((LookupSwitchCaseContext)_localctx).signedIntegerLiteral = signedIntegerLiteral();
				((LookupSwitchCaseContext)_localctx).value =  ((LookupSwitchCaseContext)_localctx).signedIntegerLiteral.value;
				}
				break;
			case CharacterLiteral:
				{
				setState(1578);
				((LookupSwitchCaseContext)_localctx).characterLiteral = characterLiteral();
				((LookupSwitchCaseContext)_localctx).value =  ((LookupSwitchCaseContext)_localctx).characterLiteral.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1583);
			match(COLON);
			setState(1584);
			((LookupSwitchCaseContext)_localctx).labelIdentifier = labelIdentifier();
			((LookupSwitchCaseContext)_localctx).label =  ((LookupSwitchCaseContext)_localctx).labelIdentifier.str;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableSwitchArgContext extends ParserRuleContext {
		public int min;
		public int max;
		public LookupSwitchCaseContext lookupSwitchCase;
		public TerminalNode LBRACE() { return getToken(ASMParser.LBRACE, 0); }
		public LookupSwitchCaseContext lookupSwitchCase() {
			return getRuleContext(LookupSwitchCaseContext.class,0);
		}
		public SwitchDefaultContext switchDefault() {
			return getRuleContext(SwitchDefaultContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ASMParser.RBRACE, 0); }
		public List<TableSwitchCaseContext> tableSwitchCase() {
			return getRuleContexts(TableSwitchCaseContext.class);
		}
		public TableSwitchCaseContext tableSwitchCase(int i) {
			return getRuleContext(TableSwitchCaseContext.class,i);
		}
		public TableSwitchArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableSwitchArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTableSwitchArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTableSwitchArg(this);
		}
	}

	public final TableSwitchArgContext tableSwitchArg() throws RecognitionException {
		TableSwitchArgContext _localctx = new TableSwitchArgContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_tableSwitchArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1587);
			match(LBRACE);
			setState(1588);
			((TableSwitchArgContext)_localctx).lookupSwitchCase = lookupSwitchCase();
			int value = ((TableSwitchArgContext)_localctx).lookupSwitchCase.value; ((TableSwitchArgContext)_localctx).min =  value;
			setState(1593);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 287)) & ~0x3f) == 0 && ((1L << (_la - 287)) & ((1L << (NegativeIntegerLiteral - 287)) | (1L << (IntegerLiteral - 287)) | (1L << (CharacterLiteral - 287)))) != 0)) {
				{
				{
				setState(1590);
				tableSwitchCase(++value);
				}
				}
				setState(1595);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			((TableSwitchArgContext)_localctx).max =  value;
			setState(1597);
			switchDefault();
			setState(1598);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableSwitchCaseContext extends ParserRuleContext {
		public int value;
		public String label;
		public int value2;
		public SignedIntegerLiteralContext signedIntegerLiteral;
		public CharacterLiteralContext characterLiteral;
		public LabelIdentifierContext labelIdentifier;
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public SignedIntegerLiteralContext signedIntegerLiteral() {
			return getRuleContext(SignedIntegerLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public TableSwitchCaseContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TableSwitchCaseContext(ParserRuleContext parent, int invokingState, int value) {
			super(parent, invokingState);
			this.value = value;
		}
		@Override public int getRuleIndex() { return RULE_tableSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTableSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTableSwitchCase(this);
		}
	}

	public final TableSwitchCaseContext tableSwitchCase(int value) throws RecognitionException {
		TableSwitchCaseContext _localctx = new TableSwitchCaseContext(_ctx, getState(), value);
		enterRule(_localctx, 96, RULE_tableSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1606);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NegativeIntegerLiteral:
			case IntegerLiteral:
				{
				setState(1600);
				((TableSwitchCaseContext)_localctx).signedIntegerLiteral = signedIntegerLiteral();
				((TableSwitchCaseContext)_localctx).value2 =  ((TableSwitchCaseContext)_localctx).signedIntegerLiteral.value;
				}
				break;
			case CharacterLiteral:
				{
				setState(1603);
				((TableSwitchCaseContext)_localctx).characterLiteral = characterLiteral();
				((TableSwitchCaseContext)_localctx).value2 =  ((TableSwitchCaseContext)_localctx).characterLiteral.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1608);
			if (!(_localctx.value2 == _localctx.value)) throw new FailedPredicateException(this, "$value2 == $value");
			setState(1609);
			match(COLON);
			setState(1610);
			((TableSwitchCaseContext)_localctx).labelIdentifier = labelIdentifier();
			((TableSwitchCaseContext)_localctx).label =  ((TableSwitchCaseContext)_localctx).labelIdentifier.str;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchDefaultContext extends ParserRuleContext {
		public String label;
		public LabelIdentifierContext labelIdentifier;
		public TerminalNode KW_DEFAULT() { return getToken(ASMParser.KW_DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(ASMParser.COLON, 0); }
		public LabelIdentifierContext labelIdentifier() {
			return getRuleContext(LabelIdentifierContext.class,0);
		}
		public SwitchDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSwitchDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSwitchDefault(this);
		}
	}

	public final SwitchDefaultContext switchDefault() throws RecognitionException {
		SwitchDefaultContext _localctx = new SwitchDefaultContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_switchDefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			match(KW_DEFAULT);
			setState(1614);
			match(COLON);
			setState(1615);
			((SwitchDefaultContext)_localctx).labelIdentifier = labelIdentifier();
			((SwitchDefaultContext)_localctx).label =  ((SwitchDefaultContext)_localctx).labelIdentifier.str;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_type);
		try {
			setState(1620);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1618);
				referenceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1619);
				primitiveType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeOrVoidContext extends ParserRuleContext {
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TypeOrVoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeOrVoid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeOrVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeOrVoid(this);
		}
	}

	public final TypeOrVoidContext typeOrVoid() throws RecognitionException {
		TypeOrVoidContext _localctx = new TypeOrVoidContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_typeOrVoid);
		try {
			setState(1625);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1622);
				voidType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1623);
				primitiveType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1624);
				referenceType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ASMParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ASMParser.RPAREN, 0); }
		public TypeOrVoidContext typeOrVoid() {
			return getRuleContext(TypeOrVoidContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitMethodType(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_methodType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1627);
			match(LPAREN);
			setState(1629);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(1628);
				typeList();
				}
				break;
			}
			setState(1631);
			match(RPAREN);
			setState(1632);
			typeOrVoid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidTypeContext extends ParserRuleContext {
		public TerminalNode KW_VOID() { return getToken(ASMParser.KW_VOID, 0); }
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitVoidType(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			match(KW_VOID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public char descriptor;
		public NumericTypeContext numericType;
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode KW_BOOLEAN() { return getToken(ASMParser.KW_BOOLEAN, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_primitiveType);
		try {
			setState(1641);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BYTE:
			case KW_CHAR:
			case KW_DOUBLE:
			case KW_FLOAT:
			case KW_INT:
			case KW_LONG:
			case KW_SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1636);
				((PrimitiveTypeContext)_localctx).numericType = numericType();
				((PrimitiveTypeContext)_localctx).descriptor =  ((PrimitiveTypeContext)_localctx).numericType.descriptor;
				}
				break;
			case KW_BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1639);
				match(KW_BOOLEAN);
				((PrimitiveTypeContext)_localctx).descriptor =  'Z';
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypeContext extends ParserRuleContext {
		public char descriptor;
		public IntegralTypeContext integralType;
		public FloatingPointTypeContext floatingPointType;
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterNumericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitNumericType(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_numericType);
		try {
			setState(1649);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BYTE:
			case KW_CHAR:
			case KW_INT:
			case KW_LONG:
			case KW_SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1643);
				((NumericTypeContext)_localctx).integralType = integralType();
				((NumericTypeContext)_localctx).descriptor =  ((NumericTypeContext)_localctx).integralType.descriptor;
				}
				break;
			case KW_DOUBLE:
			case KW_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1646);
				((NumericTypeContext)_localctx).floatingPointType = floatingPointType();
				((NumericTypeContext)_localctx).descriptor =  ((NumericTypeContext)_localctx).floatingPointType.descriptor;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegralTypeContext extends ParserRuleContext {
		public char descriptor;
		public TerminalNode KW_BYTE() { return getToken(ASMParser.KW_BYTE, 0); }
		public TerminalNode KW_SHORT() { return getToken(ASMParser.KW_SHORT, 0); }
		public TerminalNode KW_INT() { return getToken(ASMParser.KW_INT, 0); }
		public TerminalNode KW_LONG() { return getToken(ASMParser.KW_LONG, 0); }
		public TerminalNode KW_CHAR() { return getToken(ASMParser.KW_CHAR, 0); }
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterIntegralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitIntegralType(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_integralType);
		try {
			setState(1661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BYTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1651);
				match(KW_BYTE);
				((IntegralTypeContext)_localctx).descriptor =  'B';
				}
				break;
			case KW_SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1653);
				match(KW_SHORT);
				((IntegralTypeContext)_localctx).descriptor =  'S';
				}
				break;
			case KW_INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1655);
				match(KW_INT);
				((IntegralTypeContext)_localctx).descriptor =  'I';
				}
				break;
			case KW_LONG:
				enterOuterAlt(_localctx, 4);
				{
				setState(1657);
				match(KW_LONG);
				((IntegralTypeContext)_localctx).descriptor =  'J';
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(1659);
				match(KW_CHAR);
				((IntegralTypeContext)_localctx).descriptor =  'C';
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatingPointTypeContext extends ParserRuleContext {
		public char descriptor;
		public TerminalNode KW_FLOAT() { return getToken(ASMParser.KW_FLOAT, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(ASMParser.KW_DOUBLE, 0); }
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFloatingPointType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFloatingPointType(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_floatingPointType);
		try {
			setState(1667);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1663);
				match(KW_FLOAT);
				((FloatingPointTypeContext)_localctx).descriptor =  'F';
				}
				break;
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1665);
				match(KW_DOUBLE);
				((FloatingPointTypeContext)_localctx).descriptor =  'D';
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitReferenceType(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_referenceType);
		try {
			setState(1671);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1669);
				classOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1670);
				arrayType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public QualifiedTypeIdentifierContext qualifiedTypeIdentifier() {
			return getRuleContext(QualifiedTypeIdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitClassOrInterfaceType(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1673);
			qualifiedTypeIdentifier();
			setState(1675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(1674);
				typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeVariable(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_typeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1677);
			typeIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitArrayType(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_arrayType);
		try {
			setState(1685);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1679);
				primitiveType();
				setState(1680);
				dims();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1682);
				classOrInterfaceType();
				setState(1683);
				dims();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimsContext extends ParserRuleContext {
		public List<DimContext> dim() {
			return getRuleContexts(DimContext.class);
		}
		public DimContext dim(int i) {
			return getRuleContext(DimContext.class,i);
		}
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitDims(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_dims);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1688); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1687);
					dim();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1690); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ASMParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ASMParser.RBRACK, 0); }
		public DimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterDim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitDim(this);
		}
	}

	public final DimContext dim() throws RecognitionException {
		DimContext _localctx = new DimContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_dim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1692);
			match(LBRACK);
			setState(1693);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext {
		public TerminalNode KW_EXTENDS() { return getToken(ASMParser.KW_EXTENDS, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public TerminalNode KW_NULL() { return getToken(ASMParser.KW_NULL, 0); }
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeBound(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_typeBound);
		int _la;
		try {
			setState(1710);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1695);
				match(KW_EXTENDS);
				setState(1696);
				classOrInterfaceType();
				setState(1700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AMP) {
					{
					{
					setState(1697);
					additionalBound();
					}
					}
					setState(1702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1703);
				match(KW_EXTENDS);
				setState(1704);
				match(KW_NULL);
				setState(1706); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1705);
					additionalBound();
					}
					}
					setState(1708); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AMP );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditionalBoundContext extends ParserRuleContext {
		public TerminalNode AMP() { return getToken(ASMParser.AMP, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public AdditionalBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterAdditionalBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitAdditionalBound(this);
		}
	}

	public final AdditionalBoundContext additionalBound() throws RecognitionException {
		AdditionalBoundContext _localctx = new AdditionalBoundContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_additionalBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1712);
			match(AMP);
			setState(1713);
			classOrInterfaceType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(ASMParser.LT, 0); }
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TerminalNode GT() { return getToken(ASMParser.GT, 0); }
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_typeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1715);
			match(LT);
			setState(1716);
			typeArgumentList();
			setState(1717);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ASMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ASMParser.COMMA, i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeArgumentList(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1719);
			typeArgument();
			setState(1724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1720);
				match(COMMA);
				setState(1721);
				typeArgument();
				}
				}
				setState(1726);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeArgument(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_typeArgument);
		try {
			setState(1729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1727);
				referenceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1728);
				wildcard();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardContext extends ParserRuleContext {
		public TerminalNode QUES() { return getToken(ASMParser.QUES, 0); }
		public WildcardBoundsContext wildcardBounds() {
			return getRuleContext(WildcardBoundsContext.class,0);
		}
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitWildcard(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_wildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1731);
			match(QUES);
			setState(1733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_EXTENDS || _la==KW_SUPER) {
				{
				setState(1732);
				wildcardBounds();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WildcardBoundsContext extends ParserRuleContext {
		public TerminalNode KW_EXTENDS() { return getToken(ASMParser.KW_EXTENDS, 0); }
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode KW_SUPER() { return getToken(ASMParser.KW_SUPER, 0); }
		public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardBounds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterWildcardBounds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitWildcardBounds(this);
		}
	}

	public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
		WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_wildcardBounds);
		try {
			setState(1739);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1735);
				match(KW_EXTENDS);
				setState(1736);
				referenceType();
				}
				break;
			case KW_SUPER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1737);
				match(KW_SUPER);
				setState(1738);
				referenceType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdentifierContext extends ParserRuleContext {
		public String str;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitTypeIdentifier(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_typeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1741);
			if (!(!_input.LT(1).getText().equals("var"))) throw new FailedPredicateException(this, "!_input.LT(1).getText().equals(\"var\")");
			setState(1742);
			((TypeIdentifierContext)_localctx).identifier = identifier();
			((TypeIdentifierContext)_localctx).str =  ((TypeIdentifierContext)_localctx).identifier.str;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedTypeIdentifierContext extends ParserRuleContext {
		public String str;
		public IdentifierContext identifier;
		public TypeIdentifierContext typeIdentifier;
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ASMParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ASMParser.DOT, i);
		}
		public QualifiedTypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedTypeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterQualifiedTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitQualifiedTypeIdentifier(this);
		}
	}

	public final QualifiedTypeIdentifierContext qualifiedTypeIdentifier() throws RecognitionException {
		QualifiedTypeIdentifierContext _localctx = new QualifiedTypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_qualifiedTypeIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			var sb = new StringBuilder();
			setState(1752);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1746);
					((QualifiedTypeIdentifierContext)_localctx).identifier = identifier();
					setState(1747);
					match(DOT);
					sb.append(((QualifiedTypeIdentifierContext)_localctx).identifier.str).append('.');
					}
					} 
				}
				setState(1754);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			}
			setState(1755);
			((QualifiedTypeIdentifierContext)_localctx).typeIdentifier = typeIdentifier();
			sb.append(((QualifiedTypeIdentifierContext)_localctx).typeIdentifier.str);
			((QualifiedTypeIdentifierContext)_localctx).str =  sb.toString();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedIdentifierContext extends ParserRuleContext {
		public String str;
		public IdentifierContext identifier;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ASMParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ASMParser.DOT, i);
		}
		public QualifiedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterQualifiedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitQualifiedIdentifier(this);
		}
	}

	public final QualifiedIdentifierContext qualifiedIdentifier() throws RecognitionException {
		QualifiedIdentifierContext _localctx = new QualifiedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_qualifiedIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			var sb = new StringBuilder();
			setState(1766);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1760);
					((QualifiedIdentifierContext)_localctx).identifier = identifier();
					setState(1761);
					match(DOT);
					sb.append(((QualifiedIdentifierContext)_localctx).identifier.str).append('.');
					}
					} 
				}
				setState(1768);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			}
			setState(1769);
			((QualifiedIdentifierContext)_localctx).identifier = identifier();
			sb.append(((QualifiedIdentifierContext)_localctx).identifier.str);
			((QualifiedIdentifierContext)_localctx).str =  sb.toString();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelIdentifierContext extends ParserRuleContext {
		public String str;
		public TerminalNode Identifier() { return getToken(ASMParser.Identifier, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public TerminalNode KW_BRIDGE() { return getToken(ASMParser.KW_BRIDGE, 0); }
		public TerminalNode KW_MANDATED() { return getToken(ASMParser.KW_MANDATED, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public LabelIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLabelIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLabelIdentifier(this);
		}
	}

	public final LabelIdentifierContext labelIdentifier() throws RecognitionException {
		LabelIdentifierContext _localctx = new LabelIdentifierContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_labelIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1773);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_SYNTHETIC) | (1L << KW_MANDATED) | (1L << KW_BRIDGE) | (1L << KW_DEPRECATED))) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			_ctx.stop = _input.LT(-1);
			((LabelIdentifierContext)_localctx).str =  _input.getText(_localctx.start, _input.LT(-1));
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public String str;
		public TerminalNode Identifier() { return getToken(ASMParser.Identifier, 0); }
		public TerminalNode KW_CODE() { return getToken(ASMParser.KW_CODE, 0); }
		public TerminalNode KW_DEPRECATED() { return getToken(ASMParser.KW_DEPRECATED, 0); }
		public TerminalNode KW_BRIDGE() { return getToken(ASMParser.KW_BRIDGE, 0); }
		public TerminalNode KW_MANDATED() { return getToken(ASMParser.KW_MANDATED, 0); }
		public TerminalNode KW_SYNTHETIC() { return getToken(ASMParser.KW_SYNTHETIC, 0); }
		public TerminalNode KW_AASTORE() { return getToken(ASMParser.KW_AASTORE, 0); }
		public TerminalNode KW_ACONST_NULL() { return getToken(ASMParser.KW_ACONST_NULL, 0); }
		public TerminalNode KW_ALOAD() { return getToken(ASMParser.KW_ALOAD, 0); }
		public TerminalNode KW_ALOAD_0() { return getToken(ASMParser.KW_ALOAD_0, 0); }
		public TerminalNode KW_ALOAD_1() { return getToken(ASMParser.KW_ALOAD_1, 0); }
		public TerminalNode KW_ALOAD_2() { return getToken(ASMParser.KW_ALOAD_2, 0); }
		public TerminalNode KW_ALOAD_3() { return getToken(ASMParser.KW_ALOAD_3, 0); }
		public TerminalNode KW_ANEWARRAY() { return getToken(ASMParser.KW_ANEWARRAY, 0); }
		public TerminalNode KW_ARETURN() { return getToken(ASMParser.KW_ARETURN, 0); }
		public TerminalNode KW_ARRAYLENGTH() { return getToken(ASMParser.KW_ARRAYLENGTH, 0); }
		public TerminalNode KW_ASTORE() { return getToken(ASMParser.KW_ASTORE, 0); }
		public TerminalNode KW_ASTORE_0() { return getToken(ASMParser.KW_ASTORE_0, 0); }
		public TerminalNode KW_ASTORE_1() { return getToken(ASMParser.KW_ASTORE_1, 0); }
		public TerminalNode KW_ASTORE_2() { return getToken(ASMParser.KW_ASTORE_2, 0); }
		public TerminalNode KW_ASTORE_3() { return getToken(ASMParser.KW_ASTORE_3, 0); }
		public TerminalNode KW_ATHROW() { return getToken(ASMParser.KW_ATHROW, 0); }
		public TerminalNode KW_BALOAD() { return getToken(ASMParser.KW_BALOAD, 0); }
		public TerminalNode KW_BASTORE() { return getToken(ASMParser.KW_BASTORE, 0); }
		public TerminalNode KW_BIPUSH() { return getToken(ASMParser.KW_BIPUSH, 0); }
		public TerminalNode KW_CALOAD() { return getToken(ASMParser.KW_CALOAD, 0); }
		public TerminalNode KW_CASTORE() { return getToken(ASMParser.KW_CASTORE, 0); }
		public TerminalNode KW_CHECKCAST() { return getToken(ASMParser.KW_CHECKCAST, 0); }
		public TerminalNode KW_D2F() { return getToken(ASMParser.KW_D2F, 0); }
		public TerminalNode KW_D2I() { return getToken(ASMParser.KW_D2I, 0); }
		public TerminalNode KW_D2L() { return getToken(ASMParser.KW_D2L, 0); }
		public TerminalNode KW_DADD() { return getToken(ASMParser.KW_DADD, 0); }
		public TerminalNode KW_DALOAD() { return getToken(ASMParser.KW_DALOAD, 0); }
		public TerminalNode KW_DASTORE() { return getToken(ASMParser.KW_DASTORE, 0); }
		public TerminalNode KW_DCMPG() { return getToken(ASMParser.KW_DCMPG, 0); }
		public TerminalNode KW_DCMPL() { return getToken(ASMParser.KW_DCMPL, 0); }
		public TerminalNode KW_DCONST_0() { return getToken(ASMParser.KW_DCONST_0, 0); }
		public TerminalNode KW_DCONST_1() { return getToken(ASMParser.KW_DCONST_1, 0); }
		public TerminalNode KW_DDIV() { return getToken(ASMParser.KW_DDIV, 0); }
		public TerminalNode KW_DLOAD() { return getToken(ASMParser.KW_DLOAD, 0); }
		public TerminalNode KW_DLOAD_0() { return getToken(ASMParser.KW_DLOAD_0, 0); }
		public TerminalNode KW_DLOAD_1() { return getToken(ASMParser.KW_DLOAD_1, 0); }
		public TerminalNode KW_DLOAD_2() { return getToken(ASMParser.KW_DLOAD_2, 0); }
		public TerminalNode KW_DLOAD_3() { return getToken(ASMParser.KW_DLOAD_3, 0); }
		public TerminalNode KW_DMUL() { return getToken(ASMParser.KW_DMUL, 0); }
		public TerminalNode KW_DNEG() { return getToken(ASMParser.KW_DNEG, 0); }
		public TerminalNode KW_DREM() { return getToken(ASMParser.KW_DREM, 0); }
		public TerminalNode KW_DRETURN() { return getToken(ASMParser.KW_DRETURN, 0); }
		public TerminalNode KW_DSTORE() { return getToken(ASMParser.KW_DSTORE, 0); }
		public TerminalNode KW_DSTORE_0() { return getToken(ASMParser.KW_DSTORE_0, 0); }
		public TerminalNode KW_DSTORE_1() { return getToken(ASMParser.KW_DSTORE_1, 0); }
		public TerminalNode KW_DSTORE_2() { return getToken(ASMParser.KW_DSTORE_2, 0); }
		public TerminalNode KW_DSTORE_3() { return getToken(ASMParser.KW_DSTORE_3, 0); }
		public TerminalNode KW_DSUB() { return getToken(ASMParser.KW_DSUB, 0); }
		public TerminalNode KW_DUP() { return getToken(ASMParser.KW_DUP, 0); }
		public TerminalNode KW_DUP_X1() { return getToken(ASMParser.KW_DUP_X1, 0); }
		public TerminalNode KW_DUP_X2() { return getToken(ASMParser.KW_DUP_X2, 0); }
		public TerminalNode KW_DUP2() { return getToken(ASMParser.KW_DUP2, 0); }
		public TerminalNode KW_DUP2_X1() { return getToken(ASMParser.KW_DUP2_X1, 0); }
		public TerminalNode KW_DUP2_X2() { return getToken(ASMParser.KW_DUP2_X2, 0); }
		public TerminalNode KW_F2D() { return getToken(ASMParser.KW_F2D, 0); }
		public TerminalNode KW_F2I() { return getToken(ASMParser.KW_F2I, 0); }
		public TerminalNode KW_F2L() { return getToken(ASMParser.KW_F2L, 0); }
		public TerminalNode KW_FADD() { return getToken(ASMParser.KW_FADD, 0); }
		public TerminalNode KW_FALOAD() { return getToken(ASMParser.KW_FALOAD, 0); }
		public TerminalNode KW_FASTORE() { return getToken(ASMParser.KW_FASTORE, 0); }
		public TerminalNode KW_FCMPG() { return getToken(ASMParser.KW_FCMPG, 0); }
		public TerminalNode KW_FCMPL() { return getToken(ASMParser.KW_FCMPL, 0); }
		public TerminalNode KW_FCONST_0() { return getToken(ASMParser.KW_FCONST_0, 0); }
		public TerminalNode KW_FCONST_1() { return getToken(ASMParser.KW_FCONST_1, 0); }
		public TerminalNode KW_FCONST_2() { return getToken(ASMParser.KW_FCONST_2, 0); }
		public TerminalNode KW_FDIV() { return getToken(ASMParser.KW_FDIV, 0); }
		public TerminalNode KW_FLOAD() { return getToken(ASMParser.KW_FLOAD, 0); }
		public TerminalNode KW_FLOAD_0() { return getToken(ASMParser.KW_FLOAD_0, 0); }
		public TerminalNode KW_FLOAD_1() { return getToken(ASMParser.KW_FLOAD_1, 0); }
		public TerminalNode KW_FLOAD_2() { return getToken(ASMParser.KW_FLOAD_2, 0); }
		public TerminalNode KW_FLOAD_3() { return getToken(ASMParser.KW_FLOAD_3, 0); }
		public TerminalNode KW_FMUL() { return getToken(ASMParser.KW_FMUL, 0); }
		public TerminalNode KW_FNEG() { return getToken(ASMParser.KW_FNEG, 0); }
		public TerminalNode KW_FREM() { return getToken(ASMParser.KW_FREM, 0); }
		public TerminalNode KW_FRETURN() { return getToken(ASMParser.KW_FRETURN, 0); }
		public TerminalNode KW_FSTORE() { return getToken(ASMParser.KW_FSTORE, 0); }
		public TerminalNode KW_FSTORE_0() { return getToken(ASMParser.KW_FSTORE_0, 0); }
		public TerminalNode KW_FSTORE_1() { return getToken(ASMParser.KW_FSTORE_1, 0); }
		public TerminalNode KW_FSTORE_2() { return getToken(ASMParser.KW_FSTORE_2, 0); }
		public TerminalNode KW_FSTORE_3() { return getToken(ASMParser.KW_FSTORE_3, 0); }
		public TerminalNode KW_FSUB() { return getToken(ASMParser.KW_FSUB, 0); }
		public TerminalNode KW_GETFIELD() { return getToken(ASMParser.KW_GETFIELD, 0); }
		public TerminalNode KW_GETSTATIC() { return getToken(ASMParser.KW_GETSTATIC, 0); }
		public TerminalNode KW_GOTO_W() { return getToken(ASMParser.KW_GOTO_W, 0); }
		public TerminalNode KW_I2B() { return getToken(ASMParser.KW_I2B, 0); }
		public TerminalNode KW_I2C() { return getToken(ASMParser.KW_I2C, 0); }
		public TerminalNode KW_I2D() { return getToken(ASMParser.KW_I2D, 0); }
		public TerminalNode KW_I2F() { return getToken(ASMParser.KW_I2F, 0); }
		public TerminalNode KW_I2L() { return getToken(ASMParser.KW_I2L, 0); }
		public TerminalNode KW_I2S() { return getToken(ASMParser.KW_I2S, 0); }
		public TerminalNode KW_IADD() { return getToken(ASMParser.KW_IADD, 0); }
		public TerminalNode KW_IALOAD() { return getToken(ASMParser.KW_IALOAD, 0); }
		public TerminalNode KW_IAND() { return getToken(ASMParser.KW_IAND, 0); }
		public TerminalNode KW_IASTORE() { return getToken(ASMParser.KW_IASTORE, 0); }
		public TerminalNode KW_ICONST_M1() { return getToken(ASMParser.KW_ICONST_M1, 0); }
		public TerminalNode KW_ICONST_0() { return getToken(ASMParser.KW_ICONST_0, 0); }
		public TerminalNode KW_ICONST_1() { return getToken(ASMParser.KW_ICONST_1, 0); }
		public TerminalNode KW_ICONST_2() { return getToken(ASMParser.KW_ICONST_2, 0); }
		public TerminalNode KW_ICONST_3() { return getToken(ASMParser.KW_ICONST_3, 0); }
		public TerminalNode KW_ICONST_4() { return getToken(ASMParser.KW_ICONST_4, 0); }
		public TerminalNode KW_ICONST_5() { return getToken(ASMParser.KW_ICONST_5, 0); }
		public TerminalNode KW_IDIV() { return getToken(ASMParser.KW_IDIV, 0); }
		public TerminalNode KW_IF_ACMPEQ() { return getToken(ASMParser.KW_IF_ACMPEQ, 0); }
		public TerminalNode KW_IF_ACMPNE() { return getToken(ASMParser.KW_IF_ACMPNE, 0); }
		public TerminalNode KW_IF_ICMPEQ() { return getToken(ASMParser.KW_IF_ICMPEQ, 0); }
		public TerminalNode KW_IF_ICMPNE() { return getToken(ASMParser.KW_IF_ICMPNE, 0); }
		public TerminalNode KW_IF_ICMPLT() { return getToken(ASMParser.KW_IF_ICMPLT, 0); }
		public TerminalNode KW_IF_ICMPGE() { return getToken(ASMParser.KW_IF_ICMPGE, 0); }
		public TerminalNode KW_IF_ICMPGT() { return getToken(ASMParser.KW_IF_ICMPGT, 0); }
		public TerminalNode KW_IF_ICMPLE() { return getToken(ASMParser.KW_IF_ICMPLE, 0); }
		public TerminalNode KW_IFEQ() { return getToken(ASMParser.KW_IFEQ, 0); }
		public TerminalNode KW_IFNE() { return getToken(ASMParser.KW_IFNE, 0); }
		public TerminalNode KW_IFLT() { return getToken(ASMParser.KW_IFLT, 0); }
		public TerminalNode KW_IFGE() { return getToken(ASMParser.KW_IFGE, 0); }
		public TerminalNode KW_IFGT() { return getToken(ASMParser.KW_IFGT, 0); }
		public TerminalNode KW_IFLE() { return getToken(ASMParser.KW_IFLE, 0); }
		public TerminalNode KW_IFNONNULL() { return getToken(ASMParser.KW_IFNONNULL, 0); }
		public TerminalNode KW_IFNULL() { return getToken(ASMParser.KW_IFNULL, 0); }
		public TerminalNode KW_IINC() { return getToken(ASMParser.KW_IINC, 0); }
		public TerminalNode KW_ILOAD() { return getToken(ASMParser.KW_ILOAD, 0); }
		public TerminalNode KW_ILOAD_0() { return getToken(ASMParser.KW_ILOAD_0, 0); }
		public TerminalNode KW_ILOAD_1() { return getToken(ASMParser.KW_ILOAD_1, 0); }
		public TerminalNode KW_ILOAD_2() { return getToken(ASMParser.KW_ILOAD_2, 0); }
		public TerminalNode KW_ILOAD_3() { return getToken(ASMParser.KW_ILOAD_3, 0); }
		public TerminalNode KW_IMUL() { return getToken(ASMParser.KW_IMUL, 0); }
		public TerminalNode KW_INEG() { return getToken(ASMParser.KW_INEG, 0); }
		public TerminalNode KW_INVOKEDYNAMIC() { return getToken(ASMParser.KW_INVOKEDYNAMIC, 0); }
		public TerminalNode KW_INVOKEINTERFACE() { return getToken(ASMParser.KW_INVOKEINTERFACE, 0); }
		public TerminalNode KW_INVOKESPECIAL() { return getToken(ASMParser.KW_INVOKESPECIAL, 0); }
		public TerminalNode KW_INVOKESTATIC() { return getToken(ASMParser.KW_INVOKESTATIC, 0); }
		public TerminalNode KW_INVOKEVIRTUAL() { return getToken(ASMParser.KW_INVOKEVIRTUAL, 0); }
		public TerminalNode KW_IOR() { return getToken(ASMParser.KW_IOR, 0); }
		public TerminalNode KW_IREM() { return getToken(ASMParser.KW_IREM, 0); }
		public TerminalNode KW_IRETURN() { return getToken(ASMParser.KW_IRETURN, 0); }
		public TerminalNode KW_ISHL() { return getToken(ASMParser.KW_ISHL, 0); }
		public TerminalNode KW_ISHR() { return getToken(ASMParser.KW_ISHR, 0); }
		public TerminalNode KW_ISTORE() { return getToken(ASMParser.KW_ISTORE, 0); }
		public TerminalNode KW_ISTORE_0() { return getToken(ASMParser.KW_ISTORE_0, 0); }
		public TerminalNode KW_ISTORE_1() { return getToken(ASMParser.KW_ISTORE_1, 0); }
		public TerminalNode KW_ISTORE_2() { return getToken(ASMParser.KW_ISTORE_2, 0); }
		public TerminalNode KW_ISTORE_3() { return getToken(ASMParser.KW_ISTORE_3, 0); }
		public TerminalNode KW_ISUB() { return getToken(ASMParser.KW_ISUB, 0); }
		public TerminalNode KW_IUSHR() { return getToken(ASMParser.KW_IUSHR, 0); }
		public TerminalNode KW_IXOR() { return getToken(ASMParser.KW_IXOR, 0); }
		public TerminalNode KW_JSR() { return getToken(ASMParser.KW_JSR, 0); }
		public TerminalNode KW_JSR_W() { return getToken(ASMParser.KW_JSR_W, 0); }
		public TerminalNode KW_L2D() { return getToken(ASMParser.KW_L2D, 0); }
		public TerminalNode KW_L2F() { return getToken(ASMParser.KW_L2F, 0); }
		public TerminalNode KW_L2I() { return getToken(ASMParser.KW_L2I, 0); }
		public TerminalNode KW_LADD() { return getToken(ASMParser.KW_LADD, 0); }
		public TerminalNode KW_LALOAD() { return getToken(ASMParser.KW_LALOAD, 0); }
		public TerminalNode KW_LAND() { return getToken(ASMParser.KW_LAND, 0); }
		public TerminalNode KW_LASTORE() { return getToken(ASMParser.KW_LASTORE, 0); }
		public TerminalNode KW_LCMP() { return getToken(ASMParser.KW_LCMP, 0); }
		public TerminalNode KW_LCONST_0() { return getToken(ASMParser.KW_LCONST_0, 0); }
		public TerminalNode KW_LCONST_1() { return getToken(ASMParser.KW_LCONST_1, 0); }
		public TerminalNode KW_LDC() { return getToken(ASMParser.KW_LDC, 0); }
		public TerminalNode KW_LDC_W() { return getToken(ASMParser.KW_LDC_W, 0); }
		public TerminalNode KW_LDC2_W() { return getToken(ASMParser.KW_LDC2_W, 0); }
		public TerminalNode KW_LDIV() { return getToken(ASMParser.KW_LDIV, 0); }
		public TerminalNode KW_LLOAD() { return getToken(ASMParser.KW_LLOAD, 0); }
		public TerminalNode KW_LLOAD_0() { return getToken(ASMParser.KW_LLOAD_0, 0); }
		public TerminalNode KW_LLOAD_1() { return getToken(ASMParser.KW_LLOAD_1, 0); }
		public TerminalNode KW_LLOAD_2() { return getToken(ASMParser.KW_LLOAD_2, 0); }
		public TerminalNode KW_LLOAD_3() { return getToken(ASMParser.KW_LLOAD_3, 0); }
		public TerminalNode KW_LMUL() { return getToken(ASMParser.KW_LMUL, 0); }
		public TerminalNode KW_LNEG() { return getToken(ASMParser.KW_LNEG, 0); }
		public TerminalNode KW_LOOKUPSWITCH() { return getToken(ASMParser.KW_LOOKUPSWITCH, 0); }
		public TerminalNode KW_LOR() { return getToken(ASMParser.KW_LOR, 0); }
		public TerminalNode KW_LREM() { return getToken(ASMParser.KW_LREM, 0); }
		public TerminalNode KW_LRETURN() { return getToken(ASMParser.KW_LRETURN, 0); }
		public TerminalNode KW_LSHL() { return getToken(ASMParser.KW_LSHL, 0); }
		public TerminalNode KW_LSHR() { return getToken(ASMParser.KW_LSHR, 0); }
		public TerminalNode KW_LSTORE() { return getToken(ASMParser.KW_LSTORE, 0); }
		public TerminalNode KW_LSTORE_0() { return getToken(ASMParser.KW_LSTORE_0, 0); }
		public TerminalNode KW_LSTORE_1() { return getToken(ASMParser.KW_LSTORE_1, 0); }
		public TerminalNode KW_LSTORE_2() { return getToken(ASMParser.KW_LSTORE_2, 0); }
		public TerminalNode KW_LSTORE_3() { return getToken(ASMParser.KW_LSTORE_3, 0); }
		public TerminalNode KW_LSUB() { return getToken(ASMParser.KW_LSUB, 0); }
		public TerminalNode KW_LUSHR() { return getToken(ASMParser.KW_LUSHR, 0); }
		public TerminalNode KW_LXOR() { return getToken(ASMParser.KW_LXOR, 0); }
		public TerminalNode KW_MONITORENTER() { return getToken(ASMParser.KW_MONITORENTER, 0); }
		public TerminalNode KW_MONITOREXIT() { return getToken(ASMParser.KW_MONITOREXIT, 0); }
		public TerminalNode KW_MULTIANEWARRAY() { return getToken(ASMParser.KW_MULTIANEWARRAY, 0); }
		public TerminalNode KW_NEWARRAY() { return getToken(ASMParser.KW_NEWARRAY, 0); }
		public TerminalNode KW_NOP() { return getToken(ASMParser.KW_NOP, 0); }
		public TerminalNode KW_POP() { return getToken(ASMParser.KW_POP, 0); }
		public TerminalNode KW_POP2() { return getToken(ASMParser.KW_POP2, 0); }
		public TerminalNode KW_PUTFIELD() { return getToken(ASMParser.KW_PUTFIELD, 0); }
		public TerminalNode KW_PUTSTATIC() { return getToken(ASMParser.KW_PUTSTATIC, 0); }
		public TerminalNode KW_RET() { return getToken(ASMParser.KW_RET, 0); }
		public TerminalNode KW_SALOAD() { return getToken(ASMParser.KW_SALOAD, 0); }
		public TerminalNode KW_SASTORE() { return getToken(ASMParser.KW_SASTORE, 0); }
		public TerminalNode KW_SIPUSH() { return getToken(ASMParser.KW_SIPUSH, 0); }
		public TerminalNode KW_SWAP() { return getToken(ASMParser.KW_SWAP, 0); }
		public TerminalNode KW_TABLESWITCH() { return getToken(ASMParser.KW_TABLESWITCH, 0); }
		public TerminalNode KW_WIDE() { return getToken(ASMParser.KW_WIDE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			_la = _input.LA(1);
			if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (KW_SYNTHETIC - 60)) | (1L << (KW_MANDATED - 60)) | (1L << (KW_BRIDGE - 60)) | (1L << (KW_DEPRECATED - 60)) | (1L << (KW_CODE - 60)) | (1L << (KW_AASTORE - 60)) | (1L << (KW_ACONST_NULL - 60)) | (1L << (KW_ALOAD - 60)) | (1L << (KW_ALOAD_0 - 60)) | (1L << (KW_ALOAD_1 - 60)) | (1L << (KW_ALOAD_2 - 60)) | (1L << (KW_ALOAD_3 - 60)) | (1L << (KW_ANEWARRAY - 60)) | (1L << (KW_ARETURN - 60)) | (1L << (KW_ARRAYLENGTH - 60)) | (1L << (KW_ASTORE - 60)) | (1L << (KW_ASTORE_0 - 60)) | (1L << (KW_ASTORE_1 - 60)) | (1L << (KW_ASTORE_2 - 60)) | (1L << (KW_ASTORE_3 - 60)) | (1L << (KW_ATHROW - 60)) | (1L << (KW_BALOAD - 60)) | (1L << (KW_BASTORE - 60)) | (1L << (KW_BIPUSH - 60)) | (1L << (KW_CALOAD - 60)) | (1L << (KW_CASTORE - 60)) | (1L << (KW_CHECKCAST - 60)) | (1L << (KW_D2F - 60)) | (1L << (KW_D2I - 60)) | (1L << (KW_D2L - 60)) | (1L << (KW_DADD - 60)) | (1L << (KW_DALOAD - 60)) | (1L << (KW_DASTORE - 60)) | (1L << (KW_DCMPG - 60)) | (1L << (KW_DCMPL - 60)) | (1L << (KW_DCONST_0 - 60)) | (1L << (KW_DCONST_1 - 60)) | (1L << (KW_DDIV - 60)) | (1L << (KW_DLOAD - 60)) | (1L << (KW_DLOAD_0 - 60)) | (1L << (KW_DLOAD_1 - 60)) | (1L << (KW_DLOAD_2 - 60)) | (1L << (KW_DLOAD_3 - 60)) | (1L << (KW_DMUL - 60)) | (1L << (KW_DNEG - 60)) | (1L << (KW_DREM - 60)) | (1L << (KW_DRETURN - 60)) | (1L << (KW_DSTORE - 60)) | (1L << (KW_DSTORE_0 - 60)) | (1L << (KW_DSTORE_1 - 60)) | (1L << (KW_DSTORE_2 - 60)) | (1L << (KW_DSTORE_3 - 60)) | (1L << (KW_DSUB - 60)) | (1L << (KW_DUP - 60)) | (1L << (KW_DUP_X1 - 60)) | (1L << (KW_DUP_X2 - 60)) | (1L << (KW_DUP2 - 60)) | (1L << (KW_DUP2_X1 - 60)) | (1L << (KW_DUP2_X2 - 60)) | (1L << (KW_F2D - 60)) | (1L << (KW_F2I - 60)) | (1L << (KW_F2L - 60)) | (1L << (KW_FADD - 60)))) != 0) || ((((_la - 124)) & ~0x3f) == 0 && ((1L << (_la - 124)) & ((1L << (KW_FALOAD - 124)) | (1L << (KW_FASTORE - 124)) | (1L << (KW_FCMPG - 124)) | (1L << (KW_FCMPL - 124)) | (1L << (KW_FCONST_0 - 124)) | (1L << (KW_FCONST_1 - 124)) | (1L << (KW_FCONST_2 - 124)) | (1L << (KW_FDIV - 124)) | (1L << (KW_FLOAD - 124)) | (1L << (KW_FLOAD_0 - 124)) | (1L << (KW_FLOAD_1 - 124)) | (1L << (KW_FLOAD_2 - 124)) | (1L << (KW_FLOAD_3 - 124)) | (1L << (KW_FMUL - 124)) | (1L << (KW_FNEG - 124)) | (1L << (KW_FREM - 124)) | (1L << (KW_FRETURN - 124)) | (1L << (KW_FSTORE - 124)) | (1L << (KW_FSTORE_0 - 124)) | (1L << (KW_FSTORE_1 - 124)) | (1L << (KW_FSTORE_2 - 124)) | (1L << (KW_FSTORE_3 - 124)) | (1L << (KW_FSUB - 124)) | (1L << (KW_GETFIELD - 124)) | (1L << (KW_GETSTATIC - 124)) | (1L << (KW_GOTO_W - 124)) | (1L << (KW_I2B - 124)) | (1L << (KW_I2C - 124)) | (1L << (KW_I2D - 124)) | (1L << (KW_I2F - 124)) | (1L << (KW_I2L - 124)) | (1L << (KW_I2S - 124)) | (1L << (KW_IADD - 124)) | (1L << (KW_IALOAD - 124)) | (1L << (KW_IAND - 124)) | (1L << (KW_IASTORE - 124)) | (1L << (KW_ICONST_M1 - 124)) | (1L << (KW_ICONST_0 - 124)) | (1L << (KW_ICONST_1 - 124)) | (1L << (KW_ICONST_2 - 124)) | (1L << (KW_ICONST_3 - 124)) | (1L << (KW_ICONST_4 - 124)) | (1L << (KW_ICONST_5 - 124)) | (1L << (KW_IDIV - 124)) | (1L << (KW_IF_ACMPEQ - 124)) | (1L << (KW_IF_ACMPNE - 124)) | (1L << (KW_IF_ICMPEQ - 124)) | (1L << (KW_IF_ICMPNE - 124)) | (1L << (KW_IF_ICMPLT - 124)) | (1L << (KW_IF_ICMPGE - 124)) | (1L << (KW_IF_ICMPGT - 124)) | (1L << (KW_IF_ICMPLE - 124)) | (1L << (KW_IFEQ - 124)) | (1L << (KW_IFNE - 124)) | (1L << (KW_IFLT - 124)) | (1L << (KW_IFGE - 124)) | (1L << (KW_IFGT - 124)) | (1L << (KW_IFLE - 124)) | (1L << (KW_IFNONNULL - 124)) | (1L << (KW_IFNULL - 124)) | (1L << (KW_IINC - 124)) | (1L << (KW_ILOAD - 124)) | (1L << (KW_ILOAD_0 - 124)) | (1L << (KW_ILOAD_1 - 124)))) != 0) || ((((_la - 188)) & ~0x3f) == 0 && ((1L << (_la - 188)) & ((1L << (KW_ILOAD_2 - 188)) | (1L << (KW_ILOAD_3 - 188)) | (1L << (KW_IMUL - 188)) | (1L << (KW_INEG - 188)) | (1L << (KW_INVOKEDYNAMIC - 188)) | (1L << (KW_INVOKEINTERFACE - 188)) | (1L << (KW_INVOKESPECIAL - 188)) | (1L << (KW_INVOKESTATIC - 188)) | (1L << (KW_INVOKEVIRTUAL - 188)) | (1L << (KW_IOR - 188)) | (1L << (KW_IREM - 188)) | (1L << (KW_IRETURN - 188)) | (1L << (KW_ISHL - 188)) | (1L << (KW_ISHR - 188)) | (1L << (KW_ISTORE - 188)) | (1L << (KW_ISTORE_0 - 188)) | (1L << (KW_ISTORE_1 - 188)) | (1L << (KW_ISTORE_2 - 188)) | (1L << (KW_ISTORE_3 - 188)) | (1L << (KW_ISUB - 188)) | (1L << (KW_IUSHR - 188)) | (1L << (KW_IXOR - 188)) | (1L << (KW_JSR - 188)) | (1L << (KW_JSR_W - 188)) | (1L << (KW_L2D - 188)) | (1L << (KW_L2F - 188)) | (1L << (KW_L2I - 188)) | (1L << (KW_LADD - 188)) | (1L << (KW_LALOAD - 188)) | (1L << (KW_LAND - 188)) | (1L << (KW_LASTORE - 188)) | (1L << (KW_LCMP - 188)) | (1L << (KW_LCONST_0 - 188)) | (1L << (KW_LCONST_1 - 188)) | (1L << (KW_LDC - 188)) | (1L << (KW_LDC_W - 188)) | (1L << (KW_LDC2_W - 188)) | (1L << (KW_LDIV - 188)) | (1L << (KW_LLOAD - 188)) | (1L << (KW_LLOAD_0 - 188)) | (1L << (KW_LLOAD_1 - 188)) | (1L << (KW_LLOAD_2 - 188)) | (1L << (KW_LLOAD_3 - 188)) | (1L << (KW_LMUL - 188)) | (1L << (KW_LNEG - 188)) | (1L << (KW_LOOKUPSWITCH - 188)) | (1L << (KW_LOR - 188)) | (1L << (KW_LREM - 188)) | (1L << (KW_LRETURN - 188)) | (1L << (KW_LSHL - 188)) | (1L << (KW_LSHR - 188)) | (1L << (KW_LSTORE - 188)) | (1L << (KW_LSTORE_0 - 188)) | (1L << (KW_LSTORE_1 - 188)) | (1L << (KW_LSTORE_2 - 188)) | (1L << (KW_LSTORE_3 - 188)) | (1L << (KW_LSUB - 188)) | (1L << (KW_LUSHR - 188)) | (1L << (KW_LXOR - 188)) | (1L << (KW_MONITORENTER - 188)) | (1L << (KW_MONITOREXIT - 188)) | (1L << (KW_MULTIANEWARRAY - 188)) | (1L << (KW_NEWARRAY - 188)) | (1L << (KW_NOP - 188)))) != 0) || ((((_la - 252)) & ~0x3f) == 0 && ((1L << (_la - 252)) & ((1L << (KW_POP - 252)) | (1L << (KW_POP2 - 252)) | (1L << (KW_PUTFIELD - 252)) | (1L << (KW_PUTSTATIC - 252)) | (1L << (KW_RET - 252)) | (1L << (KW_SALOAD - 252)) | (1L << (KW_SASTORE - 252)) | (1L << (KW_SIPUSH - 252)) | (1L << (KW_SWAP - 252)) | (1L << (KW_TABLESWITCH - 252)) | (1L << (KW_WIDE - 252)) | (1L << (Identifier - 252)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			_ctx.stop = _input.LT(-1);
			((IdentifierContext)_localctx).str =  _input.getText(_localctx.start, _input.LT(-1));
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedByteLiteralContext extends ParserRuleContext {
		public byte value;
		public Token token;
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public TerminalNode NegativeIntegerLiteral() { return getToken(ASMParser.NegativeIntegerLiteral, 0); }
		public SignedByteLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedByteLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSignedByteLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSignedByteLiteral(this);
		}
	}

	public final SignedByteLiteralContext signedByteLiteral() throws RecognitionException {
		SignedByteLiteralContext _localctx = new SignedByteLiteralContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_signedByteLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1777);
			((SignedByteLiteralContext)_localctx).token = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NegativeIntegerLiteral || _la==IntegerLiteral) ) {
				((SignedByteLiteralContext)_localctx).token = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((SignedByteLiteralContext)_localctx).value =  parseByteLiteral((((SignedByteLiteralContext)_localctx).token!=null?((SignedByteLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedShortLiteralContext extends ParserRuleContext {
		public short value;
		public Token token;
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public TerminalNode NegativeIntegerLiteral() { return getToken(ASMParser.NegativeIntegerLiteral, 0); }
		public SignedShortLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedShortLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSignedShortLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSignedShortLiteral(this);
		}
	}

	public final SignedShortLiteralContext signedShortLiteral() throws RecognitionException {
		SignedShortLiteralContext _localctx = new SignedShortLiteralContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_signedShortLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1780);
			((SignedShortLiteralContext)_localctx).token = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NegativeIntegerLiteral || _la==IntegerLiteral) ) {
				((SignedShortLiteralContext)_localctx).token = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((SignedShortLiteralContext)_localctx).value =  parseShortLiteral((((SignedShortLiteralContext)_localctx).token!=null?((SignedShortLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerLiteralContext extends ParserRuleContext {
		public int value;
		public Token token;
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitIntegerLiteral(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_integerLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1783);
			((IntegerLiteralContext)_localctx).token = match(IntegerLiteral);
			((IntegerLiteralContext)_localctx).value =  parseIntegerLiteral((((IntegerLiteralContext)_localctx).token!=null?((IntegerLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedIntegerLiteralContext extends ParserRuleContext {
		public int value;
		public Token token;
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public TerminalNode NegativeIntegerLiteral() { return getToken(ASMParser.NegativeIntegerLiteral, 0); }
		public SignedIntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedIntegerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSignedIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSignedIntegerLiteral(this);
		}
	}

	public final SignedIntegerLiteralContext signedIntegerLiteral() throws RecognitionException {
		SignedIntegerLiteralContext _localctx = new SignedIntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_signedIntegerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1786);
			((SignedIntegerLiteralContext)_localctx).token = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NegativeIntegerLiteral || _la==IntegerLiteral) ) {
				((SignedIntegerLiteralContext)_localctx).token = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((SignedIntegerLiteralContext)_localctx).value =  parseIntegerLiteral((((SignedIntegerLiteralContext)_localctx).token!=null?((SignedIntegerLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LongLiteralContext extends ParserRuleContext {
		public long value;
		public Token token;
		public TerminalNode LongLiteral() { return getToken(ASMParser.LongLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public LongLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_longLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterLongLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitLongLiteral(this);
		}
	}

	public final LongLiteralContext longLiteral() throws RecognitionException {
		LongLiteralContext _localctx = new LongLiteralContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_longLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1789);
			((LongLiteralContext)_localctx).token = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==LongLiteral || _la==IntegerLiteral) ) {
				((LongLiteralContext)_localctx).token = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((LongLiteralContext)_localctx).value =  parseLongLiteral((((LongLiteralContext)_localctx).token!=null?((LongLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedLongLiteralContext extends ParserRuleContext {
		public long value;
		public Token token;
		public TerminalNode LongLiteral() { return getToken(ASMParser.LongLiteral, 0); }
		public TerminalNode NegativeLongLiteral() { return getToken(ASMParser.NegativeLongLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(ASMParser.IntegerLiteral, 0); }
		public TerminalNode NegativeIntegerLiteral() { return getToken(ASMParser.NegativeIntegerLiteral, 0); }
		public SignedLongLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedLongLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterSignedLongLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitSignedLongLiteral(this);
		}
	}

	public final SignedLongLiteralContext signedLongLiteral() throws RecognitionException {
		SignedLongLiteralContext _localctx = new SignedLongLiteralContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_signedLongLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1792);
			((SignedLongLiteralContext)_localctx).token = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==LongLiteral || _la==NegativeLongLiteral || _la==NegativeIntegerLiteral || _la==IntegerLiteral) ) {
				((SignedLongLiteralContext)_localctx).token = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((SignedLongLiteralContext)_localctx).value =  parseLongLiteral((((SignedLongLiteralContext)_localctx).token!=null?((SignedLongLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatLiteralContext extends ParserRuleContext {
		public float value;
		public Token token;
		public TerminalNode FloatingPointLiteral() { return getToken(ASMParser.FloatingPointLiteral, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitFloatLiteral(this);
		}
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_floatLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1795);
			((FloatLiteralContext)_localctx).token = match(FloatingPointLiteral);
			((FloatLiteralContext)_localctx).value =  parseFloatLiteral((((FloatLiteralContext)_localctx).token!=null?((FloatLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleLiteralContext extends ParserRuleContext {
		public double value;
		public Token token;
		public TerminalNode DoubleLiteral() { return getToken(ASMParser.DoubleLiteral, 0); }
		public DoubleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitDoubleLiteral(this);
		}
	}

	public final DoubleLiteralContext doubleLiteral() throws RecognitionException {
		DoubleLiteralContext _localctx = new DoubleLiteralContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_doubleLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1798);
			((DoubleLiteralContext)_localctx).token = match(DoubleLiteral);
			((DoubleLiteralContext)_localctx).value =  parseDoubleLiteral((((DoubleLiteralContext)_localctx).token!=null?((DoubleLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharacterLiteralContext extends ParserRuleContext {
		public char value;
		public Token token;
		public TerminalNode CharacterLiteral() { return getToken(ASMParser.CharacterLiteral, 0); }
		public CharacterLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterCharacterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitCharacterLiteral(this);
		}
	}

	public final CharacterLiteralContext characterLiteral() throws RecognitionException {
		CharacterLiteralContext _localctx = new CharacterLiteralContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_characterLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1801);
			((CharacterLiteralContext)_localctx).token = match(CharacterLiteral);
			((CharacterLiteralContext)_localctx).value =  parseCharacterLiteral((((CharacterLiteralContext)_localctx).token!=null?((CharacterLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public String value;
		public Token token;
		public TerminalNode StringLiteral() { return getToken(ASMParser.StringLiteral, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASMParserListener ) ((ASMParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1804);
			((StringLiteralContext)_localctx).token = match(StringLiteral);
			((StringLiteralContext)_localctx).value =  parseStringLiteral((((StringLiteralContext)_localctx).token!=null?((StringLiteralContext)_localctx).token.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return classModifier_sempred((ClassModifierContext)_localctx, predIndex);
		case 7:
			return interfaceModifier_sempred((InterfaceModifierContext)_localctx, predIndex);
		case 12:
			return superinterfaces_sempred((SuperinterfacesContext)_localctx, predIndex);
		case 18:
			return constructorDeclaration_sempred((ConstructorDeclarationContext)_localctx, predIndex);
		case 19:
			return constructorModifier_sempred((ConstructorModifierContext)_localctx, predIndex);
		case 21:
			return methodModifier_sempred((MethodModifierContext)_localctx, predIndex);
		case 22:
			return fieldDeclaration_sempred((FieldDeclarationContext)_localctx, predIndex);
		case 23:
			return fieldModifier_sempred((FieldModifierContext)_localctx, predIndex);
		case 26:
			return formalParameter_sempred((FormalParameterContext)_localctx, predIndex);
		case 27:
			return variableModifier_sempred((VariableModifierContext)_localctx, predIndex);
		case 29:
			return variadicParameter_sempred((VariadicParameterContext)_localctx, predIndex);
		case 33:
			return methodBody_sempred((MethodBodyContext)_localctx, predIndex);
		case 36:
			return instruction_sempred((InstructionContext)_localctx, predIndex);
		case 48:
			return tableSwitchCase_sempred((TableSwitchCaseContext)_localctx, predIndex);
		case 71:
			return typeIdentifier_sempred((TypeIdentifierContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean classModifier_sempred(ClassModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 1:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 2:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 3:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 4:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 5:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 6:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 7:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 8:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 9:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 10:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 11:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 12:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 13:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 14:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 15:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 16:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 17:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		}
		return true;
	}
	private boolean interfaceModifier_sempred(InterfaceModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 19:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 20:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 21:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 22:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 23:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 24:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 25:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 26:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 27:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 28:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 29:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 30:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 31:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 32:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 33:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		}
		return true;
	}
	private boolean superinterfaces_sempred(SuperinterfacesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 34:
			return _localctx.isImplements;
		case 35:
			return !_localctx.isImplements;
		}
		return true;
	}
	private boolean constructorDeclaration_sempred(ConstructorDeclarationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 36:
			return ((ConstructorDeclarationContext)_localctx).qualifiedTypeIdentifier.str.equals(currentClassName);
		}
		return true;
	}
	private boolean constructorModifier_sempred(ConstructorModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 37:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 38:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 39:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 40:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 41:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 42:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 43:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 44:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 45:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 46:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 47:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		}
		return true;
	}
	private boolean methodModifier_sempred(MethodModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 48:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 49:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 50:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 51:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 52:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 53:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 54:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 55:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 56:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 57:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 58:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 59:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 60:
			return (_localctx.flags & ACC_SYNCHRONIZED) == 0;
		case 61:
			return (_localctx.flags & ACC_NATIVE) == 0;
		case 62:
			return (_localctx.flags & ACC_STRICT) == 0;
		case 63:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 64:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 65:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 66:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 67:
			return (_localctx.flags & ACC_SYNCHRONIZED) == 0;
		case 68:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 69:
			return (_localctx.flags & ACC_NATIVE) == 0;
		case 70:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 71:
			return (_localctx.flags & ACC_STRICT) == 0;
		case 72:
			return (_localctx.flags & ACC_STRICT) == 0;
		case 73:
			return (_localctx.flags & ACC_ABSTRACT) == 0;
		case 74:
			return (_localctx.flags & ACC_NATIVE) == 0;
		case 75:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 76:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		case 77:
			return (_localctx.flags & ACC_BRIDGE) == 0;
		case 78:
			return (_localctx.flags & ACC_MANDATED) == 0;
		}
		return true;
	}
	private boolean fieldDeclaration_sempred(FieldDeclarationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 79:
			return (_localctx.flags & ACC_STATIC) != 0;
		case 80:
			return isString(_localctx.type());
		case 81:
			return isBoolean(_localctx.type());
		case 82:
			return isByte(_localctx.type());
		case 83:
			return isShort(_localctx.type());
		case 84:
			return isChar(_localctx.type());
		case 85:
			return isInt(_localctx.type());
		case 86:
			return isLong(_localctx.type());
		case 87:
			return isFloat(_localctx.type());
		case 88:
			return isDouble(_localctx.type());
		}
		return true;
	}
	private boolean fieldModifier_sempred(FieldModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 89:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 90:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 91:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 92:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 93:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 94:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 95:
			return (_localctx.flags & ACC_PRIVATE) == 0;
		case 96:
			return (_localctx.flags & ACC_PUBLIC) == 0;
		case 97:
			return (_localctx.flags & ACC_PROTECTED) == 0;
		case 98:
			return (_localctx.flags & ACC_STATIC) == 0;
		case 99:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 100:
			return (_localctx.flags & ACC_TRANSIENT) == 0;
		case 101:
			return (_localctx.flags & ACC_VOLATILE) == 0;
		case 102:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 103:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		case 104:
			return (_localctx.flags & ACC_MANDATED) == 0;
		}
		return true;
	}
	private boolean formalParameter_sempred(FormalParameterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 105:
			return localVarMode != MODE_INDICES;
		case 106:
			return localVarMode != MODE_NAMES;
		}
		return true;
	}
	private boolean variableModifier_sempred(VariableModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 107:
			return (_localctx.flags & ACC_FINAL) == 0;
		case 108:
			return (_localctx.flags & ACC_SYNTHETIC) == 0;
		case 109:
			return (_localctx.flags & ACC_DEPRECATED) == 0;
		case 110:
			return (_localctx.flags & ACC_MANDATED) == 0;
		}
		return true;
	}
	private boolean variadicParameter_sempred(VariadicParameterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 111:
			return localVarMode != MODE_INDICES;
		case 112:
			return localVarMode != MODE_NAMES;
		}
		return true;
	}
	private boolean methodBody_sempred(MethodBodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 113:
			return _localctx.hasCode;
		case 114:
			return !_localctx.hasCode;
		}
		return true;
	}
	private boolean instruction_sempred(InstructionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 115:
			return localVarMode != MODE_NAMES;
		case 116:
			return localVarMode != MODE_INDICES;
		case 117:
			return localVarMode != MODE_NAMES;
		case 118:
			return localVarMode != MODE_NAMES;
		case 119:
			return localVarMode != MODE_NAMES;
		case 120:
			return localVarMode != MODE_NAMES;
		case 121:
			return localVarMode != MODE_NAMES;
		case 122:
			return localVarMode != MODE_INDICES;
		case 123:
			return localVarMode != MODE_NAMES;
		case 124:
			return localVarMode != MODE_NAMES;
		case 125:
			return localVarMode != MODE_NAMES;
		case 126:
			return localVarMode != MODE_NAMES;
		case 127:
			return localVarMode != MODE_NAMES;
		case 128:
			return localVarMode != MODE_INDICES;
		case 129:
			return localVarMode != MODE_NAMES;
		case 130:
			return localVarMode != MODE_NAMES;
		case 131:
			return localVarMode != MODE_NAMES;
		case 132:
			return localVarMode != MODE_NAMES;
		case 133:
			return localVarMode != MODE_NAMES;
		case 134:
			return localVarMode != MODE_INDICES;
		case 135:
			return localVarMode != MODE_NAMES;
		case 136:
			return localVarMode != MODE_NAMES;
		case 137:
			return localVarMode != MODE_NAMES;
		case 138:
			return localVarMode != MODE_NAMES;
		case 139:
			return localVarMode != MODE_NAMES;
		case 140:
			return localVarMode != MODE_INDICES;
		case 141:
			return localVarMode != MODE_NAMES;
		case 142:
			return localVarMode != MODE_NAMES;
		case 143:
			return localVarMode != MODE_NAMES;
		case 144:
			return localVarMode != MODE_NAMES;
		case 145:
			return localVarMode != MODE_NAMES;
		case 146:
			return localVarMode != MODE_INDICES;
		case 147:
			return localVarMode != MODE_NAMES;
		case 148:
			return localVarMode != MODE_NAMES;
		case 149:
			return localVarMode != MODE_NAMES;
		case 150:
			return localVarMode != MODE_NAMES;
		case 151:
			return localVarMode != MODE_NAMES;
		case 152:
			return localVarMode != MODE_INDICES;
		case 153:
			return localVarMode != MODE_NAMES;
		case 154:
			return localVarMode != MODE_INDICES;
		case 155:
			return localVarMode != MODE_NAMES;
		case 156:
			return localVarMode != MODE_NAMES;
		case 157:
			return localVarMode != MODE_NAMES;
		case 158:
			return localVarMode != MODE_NAMES;
		case 159:
			return localVarMode != MODE_NAMES;
		case 160:
			return localVarMode != MODE_INDICES;
		case 161:
			return localVarMode != MODE_NAMES;
		case 162:
			return localVarMode != MODE_NAMES;
		case 163:
			return localVarMode != MODE_NAMES;
		case 164:
			return localVarMode != MODE_NAMES;
		case 165:
			return localVarMode != MODE_NAMES;
		case 166:
			return localVarMode != MODE_INDICES;
		case 167:
			return localVarMode != MODE_NAMES;
		case 168:
			return localVarMode != MODE_NAMES;
		case 169:
			return localVarMode != MODE_NAMES;
		case 170:
			return localVarMode != MODE_NAMES;
		case 171:
			return localVarMode != MODE_NAMES;
		case 172:
			return localVarMode != MODE_INDICES;
		case 173:
			return localVarMode != MODE_NAMES;
		case 174:
			return localVarMode != MODE_NAMES;
		case 175:
			return localVarMode != MODE_NAMES;
		case 176:
			return localVarMode != MODE_NAMES;
		case 177:
			return ((InstructionContext)_localctx).integerLiteral.value <= arrayDimCount(_localctx.arrayType());
		case 178:
			return localVarMode != MODE_NAMES;
		case 179:
			return localVarMode != MODE_INDICES;
		}
		return true;
	}
	private boolean tableSwitchCase_sempred(TableSwitchCaseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 180:
			return _localctx.value2 == _localctx.value;
		}
		return true;
	}
	private boolean typeIdentifier_sempred(TypeIdentifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 181:
			return !_input.LT(1).getText().equals("var");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0125\u0712\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00b9\n"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u00c2\n\5\f\5\16\5\u00c5\13\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u00cd\n\5\3\5\5\5\u00d0\n\5\3\5\5\5\u00d3\n\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6\u00fb\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0104\n\b\f\b"+
		"\16\b\u0107\13\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u010f\n\b\3\b\5\b\u0112\n"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0136\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u013f\n\13\f\13\16\13"+
		"\u0142\13\13\3\f\3\f\3\f\5\f\u0147\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\5\16\u0150\n\16\3\16\3\16\3\17\3\17\3\17\7\17\u0157\n\17\f\17\16\17\u015a"+
		"\13\17\3\20\3\20\7\20\u015e\n\20\f\20\16\20\u0161\13\20\3\20\3\20\3\21"+
		"\3\21\7\21\u0167\n\21\f\21\16\21\u016a\13\21\3\21\3\21\3\22\3\22\3\22"+
		"\5\22\u0171\n\22\3\23\3\23\5\23\u0175\n\23\3\24\3\24\3\24\3\24\7\24\u017b"+
		"\n\24\f\24\16\24\u017e\13\24\3\24\3\24\3\24\5\24\u0183\n\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u018a\n\24\3\24\3\24\5\24\u018e\n\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01aa\n\25\3\26"+
		"\3\26\3\26\3\26\7\26\u01b0\n\26\f\26\16\26\u01b3\13\26\3\26\3\26\3\26"+
		"\5\26\u01b8\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u01bf\n\26\3\26\3\26\5"+
		"\26\u01c3\n\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0203\n\27\3\30\3\30"+
		"\3\30\3\30\7\30\u0209\n\30\f\30\16\30\u020c\13\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u021c\n\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u023b\n\30\5\30\u023d\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u0266\n\31\3\32\3\32\3\32\3\32\3\32\5\32\u026d"+
		"\n\32\3\33\3\33\3\33\7\33\u0272\n\33\f\33\16\33\u0275\13\33\3\34\3\34"+
		"\3\34\3\34\7\34\u027b\n\34\f\34\16\34\u027e\13\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u0287\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u0295\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u029d\n\36\3\37\3\37\3\37\3\37\7\37\u02a3\n\37\f\37\16\37\u02a6\13\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u02b1\n\37\3 \3 \3"+
		" \3!\3!\3!\7!\u02b9\n!\f!\16!\u02bc\13!\3\"\3\"\3#\3#\3#\3#\3#\6#\u02c5"+
		"\n#\r#\16#\u02c6\3#\3#\3#\3#\5#\u02cd\n#\3$\3$\5$\u02d1\n$\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\5&\u02dc\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u02ea"+
		"\n&\3&\5&\u02ed\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\5&\u0305\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0313"+
		"\n&\3&\5&\u0316\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u034e\n&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\5&\u035c\n&\3&\5&\u035f\n&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0377\n&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0385\n&\3&\5&\u0388\n&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\5&\u03be\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u03cc\n&\3&\5&\u03cf"+
		"\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\5&\u03e7\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u03f5\n&\3&\5&\u03f8"+
		"\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u047a\n&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\5&\u0488\n&\3&\5&\u048b\n&\3&\3&\3&\3&\3&\5&\u0492"+
		"\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u04a0\n&\3&\5&\u04a3\n&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\5&\u04d9\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u04e7"+
		"\n&\3&\5&\u04ea\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0527\n&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0535\n&\3&\5&\u0538\n&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\5&\u055a\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\5&\u0568\n&\3&\5&\u056b\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u05a1\n&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\5&\u05af\n&\3&\5&\u05b2\n&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u05c5\n&\3\'\3\'\3\'\5\'\u05ca\n"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\5(\u05d4\n(\3(\3(\3(\3(\3(\5(\u05db\n"+
		"(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\5+\u05f2"+
		"\n+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\7-\u05ff\n-\f-\16-\u0602\13-\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\5.\u061f\n.\3/\3/\6/\u0623\n/\r/\16/\u0624\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u0630\n\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\7\61\u063a\n\61\f\61\16\61\u063d\13\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\5\62\u0649\n\62\3\62\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\64\3\64\5\64\u0657\n\64\3\65\3\65\3\65\5\65\u065c"+
		"\n\65\3\66\3\66\5\66\u0660\n\66\3\66\3\66\3\66\3\67\3\67\38\38\38\38\3"+
		"8\58\u066c\n8\39\39\39\39\39\39\59\u0674\n9\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\5:\u0680\n:\3;\3;\3;\3;\5;\u0686\n;\3<\3<\5<\u068a\n<\3=\3=\5=\u068e"+
		"\n=\3>\3>\3?\3?\3?\3?\3?\3?\5?\u0698\n?\3@\6@\u069b\n@\r@\16@\u069c\3"+
		"A\3A\3A\3B\3B\3B\7B\u06a5\nB\fB\16B\u06a8\13B\3B\3B\3B\6B\u06ad\nB\rB"+
		"\16B\u06ae\5B\u06b1\nB\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\7E\u06bd\nE\fE\16"+
		"E\u06c0\13E\3F\3F\5F\u06c4\nF\3G\3G\5G\u06c8\nG\3H\3H\3H\3H\5H\u06ce\n"+
		"H\3I\3I\3I\3I\3J\3J\3J\3J\3J\7J\u06d9\nJ\fJ\16J\u06dc\13J\3J\3J\3J\3J"+
		"\3K\3K\3K\3K\3K\7K\u06e7\nK\fK\16K\u06ea\13K\3K\3K\3K\3K\3L\3L\3M\3M\3"+
		"N\3N\3N\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3R\3R\3R\3S\3S\3S\3T\3T\3T\3U\3U\3"+
		"U\3V\3V\3V\3W\3W\3W\3W\2\2X\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\2\f\4\2\37\37\u0097\u0097"+
		"\3\2\u00d4\u00d5\3\2\u00e0\u00e2\4\2\u0095\u0096\u0100\u0101\3\2\u00c3"+
		"\u00c6\4\2>A\u011c\u011c\5\2>BD\u0108\u011c\u011c\3\2\u0121\u0122\4\2"+
		"\3\3\u0122\u0122\5\2\3\3\5\5\u0121\u0122\2\u0828\2\u00ae\3\2\2\2\4\u00b8"+
		"\3\2\2\2\6\u00ba\3\2\2\2\b\u00bd\3\2\2\2\n\u00fa\3\2\2\2\f\u00fc\3\2\2"+
		"\2\16\u00ff\3\2\2\2\20\u0135\3\2\2\2\22\u0137\3\2\2\2\24\u013b\3\2\2\2"+
		"\26\u0143\3\2\2\2\30\u0148\3\2\2\2\32\u014f\3\2\2\2\34\u0153\3\2\2\2\36"+
		"\u015b\3\2\2\2 \u0164\3\2\2\2\"\u0170\3\2\2\2$\u0174\3\2\2\2&\u0176\3"+
		"\2\2\2(\u01a9\3\2\2\2*\u01ab\3\2\2\2,\u0202\3\2\2\2.\u0204\3\2\2\2\60"+
		"\u0265\3\2\2\2\62\u026c\3\2\2\2\64\u026e\3\2\2\2\66\u0276\3\2\2\28\u0294"+
		"\3\2\2\2:\u029c\3\2\2\2<\u029e\3\2\2\2>\u02b2\3\2\2\2@\u02b5\3\2\2\2B"+
		"\u02bd\3\2\2\2D\u02cc\3\2\2\2F\u02d0\3\2\2\2H\u02d2\3\2\2\2J\u05c4\3\2"+
		"\2\2L\u05c9\3\2\2\2N\u05d3\3\2\2\2P\u05df\3\2\2\2R\u05e5\3\2\2\2T\u05f1"+
		"\3\2\2\2V\u05f3\3\2\2\2X\u05fb\3\2\2\2Z\u061e\3\2\2\2\\\u0620\3\2\2\2"+
		"^\u062f\3\2\2\2`\u0635\3\2\2\2b\u0648\3\2\2\2d\u064f\3\2\2\2f\u0656\3"+
		"\2\2\2h\u065b\3\2\2\2j\u065d\3\2\2\2l\u0664\3\2\2\2n\u066b\3\2\2\2p\u0673"+
		"\3\2\2\2r\u067f\3\2\2\2t\u0685\3\2\2\2v\u0689\3\2\2\2x\u068b\3\2\2\2z"+
		"\u068f\3\2\2\2|\u0697\3\2\2\2~\u069a\3\2\2\2\u0080\u069e\3\2\2\2\u0082"+
		"\u06b0\3\2\2\2\u0084\u06b2\3\2\2\2\u0086\u06b5\3\2\2\2\u0088\u06b9\3\2"+
		"\2\2\u008a\u06c3\3\2\2\2\u008c\u06c5\3\2\2\2\u008e\u06cd\3\2\2\2\u0090"+
		"\u06cf\3\2\2\2\u0092\u06d3\3\2\2\2\u0094\u06e1\3\2\2\2\u0096\u06ef\3\2"+
		"\2\2\u0098\u06f1\3\2\2\2\u009a\u06f3\3\2\2\2\u009c\u06f6\3\2\2\2\u009e"+
		"\u06f9\3\2\2\2\u00a0\u06fc\3\2\2\2\u00a2\u06ff\3\2\2\2\u00a4\u0702\3\2"+
		"\2\2\u00a6\u0705\3\2\2\2\u00a8\u0708\3\2\2\2\u00aa\u070b\3\2\2\2\u00ac"+
		"\u070e\3\2\2\2\u00ae\u00af\5\4\3\2\u00af\u00b0\b\2\1\2\u00b0\u00b1\7\2"+
		"\2\3\u00b1\3\3\2\2\2\u00b2\u00b3\5\6\4\2\u00b3\u00b4\b\3\1\2\u00b4\u00b9"+
		"\3\2\2\2\u00b5\u00b6\5\f\7\2\u00b6\u00b7\b\3\1\2\u00b7\u00b9\3\2\2\2\u00b8"+
		"\u00b2\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9\5\3\2\2\2\u00ba\u00bb\5\b\5\2"+
		"\u00bb\u00bc\b\4\1\2\u00bc\7\3\2\2\2\u00bd\u00c3\b\5\1\2\u00be\u00bf\5"+
		"\n\6\2\u00bf\u00c0\b\5\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\20\2\2\u00c7\u00c8\5\u0092J\2\u00c8"+
		"\u00cc\b\5\1\2\u00c9\u00ca\5\22\n\2\u00ca\u00cb\b\5\1\2\u00cb\u00cd\3"+
		"\2\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00d0\5\30\r\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3"+
		"\2\2\2\u00d1\u00d3\5\32\16\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\b\5\1\2\u00d5\u00d6\5\36\20\2\u00d6\u00d7\b"+
		"\5\1\2\u00d7\t\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9\u00da\b\6\1\2\u00da\u00db"+
		"\6\6\2\3\u00db\u00dc\6\6\3\3\u00dc\u00fb\6\6\4\3\u00dd\u00de\7+\2\2\u00de"+
		"\u00df\b\6\1\2\u00df\u00e0\6\6\5\3\u00e0\u00e1\6\6\6\3\u00e1\u00fb\6\6"+
		"\7\3\u00e2\u00e3\7*\2\2\u00e3\u00e4\b\6\1\2\u00e4\u00e5\6\6\b\3\u00e5"+
		"\u00e6\6\6\t\3\u00e6\u00fb\6\6\n\3\u00e7\u00e8\7\b\2\2\u00e8\u00e9\b\6"+
		"\1\2\u00e9\u00ea\6\6\13\3\u00ea\u00eb\6\6\f\3\u00eb\u00fb\6\6\r\3\u00ec"+
		"\u00ed\7/\2\2\u00ed\u00ee\b\6\1\2\u00ee\u00ef\6\6\16\3\u00ef\u00fb\6\6"+
		"\17\3\u00f0\u00f1\7\32\2\2\u00f1\u00f2\b\6\1\2\u00f2\u00f3\6\6\20\3\u00f3"+
		"\u00fb\6\6\21\3\u00f4\u00f5\7>\2\2\u00f5\u00f6\b\6\1\2\u00f6\u00fb\6\6"+
		"\22\3\u00f7\u00f8\7A\2\2\u00f8\u00f9\b\6\1\2\u00f9\u00fb\6\6\23\3\u00fa"+
		"\u00d8\3\2\2\2\u00fa\u00dd\3\2\2\2\u00fa\u00e2\3\2\2\2\u00fa\u00e7\3\2"+
		"\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00f0\3\2\2\2\u00fa\u00f4\3\2\2\2\u00fa"+
		"\u00f7\3\2\2\2\u00fb\13\3\2\2\2\u00fc\u00fd\5\16\b\2\u00fd\u00fe\b\7\1"+
		"\2\u00fe\r\3\2\2\2\u00ff\u0105\b\b\1\2\u0100\u0101\5\20\t\2\u0101\u0102"+
		"\b\b\1\2\u0102\u0104\3\2\2\2\u0103\u0100\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0108\u0109\7$\2\2\u0109\u010a\5\u0092J\2\u010a\u010e\b\b\1\2\u010b"+
		"\u010c\5\22\n\2\u010c\u010d\b\b\1\2\u010d\u010f\3\2\2\2\u010e\u010b\3"+
		"\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u0112\5\32\16\2\u0111"+
		"\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b\b"+
		"\1\2\u0114\u0115\5 \21\2\u0115\u0116\b\b\1\2\u0116\17\3\2\2\2\u0117\u0118"+
		"\7,\2\2\u0118\u0119\b\t\1\2\u0119\u011a\6\t\24\3\u011a\u011b\6\t\25\3"+
		"\u011b\u0136\6\t\26\3\u011c\u011d\7+\2\2\u011d\u011e\b\t\1\2\u011e\u011f"+
		"\6\t\27\3\u011f\u0120\6\t\30\3\u0120\u0136\6\t\31\3\u0121\u0122\7*\2\2"+
		"\u0122\u0123\b\t\1\2\u0123\u0124\6\t\32\3\u0124\u0125\6\t\33\3\u0125\u0136"+
		"\6\t\34\3\u0126\u0127\7\b\2\2\u0127\u0128\b\t\1\2\u0128\u0129\6\t\35\3"+
		"\u0129\u012a\6\t\36\3\u012a\u0136\6\t\37\3\u012b\u012c\7/\2\2\u012c\u012d"+
		"\b\t\1\2\u012d\u012e\6\t \3\u012e\u0136\6\t!\3\u012f\u0130\7>\2\2\u0130"+
		"\u0131\b\t\1\2\u0131\u0136\6\t\"\3\u0132\u0133\7A\2\2\u0133\u0134\b\t"+
		"\1\2\u0134\u0136\6\t#\3\u0135\u0117\3\2\2\2\u0135\u011c\3\2\2\2\u0135"+
		"\u0121\3\2\2\2\u0135\u0126\3\2\2\2\u0135\u012b\3\2\2\2\u0135\u012f\3\2"+
		"\2\2\u0135\u0132\3\2\2\2\u0136\21\3\2\2\2\u0137\u0138\7\u0115\2\2\u0138"+
		"\u0139\5\24\13\2\u0139\u013a\7\u0116\2\2\u013a\23\3\2\2\2\u013b\u0140"+
		"\5\26\f\2\u013c\u013d\7\u0111\2\2\u013d\u013f\5\26\f\2\u013e\u013c\3\2"+
		"\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\25\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\5\u0090I\2\u0144\u0146\b\f"+
		"\1\2\u0145\u0147\5\u0082B\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\27\3\2\2\2\u0148\u0149\7\30\2\2\u0149\u014a\5x=\2\u014a\31\3\2\2\2\u014b"+
		"\u014c\6\16$\3\u014c\u0150\7 \2\2\u014d\u014e\6\16%\3\u014e\u0150\7\30"+
		"\2\2\u014f\u014b\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\5\34\17\2\u0152\33\3\2\2\2\u0153\u0158\5x=\2\u0154\u0155\7\u0111"+
		"\2\2\u0155\u0157\5x=\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\35\3\2\2\2\u015a\u0158\3\2\2\2\u015b"+
		"\u015f\7\u010b\2\2\u015c\u015e\5\"\22\2\u015d\u015c\3\2\2\2\u015e\u0161"+
		"\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0162\u0163\7\u010c\2\2\u0163\37\3\2\2\2\u0164\u0168\7"+
		"\u010b\2\2\u0165\u0167\5$\23\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2"+
		"\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0168"+
		"\3\2\2\2\u016b\u016c\7\u010c\2\2\u016c!\3\2\2\2\u016d\u0171\5&\24\2\u016e"+
		"\u0171\5*\26\2\u016f\u0171\5.\30\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0170\u016f\3\2\2\2\u0171#\3\2\2\2\u0172\u0175\5*\26\2\u0173\u0175"+
		"\5.\30\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175%\3\2\2\2\u0176"+
		"\u017c\b\24\1\2\u0177\u0178\5(\25\2\u0178\u0179\b\24\1\2\u0179\u017b\3"+
		"\2\2\2\u017a\u0177\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u0182\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0180\5\22"+
		"\n\2\u0180\u0181\b\24\1\2\u0181\u0183\3\2\2\2\u0182\u017f\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\5\u0092J\2\u0185\u0186"+
		"\6\24&\3\u0186\u0187\7\u0109\2\2\u0187\u0189\b\24\1\2\u0188\u018a\5\62"+
		"\32\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018d\7\u010a\2\2\u018c\u018e\5> \2\u018d\u018c\3\2\2\2\u018d\u018e\3"+
		"\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\7\u010f\2\2\u0190\u0191\b\24\1"+
		"\2\u0191\u0192\5D#\2\u0192\u0193\b\24\1\2\u0193\'\3\2\2\2\u0194\u0195"+
		"\7,\2\2\u0195\u0196\b\25\1\2\u0196\u0197\6\25\'\3\u0197\u0198\6\25(\3"+
		"\u0198\u01aa\6\25)\3\u0199\u019a\7+\2\2\u019a\u019b\b\25\1\2\u019b\u019c"+
		"\6\25*\3\u019c\u019d\6\25+\3\u019d\u01aa\6\25,\3\u019e\u019f\7*\2\2\u019f"+
		"\u01a0\b\25\1\2\u01a0\u01a1\6\25-\3\u01a1\u01a2\6\25.\3\u01a2\u01aa\6"+
		"\25/\3\u01a3\u01a4\7>\2\2\u01a4\u01a5\b\25\1\2\u01a5\u01aa\6\25\60\3\u01a6"+
		"\u01a7\7A\2\2\u01a7\u01a8\b\25\1\2\u01a8\u01aa\6\25\61\3\u01a9\u0194\3"+
		"\2\2\2\u01a9\u0199\3\2\2\2\u01a9\u019e\3\2\2\2\u01a9\u01a3\3\2\2\2\u01a9"+
		"\u01a6\3\2\2\2\u01aa)\3\2\2\2\u01ab\u01b1\b\26\1\2\u01ac\u01ad\5,\27\2"+
		"\u01ad\u01ae\b\26\1\2\u01ae\u01b0\3\2\2\2\u01af\u01ac\3\2\2\2\u01b0\u01b3"+
		"\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b7\3\2\2\2\u01b3"+
		"\u01b1\3\2\2\2\u01b4\u01b5\5\22\n\2\u01b5\u01b6\b\26\1\2\u01b6\u01b8\3"+
		"\2\2\2\u01b7\u01b4\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\5h\65\2\u01ba\u01bb\5\u0098M\2\u01bb\u01bc\7\u0109\2\2\u01bc\u01be"+
		"\b\26\1\2\u01bd\u01bf\5\62\32\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2"+
		"\2\u01bf\u01c0\3\2\2\2\u01c0\u01c2\7\u010a\2\2\u01c1\u01c3\5> \2\u01c2"+
		"\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\7\u010f"+
		"\2\2\u01c5\u01c6\b\26\1\2\u01c6\u01c7\5D#\2\u01c7\u01c8\b\26\1\2\u01c8"+
		"+\3\2\2\2\u01c9\u01ca\7,\2\2\u01ca\u01cb\b\27\1\2\u01cb\u01cc\6\27\62"+
		"\3\u01cc\u01cd\6\27\63\3\u01cd\u0203\6\27\64\3\u01ce\u01cf\7+\2\2\u01cf"+
		"\u01d0\b\27\1\2\u01d0\u01d1\6\27\65\3\u01d1\u01d2\6\27\66\3\u01d2\u0203"+
		"\6\27\67\3\u01d3\u01d4\7*\2\2\u01d4\u01d5\b\27\1\2\u01d5\u01d6\6\278\3"+
		"\u01d6\u01d7\6\279\3\u01d7\u0203\6\27:\3\u01d8\u01d9\7\b\2\2\u01d9\u01da"+
		"\b\27\1\2\u01da\u01db\6\27;\3\u01db\u01dc\6\27<\3\u01dc\u01dd\6\27=\3"+
		"\u01dd\u01de\6\27>\3\u01de\u01df\6\27?\3\u01df\u0203\6\27@\3\u01e0\u01e1"+
		"\7/\2\2\u01e1\u01e2\b\27\1\2\u01e2\u01e3\6\27A\3\u01e3\u0203\6\27B\3\u01e4"+
		"\u01e5\7\32\2\2\u01e5\u01e6\b\27\1\2\u01e6\u01e7\6\27C\3\u01e7\u0203\6"+
		"\27D\3\u01e8\u01e9\7\63\2\2\u01e9\u01ea\b\27\1\2\u01ea\u01eb\6\27E\3\u01eb"+
		"\u0203\6\27F\3\u01ec\u01ed\7&\2\2\u01ed\u01ee\b\27\1\2\u01ee\u01ef\6\27"+
		"G\3\u01ef\u01f0\6\27H\3\u01f0\u0203\6\27I\3\u01f1\u01f2\7\60\2\2\u01f2"+
		"\u01f3\b\27\1\2\u01f3\u01f4\6\27J\3\u01f4\u01f5\6\27K\3\u01f5\u0203\6"+
		"\27L\3\u01f6\u01f7\7>\2\2\u01f7\u01f8\b\27\1\2\u01f8\u0203\6\27M\3\u01f9"+
		"\u01fa\7A\2\2\u01fa\u01fb\b\27\1\2\u01fb\u0203\6\27N\3\u01fc\u01fd\7@"+
		"\2\2\u01fd\u01fe\b\27\1\2\u01fe\u0203\6\27O\3\u01ff\u0200\7?\2\2\u0200"+
		"\u0201\b\27\1\2\u0201\u0203\6\27P\3\u0202\u01c9\3\2\2\2\u0202\u01ce\3"+
		"\2\2\2\u0202\u01d3\3\2\2\2\u0202\u01d8\3\2\2\2\u0202\u01e0\3\2\2\2\u0202"+
		"\u01e4\3\2\2\2\u0202\u01e8\3\2\2\2\u0202\u01ec\3\2\2\2\u0202\u01f1\3\2"+
		"\2\2\u0202\u01f6\3\2\2\2\u0202\u01f9\3\2\2\2\u0202\u01fc\3\2\2\2\u0202"+
		"\u01ff\3\2\2\2\u0203-\3\2\2\2\u0204\u020a\b\30\1\2\u0205\u0206\5\60\31"+
		"\2\u0206\u0207\b\30\1\2\u0207\u0209\3\2\2\2\u0208\u0205\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2"+
		"\2\2\u020c\u020a\3\2\2\2\u020d\u020e\5f\64\2\u020e\u020f\5\u0098M\2\u020f"+
		"\u023c\b\30\1\2\u0210\u0211\6\30Q\3\u0211\u023a\7\u011b\2\2\u0212\u0213"+
		"\6\30R\3\u0213\u0214\5\u00acW\2\u0214\u0215\b\30\1\2\u0215\u023b\3\2\2"+
		"\2\u0216\u021b\6\30S\3\u0217\u0218\78\2\2\u0218\u021c\b\30\1\2\u0219\u021a"+
		"\7\31\2\2\u021a\u021c\b\30\1\2\u021b\u0217\3\2\2\2\u021b\u0219\3\2\2\2"+
		"\u021c\u023b\3\2\2\2\u021d\u021e\6\30T\3\u021e\u021f\5\u009aN\2\u021f"+
		"\u0220\b\30\1\2\u0220\u023b\3\2\2\2\u0221\u0222\6\30U\3\u0222\u0223\5"+
		"\u009cO\2\u0223\u0224\b\30\1\2\u0224\u023b\3\2\2\2\u0225\u0226\6\30V\3"+
		"\u0226\u0227\5\u00aaV\2\u0227\u0228\b\30\1\2\u0228\u023b\3\2\2\2\u0229"+
		"\u022a\6\30W\3\u022a\u022b\5\u00a0Q\2\u022b\u022c\b\30\1\2\u022c\u023b"+
		"\3\2\2\2\u022d\u022e\6\30X\3\u022e\u022f\5\u00a4S\2\u022f\u0230\b\30\1"+
		"\2\u0230\u023b\3\2\2\2\u0231\u0232\6\30Y\3\u0232\u0233\5\u00a6T\2\u0233"+
		"\u0234\b\30\1\2\u0234\u023b\3\2\2\2\u0235\u0236\6\30Z\3\u0236\u0237\5"+
		"\u00a8U\2\u0237\u0238\b\30\1\2\u0238\u023b\3\2\2\2\u0239\u023b\7(\2\2"+
		"\u023a\u0212\3\2\2\2\u023a\u0216\3\2\2\2\u023a\u021d\3\2\2\2\u023a\u0221"+
		"\3\2\2\2\u023a\u0225\3\2\2\2\u023a\u0229\3\2\2\2\u023a\u022d\3\2\2\2\u023a"+
		"\u0231\3\2\2\2\u023a\u0235\3\2\2\2\u023a\u0239\3\2\2\2\u023b\u023d\3\2"+
		"\2\2\u023c\u0210\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\3\2\2\2\u023e"+
		"\u023f\7\u010f\2\2\u023f\u0240\b\30\1\2\u0240/\3\2\2\2\u0241\u0242\7,"+
		"\2\2\u0242\u0243\b\31\1\2\u0243\u0244\6\31[\3\u0244\u0245\6\31\\\3\u0245"+
		"\u0266\6\31]\3\u0246\u0247\7+\2\2\u0247\u0248\b\31\1\2\u0248\u0249\6\31"+
		"^\3\u0249\u024a\6\31_\3\u024a\u0266\6\31`\3\u024b\u024c\7*\2\2\u024c\u024d"+
		"\b\31\1\2\u024d\u024e\6\31a\3\u024e\u024f\6\31b\3\u024f\u0266\6\31c\3"+
		"\u0250\u0251\7/\2\2\u0251\u0252\b\31\1\2\u0252\u0266\6\31d\3\u0253\u0254"+
		"\7\32\2\2\u0254\u0255\b\31\1\2\u0255\u0266\6\31e\3\u0256\u0257\7\67\2"+
		"\2\u0257\u0258\b\31\1\2\u0258\u0266\6\31f\3\u0259\u025a\7;\2\2\u025a\u025b"+
		"\b\31\1\2\u025b\u0266\6\31g\3\u025c\u025d\7>\2\2\u025d\u025e\b\31\1\2"+
		"\u025e\u0266\6\31h\3\u025f\u0260\7A\2\2\u0260\u0261\b\31\1\2\u0261\u0266"+
		"\6\31i\3\u0262\u0263\7?\2\2\u0263\u0264\b\31\1\2\u0264\u0266\6\31j\3\u0265"+
		"\u0241\3\2\2\2\u0265\u0246\3\2\2\2\u0265\u024b\3\2\2\2\u0265\u0250\3\2"+
		"\2\2\u0265\u0253\3\2\2\2\u0265\u0256\3\2\2\2\u0265\u0259\3\2\2\2\u0265"+
		"\u025c\3\2\2\2\u0265\u025f\3\2\2\2\u0265\u0262\3\2\2\2\u0266\61\3\2\2"+
		"\2\u0267\u0268\5\64\33\2\u0268\u0269\7\u0111\2\2\u0269\u026a\5:\36\2\u026a"+
		"\u026d\3\2\2\2\u026b\u026d\5:\36\2\u026c\u0267\3\2\2\2\u026c\u026b\3\2"+
		"\2\2\u026d\63\3\2\2\2\u026e\u0273\5\66\34\2\u026f\u0270\7\u0111\2\2\u0270"+
		"\u0272\5\66\34\2\u0271\u026f\3\2\2\2\u0272\u0275\3\2\2\2\u0273\u0271\3"+
		"\2\2\2\u0273\u0274\3\2\2\2\u0274\65\3\2\2\2\u0275\u0273\3\2\2\2\u0276"+
		"\u027c\b\34\1\2\u0277\u0278\58\35\2\u0278\u0279\b\34\1\2\u0279\u027b\3"+
		"\2\2\2\u027a\u0277\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027c"+
		"\u027d\3\2\2\2\u027d\u027f\3\2\2\2\u027e\u027c\3\2\2\2\u027f\u0286\5f"+
		"\64\2\u0280\u0281\6\34k\2\u0281\u0282\5\u0098M\2\u0282\u0283\b\34\1\2"+
		"\u0283\u0287\3\2\2\2\u0284\u0285\6\34l\2\u0285\u0287\b\34\1\2\u0286\u0280"+
		"\3\2\2\2\u0286\u0284\3\2\2\2\u0287\67\3\2\2\2\u0288\u0289\7\32\2\2\u0289"+
		"\u028a\b\35\1\2\u028a\u0295\6\35m\3\u028b\u028c\7>\2\2\u028c\u028d\b\35"+
		"\1\2\u028d\u0295\6\35n\3\u028e\u028f\7A\2\2\u028f\u0290\b\35\1\2\u0290"+
		"\u0295\6\35o\3\u0291\u0292\7?\2\2\u0292\u0293\b\35\1\2\u0293\u0295\6\35"+
		"p\3\u0294\u0288\3\2\2\2\u0294\u028b\3\2\2\2\u0294\u028e\3\2\2\2\u0294"+
		"\u0291\3\2\2\2\u02959\3\2\2\2\u0296\u0297\5<\37\2\u0297\u0298\b\36\1\2"+
		"\u0298\u029d\3\2\2\2\u0299\u029a\5\66\34\2\u029a\u029b\b\36\1\2\u029b"+
		"\u029d\3\2\2\2\u029c\u0296\3\2\2\2\u029c\u0299\3\2\2\2\u029d;\3\2\2\2"+
		"\u029e\u02a4\b\37\1\2\u029f\u02a0\58\35\2\u02a0\u02a1\b\37\1\2\u02a1\u02a3"+
		"\3\2\2\2\u02a2\u029f\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4"+
		"\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a8\5f"+
		"\64\2\u02a8\u02a9\7\u0114\2\2\u02a9\u02b0\b\37\1\2\u02aa\u02ab\6\37q\2"+
		"\u02ab\u02ac\5\u0098M\2\u02ac\u02ad\b\37\1\2\u02ad\u02b1\3\2\2\2\u02ae"+
		"\u02af\6\37r\2\u02af\u02b1\b\37\1\2\u02b0\u02aa\3\2\2\2\u02b0\u02ae\3"+
		"\2\2\2\u02b1=\3\2\2\2\u02b2\u02b3\7\66\2\2\u02b3\u02b4\5@!\2\u02b4?\3"+
		"\2\2\2\u02b5\u02ba\5B\"\2\u02b6\u02b7\7\u0111\2\2\u02b7\u02b9\5B\"\2\u02b8"+
		"\u02b6\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2"+
		"\2\2\u02bbA\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\5x=\2\u02beC\3\2\2"+
		"\2\u02bf\u02c0\7B\2\2\u02c0\u02c1\7\u0110\2\2\u02c1\u02c2\6#s\3\u02c2"+
		"\u02c4\b#\1\2\u02c3\u02c5\5F$\2\u02c4\u02c3\3\2\2\2\u02c5\u02c6\3\2\2"+
		"\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9"+
		"\b#\1\2\u02c9\u02cd\3\2\2\2\u02ca\u02cb\6#t\3\u02cb\u02cd\b#\1\2\u02cc"+
		"\u02bf\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cdE\3\2\2\2\u02ce\u02d1\5H%\2\u02cf"+
		"\u02d1\5J&\2\u02d0\u02ce\3\2\2\2\u02d0\u02cf\3\2\2\2\u02d1G\3\2\2\2\u02d2"+
		"\u02d3\5\u0096L\2\u02d3\u02d4\7\u0110\2\2\u02d4\u02d5\b%\1\2\u02d5I\3"+
		"\2\2\2\u02d6\u02d7\7D\2\2\u02d7\u05c5\b&\1\2\u02d8\u02d9\7E\2\2\u02d9"+
		"\u05c5\b&\1\2\u02da\u02dc\7\u0108\2\2\u02db\u02da\3\2\2\2\u02db\u02dc"+
		"\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\7F\2\2\u02de\u02ec\b&\1\2\u02df"+
		"\u02e0\6&u\2\u02e0\u02e1\5\u009eP\2\u02e1\u02e2\b&\1\2\u02e2\u02ed\3\2"+
		"\2\2\u02e3\u02e9\6&v\2\u02e4\u02e5\5\u0098M\2\u02e5\u02e6\b&\1\2\u02e6"+
		"\u02ea\3\2\2\2\u02e7\u02e8\7\64\2\2\u02e8\u02ea\b&\1\2\u02e9\u02e4\3\2"+
		"\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ed\b&\1\2\u02ec"+
		"\u02df\3\2\2\2\u02ec\u02e3\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u05c5\b&"+
		"\1\2\u02ef\u02f0\7G\2\2\u02f0\u02f1\6&w\2\u02f1\u05c5\b&\1\2\u02f2\u02f3"+
		"\7H\2\2\u02f3\u02f4\6&x\2\u02f4\u05c5\b&\1\2\u02f5\u02f6\7I\2\2\u02f6"+
		"\u02f7\6&y\2\u02f7\u05c5\b&\1\2\u02f8\u02f9\7J\2\2\u02f9\u02fa\6&z\2\u02fa"+
		"\u05c5\b&\1\2\u02fb\u02fc\7K\2\2\u02fc\u02fd\5v<\2\u02fd\u02fe\b&\1\2"+
		"\u02fe\u05c5\3\2\2\2\u02ff\u0300\7L\2\2\u0300\u05c5\b&\1\2\u0301\u0302"+
		"\7M\2\2\u0302\u05c5\b&\1\2\u0303\u0305\7\u0108\2\2\u0304\u0303\3\2\2\2"+
		"\u0304\u0305\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0307\7N\2\2\u0307\u0315"+
		"\b&\1\2\u0308\u0309\6&{\2\u0309\u030a\5\u009eP\2\u030a\u030b\b&\1\2\u030b"+
		"\u0316\3\2\2\2\u030c\u0312\6&|\2\u030d\u030e\5\u0098M\2\u030e\u030f\b"+
		"&\1\2\u030f\u0313\3\2\2\2\u0310\u0311\7\64\2\2\u0311\u0313\b&\1\2\u0312"+
		"\u030d\3\2\2\2\u0312\u0310\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\b&"+
		"\1\2\u0315\u0308\3\2\2\2\u0315\u030c\3\2\2\2\u0316\u0317\3\2\2\2\u0317"+
		"\u05c5\b&\1\2\u0318\u0319\7O\2\2\u0319\u031a\6&}\2\u031a\u05c5\b&\1\2"+
		"\u031b\u031c\7P\2\2\u031c\u031d\6&~\2\u031d\u05c5\b&\1\2\u031e\u031f\7"+
		"Q\2\2\u031f\u0320\6&\177\2\u0320\u05c5\b&\1\2\u0321\u0322\7R\2\2\u0322"+
		"\u0323\6&\u0080\2\u0323\u05c5\b&\1\2\u0324\u0325\7S\2\2\u0325\u05c5\b"+
		"&\1\2\u0326\u0327\7T\2\2\u0327\u05c5\b&\1\2\u0328\u0329\7U\2\2\u0329\u05c5"+
		"\b&\1\2\u032a\u032b\7V\2\2\u032b\u032c\5\u009aN\2\u032c\u032d\b&\1\2\u032d"+
		"\u05c5\3\2\2\2\u032e\u032f\7W\2\2\u032f\u05c5\b&\1\2\u0330\u0331\7X\2"+
		"\2\u0331\u05c5\b&\1\2\u0332\u0333\7Y\2\2\u0333\u0334\5v<\2\u0334\u0335"+
		"\b&\1\2\u0335\u05c5\3\2\2\2\u0336\u0337\7Z\2\2\u0337\u05c5\b&\1\2\u0338"+
		"\u0339\7[\2\2\u0339\u05c5\b&\1\2\u033a\u033b\7\\\2\2\u033b\u05c5\b&\1"+
		"\2\u033c\u033d\7]\2\2\u033d\u05c5\b&\1\2\u033e\u033f\7^\2\2\u033f\u05c5"+
		"\b&\1\2\u0340\u0341\7_\2\2\u0341\u05c5\b&\1\2\u0342\u0343\7`\2\2\u0343"+
		"\u05c5\b&\1\2\u0344\u0345\7a\2\2\u0345\u05c5\b&\1\2\u0346\u0347\7b\2\2"+
		"\u0347\u05c5\b&\1\2\u0348\u0349\7c\2\2\u0349\u05c5\b&\1\2\u034a\u034b"+
		"\7d\2\2\u034b\u05c5\b&\1\2\u034c\u034e\7\u0108\2\2\u034d\u034c\3\2\2\2"+
		"\u034d\u034e\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0350\7e\2\2\u0350\u035e"+
		"\b&\1\2\u0351\u0352\6&\u0081\2\u0352\u0353\5\u009eP\2\u0353\u0354\b&\1"+
		"\2\u0354\u035f\3\2\2\2\u0355\u035b\6&\u0082\2\u0356\u0357\5\u0098M\2\u0357"+
		"\u0358\b&\1\2\u0358\u035c\3\2\2\2\u0359\u035a\7\64\2\2\u035a\u035c\b&"+
		"\1\2\u035b\u0356\3\2\2\2\u035b\u0359\3\2\2\2\u035c\u035d\3\2\2\2\u035d"+
		"\u035f\b&\1\2\u035e\u0351\3\2\2\2\u035e\u0355\3\2\2\2\u035f\u0360\3\2"+
		"\2\2\u0360\u05c5\b&\1\2\u0361\u0362\7f\2\2\u0362\u0363\6&\u0083\2\u0363"+
		"\u05c5\b&\1\2\u0364\u0365\7g\2\2\u0365\u0366\6&\u0084\2\u0366\u05c5\b"+
		"&\1\2\u0367\u0368\7h\2\2\u0368\u0369\6&\u0085\2\u0369\u05c5\b&\1\2\u036a"+
		"\u036b\7i\2\2\u036b\u036c\6&\u0086\2\u036c\u05c5\b&\1\2\u036d\u036e\7"+
		"j\2\2\u036e\u05c5\b&\1\2\u036f\u0370\7k\2\2\u0370\u05c5\b&\1\2\u0371\u0372"+
		"\7l\2\2\u0372\u05c5\b&\1\2\u0373\u0374\7m\2\2\u0374\u05c5\b&\1\2\u0375"+
		"\u0377\7\u0108\2\2\u0376\u0375\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0378"+
		"\3\2\2\2\u0378\u0379\7n\2\2\u0379\u0387\b&\1\2\u037a\u037b\6&\u0087\2"+
		"\u037b\u037c\5\u009eP\2\u037c\u037d\b&\1\2\u037d\u0388\3\2\2\2\u037e\u0384"+
		"\6&\u0088\2\u037f\u0380\5\u0098M\2\u0380\u0381\b&\1\2\u0381\u0385\3\2"+
		"\2\2\u0382\u0383\7\64\2\2\u0383\u0385\b&\1\2\u0384\u037f\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0388\b&\1\2\u0387\u037a\3\2"+
		"\2\2\u0387\u037e\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u05c5\b&\1\2\u038a"+
		"\u038b\7o\2\2\u038b\u038c\6&\u0089\2\u038c\u05c5\b&\1\2\u038d\u038e\7"+
		"p\2\2\u038e\u038f\6&\u008a\2\u038f\u05c5\b&\1\2\u0390\u0391\7q\2\2\u0391"+
		"\u0392\6&\u008b\2\u0392\u05c5\b&\1\2\u0393\u0394\7r\2\2\u0394\u0395\6"+
		"&\u008c\2\u0395\u05c5\b&\1\2\u0396\u0397\7s\2\2\u0397\u05c5\b&\1\2\u0398"+
		"\u0399\7t\2\2\u0399\u05c5\b&\1\2\u039a\u039b\7u\2\2\u039b\u05c5\b&\1\2"+
		"\u039c\u039d\7v\2\2\u039d\u05c5\b&\1\2\u039e\u039f\7w\2\2\u039f\u05c5"+
		"\b&\1\2\u03a0\u03a1\7x\2\2\u03a1\u05c5\b&\1\2\u03a2\u03a3\7y\2\2\u03a3"+
		"\u05c5\b&\1\2\u03a4\u03a5\7z\2\2\u03a5\u05c5\b&\1\2\u03a6\u03a7\7{\2\2"+
		"\u03a7\u05c5\b&\1\2\u03a8\u03a9\7|\2\2\u03a9\u05c5\b&\1\2\u03aa\u03ab"+
		"\7}\2\2\u03ab\u05c5\b&\1\2\u03ac\u03ad\7~\2\2\u03ad\u05c5\b&\1\2\u03ae"+
		"\u03af\7\177\2\2\u03af\u05c5\b&\1\2\u03b0\u03b1\7\u0080\2\2\u03b1\u05c5"+
		"\b&\1\2\u03b2\u03b3\7\u0081\2\2\u03b3\u05c5\b&\1\2\u03b4\u03b5\7\u0082"+
		"\2\2\u03b5\u05c5\b&\1\2\u03b6\u03b7\7\u0083\2\2\u03b7\u05c5\b&\1\2\u03b8"+
		"\u03b9\7\u0084\2\2\u03b9\u05c5\b&\1\2\u03ba\u03bb\7\u0085\2\2\u03bb\u05c5"+
		"\b&\1\2\u03bc\u03be\7\u0108\2\2\u03bd\u03bc\3\2\2\2\u03bd\u03be\3\2\2"+
		"\2\u03be\u03bf\3\2\2\2\u03bf\u03c0\7\u0086\2\2\u03c0\u03ce\b&\1\2\u03c1"+
		"\u03c2\6&\u008d\2\u03c2\u03c3\5\u009eP\2\u03c3\u03c4\b&\1\2\u03c4\u03cf"+
		"\3\2\2\2\u03c5\u03cb\6&\u008e\2\u03c6\u03c7\5\u0098M\2\u03c7\u03c8\b&"+
		"\1\2\u03c8\u03cc\3\2\2\2\u03c9\u03ca\7\64\2\2\u03ca\u03cc\b&\1\2\u03cb"+
		"\u03c6\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03cf\b&"+
		"\1\2\u03ce\u03c1\3\2\2\2\u03ce\u03c5\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0"+
		"\u05c5\b&\1\2\u03d1\u03d2\7\u0087\2\2\u03d2\u03d3\6&\u008f\2\u03d3\u05c5"+
		"\b&\1\2\u03d4\u03d5\7\u0088\2\2\u03d5\u03d6\6&\u0090\2\u03d6\u05c5\b&"+
		"\1\2\u03d7\u03d8\7\u0089\2\2\u03d8\u03d9\6&\u0091\2\u03d9\u05c5\b&\1\2"+
		"\u03da\u03db\7\u008a\2\2\u03db\u03dc\6&\u0092\2\u03dc\u05c5\b&\1\2\u03dd"+
		"\u03de\7\u008b\2\2\u03de\u05c5\b&\1\2\u03df\u03e0\7\u008c\2\2\u03e0\u05c5"+
		"\b&\1\2\u03e1\u03e2\7\u008d\2\2\u03e2\u05c5\b&\1\2\u03e3\u03e4\7\u008e"+
		"\2\2\u03e4\u05c5\b&\1\2\u03e5\u03e7\7\u0108\2\2\u03e6\u03e5\3\2\2\2\u03e6"+
		"\u03e7\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03e9\7\u008f\2\2\u03e9\u03f7"+
		"\b&\1\2\u03ea\u03eb\6&\u0093\2\u03eb\u03ec\5\u009eP\2\u03ec\u03ed\b&\1"+
		"\2\u03ed\u03f8\3\2\2\2\u03ee\u03f4\6&\u0094\2\u03ef\u03f0\5\u0098M\2\u03f0"+
		"\u03f1\b&\1\2\u03f1\u03f5\3\2\2\2\u03f2\u03f3\7\64\2\2\u03f3\u03f5\b&"+
		"\1\2\u03f4\u03ef\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\u03f8\b&\1\2\u03f7\u03ea\3\2\2\2\u03f7\u03ee\3\2\2\2\u03f8\u03f9\3\2"+
		"\2\2\u03f9\u05c5\b&\1\2\u03fa\u03fb\7\u0090\2\2\u03fb\u03fc\6&\u0095\2"+
		"\u03fc\u05c5\b&\1\2\u03fd\u03fe\7\u0091\2\2\u03fe\u03ff\6&\u0096\2\u03ff"+
		"\u05c5\b&\1\2\u0400\u0401\7\u0092\2\2\u0401\u0402\6&\u0097\2\u0402\u05c5"+
		"\b&\1\2\u0403\u0404\7\u0093\2\2\u0404\u0405\6&\u0098\2\u0405\u05c5\b&"+
		"\1\2\u0406\u0407\7\u0094\2\2\u0407\u05c5\b&\1\2\u0408\u0409\7\u0095\2"+
		"\2\u0409\u040a\5L\'\2\u040a\u040b\b&\1\2\u040b\u05c5\3\2\2\2\u040c\u040d"+
		"\7\u0096\2\2\u040d\u040e\5L\'\2\u040e\u040f\b&\1\2\u040f\u05c5\3\2\2\2"+
		"\u0410\u0411\t\2\2\2\u0411\u0412\5\u0096L\2\u0412\u0413\b&\1\2\u0413\u05c5"+
		"\3\2\2\2\u0414\u0415\7\u0098\2\2\u0415\u05c5\b&\1\2\u0416\u0417\7\u0099"+
		"\2\2\u0417\u05c5\b&\1\2\u0418\u0419\7\u009a\2\2\u0419\u05c5\b&\1\2\u041a"+
		"\u041b\7\u009b\2\2\u041b\u05c5\b&\1\2\u041c\u041d\7\u009c\2\2\u041d\u05c5"+
		"\b&\1\2\u041e\u041f\7\u009d\2\2\u041f\u05c5\b&\1\2\u0420\u0421\7\u009e"+
		"\2\2\u0421\u05c5\b&\1\2\u0422\u0423\7\u009f\2\2\u0423\u05c5\b&\1\2\u0424"+
		"\u0425\7\u00a0\2\2\u0425\u05c5\b&\1\2\u0426\u0427\7\u00a1\2\2\u0427\u05c5"+
		"\b&\1\2\u0428\u0429\7\u00a2\2\2\u0429\u05c5\b&\1\2\u042a\u042b\7\u00a3"+
		"\2\2\u042b\u05c5\b&\1\2\u042c\u042d\7\u00a4\2\2\u042d\u05c5\b&\1\2\u042e"+
		"\u042f\7\u00a5\2\2\u042f\u05c5\b&\1\2\u0430\u0431\7\u00a6\2\2\u0431\u05c5"+
		"\b&\1\2\u0432\u0433\7\u00a7\2\2\u0433\u05c5\b&\1\2\u0434\u0435\7\u00a8"+
		"\2\2\u0435\u05c5\b&\1\2\u0436\u0437\7\u00a9\2\2\u0437\u05c5\b&\1\2\u0438"+
		"\u0439\7\u00aa\2\2\u0439\u043a\5\u0096L\2\u043a\u043b\b&\1\2\u043b\u05c5"+
		"\3\2\2\2\u043c\u043d\7\u00ab\2\2\u043d\u043e\5\u0096L\2\u043e\u043f\b"+
		"&\1\2\u043f\u05c5\3\2\2\2\u0440\u0441\7\u00ac\2\2\u0441\u0442\5\u0096"+
		"L\2\u0442\u0443\b&\1\2\u0443\u05c5\3\2\2\2\u0444\u0445\7\u00ad\2\2\u0445"+
		"\u0446\5\u0096L\2\u0446\u0447\b&\1\2\u0447\u05c5\3\2\2\2\u0448\u0449\7"+
		"\u00ae\2\2\u0449\u044a\5\u0096L\2\u044a\u044b\b&\1\2\u044b\u05c5\3\2\2"+
		"\2\u044c\u044d\7\u00af\2\2\u044d\u044e\5\u0096L\2\u044e\u044f\b&\1\2\u044f"+
		"\u05c5\3\2\2\2\u0450\u0451\7\u00b0\2\2\u0451\u0452\5\u0096L\2\u0452\u0453"+
		"\b&\1\2\u0453\u05c5\3\2\2\2\u0454\u0455\7\u00b1\2\2\u0455\u0456\5\u0096"+
		"L\2\u0456\u0457\b&\1\2\u0457\u05c5\3\2\2\2\u0458\u0459\7\u00b2\2\2\u0459"+
		"\u045a\5\u0096L\2\u045a\u045b\b&\1\2\u045b\u05c5\3\2\2\2\u045c\u045d\7"+
		"\u00b3\2\2\u045d\u045e\5\u0096L\2\u045e\u045f\b&\1\2\u045f\u05c5\3\2\2"+
		"\2\u0460\u0461\7\u00b4\2\2\u0461\u0462\5\u0096L\2\u0462\u0463\b&\1\2\u0463"+
		"\u05c5\3\2\2\2\u0464\u0465\7\u00b5\2\2\u0465\u0466\5\u0096L\2\u0466\u0467"+
		"\b&\1\2\u0467\u05c5\3\2\2\2\u0468\u0469\7\u00b6\2\2\u0469\u046a\5\u0096"+
		"L\2\u046a\u046b\b&\1\2\u046b\u05c5\3\2\2\2\u046c\u046d\7\u00b7\2\2\u046d"+
		"\u046e\5\u0096L\2\u046e\u046f\b&\1\2\u046f\u05c5\3\2\2\2\u0470\u0471\7"+
		"\u00b8\2\2\u0471\u0472\5\u0096L\2\u0472\u0473\b&\1\2\u0473\u05c5\3\2\2"+
		"\2\u0474\u0475\7\u00b9\2\2\u0475\u0476\5\u0096L\2\u0476\u0477\b&\1\2\u0477"+
		"\u05c5\3\2\2\2\u0478\u047a\7\u0108\2\2\u0479\u0478\3\2\2\2\u0479\u047a"+
		"\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c\7\u00ba\2\2\u047c\u048a\b&\1"+
		"\2\u047d\u047e\6&\u0099\2\u047e\u047f\5\u009eP\2\u047f\u0480\b&\1\2\u0480"+
		"\u048b\3\2\2\2\u0481\u0487\6&\u009a\2\u0482\u0483\5\u0098M\2\u0483\u0484"+
		"\b&\1\2\u0484\u0488\3\2\2\2\u0485\u0486\7\64\2\2\u0486\u0488\b&\1\2\u0487"+
		"\u0482\3\2\2\2\u0487\u0485\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048b\b&"+
		"\1\2\u048a\u047d\3\2\2\2\u048a\u0481\3\2\2\2\u048b\u048c\3\2\2\2\u048c"+
		"\u048d\7\u0111\2\2\u048d\u048e\5\u00a0Q\2\u048e\u048f\b&\1\2\u048f\u05c5"+
		"\3\2\2\2\u0490\u0492\7\u0108\2\2\u0491\u0490\3\2\2\2\u0491\u0492\3\2\2"+
		"\2\u0492\u0493\3\2\2\2\u0493\u0494\7\u00bb\2\2\u0494\u04a2\b&\1\2\u0495"+
		"\u0496\6&\u009b\2\u0496\u0497\5\u009eP\2\u0497\u0498\b&\1\2\u0498\u04a3"+
		"\3\2\2\2\u0499\u049f\6&\u009c\2\u049a\u049b\5\u0098M\2\u049b\u049c\b&"+
		"\1\2\u049c\u04a0\3\2\2\2\u049d\u049e\7\64\2\2\u049e\u04a0\b&\1\2\u049f"+
		"\u049a\3\2\2\2\u049f\u049d\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a3\b&"+
		"\1\2\u04a2\u0495\3\2\2\2\u04a2\u0499\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4"+
		"\u05c5\b&\1\2\u04a5\u04a6\7\u00bc\2\2\u04a6\u04a7\6&\u009d\2\u04a7\u05c5"+
		"\b&\1\2\u04a8\u04a9\7\u00bd\2\2\u04a9\u04aa\6&\u009e\2\u04aa\u05c5\b&"+
		"\1\2\u04ab\u04ac\7\u00be\2\2\u04ac\u04ad\6&\u009f\2\u04ad\u05c5\b&\1\2"+
		"\u04ae\u04af\7\u00bf\2\2\u04af\u04b0\6&\u00a0\2\u04b0\u05c5\b&\1\2\u04b1"+
		"\u04b2\7\u00c0\2\2\u04b2\u05c5\b&\1\2\u04b3\u04b4\7\u00c1\2\2\u04b4\u05c5"+
		"\b&\1\2\u04b5\u04b6\7\"\2\2\u04b6\u04b7\5v<\2\u04b7\u04b8\b&\1\2\u04b8"+
		"\u05c5\3\2\2\2\u04b9\u04ba\7\u00c2\2\2\u04ba\u04bb\5P)\2\u04bb\u04bc\b"+
		"&\1\2\u04bc\u05c5\3\2\2\2\u04bd\u04be\7\u00c3\2\2\u04be\u04bf\5N(\2\u04bf"+
		"\u04c0\b&\1\2\u04c0\u05c5\3\2\2\2\u04c1\u04c2\7\u00c4\2\2\u04c2\u04c3"+
		"\5N(\2\u04c3\u04c4\b&\1\2\u04c4\u05c5\3\2\2\2\u04c5\u04c6\7\u00c5\2\2"+
		"\u04c6\u04c7\5N(\2\u04c7\u04c8\b&\1\2\u04c8\u05c5\3\2\2\2\u04c9\u04ca"+
		"\7\u00c6\2\2\u04ca\u04cb\5N(\2\u04cb\u04cc\b&\1\2\u04cc\u05c5\3\2\2\2"+
		"\u04cd\u04ce\7\u00c7\2\2\u04ce\u05c5\b&\1\2\u04cf\u04d0\7\u00c8\2\2\u04d0"+
		"\u05c5\b&\1\2\u04d1\u04d2\7\u00c9\2\2\u04d2\u05c5\b&\1\2\u04d3\u04d4\7"+
		"\u00ca\2\2\u04d4\u05c5\b&\1\2\u04d5\u04d6\7\u00cb\2\2\u04d6\u05c5\b&\1"+
		"\2\u04d7\u04d9\7\u0108\2\2\u04d8\u04d7\3\2\2\2\u04d8\u04d9\3\2\2\2\u04d9"+
		"\u04da\3\2\2\2\u04da\u04db\7\u00cc\2\2\u04db\u04e9\b&\1\2\u04dc\u04dd"+
		"\6&\u00a1\2\u04dd\u04de\5\u009eP\2\u04de\u04df\b&\1\2\u04df\u04ea\3\2"+
		"\2\2\u04e0\u04e6\6&\u00a2\2\u04e1\u04e2\5\u0098M\2\u04e2\u04e3\b&\1\2"+
		"\u04e3\u04e7\3\2\2\2\u04e4\u04e5\7\64\2\2\u04e5\u04e7\b&\1\2\u04e6\u04e1"+
		"\3\2\2\2\u04e6\u04e4\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u04ea\b&\1\2\u04e9"+
		"\u04dc\3\2\2\2\u04e9\u04e0\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb\u05c5\b&"+
		"\1\2\u04ec\u04ed\7\u00cd\2\2\u04ed\u04ee\6&\u00a3\2\u04ee\u05c5\b&\1\2"+
		"\u04ef\u04f0\7\u00ce\2\2\u04f0\u04f1\6&\u00a4\2\u04f1\u05c5\b&\1\2\u04f2"+
		"\u04f3\7\u00cf\2\2\u04f3\u04f4\6&\u00a5\2\u04f4\u05c5\b&\1\2\u04f5\u04f6"+
		"\7\u00d0\2\2\u04f6\u04f7\6&\u00a6\2\u04f7\u05c5\b&\1\2\u04f8\u04f9\7\u00d1"+
		"\2\2\u04f9\u05c5\b&\1\2\u04fa\u04fb\7\u00d2\2\2\u04fb\u05c5\b&\1\2\u04fc"+
		"\u04fd\7\u00d3\2\2\u04fd\u05c5\b&\1\2\u04fe\u04ff\t\3\2\2\u04ff\u0500"+
		"\5\u0096L\2\u0500\u0501\b&\1\2\u0501\u05c5\3\2\2\2\u0502\u0503\7\u00d6"+
		"\2\2\u0503\u05c5\b&\1\2\u0504\u0505\7\u00d7\2\2\u0505\u05c5\b&\1\2\u0506"+
		"\u0507\7\u00d8\2\2\u0507\u05c5\b&\1\2\u0508\u0509\7\u00d9\2\2\u0509\u05c5"+
		"\b&\1\2\u050a\u050b\7\u00da\2\2\u050b\u05c5\b&\1\2\u050c\u050d\7\u00db"+
		"\2\2\u050d\u05c5\b&\1\2\u050e\u050f\7\u00dc\2\2\u050f\u05c5\b&\1\2\u0510"+
		"\u0511\7\u00dd\2\2\u0511\u05c5\b&\1\2\u0512\u0513\7\u00de\2\2\u0513\u05c5"+
		"\b&\1\2\u0514\u0515\7\u00df\2\2\u0515\u05c5\b&\1\2\u0516\u0517\t\4\2\2"+
		"\u0517\u0518\5Z.\2\u0518\u0519\b&\1\2\u0519\u05c5\3\2\2\2\u051a\u051b"+
		"\t\4\2\2\u051b\u051c\78\2\2\u051c\u05c5\b&\1\2\u051d\u051e\t\4\2\2\u051e"+
		"\u051f\7\31\2\2\u051f\u05c5\b&\1\2\u0520\u0521\t\4\2\2\u0521\u0522\7("+
		"\2\2\u0522\u05c5\b&\1\2\u0523\u0524\7\u00e3\2\2\u0524\u05c5\b&\1\2\u0525"+
		"\u0527\7\u0108\2\2\u0526\u0525\3\2\2\2\u0526\u0527\3\2\2\2\u0527\u0528"+
		"\3\2\2\2\u0528\u0529\7\u00e4\2\2\u0529\u0537\b&\1\2\u052a\u052b\6&\u00a7"+
		"\2\u052b\u052c\5\u009eP\2\u052c\u052d\b&\1\2\u052d\u0538\3\2\2\2\u052e"+
		"\u0534\6&\u00a8\2\u052f\u0530\5\u0098M\2\u0530\u0531\b&\1\2\u0531\u0535"+
		"\3\2\2\2\u0532\u0533\7\64\2\2\u0533\u0535\b&\1\2\u0534\u052f\3\2\2\2\u0534"+
		"\u0532\3\2\2\2\u0535\u0536\3\2\2\2\u0536\u0538\b&\1\2\u0537\u052a\3\2"+
		"\2\2\u0537\u052e\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u05c5\b&\1\2\u053a"+
		"\u053b\7\u00e5\2\2\u053b\u053c\6&\u00a9\2\u053c\u05c5\b&\1\2\u053d\u053e"+
		"\7\u00e6\2\2\u053e\u053f\6&\u00aa\2\u053f\u05c5\b&\1\2\u0540\u0541\7\u00e7"+
		"\2\2\u0541\u0542\6&\u00ab\2\u0542\u05c5\b&\1\2\u0543\u0544\7\u00e8\2\2"+
		"\u0544\u0545\6&\u00ac\2\u0545\u05c5\b&\1\2\u0546\u0547\7\u00e9\2\2\u0547"+
		"\u05c5\b&\1\2\u0548\u0549\7\u00ea\2\2\u0549\u05c5\b&\1\2\u054a\u054b\7"+
		"\u00eb\2\2\u054b\u054c\5\\/\2\u054c\u054d\b&\1\2\u054d\u05c5\3\2\2\2\u054e"+
		"\u054f\7\u00ec\2\2\u054f\u05c5\b&\1\2\u0550\u0551\7\u00ed\2\2\u0551\u05c5"+
		"\b&\1\2\u0552\u0553\7\u00ee\2\2\u0553\u05c5\b&\1\2\u0554\u0555\7\u00ef"+
		"\2\2\u0555\u05c5\b&\1\2\u0556\u0557\7\u00f0\2\2\u0557\u05c5\b&\1\2\u0558"+
		"\u055a\7\u0108\2\2\u0559\u0558\3\2\2\2\u0559\u055a\3\2\2\2\u055a\u055b"+
		"\3\2\2\2\u055b\u055c\7\u00f1\2\2\u055c\u056a\b&\1\2\u055d\u055e\6&\u00ad"+
		"\2\u055e\u055f\5\u009eP\2\u055f\u0560\b&\1\2\u0560\u056b\3\2\2\2\u0561"+
		"\u0567\6&\u00ae\2\u0562\u0563\5\u0098M\2\u0563\u0564\b&\1\2\u0564\u0568"+
		"\3\2\2\2\u0565\u0566\7\64\2\2\u0566\u0568\b&\1\2\u0567\u0562\3\2\2\2\u0567"+
		"\u0565\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u056b\b&\1\2\u056a\u055d\3\2"+
		"\2\2\u056a\u0561\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u05c5\b&\1\2\u056d"+
		"\u056e\7\u00f2\2\2\u056e\u056f\6&\u00af\2\u056f\u05c5\b&\1\2\u0570\u0571"+
		"\7\u00f3\2\2\u0571\u0572\6&\u00b0\2\u0572\u05c5\b&\1\2\u0573\u0574\7\u00f4"+
		"\2\2\u0574\u0575\6&\u00b1\2\u0575\u05c5\b&\1\2\u0576\u0577\7\u00f5\2\2"+
		"\u0577\u0578\6&\u00b2\2\u0578\u05c5\b&\1\2\u0579\u057a\7\u00f6\2\2\u057a"+
		"\u05c5\b&\1\2\u057b\u057c\7\u00f7\2\2\u057c\u05c5\b&\1\2\u057d\u057e\7"+
		"\u00f8\2\2\u057e\u05c5\b&\1\2\u057f\u0580\7\u00f9\2\2\u0580\u05c5\b&\1"+
		"\2\u0581\u0582\7\u00fa\2\2\u0582\u05c5\b&\1\2\u0583\u0584\7\u00fb\2\2"+
		"\u0584\u0585\5|?\2\u0585\u0586\5\u009eP\2\u0586\u0587\6&\u00b3\3\u0587"+
		"\u0588\b&\1\2\u0588\u05c5\3\2\2\2\u0589\u058a\7\'\2\2\u058a\u058b\5x="+
		"\2\u058b\u058c\b&\1\2\u058c\u05c5\3\2\2\2\u058d\u058e\7\u00fc\2\2\u058e"+
		"\u058f\5n8\2\u058f\u0590\b&\1\2\u0590\u05c5\3\2\2\2\u0591\u0592\7\u00fd"+
		"\2\2\u0592\u05c5\b&\1\2\u0593\u0594\7\u00fe\2\2\u0594\u05c5\b&\1\2\u0595"+
		"\u0596\7\u00ff\2\2\u0596\u05c5\b&\1\2\u0597\u0598\7\u0100\2\2\u0598\u0599"+
		"\5L\'\2\u0599\u059a\b&\1\2\u059a\u05c5\3\2\2\2\u059b\u059c\7\u0101\2\2"+
		"\u059c\u059d\5L\'\2\u059d\u059e\b&\1\2\u059e\u05c5\3\2\2\2\u059f\u05a1"+
		"\7\u0108\2\2\u05a0\u059f\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1\u05a2\3\2\2"+
		"\2\u05a2\u05a3\7\u0102\2\2\u05a3\u05b1\b&\1\2\u05a4\u05a5\6&\u00b4\2\u05a5"+
		"\u05a6\5\u009eP\2\u05a6\u05a7\b&\1\2\u05a7\u05b2\3\2\2\2\u05a8\u05ae\6"+
		"&\u00b5\2\u05a9\u05aa\5\u0098M\2\u05aa\u05ab\b&\1\2\u05ab\u05af\3\2\2"+
		"\2\u05ac\u05ad\7\64\2\2\u05ad\u05af\b&\1\2\u05ae\u05a9\3\2\2\2\u05ae\u05ac"+
		"\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u05b2\b&\1\2\u05b1\u05a4\3\2\2\2\u05b1"+
		"\u05a8\3\2\2\2\u05b2\u05b3\3\2\2\2\u05b3\u05c5\b&\1\2\u05b4\u05b5\7-\2"+
		"\2\u05b5\u05c5\b&\1\2\u05b6\u05b7\7\u0103\2\2\u05b7\u05c5\b&\1\2\u05b8"+
		"\u05b9\7\u0104\2\2\u05b9\u05c5\b&\1\2\u05ba\u05bb\7\u0105\2\2\u05bb\u05bc"+
		"\5\u009cO\2\u05bc\u05bd\b&\1\2\u05bd\u05c5\3\2\2\2\u05be\u05bf\7\u0106"+
		"\2\2\u05bf\u05c5\b&\1\2\u05c0\u05c1\7\u0107\2\2\u05c1\u05c2\5`\61\2\u05c2"+
		"\u05c3\b&\1\2\u05c3\u05c5\3\2\2\2\u05c4\u02d6\3\2\2\2\u05c4\u02d8\3\2"+
		"\2\2\u05c4\u02db\3\2\2\2\u05c4\u02ef\3\2\2\2\u05c4\u02f2\3\2\2\2\u05c4"+
		"\u02f5\3\2\2\2\u05c4\u02f8\3\2\2\2\u05c4\u02fb\3\2\2\2\u05c4\u02ff\3\2"+
		"\2\2\u05c4\u0301\3\2\2\2\u05c4\u0304\3\2\2\2\u05c4\u0318\3\2\2\2\u05c4"+
		"\u031b\3\2\2\2\u05c4\u031e\3\2\2\2\u05c4\u0321\3\2\2\2\u05c4\u0324\3\2"+
		"\2\2\u05c4\u0326\3\2\2\2\u05c4\u0328\3\2\2\2\u05c4\u032a\3\2\2\2\u05c4"+
		"\u032e\3\2\2\2\u05c4\u0330\3\2\2\2\u05c4\u0332\3\2\2\2\u05c4\u0336\3\2"+
		"\2\2\u05c4\u0338\3\2\2\2\u05c4\u033a\3\2\2\2\u05c4\u033c\3\2\2\2\u05c4"+
		"\u033e\3\2\2\2\u05c4\u0340\3\2\2\2\u05c4\u0342\3\2\2\2\u05c4\u0344\3\2"+
		"\2\2\u05c4\u0346\3\2\2\2\u05c4\u0348\3\2\2\2\u05c4\u034a\3\2\2\2\u05c4"+
		"\u034d\3\2\2\2\u05c4\u0361\3\2\2\2\u05c4\u0364\3\2\2\2\u05c4\u0367\3\2"+
		"\2\2\u05c4\u036a\3\2\2\2\u05c4\u036d\3\2\2\2\u05c4\u036f\3\2\2\2\u05c4"+
		"\u0371\3\2\2\2\u05c4\u0373\3\2\2\2\u05c4\u0376\3\2\2\2\u05c4\u038a\3\2"+
		"\2\2\u05c4\u038d\3\2\2\2\u05c4\u0390\3\2\2\2\u05c4\u0393\3\2\2\2\u05c4"+
		"\u0396\3\2\2\2\u05c4\u0398\3\2\2\2\u05c4\u039a\3\2\2\2\u05c4\u039c\3\2"+
		"\2\2\u05c4\u039e\3\2\2\2\u05c4\u03a0\3\2\2\2\u05c4\u03a2\3\2\2\2\u05c4"+
		"\u03a4\3\2\2\2\u05c4\u03a6\3\2\2\2\u05c4\u03a8\3\2\2\2\u05c4\u03aa\3\2"+
		"\2\2\u05c4\u03ac\3\2\2\2\u05c4\u03ae\3\2\2\2\u05c4\u03b0\3\2\2\2\u05c4"+
		"\u03b2\3\2\2\2\u05c4\u03b4\3\2\2\2\u05c4\u03b6\3\2\2\2\u05c4\u03b8\3\2"+
		"\2\2\u05c4\u03ba\3\2\2\2\u05c4\u03bd\3\2\2\2\u05c4\u03d1\3\2\2\2\u05c4"+
		"\u03d4\3\2\2\2\u05c4\u03d7\3\2\2\2\u05c4\u03da\3\2\2\2\u05c4\u03dd\3\2"+
		"\2\2\u05c4\u03df\3\2\2\2\u05c4\u03e1\3\2\2\2\u05c4\u03e3\3\2\2\2\u05c4"+
		"\u03e6\3\2\2\2\u05c4\u03fa\3\2\2\2\u05c4\u03fd\3\2\2\2\u05c4\u0400\3\2"+
		"\2\2\u05c4\u0403\3\2\2\2\u05c4\u0406\3\2\2\2\u05c4\u0408\3\2\2\2\u05c4"+
		"\u040c\3\2\2\2\u05c4\u0410\3\2\2\2\u05c4\u0414\3\2\2\2\u05c4\u0416\3\2"+
		"\2\2\u05c4\u0418\3\2\2\2\u05c4\u041a\3\2\2\2\u05c4\u041c\3\2\2\2\u05c4"+
		"\u041e\3\2\2\2\u05c4\u0420\3\2\2\2\u05c4\u0422\3\2\2\2\u05c4\u0424\3\2"+
		"\2\2\u05c4\u0426\3\2\2\2\u05c4\u0428\3\2\2\2\u05c4\u042a\3\2\2\2\u05c4"+
		"\u042c\3\2\2\2\u05c4\u042e\3\2\2\2\u05c4\u0430\3\2\2\2\u05c4\u0432\3\2"+
		"\2\2\u05c4\u0434\3\2\2\2\u05c4\u0436\3\2\2\2\u05c4\u0438\3\2\2\2\u05c4"+
		"\u043c\3\2\2\2\u05c4\u0440\3\2\2\2\u05c4\u0444\3\2\2\2\u05c4\u0448\3\2"+
		"\2\2\u05c4\u044c\3\2\2\2\u05c4\u0450\3\2\2\2\u05c4\u0454\3\2\2\2\u05c4"+
		"\u0458\3\2\2\2\u05c4\u045c\3\2\2\2\u05c4\u0460\3\2\2\2\u05c4\u0464\3\2"+
		"\2\2\u05c4\u0468\3\2\2\2\u05c4\u046c\3\2\2\2\u05c4\u0470\3\2\2\2\u05c4"+
		"\u0474\3\2\2\2\u05c4\u0479\3\2\2\2\u05c4\u0491\3\2\2\2\u05c4\u04a5\3\2"+
		"\2\2\u05c4\u04a8\3\2\2\2\u05c4\u04ab\3\2\2\2\u05c4\u04ae\3\2\2\2\u05c4"+
		"\u04b1\3\2\2\2\u05c4\u04b3\3\2\2\2\u05c4\u04b5\3\2\2\2\u05c4\u04b9\3\2"+
		"\2\2\u05c4\u04bd\3\2\2\2\u05c4\u04c1\3\2\2\2\u05c4\u04c5\3\2\2\2\u05c4"+
		"\u04c9\3\2\2\2\u05c4\u04cd\3\2\2\2\u05c4\u04cf\3\2\2\2\u05c4\u04d1\3\2"+
		"\2\2\u05c4\u04d3\3\2\2\2\u05c4\u04d5\3\2\2\2\u05c4\u04d8\3\2\2\2\u05c4"+
		"\u04ec\3\2\2\2\u05c4\u04ef\3\2\2\2\u05c4\u04f2\3\2\2\2\u05c4\u04f5\3\2"+
		"\2\2\u05c4\u04f8\3\2\2\2\u05c4\u04fa\3\2\2\2\u05c4\u04fc\3\2\2\2\u05c4"+
		"\u04fe\3\2\2\2\u05c4\u0502\3\2\2\2\u05c4\u0504\3\2\2\2\u05c4\u0506\3\2"+
		"\2\2\u05c4\u0508\3\2\2\2\u05c4\u050a\3\2\2\2\u05c4\u050c\3\2\2\2\u05c4"+
		"\u050e\3\2\2\2\u05c4\u0510\3\2\2\2\u05c4\u0512\3\2\2\2\u05c4\u0514\3\2"+
		"\2\2\u05c4\u0516\3\2\2\2\u05c4\u051a\3\2\2\2\u05c4\u051d\3\2\2\2\u05c4"+
		"\u0520\3\2\2\2\u05c4\u0523\3\2\2\2\u05c4\u0526\3\2\2\2\u05c4\u053a\3\2"+
		"\2\2\u05c4\u053d\3\2\2\2\u05c4\u0540\3\2\2\2\u05c4\u0543\3\2\2\2\u05c4"+
		"\u0546\3\2\2\2\u05c4\u0548\3\2\2\2\u05c4\u054a\3\2\2\2\u05c4\u054e\3\2"+
		"\2\2\u05c4\u0550\3\2\2\2\u05c4\u0552\3\2\2\2\u05c4\u0554\3\2\2\2\u05c4"+
		"\u0556\3\2\2\2\u05c4\u0559\3\2\2\2\u05c4\u056d\3\2\2\2\u05c4\u0570\3\2"+
		"\2\2\u05c4\u0573\3\2\2\2\u05c4\u0576\3\2\2\2\u05c4\u0579\3\2\2\2\u05c4"+
		"\u057b\3\2\2\2\u05c4\u057d\3\2\2\2\u05c4\u057f\3\2\2\2\u05c4\u0581\3\2"+
		"\2\2\u05c4\u0583\3\2\2\2\u05c4\u0589\3\2\2\2\u05c4\u058d\3\2\2\2\u05c4"+
		"\u0591\3\2\2\2\u05c4\u0593\3\2\2\2\u05c4\u0595\3\2\2\2\u05c4\u0597\3\2"+
		"\2\2\u05c4\u059b\3\2\2\2\u05c4\u05a0\3\2\2\2\u05c4\u05b4\3\2\2\2\u05c4"+
		"\u05b6\3\2\2\2\u05c4\u05b8\3\2\2\2\u05c4\u05ba\3\2\2\2\u05c4\u05be\3\2"+
		"\2\2\u05c4\u05c0\3\2\2\2\u05c5K\3\2\2\2\u05c6\u05c7\5x=\2\u05c7\u05c8"+
		"\7\u0112\2\2\u05c8\u05ca\3\2\2\2\u05c9\u05c6\3\2\2\2\u05c9\u05ca\3\2\2"+
		"\2\u05ca\u05cb\3\2\2\2\u05cb\u05cc\5\u0098M\2\u05cc\u05cd\b\'\1\2\u05cd"+
		"\u05ce\7\u0110\2\2\u05ce\u05cf\5f\64\2\u05cfM\3\2\2\2\u05d0\u05d1\5x="+
		"\2\u05d1\u05d2\7\u0112\2\2\u05d2\u05d4\3\2\2\2\u05d3\u05d0\3\2\2\2\u05d3"+
		"\u05d4\3\2\2\2\u05d4\u05da\3\2\2\2\u05d5\u05d6\5\u0098M\2\u05d6\u05d7"+
		"\b(\1\2\u05d7\u05db\3\2\2\2\u05d8\u05d9\7C\2\2\u05d9\u05db\b(\1\2\u05da"+
		"\u05d5\3\2\2\2\u05da\u05d8\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc\u05dd\7\u0110"+
		"\2\2\u05dd\u05de\5j\66\2\u05deO\3\2\2\2\u05df\u05e0\5R*\2\u05e0\u05e1"+
		"\7\u0110\2\2\u05e1\u05e2\5\u0098M\2\u05e2\u05e3\7\u0110\2\2\u05e3\u05e4"+
		"\5j\66\2\u05e4Q\3\2\2\2\u05e5\u05e6\7\u010b\2\2\u05e6\u05e7\5T+\2\u05e7"+
		"\u05e8\5V,\2\u05e8\u05e9\7\u010c\2\2\u05e9S\3\2\2\2\u05ea\u05eb\t\5\2"+
		"\2\u05eb\u05f2\5L\'\2\u05ec\u05ed\t\6\2\2\u05ed\u05f2\5N(\2\u05ee\u05ef"+
		"\7\'\2\2\u05ef\u05f0\7\u00c4\2\2\u05f0\u05f2\5N(\2\u05f1\u05ea\3\2\2\2"+
		"\u05f1\u05ec\3\2\2\2\u05f1\u05ee\3\2\2\2\u05f2U\3\2\2\2\u05f3\u05f4\7"+
		"\u0109\2\2\u05f4\u05f5\5j\66\2\u05f5\u05f6\7\u0111\2\2\u05f6\u05f7\5T"+
		"+\2\u05f7\u05f8\7\u0111\2\2\u05f8\u05f9\5j\66\2\u05f9\u05fa\7\u010a\2"+
		"\2\u05faW\3\2\2\2\u05fb\u0600\5f\64\2\u05fc\u05fd\7\u0111\2\2\u05fd\u05ff"+
		"\5f\64\2\u05fe\u05fc\3\2\2\2\u05ff\u0602\3\2\2\2\u0600\u05fe\3\2\2\2\u0600"+
		"\u0601\3\2\2\2\u0601Y\3\2\2\2\u0602\u0600\3\2\2\2\u0603\u0604\5\u00a0"+
		"Q\2\u0604\u0605\b.\1\2\u0605\u061f\3\2\2\2\u0606\u0607\5\u00a4S\2\u0607"+
		"\u0608\b.\1\2\u0608\u061f\3\2\2\2\u0609\u060a\5\u00a6T\2\u060a\u060b\b"+
		".\1\2\u060b\u061f\3\2\2\2\u060c\u060d\5\u00a8U\2\u060d\u060e\b.\1\2\u060e"+
		"\u061f\3\2\2\2\u060f\u0610\5\u00acW\2\u0610\u0611\b.\1\2\u0611\u061f\3"+
		"\2\2\2\u0612\u0613\5\u00aaV\2\u0613\u0614\b.\1\2\u0614\u061f\3\2\2\2\u0615"+
		"\u0616\5h\65\2\u0616\u0617\b.\1\2\u0617\u061f\3\2\2\2\u0618\u0619\5j\66"+
		"\2\u0619\u061a\b.\1\2\u061a\u061f\3\2\2\2\u061b\u061c\5T+\2\u061c\u061d"+
		"\b.\1\2\u061d\u061f\3\2\2\2\u061e\u0603\3\2\2\2\u061e\u0606\3\2\2\2\u061e"+
		"\u0609\3\2\2\2\u061e\u060c\3\2\2\2\u061e\u060f\3\2\2\2\u061e\u0612\3\2"+
		"\2\2\u061e\u0615\3\2\2\2\u061e\u0618\3\2\2\2\u061e\u061b\3\2\2\2\u061f"+
		"[\3\2\2\2\u0620\u0622\7\u010b\2\2\u0621\u0623\5^\60\2\u0622\u0621\3\2"+
		"\2\2\u0623\u0624\3\2\2\2\u0624\u0622\3\2\2\2\u0624\u0625\3\2\2\2\u0625"+
		"\u0626\3\2\2\2\u0626\u0627\5d\63\2\u0627\u0628\7\u010c\2\2\u0628]\3\2"+
		"\2\2\u0629\u062a\5\u00a0Q\2\u062a\u062b\b\60\1\2\u062b\u0630\3\2\2\2\u062c"+
		"\u062d\5\u00aaV\2\u062d\u062e\b\60\1\2\u062e\u0630\3\2\2\2\u062f\u0629"+
		"\3\2\2\2\u062f\u062c\3\2\2\2\u0630\u0631\3\2\2\2\u0631\u0632\7\u0110\2"+
		"\2\u0632\u0633\5\u0096L\2\u0633\u0634\b\60\1\2\u0634_\3\2\2\2\u0635\u0636"+
		"\7\u010b\2\2\u0636\u0637\5^\60\2\u0637\u063b\b\61\1\2\u0638\u063a\5b\62"+
		"\2\u0639\u0638\3\2\2\2\u063a\u063d\3\2\2\2\u063b\u0639\3\2\2\2\u063b\u063c"+
		"\3\2\2\2\u063c\u063e\3\2\2\2\u063d\u063b\3\2\2\2\u063e\u063f\b\61\1\2"+
		"\u063f\u0640\5d\63\2\u0640\u0641\7\u010c\2\2\u0641a\3\2\2\2\u0642\u0643"+
		"\5\u00a0Q\2\u0643\u0644\b\62\1\2\u0644\u0649\3\2\2\2\u0645\u0646\5\u00aa"+
		"V\2\u0646\u0647\b\62\1\2\u0647\u0649\3\2\2\2\u0648\u0642\3\2\2\2\u0648"+
		"\u0645\3\2\2\2\u0649\u064a\3\2\2\2\u064a\u064b\6\62\u00b6\3\u064b\u064c"+
		"\7\u0110\2\2\u064c\u064d\5\u0096L\2\u064d\u064e\b\62\1\2\u064ec\3\2\2"+
		"\2\u064f\u0650\7\23\2\2\u0650\u0651\7\u0110\2\2\u0651\u0652\5\u0096L\2"+
		"\u0652\u0653\b\63\1\2\u0653e\3\2\2\2\u0654\u0657\5v<\2\u0655\u0657\5n"+
		"8\2\u0656\u0654\3\2\2\2\u0656\u0655\3\2\2\2\u0657g\3\2\2\2\u0658\u065c"+
		"\5l\67\2\u0659\u065c\5n8\2\u065a\u065c\5v<\2\u065b\u0658\3\2\2\2\u065b"+
		"\u0659\3\2\2\2\u065b\u065a\3\2\2\2\u065ci\3\2\2\2\u065d\u065f\7\u0109"+
		"\2\2\u065e\u0660\5X-\2\u065f\u065e\3\2\2\2\u065f\u0660\3\2\2\2\u0660\u0661"+
		"\3\2\2\2\u0661\u0662\7\u010a\2\2\u0662\u0663\5h\65\2\u0663k\3\2\2\2\u0664"+
		"\u0665\7:\2\2\u0665m\3\2\2\2\u0666\u0667\5p9\2\u0667\u0668\b8\1\2\u0668"+
		"\u066c\3\2\2\2\u0669\u066a\7\n\2\2\u066a\u066c\b8\1\2\u066b\u0666\3\2"+
		"\2\2\u066b\u0669\3\2\2\2\u066co\3\2\2\2\u066d\u066e\5r:\2\u066e\u066f"+
		"\b9\1\2\u066f\u0674\3\2\2\2\u0670\u0671\5t;\2\u0671\u0672\b9\1\2\u0672"+
		"\u0674\3\2\2\2\u0673\u066d\3\2\2\2\u0673\u0670\3\2\2\2\u0674q\3\2\2\2"+
		"\u0675\u0676\7\f\2\2\u0676\u0680\b:\1\2\u0677\u0678\7.\2\2\u0678\u0680"+
		"\b:\1\2\u0679\u067a\7#\2\2\u067a\u0680\b:\1\2\u067b\u067c\7%\2\2\u067c"+
		"\u0680\b:\1\2\u067d\u067e\7\17\2\2\u067e\u0680\b:\1\2\u067f\u0675\3\2"+
		"\2\2\u067f\u0677\3\2\2\2\u067f\u0679\3\2\2\2\u067f\u067b\3\2\2\2\u067f"+
		"\u067d\3\2\2\2\u0680s\3\2\2\2\u0681\u0682\7\34\2\2\u0682\u0686\b;\1\2"+
		"\u0683\u0684\7\25\2\2\u0684\u0686\b;\1\2\u0685\u0681\3\2\2\2\u0685\u0683"+
		"\3\2\2\2\u0686u\3\2\2\2\u0687\u068a\5x=\2\u0688\u068a\5|?\2\u0689\u0687"+
		"\3\2\2\2\u0689\u0688\3\2\2\2\u068aw\3\2\2\2\u068b\u068d\5\u0092J\2\u068c"+
		"\u068e\5\u0086D\2\u068d\u068c\3\2\2\2\u068d\u068e\3\2\2\2\u068ey\3\2\2"+
		"\2\u068f\u0690\5\u0090I\2\u0690{\3\2\2\2\u0691\u0692\5n8\2\u0692\u0693"+
		"\5~@\2\u0693\u0698\3\2\2\2\u0694\u0695\5x=\2\u0695\u0696\5~@\2\u0696\u0698"+
		"\3\2\2\2\u0697\u0691\3\2\2\2\u0697\u0694\3\2\2\2\u0698}\3\2\2\2\u0699"+
		"\u069b\5\u0080A\2\u069a\u0699\3\2\2\2\u069b\u069c\3\2\2\2\u069c\u069a"+
		"\3\2\2\2\u069c\u069d\3\2\2\2\u069d\177\3\2\2\2\u069e\u069f\7\u010d\2\2"+
		"\u069f\u06a0\7\u010e\2\2\u06a0\u0081\3\2\2\2\u06a1\u06a2\7\30\2\2\u06a2"+
		"\u06a6\5x=\2\u06a3\u06a5\5\u0084C\2\u06a4\u06a3\3\2\2\2\u06a5\u06a8\3"+
		"\2\2\2\u06a6\u06a4\3\2\2\2\u06a6\u06a7\3\2\2\2\u06a7\u06b1\3\2\2\2\u06a8"+
		"\u06a6\3\2\2\2\u06a9\u06aa\7\30\2\2\u06aa\u06ac\7(\2\2\u06ab\u06ad\5\u0084"+
		"C\2\u06ac\u06ab\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u06ac\3\2\2\2\u06ae"+
		"\u06af\3\2\2\2\u06af\u06b1\3\2\2\2\u06b0\u06a1\3\2\2\2\u06b0\u06a9\3\2"+
		"\2\2\u06b1\u0083\3\2\2\2\u06b2\u06b3\7\u0117\2\2\u06b3\u06b4\5x=\2\u06b4"+
		"\u0085\3\2\2\2\u06b5\u06b6\7\u0115\2\2\u06b6\u06b7\5\u0088E\2\u06b7\u06b8"+
		"\7\u0116\2\2\u06b8\u0087\3\2\2\2\u06b9\u06be\5\u008aF\2\u06ba\u06bb\7"+
		"\u0111\2\2\u06bb\u06bd\5\u008aF\2\u06bc\u06ba\3\2\2\2\u06bd\u06c0\3\2"+
		"\2\2\u06be\u06bc\3\2\2\2\u06be\u06bf\3\2\2\2\u06bf\u0089\3\2\2\2\u06c0"+
		"\u06be\3\2\2\2\u06c1\u06c4\5v<\2\u06c2\u06c4\5\u008cG\2\u06c3\u06c1\3"+
		"\2\2\2\u06c3\u06c2\3\2\2\2\u06c4\u008b\3\2\2\2\u06c5\u06c7\7\u0119\2\2"+
		"\u06c6\u06c8\5\u008eH\2\u06c7\u06c6\3\2\2\2\u06c7\u06c8\3\2\2\2\u06c8"+
		"\u008d\3\2\2\2\u06c9\u06ca\7\30\2\2\u06ca\u06ce\5v<\2\u06cb\u06cc\7\61"+
		"\2\2\u06cc\u06ce\5v<\2\u06cd\u06c9\3\2\2\2\u06cd\u06cb\3\2\2\2\u06ce\u008f"+
		"\3\2\2\2\u06cf\u06d0\6I\u00b7\2\u06d0\u06d1\5\u0098M\2\u06d1\u06d2\bI"+
		"\1\2\u06d2\u0091\3\2\2\2\u06d3\u06da\bJ\1\2\u06d4\u06d5\5\u0098M\2\u06d5"+
		"\u06d6\7\u0112\2\2\u06d6\u06d7\bJ\1\2\u06d7\u06d9\3\2\2\2\u06d8\u06d4"+
		"\3\2\2\2\u06d9\u06dc\3\2\2\2\u06da\u06d8\3\2\2\2\u06da\u06db\3\2\2\2\u06db"+
		"\u06dd\3\2\2\2\u06dc\u06da\3\2\2\2\u06dd\u06de\5\u0090I\2\u06de\u06df"+
		"\bJ\1\2\u06df\u06e0\bJ\1\2\u06e0\u0093\3\2\2\2\u06e1\u06e8\bK\1\2\u06e2"+
		"\u06e3\5\u0098M\2\u06e3\u06e4\7\u0112\2\2\u06e4\u06e5\bK\1\2\u06e5\u06e7"+
		"\3\2\2\2\u06e6\u06e2\3\2\2\2\u06e7\u06ea\3\2\2\2\u06e8\u06e6\3\2\2\2\u06e8"+
		"\u06e9\3\2\2\2\u06e9\u06eb\3\2\2\2\u06ea\u06e8\3\2\2\2\u06eb\u06ec\5\u0098"+
		"M\2\u06ec\u06ed\bK\1\2\u06ed\u06ee\bK\1\2\u06ee\u0095\3\2\2\2\u06ef\u06f0"+
		"\t\7\2\2\u06f0\u0097\3\2\2\2\u06f1\u06f2\t\b\2\2\u06f2\u0099\3\2\2\2\u06f3"+
		"\u06f4\t\t\2\2\u06f4\u06f5\bN\1\2\u06f5\u009b\3\2\2\2\u06f6\u06f7\t\t"+
		"\2\2\u06f7\u06f8\bO\1\2\u06f8\u009d\3\2\2\2\u06f9\u06fa\7\u0122\2\2\u06fa"+
		"\u06fb\bP\1\2\u06fb\u009f\3\2\2\2\u06fc\u06fd\t\t\2\2\u06fd\u06fe\bQ\1"+
		"\2\u06fe\u00a1\3\2\2\2\u06ff\u0700\t\n\2\2\u0700\u0701\bR\1\2\u0701\u00a3"+
		"\3\2\2\2\u0702\u0703\t\13\2\2\u0703\u0704\bS\1\2\u0704\u00a5\3\2\2\2\u0705"+
		"\u0706\7\u0123\2\2\u0706\u0707\bT\1\2\u0707\u00a7\3\2\2\2\u0708\u0709"+
		"\7\4\2\2\u0709\u070a\bU\1\2\u070a\u00a9\3\2\2\2\u070b\u070c\7\u0124\2"+
		"\2\u070c\u070d\bV\1\2\u070d\u00ab\3\2\2\2\u070e\u070f\7\u0125\2\2\u070f"+
		"\u0710\bW\1\2\u0710\u00ad\3\2\2\2r\u00b8\u00c3\u00cc\u00cf\u00d2\u00fa"+
		"\u0105\u010e\u0111\u0135\u0140\u0146\u014f\u0158\u015f\u0168\u0170\u0174"+
		"\u017c\u0182\u0189\u018d\u01a9\u01b1\u01b7\u01be\u01c2\u0202\u020a\u021b"+
		"\u023a\u023c\u0265\u026c\u0273\u027c\u0286\u0294\u029c\u02a4\u02b0\u02ba"+
		"\u02c6\u02cc\u02d0\u02db\u02e9\u02ec\u0304\u0312\u0315\u034d\u035b\u035e"+
		"\u0376\u0384\u0387\u03bd\u03cb\u03ce\u03e6\u03f4\u03f7\u0479\u0487\u048a"+
		"\u0491\u049f\u04a2\u04d8\u04e6\u04e9\u0526\u0534\u0537\u0559\u0567\u056a"+
		"\u05a0\u05ae\u05b1\u05c4\u05c9\u05d3\u05da\u05f1\u0600\u061e\u0624\u062f"+
		"\u063b\u0648\u0656\u065b\u065f\u066b\u0673\u067f\u0685\u0689\u068d\u0697"+
		"\u069c\u06a6\u06ae\u06b0\u06be\u06c3\u06c7\u06cd\u06da\u06e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}