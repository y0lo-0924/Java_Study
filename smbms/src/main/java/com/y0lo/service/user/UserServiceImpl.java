package com.y0lo.service.user;

import com.y0lo.dao.BaseDao;
import com.y0lo.dao.user.UserDao;
import com.y0lo.dao.user.UserDaoImpl;
import com.y0lo.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class UserServiceImpl implements UserService {
    //业务层都会调用dao层，所以我们要引入DAO层;
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user = userDao.getLoginUser(connection,userCode,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
    return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "1234567");
        System.out.println(admin.getUserPassword());
    }

    public boolean updatePwd(int id, String password) {
        System.out.println("UserServiceImpl:"+password);
        Connection connection = null;
        boolean flag=false;

        //修改密码
        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection,id,password)>0){
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    //查询记录数
    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Test
    public void test2(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null, 0);
        System.out.println(userCount);
    }

}
