package com.di.instance01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "student")       // 指定该Student为组件。value属性为Bean的id
@Scope(value = "singleton")         // 设置Bean的作用域。默认就是singleton.
public class Student {
    @Value(value = "张三")
    private String name;
    @Value(value = "18")
    private int age;
    // @Resource(name = "school")      // byName的方式          // JSR中的注解，完成对域属性的注入
    @Resource       // byType的方式注入域属性
    private School school;

    /*注解的方式装配Bean，不需要在借助Setter方法*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
