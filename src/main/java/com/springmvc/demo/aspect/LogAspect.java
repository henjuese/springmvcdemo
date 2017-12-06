package com.springmvc.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public * com.springmvc.demo.service.impl..*.*(..))")
    public void controllerLog() {
        //define pointcut
    }

    @Before("controllerLog()")
    public void object(JoinPoint pjp) {
        String className = pjp.getTarget().getClass().getName();
        System.out.println("before className:" + className);
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
    }

    @After("controllerLog()")
    public void after(JoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getSimpleName();
        System.out.println("after className:" + className);
    }

//    @Around("controllerLog()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        String className = pjp.getTarget().getClass().getSimpleName();
//        System.out.println("around before className:" + className);
//        Object o = pjp.proceed();
//        System.out.println("around after.......");
//        return o;
//    }
}
