package com.services;

public class SomeServiceImpl implements ISomeService {
    @Override
    public String doFirst() {
        System.out.println("执行doFirst()方法！");
        return "abcd";
    }

    @Override
    public String doSecond() {
        System.out.println("执行doSecond()方法！");
        return "dfhskdj";
    }
}
