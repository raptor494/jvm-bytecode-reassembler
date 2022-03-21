package com.raptor.test06;

import java.util.Collection;
import java.util.function.Predicate;

public class TestClass06 {
    String stringConstant() {
        return "test string\n\0\"";
    }
    
    Class<String> classConstant() {
        return String.class;
    }

    Predicate<Object> lambda() {
        return (obj) -> obj != null;
    }

    Predicate<String> methodReference() {
        return String::isEmpty;
    }   
    
    @SourceOnlyAnnotation
    int field1;

    @ClassOnlyAnnotation("field2 value")
    int field2;

    @RuntimeAnnotation(value="field3 value")
    int field3;

    @RuntimeAnnotation(value="field4 value", optionalValue=1)
    int field4;

    @RuntimeAnnotation(value="field5 value", optionalClass=String.class)
    @ClassOnlyAnnotation("field5 value")
    int field5;

    @RuntimeAnnotation(value="field6 value", optionalValue='B', optionalClass=Object.class, annotation=@ClassOnlyAnnotation("field6 value"), flag=true, c='A')
    int field6;
}
