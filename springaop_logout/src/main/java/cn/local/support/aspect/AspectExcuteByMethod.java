package cn.local.support.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AspectExcuteByMethod {


    /**
     * 定义切入点pointCut
     */

//    @Pointcut("execution(* cn.local.service..*.*(..))")
//
//    public void pointExcute(){}
//
//
//    @Before("pointExcute()")
//    public void before(JoinPoint joinPoint){
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//
//        log.info("接收请求url:{}",request.getRequestURL().toString());
//        log.info("接收请求Method:{}",request.getMethod());
//        log.info("接收请求IP:{}",request.getRemoteAddr());
//        log.info("接收请求Param:{}", Arrays.toString(joinPoint.getArgs()));
//        log.info("before：{}","excuteBeforeAdd");
//    }
//
//    @After("pointExcute()")
//    public void after(){
//        log.info("after:{}","excuterAfterAdd");
//    }
//
//    @AfterReturning(value = "pointExcute()",returning = "responseData")
//    public void aspectAfterReturn(Object responseData){
//        log.info("response BodyByData:{}",responseData);
//    }
//
}
