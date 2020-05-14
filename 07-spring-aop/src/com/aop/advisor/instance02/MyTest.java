package com.aop.advisor.instance02;

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
        String path = "com/aop/advisor/instance02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ISomeService someService = (ISomeService) context.getBean("someServiceProxy");
        someService.doFirst();
        System.out.println("==========================================");
        someService.doSecond();
    }
}
