package com.csust.template.dao;

import com.csust.template.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 行元素映射
 */
public class StudentRowMapper implements RowMapper<Student> {
    /**
     * 需要注意的是，resultSet并不是全部的查询结果集，而是查询中每一行的结果集。即框架会自动遍历结果集，将每一行的内容放入到resultSet中。
     * @param resultSet
     * @param i
     */
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student(resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getDouble("score"));
        student.setId(resultSet.getInt("id"));
        return student;
    }
}
