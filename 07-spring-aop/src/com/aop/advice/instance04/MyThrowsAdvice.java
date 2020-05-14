package com.aop.advice.instance04;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {
    /**
     * 目标方法发生异常时执行，可以在该方法中定义一些当目标方法发生异常后的处理逻辑。
     *
     * @param ex // 目标方法发生异常的异常对象
     */
    public void afterThrowing(UserNameException ex) {
        System.out.println("用户名输入发生异常了！异常信息为： message = " + ex.getMessage());
    }

    /**
     * 目标方法发生异常时执行，在此方法中可以对目标方法发生的异常进行一些处理
     *
     * @param ex // 目标方法发生异常的异常对象
     */
    public void afterThrowing(PasswordException ex) {
        System.out.println("密码输入发生异常了！异常信息为： message = " + ex.getMessage());
    }

}
