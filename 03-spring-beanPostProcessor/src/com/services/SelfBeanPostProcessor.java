package com.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SelfBeanPostProcessor implements BeanPostProcessor {
    // 该方法会在Bean初始化完成之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("------------before-----------");
        return bean;
    }

    // 该方法会在Bean初始化完成之后执行

    /**
     * 可以利用该特性，以代理的方式对目标Bean进行增强。
     *
     * @param bean  系统初始化完成的Bean对象
     * @param beanName  系统初始化完成的Bean对象的id。若Bean对象没有id就是name属性值。
     * @return  Bean实例对象
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 对指定Bean对象进行增强
        if("someService".equals(beanName)){
            Object obj = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // 对指定的方法进行增强
                            if("doFirst".equals(method.getName())){
                                // 调用bean的方法，并取得返回值
                                String res = (String) method.invoke(bean, args);
                                res = res.toUpperCase();
                                return res;
                            }else {
                                return method.invoke(bean, args);
                            }
                        }
                    }
            );
            return obj;
        }
        return bean;
    }
}
