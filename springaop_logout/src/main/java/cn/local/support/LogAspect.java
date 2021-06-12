package cn.local.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * fix: 自定义注解
 * Springaop切面处理 自定义注解 -> @Pointcut("@annotation(cn.local.support.LogAspect)")
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAspect {
    String logName() default "LogAspect OUT LOG";
}
