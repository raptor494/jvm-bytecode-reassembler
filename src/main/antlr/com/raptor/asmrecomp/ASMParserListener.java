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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ASMParser}.
 */
public interface ASMParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ASMParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(ASMParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(ASMParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(ASMParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(ASMParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ASMParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ASMParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(ASMParser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(ASMParser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(ASMParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(ASMParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(ASMParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(ASMParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(ASMParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(ASMParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(ASMParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(ASMParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(ASMParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(ASMParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(ASMParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(ASMParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(ASMParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(ASMParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(ASMParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(ASMParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(ASMParser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(ASMParser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(ASMParser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(ASMParser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ASMParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ASMParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(ASMParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(ASMParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(ASMParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(ASMParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(ASMParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(ASMParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(ASMParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(ASMParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(ASMParser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(ASMParser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(ASMParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(ASMParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(ASMParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(ASMParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(ASMParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(ASMParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(ASMParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(ASMParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(ASMParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(ASMParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(ASMParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(ASMParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(ASMParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(ASMParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(ASMParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(ASMParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(ASMParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(ASMParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#variadicParameter}.
	 * @param ctx the parse tree
	 */
	void enterVariadicParameter(ASMParser.VariadicParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#variadicParameter}.
	 * @param ctx the parse tree
	 */
	void exitVariadicParameter(ASMParser.VariadicParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#exceptions}.
	 * @param ctx the parse tree
	 */
	void enterExceptions(ASMParser.ExceptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#exceptions}.
	 * @param ctx the parse tree
	 */
	void exitExceptions(ASMParser.ExceptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(ASMParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(ASMParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(ASMParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(ASMParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(ASMParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(ASMParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ASMParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ASMParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#labelDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLabelDeclaration(ASMParser.LabelDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#labelDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLabelDeclaration(ASMParser.LabelDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(ASMParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(ASMParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#fieldRef}.
	 * @param ctx the parse tree
	 */
	void enterFieldRef(ASMParser.FieldRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#fieldRef}.
	 * @param ctx the parse tree
	 */
	void exitFieldRef(ASMParser.FieldRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#methodRef}.
	 * @param ctx the parse tree
	 */
	void enterMethodRef(ASMParser.MethodRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#methodRef}.
	 * @param ctx the parse tree
	 */
	void exitMethodRef(ASMParser.MethodRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#callSiteRef}.
	 * @param ctx the parse tree
	 */
	void enterCallSiteRef(ASMParser.CallSiteRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#callSiteRef}.
	 * @param ctx the parse tree
	 */
	void exitCallSiteRef(ASMParser.CallSiteRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#bootstrapRef}.
	 * @param ctx the parse tree
	 */
	void enterBootstrapRef(ASMParser.BootstrapRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#bootstrapRef}.
	 * @param ctx the parse tree
	 */
	void exitBootstrapRef(ASMParser.BootstrapRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#handle}.
	 * @param ctx the parse tree
	 */
	void enterHandle(ASMParser.HandleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#handle}.
	 * @param ctx the parse tree
	 */
	void exitHandle(ASMParser.HandleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#bootstrapArgs}.
	 * @param ctx the parse tree
	 */
	void enterBootstrapArgs(ASMParser.BootstrapArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#bootstrapArgs}.
	 * @param ctx the parse tree
	 */
	void exitBootstrapArgs(ASMParser.BootstrapArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(ASMParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(ASMParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#loadableConstant}.
	 * @param ctx the parse tree
	 */
	void enterLoadableConstant(ASMParser.LoadableConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#loadableConstant}.
	 * @param ctx the parse tree
	 */
	void exitLoadableConstant(ASMParser.LoadableConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#lookupSwitchArg}.
	 * @param ctx the parse tree
	 */
	void enterLookupSwitchArg(ASMParser.LookupSwitchArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#lookupSwitchArg}.
	 * @param ctx the parse tree
	 */
	void exitLookupSwitchArg(ASMParser.LookupSwitchArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#lookupSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterLookupSwitchCase(ASMParser.LookupSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#lookupSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitLookupSwitchCase(ASMParser.LookupSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#tableSwitchArg}.
	 * @param ctx the parse tree
	 */
	void enterTableSwitchArg(ASMParser.TableSwitchArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#tableSwitchArg}.
	 * @param ctx the parse tree
	 */
	void exitTableSwitchArg(ASMParser.TableSwitchArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#tableSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterTableSwitchCase(ASMParser.TableSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#tableSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitTableSwitchCase(ASMParser.TableSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#switchDefault}.
	 * @param ctx the parse tree
	 */
	void enterSwitchDefault(ASMParser.SwitchDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#switchDefault}.
	 * @param ctx the parse tree
	 */
	void exitSwitchDefault(ASMParser.SwitchDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ASMParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ASMParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeOrVoid(ASMParser.TypeOrVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeOrVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeOrVoid(ASMParser.TypeOrVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(ASMParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(ASMParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(ASMParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(ASMParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(ASMParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(ASMParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(ASMParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(ASMParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(ASMParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(ASMParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(ASMParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(ASMParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(ASMParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(ASMParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(ASMParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(ASMParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(ASMParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(ASMParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(ASMParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(ASMParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(ASMParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(ASMParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#dim}.
	 * @param ctx the parse tree
	 */
	void enterDim(ASMParser.DimContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#dim}.
	 * @param ctx the parse tree
	 */
	void exitDim(ASMParser.DimContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(ASMParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(ASMParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(ASMParser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(ASMParser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(ASMParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(ASMParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(ASMParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(ASMParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(ASMParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(ASMParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(ASMParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(ASMParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(ASMParser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(ASMParser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(ASMParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(ASMParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#qualifiedTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedTypeIdentifier(ASMParser.QualifiedTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#qualifiedTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedTypeIdentifier(ASMParser.QualifiedTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdentifier(ASMParser.QualifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdentifier(ASMParser.QualifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#labelIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterLabelIdentifier(ASMParser.LabelIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#labelIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitLabelIdentifier(ASMParser.LabelIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ASMParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ASMParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#signedByteLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedByteLiteral(ASMParser.SignedByteLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#signedByteLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedByteLiteral(ASMParser.SignedByteLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#signedShortLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedShortLiteral(ASMParser.SignedShortLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#signedShortLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedShortLiteral(ASMParser.SignedShortLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(ASMParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(ASMParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#signedIntegerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedIntegerLiteral(ASMParser.SignedIntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#signedIntegerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedIntegerLiteral(ASMParser.SignedIntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#longLiteral}.
	 * @param ctx the parse tree
	 */
	void enterLongLiteral(ASMParser.LongLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#longLiteral}.
	 * @param ctx the parse tree
	 */
	void exitLongLiteral(ASMParser.LongLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#signedLongLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedLongLiteral(ASMParser.SignedLongLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#signedLongLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedLongLiteral(ASMParser.SignedLongLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(ASMParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(ASMParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#doubleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(ASMParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#doubleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(ASMParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#characterLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCharacterLiteral(ASMParser.CharacterLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#characterLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCharacterLiteral(ASMParser.CharacterLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ASMParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ASMParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASMParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ASMParser.StringLiteralContext ctx);
}