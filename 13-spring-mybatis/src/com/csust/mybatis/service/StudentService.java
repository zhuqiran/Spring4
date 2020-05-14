package com.csust.mybatis.service;

import com.csust.mybatis.dao.IStudentDao;
import com.csust.mybatis.entity.Student;

import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {

    private IStudentDao studentDao;

    // 通过设置注入的方式，注入StudentDao对象
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int removeStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int modifyStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student searchById(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public String searchNameById(int id) {
        return studentDao.selectNameById(id);
    }

    @Override
    public List<Student> searchAll() {
        return studentDao.selectAll();
    }

    @Override
    public List<String> searchAllNames() {
        return studentDao.selectAllNames();
    }
    @Override
    public List<Map<String, Object>> selectOptional(){
        return studentDao.selectOptional();
    }
}
