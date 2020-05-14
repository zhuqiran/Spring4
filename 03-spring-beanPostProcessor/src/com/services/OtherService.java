package com.services;

public class OtherService implements ISomeService {


    @Override
    public String doFirst() {
        System.out.println("------other doFirst-------");
        return "odjfa";
    }

    @Override
    public String doSecond() {
        System.out.println("------other doSecond-------");
        return "null";
    }
}
