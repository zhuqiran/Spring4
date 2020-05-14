package com.aop.advice.instance02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * AspectJ基于xml的AOP实现
 *
 * 定义一个切面
 */
public class MyAspect {
    /**
     * 前置通知
     */
    public void beforeAdvice(){
        System.out.println("执行前置通知方法");
    }

    // 前置通知方法的参数
    public void beforeAdvice(JoinPoint joinPoint){
        // joinPoint = execution(void com.aop.advice.instance01.ISomeService.doFirst())
        System.out.println("执行前置通知方法 joinPoint = " + joinPoint);
    }


    /**
     * 后置通知
     */
    public void afterAdvice(){
        System.out.println("执行后置通知方法");
    }
    /**
     * 后置通知， 获取到目标方法的返回值，通过配置returning参数。需要注意的是，方法的参数名要和returnning参数的参数值一致
     */
    public void afteAdvice(Object result){
        System.out.println("执行后置通知方法 result = " + result);
    }


    /**
     * 环绕通知
     * 增强方法有ProceedingJoinPoint参数
     */
    public String aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("在目标方法之前执行");
        // 执行目标方法
        String res = (String) proceedingJoinPoint.proceed();
        System.out.println("在目标方法之后执行");
        return res;
    }

    /**
     * 异常通知
     */
    public void exceptionAdvice(ArithmeticException ex){
        System.out.println("执行异常通知方法" + ex.getMessage());
    }


    /**
     * 最终通知(不论方法是不是会出现异常，在方法执行完成以后都会执行该方法)
     */
    public void finallyAdvice(){
        System.out.println("执行最终通知方法");
    }

}
