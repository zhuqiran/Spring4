package com.aop.advice.instance01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * aop编程中的通知类，通知类要实现相应通知类型的接口
 *
 * 例如，这个通知要在目标方法执行之前进行，就需要实现MethodBeforeAdvice接口。
 * 实现before()方法，该before方法会在目标方法执行之前执行。即前置通知
 */

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    // 在目标方法之前执行
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行doLog方法.......");
    }
}
