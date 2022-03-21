lexer grammar ASMLexer;

//tokens { INDENT, DEDENT }

tokens { LongLiteral, DoubleLiteral, NegativeLongLiteral, INDENT, DEDENT }

@header {
import com.raptor.antlr.denterhelper.DenterHelper;
import com.raptor.antlr.denterhelper.DefaultDenterHelper;
import com.raptor.antlr.denterhelper.InvalidDedentException;
}

@members {
/*
private boolean enableDenter = false;
private int indentCount;
private final DenterHelper denter = new DenterHelper(NL, INDENT, DEDENT) {
    protected Token pullToken() {
        return ASMLexer.super.nextToken();
    }
    protected void handlePartialDedent(int prevIndent, int targetIndent, Token copyFrom) {
        //indentations.clear();
        //indentations.push(0);
        //System.out.println(dentsBuffer);
        //dentsBuffer.removeIf(tk -> tk.getType() == indentToken || tk.getType() == dedentToken || tk.getType() == nlToken);
        //dentsBuffer.offerFirst(createToken(dedentToken, copyFrom));
        //throw new InvalidDedentException(ASMLexer.this, _input, null);
        //super.handlePartialDedent(prevIndent, targetIndent, copyFrom);
        disable();
    }
};
{denter.disable();}
private Token prevToken, prevPrevToken;

@Override
public Token nextToken() {
    Token token;
    token = denter.nextToken();
    if (denter.isEnabled()) {
        switch (token.getType()) {
            case NL -> {
                if (indentCount == 0) {
                    denter.disable();                  
                } else {
                    ((WritableToken)token).setChannel(0);
                }
            }
            case INDENT -> {
                indentCount++;
                ((WritableToken)token).setChannel(0);
            }
            case DEDENT -> {
                if (--indentCount == 0) {
                    denter.disable();
                }
                ((WritableToken)token).setChannel(0);
            }
        }
    } else {
        // if (token.getType() == NL) {
        //     if (prevPrevToken != null && prevPrevToken.getType() == KW_CODE && prevToken.getType() == COLON) {
        //         denter.reset();
        //         denter.enable(); 
        //     }
        // }
        // if (token.getType() == COLON) {
        //     if (prevToken != null && prevToken.getType() == KW_CODE) {
        //         denter.reset();
        //         denter.enable();
        //     }
        // }
    }
    prevPrevToken = prevToken;
    prevToken = token;
    return token;
}
*/
/*    
@Override
public void recover(RecognitionException e) {
    throw e;
}
*/
}

//#region Keywords

//#region Java Reserved Words
KW_ABSTRACT : 'abstract';
KW_ASSERT : 'assert';
KW_BOOLEAN : 'boolean';
KW_BREAK : 'break';
KW_BYTE : 'byte';
KW_CASE : 'case';
KW_CATCH : 'catch';
KW_CHAR : 'char';
KW_CLASS : 'class';
KW_CONST : 'const';
KW_CONTINUE : 'continue';
KW_DEFAULT : 'default';
KW_DO : 'do';
KW_DOUBLE : 'double';
KW_ELSE : 'else';
KW_ENUM : 'enum';
KW_EXTENDS : 'extends';
KW_FALSE : 'false';
KW_FINAL : 'final';
KW_FINALLY : 'finally';
KW_FLOAT : 'float';
KW_FOR : 'for';
KW_IF : 'if';
KW_GOTO : 'goto';
KW_IMPLEMENTS : 'implements';
KW_IMPORT : 'import';
KW_INSTANCEOF : 'instanceof';
KW_INT : 'int';
KW_INTERFACE : 'interface';
KW_LONG : 'long';
KW_NATIVE : 'native';
KW_NEW : 'new';
KW_NULL : 'null';
KW_PACKAGE : 'package';
KW_PRIVATE : 'private';
KW_PROTECTED : 'protected';
KW_PUBLIC : 'public';
KW_RETURN : 'return';
KW_SHORT : 'short';
KW_STATIC : 'static';
KW_STRICTFP : 'strictfp';
KW_SUPER : 'super';
KW_SWITCH : 'switch';
KW_SYNCHRONIZED : 'synchronized';
KW_THIS : 'this';
KW_THROW : 'throw';
KW_THROWS : 'throws';
KW_TRANSIENT : 'transient';
KW_TRUE : 'true';
KW_TRY : 'try';
KW_VOID : 'void';
KW_VOLATILE : 'volatile';
KW_WHILE : 'while';
KW_UNDER_SCORE : '_';//Introduced in Java 9

//#endregion

//#region Language-specific keywords

KW_SYNTHETIC : 'synthetic';
KW_MANDATED : 'mandated';
KW_BRIDGE : 'bridge';
KW_DEPRECATED : 'deprecated';
KW_CODE : 'Code';
KW_RUNTIME_VISIBILE_ANNOTATIONS : 'RuntimeVisibleAnnotations';
KW_RUNTIME_INVISIBLE_ANNOTATIONS : 'RuntimeInvisibleAnnotations';
INIT : '<init>';

//#endregion

//#region Bytecode Instruction Keywords

KW_AASTORE : 'aastore';
KW_ACONST_NULL : 'aconst_null';
KW_ALOAD : 'aload';
KW_ALOAD_0 : 'aload_0';
KW_ALOAD_1 : 'aload_1';
KW_ALOAD_2 : 'aload_2';
KW_ALOAD_3 : 'aload_3';
KW_ANEWARRAY : 'anewarray';
KW_ARETURN : 'areturn';
KW_ARRAYLENGTH : 'arraylength';
KW_ASTORE : 'astore';
KW_ASTORE_0 : 'astore_0';
KW_ASTORE_1 : 'astore_1';
KW_ASTORE_2 : 'astore_2';
KW_ASTORE_3 : 'astore_3';
KW_ATHROW : 'athrow';
KW_BALOAD : 'baload';
KW_BASTORE : 'bastore';
KW_BIPUSH : 'bipush';
KW_CALOAD : 'caload';
KW_CASTORE : 'castore';
KW_CHECKCAST : 'checkcast';
KW_D2F : 'd2f';
KW_D2I : 'd2i';
KW_D2L : 'd2l';
KW_DADD : 'dadd';
KW_DALOAD : 'daload';
KW_DASTORE : 'dastore';
KW_DCMPG : 'dcmpg';
KW_DCMPL : 'dcmpl';
KW_DCONST_0 : 'dconst_0';
KW_DCONST_1 : 'dconst_1';
KW_DDIV : 'ddiv';
KW_DLOAD : 'dload';
KW_DLOAD_0 : 'dload_0';
KW_DLOAD_1 : 'dload_1';
KW_DLOAD_2 : 'dload_2';
KW_DLOAD_3 : 'dload_3';
KW_DMUL : 'dmul';
KW_DNEG : 'dneg';
KW_DREM : 'drem';
KW_DRETURN : 'dreturn';
KW_DSTORE : 'dstore';
KW_DSTORE_0 : 'dstore_0';
KW_DSTORE_1 : 'dstore_1';
KW_DSTORE_2 : 'dstore_2';
KW_DSTORE_3 : 'dstore_3';
KW_DSUB : 'dsub';
KW_DUP : 'dup';
KW_DUP_X1 : 'dup_x1';
KW_DUP_X2 : 'dup_x2';
KW_DUP2 : 'dup2';
KW_DUP2_X1 : 'dup2_x1';
KW_DUP2_X2 : 'dup2_x2';
KW_F2D : 'f2d';
KW_F2I : 'f2i';
KW_F2L : 'f2l';
KW_FADD : 'fadd';
KW_FALOAD : 'faload';
KW_FASTORE : 'fastore';
KW_FCMPG : 'fcmpg';
KW_FCMPL : 'fcmpl';
KW_FCONST_0 : 'fconst_0';
KW_FCONST_1 : 'fconst_1';
KW_FCONST_2 : 'fconst_2';
KW_FDIV : 'fdiv';
KW_FLOAD : 'fload';
KW_FLOAD_0 : 'fload_0';
KW_FLOAD_1 : 'fload_1';
KW_FLOAD_2 : 'fload_2';
KW_FLOAD_3 : 'fload_3';
KW_FMUL : 'fmul';
KW_FNEG : 'fneg';
KW_FREM : 'frem';
KW_FRETURN : 'freturn';
KW_FSTORE : 'fstore';
KW_FSTORE_0 : 'fstore_0';
KW_FSTORE_1 : 'fstore_1';
KW_FSTORE_2 : 'fstore_2';
KW_FSTORE_3 : 'fstore_3';
KW_FSUB : 'fsub';
KW_GETFIELD : 'getfield';
KW_GETSTATIC : 'getstatic';
//GOTO : 'goto';
KW_GOTO_W : 'goto_w';
KW_I2B : 'i2b';
KW_I2C : 'i2c';
KW_I2D : 'i2d';
KW_I2F : 'i2f';
KW_I2L : 'i2l';
KW_I2S : 'i2s';
KW_IADD : 'iadd';
KW_IALOAD : 'iaload';
KW_IAND : 'iand';
KW_IASTORE : 'iastore';
KW_ICONST_M1 : 'iconst_m1';
KW_ICONST_0 : 'iconst_0';
KW_ICONST_1 : 'iconst_1';
KW_ICONST_2 : 'iconst_2';
KW_ICONST_3 : 'iconst_3';
KW_ICONST_4 : 'iconst_4';
KW_ICONST_5 : 'iconst_5';
KW_IDIV : 'idiv';
KW_IF_ACMPEQ : 'if_acmpeq';
KW_IF_ACMPNE : 'if_acmpne';
KW_IF_ICMPEQ : 'if_icmpeq';
KW_IF_ICMPNE : 'if_icmpne';
KW_IF_ICMPLT : 'if_icmplt';
KW_IF_ICMPGE : 'if_icmpge';
KW_IF_ICMPGT : 'if_icmpgt';
KW_IF_ICMPLE : 'if_icmple';
KW_IFEQ : 'ifeq';
KW_IFNE : 'ifne';
KW_IFLT : 'iflt';
KW_IFGE : 'ifge';
KW_IFGT : 'ifgt';
KW_IFLE : 'ifle';
KW_IFNONNULL : 'ifnonnull';
KW_IFNULL : 'ifnull';
KW_IINC : 'iinc';
KW_ILOAD : 'iload';
KW_ILOAD_0 : 'iload_0';
KW_ILOAD_1 : 'iload_1';
KW_ILOAD_2 : 'iload_2';
KW_ILOAD_3 : 'iload_3';
KW_IMUL : 'imul';
KW_INEG : 'ineg';
//INSTANCEOF : 'instanceof';
KW_INVOKEDYNAMIC : 'invokedynamic';
KW_INVOKEINTERFACE : 'invokeinterface';
KW_INVOKESPECIAL : 'invokespecial';
KW_INVOKESTATIC : 'invokestatic';
KW_INVOKEVIRTUAL : 'invokevirtual';
KW_IOR : 'ior';
KW_IREM : 'irem';
KW_IRETURN : 'ireturn';
KW_ISHL : 'ishl';
KW_ISHR : 'ishr';
KW_ISTORE : 'istore';
KW_ISTORE_0 : 'istore_0';
KW_ISTORE_1 : 'istore_1';
KW_ISTORE_2 : 'istore_2';
KW_ISTORE_3 : 'istore_3';
KW_ISUB : 'isub';
KW_IUSHR : 'iushr';
KW_IXOR : 'ixor';
KW_JSR : 'jsr';
KW_JSR_W : 'jsr_w';
KW_L2D : 'l2d';
KW_L2F : 'l2f';
KW_L2I : 'l2i';
KW_LADD : 'ladd';
KW_LALOAD : 'laload';
KW_LAND : 'land';
KW_LASTORE : 'lastore';
KW_LCMP : 'lcmp';
KW_LCONST_0 : 'lconst_0';
KW_LCONST_1 : 'lconst_1';
KW_LDC : 'ldc';
KW_LDC_W : 'ldc_w';
KW_LDC2_W : 'ldc2_w';
KW_LDIV : 'ldiv';
KW_LLOAD : 'lload';
KW_LLOAD_0 : 'lload_0';
KW_LLOAD_1 : 'lload_1';
KW_LLOAD_2 : 'lload_2';
KW_LLOAD_3 : 'lload_3';
KW_LMUL : 'lmul';
KW_LNEG : 'lneg';
KW_LOOKUPSWITCH : 'lookupswitch';
KW_LOR : 'lor';
KW_LREM : 'lrem';
KW_LRETURN : 'lreturn';
KW_LSHL : 'lshl';
KW_LSHR : 'lshr';
KW_LSTORE : 'lstore';
KW_LSTORE_0 : 'lstore_0';
KW_LSTORE_1 : 'lstore_1';
KW_LSTORE_2 : 'lstore_2';
KW_LSTORE_3 : 'lstore_3';
KW_LSUB : 'lsub';
KW_LUSHR : 'lushr';
KW_LXOR : 'lxor';
KW_MONITORENTER : 'monitorenter';
KW_MONITOREXIT : 'monitorexit';
KW_MULTIANEWARRAY : 'multianewarray';
//NEW : 'new';
KW_NEWARRAY : 'newarray';
KW_NOP : 'nop';
KW_POP : 'pop';
KW_POP2 : 'pop2';
KW_PUTFIELD : 'putfield';
KW_PUTSTATIC : 'putstatic';
KW_RET : 'ret';
//RETURN : 'return';
KW_SALOAD : 'saload';
KW_SASTORE : 'sastore';
KW_SIPUSH : 'sipush';
KW_SWAP : 'swap';
KW_TABLESWITCH : 'tableswitch';
KW_WIDE : 'wide';

//#endregion
//#endregion
    
//#region Separators/Operators

APPLY_TO : ':=>';
PLUS   : '+';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI   : ';';
COLON  : ':';
COMMA  : ',';
DOT    : '.';
AT     : '@';
ELLIPSIS : '...';
LT     : '<';
GT     : '>';
AMP    : '&';
BAR    : '|';
QUES   : '?';
STAR   : '*';
EQ     : '=';

//#endregion

//#region Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

//#endregion

//#region Whitespace and comments

NL  :   ('\r' '\n'? | '\n') [ \t]* -> channel(HIDDEN)
    ;

WS  :   [ \t\u000C]+ -> skip
    ;

//#region Descriptor comments
/*
ClassDescriptor
    : '//' WS? [cC]'lass' WS SlashyName WS? (NL | EOF)
    ;

FieldDescriptor
    : '//' WS? [fF]'ield' WS (SlashyName '.')? Identifier ':' NonVoidTypeName WS? (NL | EOF)
    ;

StringDescriptor
    : '//' WS? [sS]'tring' WS StringCharacters? (NL | EOF)
    ;

MethodDescriptor
    : '//' WS? [mM]'ethod' WS (SlashyName '.')? (Identifier | '"<init>"' | '"<clinit>"') ':' MethodTypeName WS? (NL | EOF)
    ;

MethodTypeDescriptor
    : '//' WS? [mM]'ethod'[tT]'ype' WS MethodTypeName WS? (NL | EOF)
    ;

fragment SlashyName
    : Identifier ('/' Identifier)*
    ;

fragment MethodTypeName
    : '(' NonVoidTypeName* ')' TypeName
    ;

fragment TypeName
    : NonVoidTypeName
    | VoidTypeName
    ;

fragment NonVoidTypeName
    : PrimitiveTypeName
    | ReferenceTypeName
    | ArrayTypeName
    ;

fragment PrimitiveTypeName
    : [BSIJCFDZ]
    ;

fragment VoidTypeName
    : 'V'
    ;

fragment ReferenceTypeName
    : 'L' SlashyName ';'
    ;

fragment ArrayTypeName
    : '[' NonVoidTypeName
    ;
*/
//#endregion

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;

//#endregion
 
//#region Integer Literals

NegativeIntegerLiteral
    :   '-' IntegerLiteral
{
switch (getText().charAt(getText().length() - 1)) {
    case 'l', 'L': setType(NegativeLongLiteral);
}
}
    ;

IntegerLiteral
    :   (   DecimalIntegerLiteral
        |   HexIntegerLiteral
        |   OctalIntegerLiteral
        |   BinaryIntegerLiteral
        )
{
switch (getText().charAt(getText().length() - 1)) {
    case 'l', 'L': setType(LongLiteral);
}
}
    ;

//#region Integer Literal Fragments

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;

fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;

fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitsAndUnderscores? Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitsAndUnderscores
    :   DigitOrUnderscore+
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitsAndUnderscores? HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitsAndUnderscores
    :   HexDigitOrUnderscore+
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitsAndUnderscores
    :   OctalDigitOrUnderscore+
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitsAndUnderscores
    :   BinaryDigitOrUnderscore+
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

//#endregion
//#endregion

//#region Floating-Point Literals

FloatingPointLiteral
    :   '-'? (   DecimalFloatingPointLiteral
        |   HexadecimalFloatingPointLiteral
        )
{
switch (getText().charAt(getText().length() - 1)) {
    case 'f', 'F' -> {}
    default -> setType(DoubleLiteral);
}
}
    ;

//#region Floating-Point Literal Fragments

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

fragment
FloatTypeSuffix
    :   [fFdD]
    ;

fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;

fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;

fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;

fragment
BinaryExponentIndicator
    :   [pP]
    ;

//#endregion
//#endregion

//#region Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

fragment
SingleCharacter
    :   ~['\\\r\n]
    ;

//#endregion

//#region String Literals

StringLiteral
    :   '"' StringCharacters? '"'
    ;
    
fragment
StringCharacters
    :   StringCharacter+
    ;
    
fragment
StringCharacter
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

//#endregion

//#region Escape Sequences for Character and String Literals

fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// This is not in the spec but prevents having to preprocess the input
fragment
UnicodeEscape
    :   '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

//#endregion
