package com.csust.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * 自定义监听器，不借助spring-web的jar包完成，将Spring容器在项目初始化的时候放入到ServletContext域属性空间中
 */
@WebListener
public class ServletConfigListener implements ServletContextListener {
    // 在ServletContext对象初始化时执行
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 将Spring容器对象放入到ServletContext容器中
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        servletContext.setAttribute("context", context);
    }
}
