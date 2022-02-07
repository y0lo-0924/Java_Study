package com.y0lo.diy;

//方式三：使用注解实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.y0lo.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }

    @After("execution(* com.y0lo.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点；
    @Around("execution(* com.y0lo.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp){
        System.out.println("环绕前");

        //执行方法
        try {
            Object proceed = jp.proceed();
            Signature signature = jp.getSignature();
            System.out.println(signature);
            System.out.println("环绕后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
