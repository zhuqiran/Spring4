package com.di.instance02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String path = "com/di/instance02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
