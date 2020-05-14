package com.aop.advisor.instance01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-----在目标方法之前执行---------");
    }
}
