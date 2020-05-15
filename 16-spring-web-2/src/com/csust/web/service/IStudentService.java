package com.csust.web.service;

import com.csust.web.entity.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    int addStudent(Student student);
    int removeStudent(int id);
    int modifyStudent(Student student);

    Student searchById(int id);
    String searchNameById(int id);
    List<Student> searchAll();
    List<String> searchAllNames();
    public List<Map<String, Object>> selectOptional();
}
