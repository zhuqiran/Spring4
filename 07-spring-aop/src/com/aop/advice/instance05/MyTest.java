package com.aop.advice.instance05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  为目标方法配置多个切面（通知的方式实现切面）
 */
public class MyTest {
    @Test
    public void test01(){
        String path = "com/aop/advice/instance05/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ISomeService service = (ISomeService) context.getBean("someServiceProxy");
        service.doFirst();

        System.out.println("========================");

        service.doSecond();
    }
}
