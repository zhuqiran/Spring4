package com.multiConfiguration.instance01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        /*String resource = "com/multiConfiguration/instance01/spring-base.xml";
        String resource2 = "com/multiConfiguration/instance01/spring-beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resource, resource2);*/

        // 还可以以通配符的方式导入
        String resource = "com/multiConfiguration/instance01/spring-*.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(resource);
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
    }
}
