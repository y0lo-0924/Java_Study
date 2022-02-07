package com.y0lo.dao;

import com.y0lo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据ID查询用户
    User queryUserById(@Param("id") int id);

    int updateUser(User user);
}
