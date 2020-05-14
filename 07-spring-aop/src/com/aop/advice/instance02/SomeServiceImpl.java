package com.aop.advice.instance02;

// 目标类

public class SomeServiceImpl implements ISomeService {

    // 目标方法
    @Override
    public String doFirst() {
        System.out.println("执行doFirst()方法！");
        return "abcd";
    }

    // 目标方法
    @Override
    public String doSecond() {
        System.out.println("执行doSecond()方法！");
        return "edhfads";
    }
}
