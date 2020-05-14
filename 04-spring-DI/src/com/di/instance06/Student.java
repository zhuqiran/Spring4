package com.di.instance06;

/**
 * 使用xml注入方式中的设置注入，完成对属性值的注入
 */

public class Student {
    private String name;
    private int age;
    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
