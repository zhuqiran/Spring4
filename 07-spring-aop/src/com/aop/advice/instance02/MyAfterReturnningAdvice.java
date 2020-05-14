package com.aop.advice.instance02;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterReturnningAdvice implements AfterReturningAdvice {
    /**
     *  该方法在目标方法之后执行，由于没有返回值，所以无法修改目标方法的返回值
     * @param returnValue   目标方法的返回值
     * @param method        目标方法
     * @param args          目标方法的参数列表
     * @param target        目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("目标方法的后置方法执行了 returnValue = " + returnValue);
    }
}
