package com.aop.advice.instance02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01(){
        String path = "com/aop/advice/instance02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        ISomeService someService = (ISomeService) context.getBean("someService");
        someService.doFirst();
        System.out.println("-------------------------------------------");
        someService.doSecond();
        System.out.println("-------------------------------------------");
        someService.doThird();
    }
}
