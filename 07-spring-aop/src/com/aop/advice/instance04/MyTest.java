package com.aop.advice.instance04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 切面的通知实现：
 *  异常通知，当检测到目标方法发生异常时执行。
 */
public class MyTest {
    @Test
    public void test01() {
        String path = "com/aop/advice/instance04/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        ILoginService loginService = (ILoginService) context.getBean("loginProxy");
        try {
            loginService.login("lisi", "111222");
        }catch (UserNameException e) {
            System.out.println(e.getMessage());
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}
