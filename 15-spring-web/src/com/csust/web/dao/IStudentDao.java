package com.csust.web.dao;

import com.csust.web.entity.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    int insertStudent(Student student);
    int deleteStudent(int id);
    int updateStudent(Student student);

    Student selectById(int id);
    String selectNameById(int id);
    List<Student> selectAll();
    List<String> selectAllNames();
    List<Map<String, Object>> selectOptional();
}
