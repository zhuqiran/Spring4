package com.csust.transactional.test;

import com.csust.transactional.exception.BuyStockException;
import com.csust.transactional.service.IBuyStockService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    private IBuyStockService service;
    @Before
    public void before(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        service = (IBuyStockService) context.getBean("proxyService");
    }

    @Test
    public void test01(){
        service.createAccount("李思思", 10000);
        service.createStock("动力节点", 0);
    }

    @Test
    public void test02(){
        try {
            service.buyStock("李思思", 2000, "动力节点", 5);
        } catch (BuyStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
