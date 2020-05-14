package com.di.instance02;

/**
 * 使用xml注入方式中的构造器注入，完成对属性值的注入。
 *
 * 值得注意的是，使用构造器的方式完成属性值注入：
 *  1）不再需要定义无参构造器，容器在初始化Bean对象时，自动使用带参构造器完成Bean的实例化。
 *  2）无须为成员变量定义setter方法。
 */

public class Student {
    private String name;
    private String age;
    private School school;

    public Student(String name, String age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", school=" + school +
                '}';
    }
}
