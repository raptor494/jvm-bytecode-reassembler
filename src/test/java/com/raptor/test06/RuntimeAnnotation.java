package com.raptor.test06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RuntimeAnnotation {
    String[] value();
    int optionalValue() default 0;
    Class<?> optionalClass() default void.class;
    boolean flag() default false;
    ClassOnlyAnnotation annotation() default @ClassOnlyAnnotation("value");
    char c() default '\0';
}
