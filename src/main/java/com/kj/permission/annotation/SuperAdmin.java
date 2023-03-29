package com.kj.permission.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Permission
public @interface SuperAdmin {

    @AliasFor(annotation = Permission.class)
    int role() default 1;
}
