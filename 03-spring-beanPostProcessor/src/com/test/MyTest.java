package com.test;

import com.services.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISomeService service = (ISomeService) context.getBean("someService");
        System.out.println(service.doFirst());
        System.out.println(service.doSecond());
    }
}
