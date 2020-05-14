package com.factories;

import com.services.ISomeService;
import com.services.SomeServiceImpl;

/**
 * 动态工厂Bean
 *  通过动态工厂的方式产生需要的Bean对象，而不是容器对象对其定义的Bean进行创建。
 */
public class ServiceFactory {
    // 返回SomeService对象
    public ISomeService getSomeService(){
        return new SomeServiceImpl();
    }
}
