parser grammar ASMParser;

options {
    tokenVocab = ASMLexer;
}

@header {
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
}

@members {
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
    
}

compilationUnit
returns [ClassWriter cw, String name]
    :   typeDeclaration {$cw = $typeDeclaration.cw; $name = $typeDeclaration.name;} EOF
    ;
    
typeDeclaration
returns [ClassWriter cw, String name]
    :   classDeclaration     {$cw = $classDeclaration.cw;     $name = $classDeclaration.name;}
    |   interfaceDeclaration {$cw = $interfaceDeclaration.cw; $name = $interfaceDeclaration.name;}
    ;
    
classDeclaration
returns [ClassWriter cw, String name]
    :   normalClassDeclaration {$cw = $normalClassDeclaration.cw; $name = $normalClassDeclaration.name;}
//  |   enumDeclaration
    ;
    
normalClassDeclaration
returns [ClassWriter cw, String name]
locals [int flags]
    :   {$flags = 0;} (classModifier[$flags] {$flags |= $classModifier.flag;})* 
        'class' qualifiedTypeIdentifier {$name = currentClassName = $qualifiedTypeIdentifier.str;} 
        (typeParameters {enterScope();})? superclass? superinterfaces[false]?
        {
            $cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
            var cv = debug? new TraceClassVisitor($cw, new java.io.PrintWriter(System.out)) : $cw;
            cv.visit(
                // version
                V14,
                // access
                $flags,
                // name
                dottedNameToSlashedName($qualifiedTypeIdentifier.str),
                // signature
                $ctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
                // superName
                ($ctx.superclass() == null)? Type.getInternalName(Object.class) : getInternalName($ctx.superclass().classOrInterfaceType()),
                // interfaces
                getDescriptorsArray($ctx.superinterfaces())                
            );
        }
        classBody[cv]
        {
            if ($ctx.typeParameters() != null) exitScope();
            cv.visitEnd();
        }
    ;

classModifier[int flags]
returns [int flag]
    :   'public'     {$flag = ACC_PUBLIC;}      {($flags & ACC_PUBLIC) == 0}?<fail='Duplicate flag "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incomatible flags "public", "protected"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "public", "private"'>
    |   'protected'  {$flag = ACC_PROTECTED;}   {($flags & ACC_PROTECTED) == 0}?<fail='Duplicate flag "protected"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "protected", "public"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "protected", "private"'> 
    |   'private'    {$flag = ACC_PRIVATE;}     {($flags & ACC_PRIVATE) == 0}?<fail='Duplicate flag "private"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "private", "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incompatible flags "private", "protected"'>
    |   'abstract'   {$flag = ACC_ABSTRACT;}    {($flags & ACC_ABSTRACT) == 0}?<fail='Duplicate flag "abstract"'> {($flags & ACC_FINAL) == 0}?<fail='Incompatible flags "abstract", "final"'> {($flags & ACC_STATIC) == 0}?<fail='Incompatible flags "abstract", "static"'>
    |   'static'     {$flag = ACC_STATIC;}      {($flags & ACC_STATIC) == 0}?<fail='Duplicate flag "static"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "static", "abstract"'>      
    |   'final'      {$flag = ACC_FINAL;}       {($flags & ACC_FINAL) == 0}?<fail='Duplicate flag "final"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "final", "abstract"'>
    |   'synthetic'  {$flag = ACC_SYNTHETIC;}   {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated' {$flag = ACC_DEPRECATED;}  {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    ;
    
interfaceDeclaration
returns [ClassWriter cw, String name]
    :   normalInterfaceDeclaration {$cw = $normalInterfaceDeclaration.cw; $name = $normalInterfaceDeclaration.name;}
//  |   annotationTypeDeclaration
    ;
    
normalInterfaceDeclaration
returns [ClassWriter cw, String name]
locals [int flags]
    :   {$flags = 0;} (interfaceModifier[$flags] {$flags |= $interfaceModifier.flag;})*
        'interface' qualifiedTypeIdentifier {$name = currentClassName = $qualifiedTypeIdentifier.str;} 
        (typeParameters {enterScope();})? superinterfaces[true]?
        {
            $flags |= ACC_INTERFACE | ACC_ABSTRACT;
            $cw = new ClassWriter(COMPUTE_MAXS | COMPUTE_FRAMES);
            var cv = debug? new TraceClassVisitor($cw, new java.io.PrintWriter(System.out)) : $cw;
            cv.visit(
                // version
                V14,
                // access
                $flags,
                // name
                dottedNameToSlashedName($qualifiedTypeIdentifier.str),
                // signature
                $ctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
                // superName
                null,
                // interfaces
                getDescriptorsArray($ctx.superinterfaces())
            );
        }
        interfaceBody[cv]
        {
            if ($ctx.typeParameters() != null) exitScope();
            cv.visitEnd();
        }
    ;

interfaceModifier[int flags]
returns [int flag]
    :   'public'     {$flag = ACC_PUBLIC;}      {($flags & ACC_PUBLIC) == 0}?<fail='Duplicate flag "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incomatible flags "public", "protected"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "public", "private"'>
    |   'protected'  {$flag = ACC_PROTECTED;}   {($flags & ACC_PROTECTED) == 0}?<fail='Duplicate flag "protected"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "protected", "public"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "protected", "private"'> 
    |   'private'    {$flag = ACC_PRIVATE;}     {($flags & ACC_PRIVATE) == 0}?<fail='Duplicate flag "private"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "private", "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incompatible flags "private", "protected"'>
    |   'abstract'   {$flag = ACC_ABSTRACT;}    {($flags & ACC_ABSTRACT) == 0}?<fail='Duplicate flag "abstract"'> {($flags & ACC_FINAL) == 0}?<fail='Incompatible flags "abstract", "final"'> {($flags & ACC_STATIC) == 0}?<fail='Incompatible flags "abstract", "static"'>
    |   'static'     {$flag = ACC_STATIC;}      {($flags & ACC_STATIC) == 0}?<fail='Duplicate flag "static"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "static", "abstract"'>
    |   'synthetic'  {$flag = ACC_SYNTHETIC;}   {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated' {$flag = ACC_DEPRECATED;}  {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    ;
    
typeParameters
    :   '<' typeParameterList '>'
    ;
    
typeParameterList
    :   typeParameter (',' typeParameter)*
    ;
    
typeParameter
    :   typeIdentifier {addTypeParameter($typeIdentifier.text, $ctx);} typeBound?
    ;
    
superclass
    :   'extends' classOrInterfaceType
    ;
    
superinterfaces[boolean isImplements]
    :   ({$isImplements}? 'implements' | {!$isImplements}? 'extends') interfaceTypeList
    ;
    
interfaceTypeList
    :   classOrInterfaceType (',' classOrInterfaceType)*
    ;
    
classBody[ClassVisitor cw]
    :   '{' classBodyDeclaration[$cw]* '}'
    ;
    
interfaceBody[ClassVisitor cw]
    :   '{' interfaceBodyDeclaration[$cw]* '}'
    ;
    
//
// Class Body Declarations
//

classBodyDeclaration[ClassVisitor cw]
    :   constructorDeclaration[$cw]
    |   methodDeclaration[$cw]
    |   fieldDeclaration[$cw]
    ;
    
interfaceBodyDeclaration[ClassVisitor cw]
    :   methodDeclaration[$cw]
    |   fieldDeclaration[$cw]
    ;
    
constructorDeclaration[ClassVisitor cw]
locals [int flags]
    :   {$flags = 0;} (constructorModifier[$flags] {$flags |= $constructorModifier.flag;})*
        (typeParameters {enterScope();})? qualifiedTypeIdentifier {$qualifiedTypeIdentifier.str.equals(currentClassName)}?<fail={"Invalid constructor name, must be "+currentClassName}>
        '(' {localVarMode = MODE_UNDECIDED;} formalParameterList? ')' exceptions? ';'
        {
            var formalParameterList = $ctx.formalParameterList();
            if (formalParameterList != null && formalParameterList.lastFormalParameter().variadicParameter() != null) {
                $flags |= ACC_VARARGS;
            }
            var mv = cw.visitMethod(
                // access
                $flags,
                // name
                "<init>",
                // descriptor
                $ctx.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString(),
                // signature
                $ctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
                // exceptions
                getDescriptorsArray($ctx.exceptions())
            );
            
            addedThisLocalVar = false;
            methodIsStatic = ($flags & ACC_STATIC) != 0;

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
        }
        methodBody[mv, ($flags & (ACC_ABSTRACT | ACC_NATIVE)) == 0]
        {
            
            if ($ctx.typeParameters() != null) exitScope();
            if (localVarMode == MODE_NAMES) varnames = null;
        }
    ;
    
constructorModifier[int flags]
returns [int flag]
    :   'public'     {$flag = ACC_PUBLIC;}      {($flags & ACC_PUBLIC) == 0}?<fail='Duplicate flag "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incomatible flags "public", "protected"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "public", "private"'>
    |   'protected'  {$flag = ACC_PROTECTED;}   {($flags & ACC_PROTECTED) == 0}?<fail='Duplicate flag "protected"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "protected", "public"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "protected", "private"'> 
    |   'private'    {$flag = ACC_PRIVATE;}     {($flags & ACC_PRIVATE) == 0}?<fail='Duplicate flag "private"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "private", "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incompatible flags "private", "protected"'>
    |   'synthetic'  {$flag = ACC_SYNTHETIC;}   {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated' {$flag = ACC_DEPRECATED;}  {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    ;

methodDeclaration[ClassVisitor cw]
locals [int flags]
    :   {$flags = 0;} (methodModifier[$flags] {$flags |= $methodModifier.flag;})*
        (typeParameters {enterScope();})? typeOrVoid identifier 
        '(' {localVarMode = MODE_UNDECIDED;} formalParameterList? ')' exceptions? ';'
        {
            var formalParameterList = $ctx.formalParameterList();
            if (formalParameterList != null && formalParameterList.lastFormalParameter().variadicParameter() != null) {
                $flags |= ACC_VARARGS;
            }
            var mv = cw.visitMethod(
                // access
                $flags,
                // name
                $identifier.str,
                // descriptor
                $ctx.accept(new DescriptorVisitor(this::lookupTypeParameter)).toString(),
                // signature
                $ctx.accept(new SignatureVisitor(this::hasTypeParameter)).toString(),
                // exceptions
                getDescriptorsArray($ctx.exceptions())
            );
            
            addedThisLocalVar = false;
            methodIsStatic = ($flags & ACC_STATIC) != 0;

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
        }
        methodBody[mv, ($flags & (ACC_ABSTRACT | ACC_NATIVE)) == 0]
        {
            
            if ($ctx.typeParameters() != null) exitScope();
            if (localVarMode == MODE_NAMES) varnames = null;
        }
    ;

methodModifier[int flags]
returns [int flag]
    :   'public'       {$flag = ACC_PUBLIC;}       {($flags & ACC_PUBLIC) == 0}?<fail='Duplicate flag "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incomatible flags "public", "protected"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "public", "private"'>
    |   'protected'    {$flag = ACC_PROTECTED;}    {($flags & ACC_PROTECTED) == 0}?<fail='Duplicate flag "protected"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "protected", "public"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "protected", "private"'> 
    |   'private'      {$flag = ACC_PRIVATE;}      {($flags & ACC_PRIVATE) == 0}?<fail='Duplicate flag "private"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "private", "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incompatible flags "private", "protected"'>
    |   'abstract'     {$flag = ACC_ABSTRACT;}     {($flags & ACC_ABSTRACT) == 0}?<fail='Duplicate flag "abstract"'> {($flags & ACC_FINAL) == 0}?<fail='Incompatible flags "abstract", "final"'> {($flags & ACC_STATIC) == 0}?<fail='Incompatible flags "abstract", "static"'> {($flags & ACC_SYNCHRONIZED) == 0}?<fail='Incompatible flags "abstract", "synchronized"'> {($flags & ACC_NATIVE) == 0}?<fail='Incompatible flags "abstract", "native"'> {($flags & ACC_STRICT) == 0}?<fail='Incompatible flags "abstract", "strictfp"'>
    |   'static'       {$flag = ACC_STATIC;}       {($flags & ACC_STATIC) == 0}?<fail='Duplicate flag "static"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "static", "abstract"'>      
    |   'final'        {$flag = ACC_FINAL;}        {($flags & ACC_FINAL) == 0}?<fail='Duplicate flag "final"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "final", "abstract"'>
    |   'synchronized' {$flag = ACC_SYNCHRONIZED;} {($flags & ACC_SYNCHRONIZED) == 0}?<fail='Duplicate flag "synchronized"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "synchronized", "abstract"'>
    |   'native'       {$flag = ACC_NATIVE;}       {($flags & ACC_NATIVE) == 0}?<fail='Duplicate flag "native"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "native", "abstract"'> {($flags & ACC_STRICT) == 0}?<fail='Incompatible flags "native", "strictfp"'>
    |   'strictfp'     {$flag = ACC_STRICT;}       {($flags & ACC_STRICT) == 0}?<fail='Duplicate flag "strictfp"'> {($flags & ACC_ABSTRACT) == 0}?<fail='Incompatible flags "strictfp", "abstract"'> {($flags & ACC_NATIVE) == 0}?<fail='Incompatible flags "strictfp", "native"'>
    |   'synthetic'    {$flag = ACC_SYNTHETIC;}    {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated'   {$flag = ACC_DEPRECATED;}   {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    |   'bridge'       {$flag = ACC_BRIDGE;}       {($flags & ACC_BRIDGE) == 0}?<fail='Duplicate flag "bridge"'>
    |   'mandated'     {$flag = ACC_MANDATED;}     {($flags & ACC_MANDATED) == 0}?<fail='Duplicate flag "mandated"'>
;
    
fieldDeclaration[ClassVisitor cw]
locals [int flags]
    :   {$flags = 0;} (fieldModifier[$flags] {$flags |= $fieldModifier.flag;})*
        type identifier {Object initialValue = null;} 
        ({($flags & ACC_STATIC) != 0}? '='
            (   {isString($ctx.type())}? stringLiteral {initialValue = $stringLiteral.value;}
            |   {isBoolean($ctx.type())}? ('true' {initialValue = true;} | 'false' {initialValue = false;})
            |   {isByte($ctx.type())}? signedByteLiteral {initialValue = $signedByteLiteral.value;}
            |   {isShort($ctx.type())}? signedShortLiteral {initialValue = $signedShortLiteral.value;}
            |   {isChar($ctx.type())}?  characterLiteral {initialValue = (int)$characterLiteral.value;}
            |   {isInt($ctx.type())}? signedIntegerLiteral {initialValue = $signedIntegerLiteral.value;}
            |   {isLong($ctx.type())}? signedLongLiteral {initialValue = $signedLongLiteral.value;}
            |   {isFloat($ctx.type())}? floatLiteral {initialValue = $floatLiteral.value;}
            |   {isDouble($ctx.type())}? doubleLiteral {initialValue = $doubleLiteral.value;}
            |   'null'
            )
        )? ';'
        {
            var fv = cw.visitField(
                // access
                $flags,
                // name
                $identifier.str,
                // descriptor
                getDescriptor($ctx.type()),
                // signature
                getSignature($ctx.type()),
                // value
                initialValue
            );
            fv.visitEnd();
        }
    ;
    
fieldModifier[int flags]
returns [int flag]
    :   'public'       {$flag = ACC_PUBLIC;}     {($flags & ACC_PUBLIC) == 0}?<fail='Duplicate flag "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incomatible flags "public", "protected"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "public", "private"'>
    |   'protected'    {$flag = ACC_PROTECTED;}  {($flags & ACC_PROTECTED) == 0}?<fail='Duplicate flag "protected"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "protected", "public"'> {($flags & ACC_PRIVATE) == 0}?<fail='Incompatible flags "protected", "private"'> 
    |   'private'      {$flag = ACC_PRIVATE;}    {($flags & ACC_PRIVATE) == 0}?<fail='Duplicate flag "private"'> {($flags & ACC_PUBLIC) == 0}?<fail='Incompatible flags "private", "public"'> {($flags & ACC_PROTECTED) == 0}?<fail='Incompatible flags "private", "protected"'>
    |   'static'       {$flag = ACC_STATIC;}     {($flags & ACC_STATIC) == 0}?<fail='Duplicate flag "static"'>
    |   'final'        {$flag = ACC_FINAL;}      {($flags & ACC_FINAL) == 0}?<fail='Duplicate flag "final"'>
    |   'transient'    {$flag = ACC_TRANSIENT;}  {($flags & ACC_TRANSIENT) == 0}?<fail='Duplicate flag "transient"'>
    |   'volatile'     {$flag = ACC_VOLATILE;}   {($flags & ACC_VOLATILE) == 0}?<fail='Duplicate flag "volatile"'>
    |   'synthetic'    {$flag = ACC_SYNTHETIC;}  {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated'   {$flag = ACC_DEPRECATED;} {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    |   'mandated'     {$flag = ACC_MANDATED;}   {($flags & ACC_MANDATED) == 0}?<fail='Duplicate flag "mandated"'>
    ;
    
formalParameterList
    :   formalParameters ',' lastFormalParameter
    |   lastFormalParameter
    ;
    
formalParameters
    :   formalParameter (',' formalParameter)*
    ;
    
formalParameter
returns [int flags, String name]
    :   {$flags = 0;} (variableModifier[$flags] {$flags |= $variableModifier.flag;})* type
        (   {localVarMode != MODE_INDICES}? identifier {localVarMode = MODE_NAMES; $name = $identifier.str;} 
        |   {localVarMode != MODE_NAMES}? {localVarMode = MODE_INDICES;}
        )
    ;
    
variableModifier[int flags]
returns [int flag]
    :   'final'        {$flag = ACC_FINAL;}      {($flags & ACC_FINAL) == 0}?<fail='Duplicate flag "final"'>
    |   'synthetic'    {$flag = ACC_SYNTHETIC;}  {($flags & ACC_SYNTHETIC) == 0}?<fail='Duplicate flag "synthetic"'>
    |   'deprecated'   {$flag = ACC_DEPRECATED;} {($flags & ACC_DEPRECATED) == 0}?<fail='Duplicate flag "deprecated"'>
    |   'mandated'     {$flag = ACC_MANDATED;}   {($flags & ACC_MANDATED) == 0}?<fail='Duplicate flag "mandated"'>
    ;
    
lastFormalParameter
returns [int flags, String name]
    :   variadicParameter {$flags = $variadicParameter.flags; $name = $variadicParameter.name;}
    |   formalParameter   {$flags = $formalParameter.flags;   $name = $formalParameter.name;}
    ;
    
variadicParameter
returns [int flags, String name]
    :   {$flags = 0;} (variableModifier[$flags] {$flags |= $variableModifier.flag;})* type '...' {$flags |= ACC_VARARGS;}
        (   {localVarMode != MODE_INDICES}? identifier {localVarMode = MODE_NAMES; $name = $identifier.str;} 
        |   {localVarMode != MODE_NAMES}? {localVarMode = MODE_INDICES;}
        )
    ;
    
exceptions
    :   'throws' exceptionTypeList
    ;
    
exceptionTypeList
    :   exceptionType (',' exceptionType)*
    ;
    
exceptionType
    :   classOrInterfaceType
//  |   typeVariable
    ;
    
methodBody[MethodVisitor mv, boolean hasCode]
    :   'Code' ':' {$hasCode}?<fail='This method may not define a body'> {$mv.visitCode(); labels = new HashMap<>();}
            statement[$mv]+
        {$mv.visitMaxs(1, 2); $mv.visitEnd(); labels = null;} 
    |   {!$hasCode}?<fail='This method must define a body'> {$mv.visitEnd();}
    ;
    
statement[MethodVisitor mv]
    :   labelDeclaration[$mv]
    |   instruction[$mv]
    ;
    
labelDeclaration[MethodVisitor mv]
    :   labelIdentifier ':' {$mv.visitLabel(getLabel($labelIdentifier.str));}
    ;
    
instruction[MethodVisitor mv]
    :   name='aastore'
        {mv.visitInsn(AASTORE);}
    |   name='aconst_null'
        {mv.visitInsn(ACONST_NULL);}
    |   'wide'? name='aload' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(ALOAD, value);}
    |   name='aload_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ALOAD, 0); localVarMode = MODE_INDICES;}
    |   name='aload_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ALOAD, 1); localVarMode = MODE_INDICES;}
    |   name='aload_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ALOAD, 2); localVarMode = MODE_INDICES;}
    |   name='aload_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ALOAD, 3); localVarMode = MODE_INDICES;}
    |   name='anewarray' referenceType
        {
            var referenceType = $ctx.referenceType();
            var arrayType = referenceType.arrayType();
            mv.visitTypeInsn(ANEWARRAY, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
        }
    |   name='areturn'
        {mv.visitInsn(ARETURN);}
    |   name='arraylength'
        {mv.visitInsn(ARRAYLENGTH);}
    |   'wide'? name='astore' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(ASTORE, value);}
    |   name='astore_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ASTORE, 0); localVarMode = MODE_INDICES;}
    |   name='astore_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ASTORE, 1); localVarMode = MODE_INDICES;}
    |   name='astore_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ASTORE, 2); localVarMode = MODE_INDICES;}
    |   name='astore_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ASTORE, 3); localVarMode = MODE_INDICES;}
    |   name='athrow'
        {mv.visitInsn(ATHROW);}
    |   name='baload'
        {mv.visitInsn(BALOAD);}
    |   name='bastore'
        {mv.visitInsn(BASTORE);}
    |   name='bipush' signedByteLiteral
        {mv.visitIntInsn(BIPUSH, $signedByteLiteral.value);}
    |   name='caload'
        {mv.visitInsn(CALOAD);}
    |   name='castore'
        {mv.visitInsn(CASTORE);}
    |   name='checkcast' referenceType
        {
            var referenceType = $ctx.referenceType();
            var arrayType = referenceType.arrayType();
            mv.visitTypeInsn(CHECKCAST, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
        }
    |   name='d2f'
        {mv.visitInsn(D2F);}
    |   name='d2i'
        {mv.visitInsn(D2I);}
    |   name='d2l'
        {mv.visitInsn(D2L);}
    |   name='dadd'
        {mv.visitInsn(DADD);}
    |   name='daload'
        {mv.visitInsn(DALOAD);}
    |   name='dastore'
        {mv.visitInsn(DASTORE);}
    |   name='dcmpg'
        {mv.visitInsn(DCMPG);}
    |   name='dcmpl'
        {mv.visitInsn(DCMPL);}
    |   name='dconst_0'
        {mv.visitInsn(DCONST_0);}
    |   name='dconst_1'
        {mv.visitInsn(DCONST_1);}
    |   name='ddiv'
        {mv.visitInsn(DDIV);}
    |   'wide'? name='dload' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(DLOAD, value);}
    |   name='dload_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DLOAD, 0); localVarMode = MODE_INDICES;}
    |   name='dload_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DLOAD, 1); localVarMode = MODE_INDICES;}
    |   name='dload_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DLOAD, 2); localVarMode = MODE_INDICES;}
    |   name='dload_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DLOAD, 3); localVarMode = MODE_INDICES;}
    |   name='dmul'
        {mv.visitInsn(DMUL);}
    |   name='dneg'
        {mv.visitInsn(DNEG);}
    |   name='drem'
        {mv.visitInsn(DREM);}
    |   name='dreturn'
        {mv.visitInsn(DRETURN);}
    |   'wide'? name='dstore' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(DSTORE, value);}
    |   name='dstore_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DSTORE, 0); localVarMode = MODE_INDICES;}
    |   name='dstore_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DSTORE, 1); localVarMode = MODE_INDICES;}
    |   name='dstore_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DSTORE, 2); localVarMode = MODE_INDICES;}
    |   name='dstore_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(DSTORE, 3); localVarMode = MODE_INDICES;}
    |   name='dsub'
        {mv.visitInsn(DSUB);}
    |   name='dup'
        {mv.visitInsn(DUP);}
    |   name='dup_x1'
        {mv.visitInsn(DUP_X1);}
    |   name='dup_x2'
        {mv.visitInsn(DUP_X2);}
    |   name='dup2'
        {mv.visitInsn(DUP2);}
    |   name='dup2_x1'
        {mv.visitInsn(DUP2_X1);}
    |   name='dup2_x2'
        {mv.visitInsn(DUP2_X2);}
    |   name='f2d'
        {mv.visitInsn(F2D);}
    |   name='f2i'
        {mv.visitInsn(F2I);}
    |   name='f2l'
        {mv.visitInsn(F2L);}
    |   name='fadd'
        {mv.visitInsn(FADD);}
    |   name='faload'
        {mv.visitInsn(FALOAD);}
    |   name='fastore'
        {mv.visitInsn(FASTORE);}
    |   name='fcmpg'
        {mv.visitInsn(FCMPG);}
    |   name='fcmpl'
        {mv.visitInsn(FCMPL);}
    |   name='fconst_0'
        {mv.visitInsn(FCONST_0);}
    |   name='fconst_1'
        {mv.visitInsn(FCONST_1);}
    |   name='fconst_2'
        {mv.visitInsn(FCONST_2);}
    |   name='fdiv'
        {mv.visitInsn(FDIV);}
    |   'wide'? name='fload' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(FLOAD, value);}
    |   name='fload_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FLOAD, 0); localVarMode = MODE_INDICES;}
    |   name='fload_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FLOAD, 1); localVarMode = MODE_INDICES;}
    |   name='fload_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FLOAD, 2); localVarMode = MODE_INDICES;}
    |   name='fload_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FLOAD, 3); localVarMode = MODE_INDICES;}
    |   name='fmul'
        {mv.visitInsn(FMUL);}
    |   name='fneg'
        {mv.visitInsn(FNEG);}
    |   name='frem'
        {mv.visitInsn(FREM);}
    |   name='freturn'
        {mv.visitInsn(FRETURN);}
    |   'wide'? name='fstore' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(FSTORE, value);}
    |   name='fstore_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FSTORE, 0); localVarMode = MODE_INDICES;}
    |   name='fstore_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FSTORE, 1); localVarMode = MODE_INDICES;}
    |   name='fstore_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FSTORE, 2); localVarMode = MODE_INDICES;}
    |   name='fstore_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(FSTORE, 3); localVarMode = MODE_INDICES;}
    |   name='fsub'
        {mv.visitInsn(FSUB);}
    |   name='getfield' fieldRef
        {mv.visitFieldInsn(GETFIELD, getOwner($ctx.fieldRef()), $fieldRef.name, getDescriptor($ctx.fieldRef()));}
    |   name='getstatic' fieldRef
        {mv.visitFieldInsn(GETSTATIC, getOwner($ctx.fieldRef()), $fieldRef.name, getDescriptor($ctx.fieldRef()));}
    |   name=('goto' | 'goto_w') labelIdentifier
        {mv.visitJumpInsn(GOTO, getLabel($labelIdentifier.str));}
    |   name='i2b'
        {mv.visitInsn(I2B);}
    |   name='i2c'
        {mv.visitInsn(I2C);}
    |   name='i2d'
        {mv.visitInsn(I2D);}
    |   name='i2f'
        {mv.visitInsn(I2F);}
    |   name='i2l'
        {mv.visitInsn(I2L);}
    |   name='i2s'
        {mv.visitInsn(I2S);}
    |   name='iadd'
        {mv.visitInsn(IADD);}
    |   name='iaload'
        {mv.visitInsn(IALOAD);}
    |   name='iand'
        {mv.visitInsn(IAND);}
    |   name='iastore'
        {mv.visitInsn(IASTORE);}
    |   name='iconst_m1'
        {mv.visitInsn(ICONST_M1);}
    |   name='iconst_0'
        {mv.visitInsn(ICONST_0);}
    |   name='iconst_1'
        {mv.visitInsn(ICONST_1);}
    |   name='iconst_2'
        {mv.visitInsn(ICONST_2);}
    |   name='iconst_3'
        {mv.visitInsn(ICONST_3);}
    |   name='iconst_4'
        {mv.visitInsn(ICONST_4);}
    |   name='iconst_5'
        {mv.visitInsn(ICONST_5);}
    |   name='idiv'
        {mv.visitInsn(IDIV);}
    |   name='if_acmpeq' labelIdentifier
        {mv.visitJumpInsn(IF_ACMPEQ, getLabel($labelIdentifier.str));}
    |   name='if_acmpne' labelIdentifier
        {mv.visitJumpInsn(IF_ACMPNE, getLabel($labelIdentifier.str));}
    |   name='if_icmpeq' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPEQ, getLabel($labelIdentifier.str));}
    |   name='if_icmpne' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPNE, getLabel($labelIdentifier.str));}
    |   name='if_icmplt' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPLT, getLabel($labelIdentifier.str));}
    |   name='if_icmpge' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPGE, getLabel($labelIdentifier.str));}
    |   name='if_icmpgt' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPGT, getLabel($labelIdentifier.str));}
    |   name='if_icmple' labelIdentifier
        {mv.visitJumpInsn(IF_ICMPLE, getLabel($labelIdentifier.str));}
    |   name='ifeq' labelIdentifier
        {mv.visitJumpInsn(IFEQ, getLabel($labelIdentifier.str));}
    |   name='ifne' labelIdentifier
        {mv.visitJumpInsn(IFNE, getLabel($labelIdentifier.str));}
    |   name='iflt' labelIdentifier
        {mv.visitJumpInsn(IFLT, getLabel($labelIdentifier.str));}
    |   name='ifge' labelIdentifier
        {mv.visitJumpInsn(IFGE, getLabel($labelIdentifier.str));}
    |   name='ifgt' labelIdentifier
        {mv.visitJumpInsn(IFGT, getLabel($labelIdentifier.str));}
    |   name='ifle' labelIdentifier
        {mv.visitJumpInsn(IFLE, getLabel($labelIdentifier.str));}
    |   name='ifnonnull' labelIdentifier
        {mv.visitJumpInsn(IFNONNULL, getLabel($labelIdentifier.str));}
    |   name='ifnull' labelIdentifier
        {mv.visitJumpInsn(IFNULL, getLabel($labelIdentifier.str));}
    |   'wide'? name='iinc' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        ) ',' signedIntegerLiteral
        {mv.visitIincInsn(value, $signedIntegerLiteral.value);}
    |   'wide'? name='iload' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(ILOAD, value);}
    |   name='iload_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ILOAD, 0); localVarMode = MODE_INDICES;}
    |   name='iload_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ILOAD, 1); localVarMode = MODE_INDICES;}
    |   name='iload_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ILOAD, 2); localVarMode = MODE_INDICES;}
    |   name='iload_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ILOAD, 3); localVarMode = MODE_INDICES;}
    |   name='imul'
        {mv.visitInsn(IMUL);}
    |   name='ineg'
        {mv.visitInsn(INEG);}
    |   name='instanceof' referenceType
        {
            var referenceType = $ctx.referenceType();
            var arrayType = referenceType.arrayType();
            mv.visitTypeInsn(INSTANCEOF, arrayType != null? getDescriptor(arrayType) : dottedNameToSlashedName(referenceType.classOrInterfaceType().qualifiedTypeIdentifier().str));
        }
    |   name='invokedynamic' callSiteRef
        {
            var callSite = $ctx.callSiteRef();
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
    |   name='invokeinterface' methodRef
        {mv.visitMethodInsn(INVOKEINTERFACE, getOwner($ctx.methodRef()), $methodRef.name, getDescriptor($ctx.methodRef()));}
    |   name='invokespecial' methodRef
        {mv.visitMethodInsn(INVOKESPECIAL, getOwner($ctx.methodRef()), $methodRef.name, getDescriptor($ctx.methodRef()));}
    |   name='invokestatic' methodRef
        {mv.visitMethodInsn(INVOKESTATIC, getOwner($ctx.methodRef()), $methodRef.name, getDescriptor($ctx.methodRef()));}
    |   name='invokevirtual' methodRef
        {mv.visitMethodInsn(INVOKEVIRTUAL, getOwner($ctx.methodRef()), $methodRef.name, getDescriptor($ctx.methodRef()));}
    |   name='ior'
        {mv.visitInsn(IOR);}
    |   name='irem'
        {mv.visitInsn(IREM);}
    |   name='ireturn'
        {mv.visitInsn(IRETURN);}
    |   name='ishl'
        {mv.visitInsn(ISHL);}
    |   name='ishr'
        {mv.visitInsn(ISHR);}
    |   'wide'? name='istore' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(ISTORE, value);}
    |   name='istore_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ISTORE, 0); localVarMode = MODE_INDICES;}
    |   name='istore_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ISTORE, 1); localVarMode = MODE_INDICES;}
    |   name='istore_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ISTORE, 2); localVarMode = MODE_INDICES;}
    |   name='istore_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(ISTORE, 3); localVarMode = MODE_INDICES;}
    |   name='isub'
        {mv.visitInsn(ISUB);}
    |   name='iushr'
        {mv.visitInsn(IUSHR);}
    |   name='ixor'
        {mv.visitInsn(IXOR);}
    |   name=('jsr' | 'jsr_w') labelIdentifier
        {mv.visitJumpInsn(JSR, getLabel($labelIdentifier.str));}
    |   name='l2d'
        {mv.visitInsn(L2D);}
    |   name='l2f'
        {mv.visitInsn(L2F);}
    |   name='l2i'
        {mv.visitInsn(L2I);}
    |   name='ladd'
        {mv.visitInsn(LADD);}
    |   name='laload'
        {mv.visitInsn(LALOAD);}
    |   name='land'
        {mv.visitInsn(LAND);}
    |   name='lastore'
        {mv.visitInsn(LASTORE);}
    |   name='lcmp'
        {mv.visitInsn(LCMP);}
    |   name='lconst_0'
        {mv.visitInsn(LCONST_0);}
    |   name='lconst_1'
        {mv.visitInsn(LCONST_1);}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') {int value = -1;} (signedIntegerLiteral {value = $signedIntegerLiteral.value;} | characterLiteral {value = $characterLiteral.value;})
        {
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
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') signedLongLiteral
        {
            long value = $signedLongLiteral.value;
            if (value == 0) mv.visitInsn(LCONST_0);
            else if (value == 1) mv.visitInsn(LCONST_1);
            else mv.visitLdcInsn(value);
        }
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') floatLiteral
        {
            float value = $floatLiteral.value;
            if (value == 0.0f) mv.visitInsn(FCONST_0);
            else if (value == 1.0f) mv.visitInsn(FCONST_1);
            else if (value == 2.0f) mv.visitInsn(FCONST_2);
            else mv.visitLdcInsn(value);
        }
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') doubleLiteral
        {
            double value = $doubleLiteral.value;
            if (value == 0.0) mv.visitInsn(DCONST_0);
            else if (value == 1.0) mv.visitInsn(DCONST_1);
            else mv.visitLdcInsn(value);
        }
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') stringLiteral
        {mv.visitLdcInsn($stringLiteral.value);}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') typeOrVoid
        {mv.visitLdcInsn(Type.getType(getDescriptor($ctx.typeOrVoid())));}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') methodType
        {mv.visitLdcInsn(Type.getType(getDescriptor($ctx.methodType())));}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') handle
        {mv.visitLdcInsn(getHandle($ctx.handle()));}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') 'true'
        {mv.visitInsn(ICONST_1);}
    |   name=('ldc' | 'ldc_w' | 'ldc2_w') 'false'
        {mv.visitInsn(ICONST_0);}
    |   name='ldiv'
        {mv.visitInsn(LDIV);}
    |   'wide'? name='lload' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(LLOAD, value);}
    |   name='lload_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LLOAD, 0); localVarMode = MODE_INDICES;}
    |   name='lload_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LLOAD, 1); localVarMode = MODE_INDICES;}
    |   name='lload_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LLOAD, 2); localVarMode = MODE_INDICES;}
    |   name='lload_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LLOAD, 3); localVarMode = MODE_INDICES;}
    |   name='lmul'
        {mv.visitInsn(LMUL);}
    |   name='lneg'
        {mv.visitInsn(LNEG);}
    |   name='lookupswitch' lookupSwitchArg
        {
            var switchArg = $ctx.lookupSwitchArg();
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
    |   name='lor'
        {mv.visitInsn(LOR);}
    |   name='lrem'
        {mv.visitInsn(LREM);}
    |   name='lreturn'
        {mv.visitInsn(LRETURN);}
    |   name='lshl'
        {mv.visitInsn(LSHL);}
    |   name='lshr'
        {mv.visitInsn(LSHR);}
    |   'wide'? name='lstore' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(LSTORE, value);}
    |   name='lstore_0'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LSTORE, 0); localVarMode = MODE_INDICES;}
    |   name='lstore_1'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LSTORE, 1); localVarMode = MODE_INDICES;}
    |   name='lstore_2'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LSTORE, 2); localVarMode = MODE_INDICES;}
    |   name='lstore_3'
        {localVarMode != MODE_NAMES}?
        {mv.visitVarInsn(LSTORE, 3); localVarMode = MODE_INDICES;}
    |   name='lsub'
        {mv.visitInsn(LSUB);}
    |   name='lushr'
        {mv.visitInsn(LUSHR);}
    |   name='lxor'
        {mv.visitInsn(LXOR);}
    |   name='monitorenter'
        {mv.visitInsn(MONITORENTER);}
    |   name='monitorexit'
        {mv.visitInsn(MONITOREXIT);}
    |   name='multianewarray' arrayType integerLiteral {$integerLiteral.value <= arrayDimCount($ctx.arrayType())}?
        {mv.visitMultiANewArrayInsn(getDescriptor($ctx.arrayType()), $integerLiteral.value);}
    |   name='new' classOrInterfaceType
        {mv.visitTypeInsn(NEW, getDescriptor($ctx.classOrInterfaceType()));}
    |   name='newarray' primitiveType
        {mv.visitIntInsn(NEWARRAY, switch($primitiveType.descriptor) {
            case 'Z' -> T_BOOLEAN;
            case 'B' -> T_BYTE;
            case 'C' -> T_CHAR;
            case 'S' -> T_SHORT;
            case 'L' -> T_LONG;
            case 'I' -> T_INT;
            case 'F' -> T_FLOAT;
            case 'D' -> T_DOUBLE;
            default -> throw new AssertionError();
        });}
    |   name='nop' 
        {mv.visitInsn(NOP);}
    |   name='pop'
        {mv.visitInsn(POP);}
    |   name='pop2'
        {mv.visitInsn(POP2);}
    |   name='putfield' fieldRef
        {mv.visitFieldInsn(PUTFIELD, getOwner($ctx.fieldRef()), $fieldRef.name, getDescriptor($ctx.fieldRef()));}
    |   name='putstatic' fieldRef
        {mv.visitFieldInsn(PUTSTATIC, getOwner($ctx.fieldRef()), $fieldRef.name, getDescriptor($ctx.fieldRef()));}
    |   'wide'? name='ret' {int value = -1;}
        (   {localVarMode != MODE_NAMES}? integerLiteral {value = $integerLiteral.value; localVarMode = MODE_INDICES;}
        |   {localVarMode != MODE_INDICES}? (identifier {value = getVariable($identifier.str);} | 'this' {value = getVariable("this");}) {localVarMode = MODE_NAMES;}
        )
        {mv.visitVarInsn(RET, value);}
    |   name='return' 
        {mv.visitInsn(RETURN);}
    |   name='saload'
        {mv.visitInsn(SALOAD);}
    |   name='sastore'
        {mv.visitInsn(SASTORE);}
    |   name='sipush' signedShortLiteral
        {mv.visitIntInsn(SIPUSH, $signedShortLiteral.value);}
    |   name='swap'
        {mv.visitInsn(SWAP);}
    |   name='tableswitch' tableSwitchArg
        {
            var switchArg = $ctx.tableSwitchArg();
            var labels = new ArrayList<Label>();
            labels.add(getLabel(switchArg.lookupSwitchCase().label));
            switchArg.tableSwitchCase().forEach(tableSwitchCase -> labels.add(getLabel(tableSwitchCase.label)));
            mv.visitTableSwitchInsn(switchArg.min, switchArg.max, getLabel(switchArg.switchDefault().label), labels.toArray(Label[]::new));
        }
    ;
    
fieldRef
returns [String name]
    :   (classOrInterfaceType '.')? identifier {$name = $identifier.str;} ':' type
    ;
    
methodRef
returns [String name]
    :   (classOrInterfaceType '.')? (identifier {$name = $identifier.str;} | INIT {$name = "<init>";}) ':' methodType
    ;
    
callSiteRef
    :   bootstrapRef ':' identifier ':' methodType
    ;
    
bootstrapRef
    :   '{' handle bootstrapArgs '}'
    ;
    
handle
    :   name=('getfield' | 'getstatic' | 'putfield' | 'putstatic') fieldRef
    |   name=('invokevirtual' | 'invokestatic' | 'invokespecial' | 'invokeinterface') methodRef
    |   'new' name='invokespecial' methodRef
    ;
    
bootstrapArgs
    : '(' methodType ',' handle ',' methodType ')'
    ;
    
typeList
    : type (',' type)*
    ;
    
loadableConstant
    :   integerLiteral
    |   FloatingPointLiteral 
    |   StringLiteral 
    |   CharacterLiteral 
    |   type 
    |   methodType 
    |   handle
    ;
    
lookupSwitchArg
    :   '{' lookupSwitchCase+ switchDefault '}'
    ;
    
lookupSwitchCase
returns [int value, String label]
    :   (signedIntegerLiteral {$value = $signedIntegerLiteral.value;} | characterLiteral {$value = $characterLiteral.value;}) ':' labelIdentifier {$label = $labelIdentifier.str;}
    ;

tableSwitchArg
returns [int min, int max]
    :   '{' lookupSwitchCase {int value = $lookupSwitchCase.value; $min = value;}
            tableSwitchCase[++value]* {$max = value;}
            switchDefault '}'
    ;

tableSwitchCase[int value]
returns [String label]
locals [int value2]
    :   (signedIntegerLiteral {$value2 = $signedIntegerLiteral.value;}
        | characterLiteral {$value2 = $characterLiteral.value;})
        {$value2 == $value}? ':' labelIdentifier {$label = $labelIdentifier.str;}
    ;
    
switchDefault
returns [String label]
    :   'default' ':' labelIdentifier {$label = $labelIdentifier.str;}
    ;
    
//
// Type References
//

type
    :   referenceType
    |   primitiveType
    ;
    
typeOrVoid
    :   voidType
    |   primitiveType
    |   referenceType
    ;
    
methodType
    :   '(' typeList? ')' typeOrVoid
    ;
    
voidType
    :   'void'
    ;

primitiveType
returns [char descriptor]
    :   numericType {$descriptor = $numericType.descriptor;}
    |   'boolean' {$descriptor = 'Z';}
    ;
    
numericType
returns [char descriptor]
    :   integralType {$descriptor = $integralType.descriptor;}
    |   floatingPointType {$descriptor = $floatingPointType.descriptor;}
    ;
    
integralType
returns [char descriptor]
    :   'byte'  {$descriptor = 'B';}
    |   'short' {$descriptor = 'S';}
    |   'int'   {$descriptor = 'I';}
    |   'long'  {$descriptor = 'J';}
    |   'char'  {$descriptor = 'C';}
    ;
    
floatingPointType
returns [char descriptor]
    :   'float'  {$descriptor = 'F';}
    |   'double' {$descriptor = 'D';}
    ;
    
referenceType
    :   classOrInterfaceType
//  |   typeVariable
    |   arrayType
    ;
    
classOrInterfaceType
    :   qualifiedTypeIdentifier typeArguments?
    ;
    
typeVariable
    :   typeIdentifier
    ;
    
arrayType
    :   primitiveType dims
    |   classOrInterfaceType dims
//  |   typeVariable dims
    ;
    
dims
    :   dim+
    ;
    
dim
    :   '[' ']'
    ;
    
typeBound
    :   'extends' classOrInterfaceType additionalBound*
    |   'extends' 'null' additionalBound+
    ;
    
additionalBound
    :   '&' classOrInterfaceType
    ;
    
typeArguments
    :   '<' typeArgumentList '>'
    ;
    
typeArgumentList
    :   typeArgument (',' typeArgument)*
    ;
    
typeArgument
    :   referenceType
    |   wildcard
    ;
    
wildcard
    :   '?' wildcardBounds?
    ;
    
wildcardBounds
    :   'extends' referenceType
    |   'super' referenceType
    ;
    
typeIdentifier
returns [String str]
    :   {!_input.LT(1).getText().equals("var")}? identifier {$str = $identifier.str;}
    ;
    
qualifiedTypeIdentifier
returns [String str]
    :   {var sb = new StringBuilder();}
        (identifier '.' {sb.append($identifier.str).append('.');})* typeIdentifier {sb.append($typeIdentifier.str);}
        {$str = sb.toString();}
    ;
    
qualifiedIdentifier
returns [String str]
    :   {var sb = new StringBuilder();}
        (identifier '.' {sb.append($identifier.str).append('.');})* identifier {sb.append($identifier.str);}
        {$str = sb.toString();}
    ;

//
// LEXER
//

labelIdentifier
returns [String str]
@after {$str = $text;}
    : Identifier
    | KW_DEPRECATED | KW_BRIDGE | KW_MANDATED | KW_SYNTHETIC
    ;

identifier
returns [String str]
@after {$str = $text;}
    : Identifier 
    | KW_CODE | KW_DEPRECATED | KW_BRIDGE | KW_MANDATED | KW_SYNTHETIC | KW_AASTORE | KW_ACONST_NULL | KW_ALOAD | KW_ALOAD_0 | KW_ALOAD_1 | KW_ALOAD_2 | KW_ALOAD_3 | KW_ANEWARRAY | KW_ARETURN | KW_ARRAYLENGTH | KW_ASTORE | KW_ASTORE_0 | KW_ASTORE_1 | KW_ASTORE_2 | KW_ASTORE_3 | KW_ATHROW | KW_BALOAD | KW_BASTORE | KW_BIPUSH | KW_CALOAD | KW_CASTORE | KW_CHECKCAST | KW_D2F | KW_D2I | KW_D2L | KW_DADD | KW_DALOAD | KW_DASTORE | KW_DCMPG | KW_DCMPL | KW_DCONST_0 | KW_DCONST_1 | KW_DDIV | KW_DLOAD | KW_DLOAD_0 | KW_DLOAD_1 | KW_DLOAD_2 | KW_DLOAD_3 | KW_DMUL | KW_DNEG | KW_DREM | KW_DRETURN | KW_DSTORE | KW_DSTORE_0 | KW_DSTORE_1 | KW_DSTORE_2 | KW_DSTORE_3 | KW_DSUB | KW_DUP | KW_DUP_X1 | KW_DUP_X2 | KW_DUP2 | KW_DUP2_X1 | KW_DUP2_X2 | KW_F2D | KW_F2I | KW_F2L | KW_FADD | KW_FALOAD | KW_FASTORE | KW_FCMPG | KW_FCMPL | KW_FCONST_0 | KW_FCONST_1 | KW_FCONST_2 | KW_FDIV | KW_FLOAD | KW_FLOAD_0 | KW_FLOAD_1 | KW_FLOAD_2 | KW_FLOAD_3 | KW_FMUL | KW_FNEG | KW_FREM | KW_FRETURN | KW_FSTORE | KW_FSTORE_0 | KW_FSTORE_1 | KW_FSTORE_2 | KW_FSTORE_3 | KW_FSUB | KW_GETFIELD | KW_GETSTATIC | KW_GOTO_W | KW_I2B | KW_I2C | KW_I2D | KW_I2F | KW_I2L | KW_I2S | KW_IADD | KW_IALOAD | KW_IAND | KW_IASTORE | KW_ICONST_M1 | KW_ICONST_0 | KW_ICONST_1 | KW_ICONST_2 | KW_ICONST_3 | KW_ICONST_4 | KW_ICONST_5 | KW_IDIV | KW_IF_ACMPEQ | KW_IF_ACMPNE | KW_IF_ICMPEQ | KW_IF_ICMPNE | KW_IF_ICMPLT | KW_IF_ICMPGE | KW_IF_ICMPGT | KW_IF_ICMPLE | KW_IFEQ | KW_IFNE | KW_IFLT | KW_IFGE | KW_IFGT | KW_IFLE | KW_IFNONNULL | KW_IFNULL | KW_IINC | KW_ILOAD | KW_ILOAD_0 | KW_ILOAD_1 | KW_ILOAD_2 | KW_ILOAD_3 | KW_IMUL | KW_INEG | KW_INVOKEDYNAMIC | KW_INVOKEINTERFACE | KW_INVOKESPECIAL | KW_INVOKESTATIC | KW_INVOKEVIRTUAL | KW_IOR | KW_IREM | KW_IRETURN | KW_ISHL | KW_ISHR | KW_ISTORE | KW_ISTORE_0 | KW_ISTORE_1 | KW_ISTORE_2 | KW_ISTORE_3 | KW_ISUB | KW_IUSHR | KW_IXOR | KW_JSR | KW_JSR_W | KW_L2D | KW_L2F | KW_L2I | KW_LADD | KW_LALOAD | KW_LAND | KW_LASTORE | KW_LCMP | KW_LCONST_0 | KW_LCONST_1 | KW_LDC | KW_LDC_W | KW_LDC2_W | KW_LDIV | KW_LLOAD | KW_LLOAD_0 | KW_LLOAD_1 | KW_LLOAD_2 | KW_LLOAD_3 | KW_LMUL | KW_LNEG | KW_LOOKUPSWITCH | KW_LOR | KW_LREM | KW_LRETURN | KW_LSHL | KW_LSHR | KW_LSTORE | KW_LSTORE_0 | KW_LSTORE_1 | KW_LSTORE_2 | KW_LSTORE_3 | KW_LSUB | KW_LUSHR | KW_LXOR | KW_MONITORENTER | KW_MONITOREXIT | KW_MULTIANEWARRAY | KW_NEWARRAY | KW_NOP | KW_POP | KW_POP2 | KW_PUTFIELD | KW_PUTSTATIC | KW_RET | KW_SALOAD | KW_SASTORE | KW_SIPUSH | KW_SWAP | KW_TABLESWITCH | KW_WIDE
    ;
    
signedByteLiteral
returns [byte value]
    : token=(IntegerLiteral | NegativeIntegerLiteral) {$value = parseByteLiteral($token.text);}
    ;
    
signedShortLiteral
returns [short value]
    : token=(IntegerLiteral | NegativeIntegerLiteral) {$value = parseShortLiteral($token.text);}
    ;
    
integerLiteral
returns [int value]
    : token=IntegerLiteral {$value = parseIntegerLiteral($token.text);}
    ;
    
signedIntegerLiteral
returns [int value]
    : token=(IntegerLiteral | NegativeIntegerLiteral) {$value = parseIntegerLiteral($token.text);}
    ;
    
longLiteral
returns [long value]
    : token=(LongLiteral | IntegerLiteral) {$value = parseLongLiteral($token.text);}
    ;
    
signedLongLiteral
returns [long value]
    : token=(LongLiteral | NegativeLongLiteral | IntegerLiteral | NegativeIntegerLiteral) {$value = parseLongLiteral($token.text);}
    ;
    
floatLiteral
returns [float value]
    : token=FloatingPointLiteral {$value = parseFloatLiteral($token.text);}
    ;
    
doubleLiteral
returns [double value]
    : token=DoubleLiteral {$value = parseDoubleLiteral($token.text);}
    ;
    
characterLiteral
returns [char value]
    : token=CharacterLiteral {$value = parseCharacterLiteral($token.text);}
    ;
    
stringLiteral
returns [String value]
    : token=StringLiteral {$value = parseStringLiteral($token.text);}
    ;