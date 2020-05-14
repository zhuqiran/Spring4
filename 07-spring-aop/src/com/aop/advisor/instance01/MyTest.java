package com.aop.advisor.instance01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 名称匹配方法切入点顾问
 */
public class MyTest {
    @Test
    public void test01(){
        String path = "com/aop/advisor/instance01/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ISomeService someService = (ISomeService) context.getBean("someServiceProxy");
        someService.doFirst();
        System.out.println("==========================================");
        someService.doSecond();
    }
}
