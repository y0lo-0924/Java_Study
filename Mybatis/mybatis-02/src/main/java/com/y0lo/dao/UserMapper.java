package com.y0lo.dao;

import com.y0lo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    List<User> getUserLike(String value);

    //根据ID查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //万能的Map
    int addUser2(Map<String,Object> map);

    User getUserById2(Map<String,Object> map);
}
