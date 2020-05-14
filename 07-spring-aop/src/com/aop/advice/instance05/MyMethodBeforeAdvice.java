package com.aop.advice.instance05;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

// 前置通知
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-----------在目标方法之前执行----------------");
    }
}
