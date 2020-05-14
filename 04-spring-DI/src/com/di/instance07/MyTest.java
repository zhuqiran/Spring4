package com.di.instance07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String path = "com/di/instance07/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);

        Student student2 = (Student) context.getBean("student2");
        System.out.println(student2);
    }
}
