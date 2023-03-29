package com.kj.permission.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Permission
public @interface GeneralAdmin {
    int role() default 0;
}
