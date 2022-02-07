package com.y0lo.dao;

import com.y0lo.pojo.Student;
import com.y0lo.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao{
    @Override
    public Student getStudentById(Connection connection, int id) {
        String sql = "select * from student where id = ?";
        System.out.println(sql);
        Student student = getBean(connection,sql,id);
        return student;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from student";
        return (Long) getValue(connection,sql);
    }

    @Override
    public List<Student> getALlStudent(Connection connection) {
        String sql = "select * from student";
        List<Student> studentList = getBeanList(connection, sql);
        return studentList;
    }

    @Test
    public void testGetStudentById(){
        Connection connection = null;
        StudentDaoImpl studentDao = new StudentDaoImpl();
        try {
            connection = JDBCutils.getConnection();
            Student studentById = studentDao.getStudentById(connection, 1);
            System.out.println(studentById.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.closeResource(connection,null,null);
        }

    }

    @Test
    public void testGetAllStudent(){
        Connection connection = null;
        StudentDaoImpl studentDao = new StudentDaoImpl();

        try {
            connection = JDBCutils.getConnection();
            List<Student> aLlStudent = studentDao.getALlStudent(connection);
            for (Student student : aLlStudent) {
                System.out.println(student.getName());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void testGetCount(){
        Connection connection = null;
        StudentDaoImpl studentDao = new StudentDaoImpl();
        try {
            connection = JDBCutils.getConnection();
            Long count = studentDao.getCount(connection);
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
