package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
public class HandleLogger {

    private final static Logger logger = LoggerFactory.getLogger(HandleLogger.class);

    // 切入点
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void handleControllerLogger(){};



    // 定义的advice
    // 切入点方法 run 之前要干的
    @Before("handleControllerLogger()")
    public void handle(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        logger.info("接收请求url:{}",request.getRequestURL().toString());
        logger.info("接收请求Method:{}",request.getMethod());
        logger.info("接收请求IP:{}",request.getRemoteAddr());
        logger.info("接收请求Param:{}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("handleControllerLogger()")
    public void handleAfter(JoinPoint jp){
        logger.info("接受方法以执行完成,状态正常");
    }



    @PostConstruct
    public void init(){
        logger.info("Spring Aop-Pointcut初始化成功");
    }





}
