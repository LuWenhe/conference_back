package edu.conf.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)    // 将注解放在方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    // 模块名称
    String module() default "";

    // 操作名称
    String operator() default "";

}
