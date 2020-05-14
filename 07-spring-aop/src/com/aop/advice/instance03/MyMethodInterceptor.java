package com.aop.advice.instance03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * 该方法在目标方法前后都执行，因为目标方法的指定就是在该方法中完成的。通过methodInvocation对象即可执行目标方法。
     * 值得注意的是，该方法有返回值，所以可以修改目标方法的返回值。
     * @param methodInvocation      // 调用目标方法的handler
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("在目标方法之前执行");
        // 执行目标方法，并获取返回值
        Object res = methodInvocation.proceed();
        // 修改目标方法的返回值
        if(res != null){
            res = ((String)res).toUpperCase();
        }

        System.out.println("在目标方法之后执行");

        return res;
    }
}
