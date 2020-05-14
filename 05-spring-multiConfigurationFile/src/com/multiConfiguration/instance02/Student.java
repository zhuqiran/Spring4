package com.multiConfiguration.instance02;

/**
 * 使用xml注入方式中的设置注入，完成对属性值的注入
 */

public class Student {
    private String name;
    private int age;
    private String university;
    private String department;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
