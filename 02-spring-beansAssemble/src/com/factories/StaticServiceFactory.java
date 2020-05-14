package com.factories;

import com.services.ISomeService;
import com.services.SomeServiceImpl;

/**
 * 静态工厂Bean
 */
public class StaticServiceFactory {
    // 返回Service Bean
    public static ISomeService getSomeService(){
        return new SomeServiceImpl();
    }
}
