package com.aop.advice.instance05;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterReturningAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("---------------在目标方法之后执行------------:" + o);
    }
}