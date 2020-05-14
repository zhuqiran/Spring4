package com.aop.advice.instance01;

// 目标类

public class SomeServiceImpl implements ISomeService {

    // 目标方法
    @Override
    public void doFirst() {
        System.out.println("执行doFirst()方法！");
    }

    // 目标方法
    @Override
    public String doSecond() {
        System.out.println("执行doSecond()方法！");
        return "abcd";
    }

    @Override
    public void doThird() {
//        System.out.println("执行doThird()方法!" + 2/0);
        System.out.println("执行doThird()方法!");
    }
}
