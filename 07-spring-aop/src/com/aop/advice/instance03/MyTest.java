package com.aop.advice.instance03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 以通知的方法实现切面：
 *  环绕通知，在目标方法的前后执行。可以修改目标方法的返回值。
 */
public class MyTest {
    @Test
    public void test01(){
        String path = "com/aop/advice/instance03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ISomeService service = (ISomeService) context.getBean("serviceProxy");
        String res = service.doFirst();
        System.out.println(res);

        System.out.println("====================");

        System.out.println(service.doSecond());

    }
}
