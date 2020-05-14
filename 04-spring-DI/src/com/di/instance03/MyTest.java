package com.di.instance03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String path = "com/di/instance03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        SomeCollection some = (SomeCollection) context.getBean("someCollection");
        System.out.println(some);
    }
}
