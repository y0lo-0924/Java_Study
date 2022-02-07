package com.y0lo.dao;

import com.y0lo.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师的信息！
    List<Student> getStudent();
    List<Student> getStudent2();
}
