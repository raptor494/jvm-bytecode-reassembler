package com.raptor.test06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface ClassOnlyAnnotation {
    String value();
}
