package cn.local.support.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * fix: 自定义注解进行切面
 */
@Slf4j
@Aspect
@Component
public class AspectExcuteByInterface {


    @Pointcut("@annotation(cn.local.support.LogAspect)")
    public void pointExcute(){}

    @Before("pointExcute()")
    public void before(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        String[] paramNamms = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (String thisParam : paramNamms){

        }

        log.info("模拟权益请求进来后进行保存保存请求");
        log.info("benefit Request add:{}",request.getMethod());
    }

    @After("pointExcute()")
    public void afterExcute(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        log.info("RequestPath:{},请求完成",request.getRequestURI());
    }


    @AfterReturning(value = "pointExcute()",returning="re")
    public void afterReturnExcute(Object re){
        log.info("Response Data:{}",re);

    }




}
