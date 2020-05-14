package com.csust.template.dao;

import com.csust.template.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  继承JdbcDaoSupport类，通过getJdbcTemplate方法得到JDBCTemplate对象，
 *  然后通过JDBCTemplate对象进行数据操作
 */

public class StudentDao extends JdbcDaoSupport implements IStudentDao {
    @Override
    public int insertStudent(Student student) {
        String sql = "insert into student(name, age, score) values(?, ?, ?)";
        int count = this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getScore());
        return count;
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        int count = this.getJdbcTemplate().update(sql, id);
        return count;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set name = ?, age = ?, score = ? where id = ?";
        int count = this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getScore(), student.getId());
        return count;
    }

    @Override
    public Student selectById(int id) {
        String sql = "select id, name, age, score from student where id = ?";
        Student student = this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public String selectNameById(int id) {
        String sql = "select name from student where id = ?";
        String name = this.getJdbcTemplate().queryForObject(sql, String.class, id);
        return name;
    }

    @Override
    public List<Student> selectAll() {
        String sql = "select id, name, age, score from student";
        List<Student> studentList = this.getJdbcTemplate().query(sql, new StudentRowMapper());
        return studentList;
    }

    @Override
    public List<String> selectAllNames() {
        String sql = "select name from student";
        List<String> names = this.getJdbcTemplate().queryForList(sql, String.class);
        return names;
    }
    @Override
    public List<Map<String, Object>> selectOptional(){
        String sql = "select name, age from student";
        List<Map<String, Object>> result = this.getJdbcTemplate().query(sql, new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> map = new HashMap<>();
                map.put("name", resultSet.getString("name"));
                map.put("age", resultSet.getInt("age"));
                return map;
            }
        });

        return result;
    }
}
