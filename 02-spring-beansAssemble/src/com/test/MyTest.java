package com.test;

import com.services.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    // 演示利用动态工厂Bean，装配需要的ServiceBean
    public void test01(){
        // 创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过容器获取Service Bean
        ISomeService service = (ISomeService) context.getBean("serviceOfISomeService");
        service.doSome();
    }

    @Test
    // 演示利用静态工厂Bean，装配需要的Service Bean
    public void test02(){
        // 创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISomeService service = (ISomeService) context.getBean("myService");
        service.doSome();
    }
}
