package com.aop.advice.instance01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * AspectJ基于注解的AOP实现
 *
 * 定义一个切面:通过@Aspect注解实现
 *
 * 具体的通知，通过定义方法实现
 */
@Aspect
public class MyAspect {
    /**
     * 前置通知
     *  @Before 注解表示
     */
    @Before(value = "execution(* *..ISomeService.doFirst(..))")
    public void beforeAdvice(){
        System.out.println("执行前置通知方法");
    }

    // 前置通知方法的参数
    @Before(value = "execution(* ISomeService.doFirst(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        // joinPoint = execution(void com.aop.advice.instance01.ISomeService.doFirst())
        System.out.println("执行前置通知方法 joinPoint = " + joinPoint);
    }


    /**
     * 后置通知
     *  @AfterReturning 注解表示
     */
    @AfterReturning(value = "execution(* *..ISomeService.doSecond(..))")
    public void afterAdvice(){
        System.out.println("执行后置通知方法");
    }
    /**
     * 后置通知， 获取到目标方法的返回值，通过配置returning参数。需要注意的是，方法的参数名要和returnning参数的参数值一致
     *  @AfterReturning 注解表示
     */
    @AfterReturning(value = "execution(* *..ISomeService.doSecond(..))", returning = "result")
    public void afteAdvice(Object result){
        System.out.println("执行后置通知方法 result = " + result);
    }


    /**
     * 环绕通知
     * 增强方法有ProceedingJoinPoint参数
     */
    @Around(value = "execution(* *..ISomeService.doThird(..))")
    public String aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("在目标方法之前执行");
        // 执行目标方法
        String res = (String) proceedingJoinPoint.proceed();
        System.out.println("在目标方法之后执行");
        return res;
    }

    /**
     * 异常通知
     * @AfterThrowing
     */
    @AfterThrowing(value = "execution(* *..ISomeService.doThird(..))", throwing = "ex")
    public void exceptionAdvice(ArithmeticException ex){
        System.out.println("执行异常通知方法" + ex.getMessage());
        ex.printStackTrace();
    }


    /**
     * 最终通知(不论方法是不是会出现异常，在方法执行完成以后都会执行该方法)
     * @After
     */
//    @After(value = "execution(* *..ISomeService.doThird(..))")
    @After(value = "doThirdPointcut()")
    public void finallyAdvice(){
        System.out.println("执行最终通知方法");
    }


    /**
     * 通过上面的代码，我们发现，切入点表达式的定义存在着繁琐冗余的现象。
     * 我们可以通过定义一个切入点来解决这个问题
     *
     * 定义切入点，切入点的名称为：doThirdPointcut()，可以通过这个名称引入其定义的切入点表达式
     */
    @Pointcut(value = "execution(* *..ISomeService.doThird(..))")
    public void doThirdPointcut(){

    }

}
