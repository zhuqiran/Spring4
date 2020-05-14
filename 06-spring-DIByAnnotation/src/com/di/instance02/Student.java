package com.di.instance02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    /*@Autowired          // byType的方式注入域属性
    private School school;*/

    @Autowired
    @Qualifier(value = "school")     // byName的方式注入。需要注意的是，使用byName方式时，需要联合AutoWired使用
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
