package com.aop.proxycreator.instance01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 正则表达式方法切入点顾问
 *  RegexpMethodPointcutAdvisor，即正则表达式方法顾问。容器可根据正则表达式来设置切入点。
 *  注意，与正则表达式进行匹配的对象是接口中的方法名，而非目标类（接口的实现类）的方法名。
 */
public class MyTest {
    @Test
    public void test01(){
        String path = "com/aop/proxycreator/instance01/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ISomeService someService = (ISomeService) context.getBean("someService");
        someService.doFirst();
        System.out.println("==========================================");
        someService.doSecond();

        System.out.println("------------------------------------------------------");

        ISomeService someService2 = (ISomeService) context.getBean("someService2");
        someService2.doFirst();
        System.out.println("==========================================");
        someService2.doSecond();
    }
}
