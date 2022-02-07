package com.y0lo.dao;

import com.y0lo.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    //获取所有老师
    Teacher getTeacher(int id);

    //获取指定老师下的所有学生及老师的信息
//    Teacher getTeacher(@Param("tid") int id);
}
