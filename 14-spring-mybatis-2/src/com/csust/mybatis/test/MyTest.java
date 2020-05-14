package com.csust.mybatis.test;

import com.csust.mybatis.entity.Student;
import com.csust.mybatis.service.IStudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class MyTest {

    private IStudentService service;

    @Before
    public void before(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        service = (IStudentService) context.getBean("studentService");
    }

    @Test
    public void testAdd(){
        Student student = new Student("张三三", 18, 97);
        int i = service.addStudent(student);
        System.out.println(i);
    }
    @Test
    public void testModify(){
        Student student = new Student("张三三new", 18, 97);
        student.setId(1);
        int i = service.modifyStudent(student);
        System.out.println(i);
    }
    @Test
    public void testRemove(){
        int i = service.removeStudent(2);
        System.out.println(i);
    }

    @Test
    public void testSelectById(){
        Student student = service.searchById(3);
        System.out.println(student);
    }

    @Test
    public void testSelectNameById(){
        String name = service.searchNameById(3);
        System.out.println(name);
    }

    @Test
    public void testSelectAll(){
        List<Student> students = service.searchAll();
        for (Student student: students
             ) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectAllNames(){
        List<String> names = service.searchAllNames();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    @Test
    public void testSelectOptional(){
        List<Map<String, Object>> maps = service.selectOptional();
        for (Map<String, Object> map: maps
             ) {
            System.out.println(map.get("name") + map.get("age").toString());
        }
    }
}
