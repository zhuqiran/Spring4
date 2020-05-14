package com.di.instance01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String resource = "com/di/instance01/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
