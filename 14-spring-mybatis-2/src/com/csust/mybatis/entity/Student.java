package com.csust.mybatis.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private double score;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student(String name, Integer age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
