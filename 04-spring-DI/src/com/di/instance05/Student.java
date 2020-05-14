package com.di.instance05;

/**
 * 使用xml注入方式中的设置注入，完成对属性值的注入
 */

public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public int computeAge(){

        return this.age > 25? 25 : this.age;
    }
}
