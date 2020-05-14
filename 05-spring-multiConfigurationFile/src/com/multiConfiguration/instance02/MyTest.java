package com.multiConfiguration.instance02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String resource = "com/multiConfiguration/instance02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
    }
}
