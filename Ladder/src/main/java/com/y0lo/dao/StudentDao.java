package com.y0lo.dao;

import com.y0lo.pojo.Student;

import java.sql.Connection;
import java.util.List;

public interface    StudentDao {
    public Student getStudentById(Connection connection,int id);

    public List<Student> getALlStudent(Connection connection);

    public Long getCount(Connection connection);
}
