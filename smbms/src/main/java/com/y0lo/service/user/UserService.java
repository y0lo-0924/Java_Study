package com.y0lo.service.user;

import com.y0lo.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode,String password);

    //根据用户ID修改密码
    public boolean updatePwd(int id,String password);

    //查询记录数
    public int getUserCount(String username,int userRole);
}
