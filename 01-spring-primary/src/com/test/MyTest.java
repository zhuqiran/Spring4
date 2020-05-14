package com.test;

import com.services.ISomeService;
import com.services.SomeServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyTest {
    // 以前的面向接口编程
    @Test
    public void test01(){
        ISomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    // spring中的ApplicationContext容器注入方式的面向接口编程
    @Test
    public void test02(){
        // 通过spring的配置文件，创建ApplicationContext容器.
        // 以类路径的方式，读取xml文件并创建ApplicationContext容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 以文件系统路径的方式，读取xml文件
        // ApplicationContext context = new FileSystemXmlApplicationContext("D:/IdeaProjects/Spring4Project/out/production/01-spring-primary/applicationContext.xml");
//        ApplicationContext context1 = new FileSystemXmlApplicationContext("src/applicationContext.xml");

        // 从容器中通过id获取service对象
        ISomeService service = (ISomeService) context.getBean("serviceOfISomeService");
        service.doSome();
    }

    /**
     * spring中的BeanFactory容器注入方式的面向接口编程.
     * BeanFactory接口是ApplicationContext接口的父接口
     *
     */
    @Test
    public void test03(){
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        // 从容器中通过id获取service对象
        ISomeService service = (ISomeService) factory.getBean("serviceOfISomeService");
        service.doSome();
    }

    /**
     * ApplicationContext和BeanFactory容器的区别：
     *  1）ApplicationContext容器，在初始化的时候，会一并初始化其容器中定义的Bean对象。
     *      优点：响应速度快。
     *      缺点：相对占用较多的系统资源。
     *  2）BeanFactory容器，在初始化的时候并不会一并初始化其定义的Bean对象，而是当Bean对象真正到使用的时候才创建。
     *      优点：占用系统资源相对较少
     *      缺点：相对响应速度较慢
     */
}




























