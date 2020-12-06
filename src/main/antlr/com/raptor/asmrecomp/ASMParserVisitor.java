// Generated from ASMParser.g4 by ANTLR 4.8

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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ASMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ASMParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ASMParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(ASMParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(ASMParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ASMParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(ASMParser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(ASMParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(ASMParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(ASMParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(ASMParser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(ASMParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(ASMParser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(ASMParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(ASMParser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#superinterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperinterfaces(ASMParser.SuperinterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(ASMParser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(ASMParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(ASMParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(ASMParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBodyDeclaration(ASMParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(ASMParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(ASMParser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(ASMParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(ASMParser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(ASMParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(ASMParser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(ASMParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(ASMParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(ASMParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(ASMParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(ASMParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#variadicParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariadicParameter(ASMParser.VariadicParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#exceptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptions(ASMParser.ExceptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(ASMParser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(ASMParser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(ASMParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ASMParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#labelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclaration(ASMParser.LabelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(ASMParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#fieldRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldRef(ASMParser.FieldRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#methodRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodRef(ASMParser.MethodRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#callSiteRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSiteRef(ASMParser.CallSiteRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#bootstrapRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBootstrapRef(ASMParser.BootstrapRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#handle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandle(ASMParser.HandleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#bootstrapArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBootstrapArgs(ASMParser.BootstrapArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(ASMParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#loadableConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadableConstant(ASMParser.LoadableConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#lookupSwitchArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupSwitchArg(ASMParser.LookupSwitchArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#lookupSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupSwitchCase(ASMParser.LookupSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#tableSwitchArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSwitchArg(ASMParser.TableSwitchArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#tableSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableSwitchCase(ASMParser.TableSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#switchDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchDefault(ASMParser.SwitchDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ASMParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeOrVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOrVoid(ASMParser.TypeOrVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(ASMParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#voidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(ASMParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(ASMParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(ASMParser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(ASMParser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(ASMParser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(ASMParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(ASMParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(ASMParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(ASMParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(ASMParser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#dim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim(ASMParser.DimContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(ASMParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(ASMParser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(ASMParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(ASMParser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(ASMParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(ASMParser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(ASMParser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(ASMParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#qualifiedTypeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedTypeIdentifier(ASMParser.QualifiedTypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedIdentifier(ASMParser.QualifiedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#labelIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelIdentifier(ASMParser.LabelIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ASMParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#signedByteLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedByteLiteral(ASMParser.SignedByteLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#signedShortLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedShortLiteral(ASMParser.SignedShortLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(ASMParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#signedIntegerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntegerLiteral(ASMParser.SignedIntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#longLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongLiteral(ASMParser.LongLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#signedLongLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedLongLiteral(ASMParser.SignedLongLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(ASMParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#doubleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(ASMParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#characterLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(ASMParser.CharacterLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ASMParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ASMParser.StringLiteralContext ctx);
}