package com.github.dylanz666.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE})
public @interface Skip {
    //like: "cm" or { "cm" } or { "qa" , "cm" , "pr" }
    String[] env() default {};

    //like: 2019-12-15
    String before() default "";

    //like: 2019-12-15
    String when() default "";

    //like: 2019-12-15
    String after() default "";
}
