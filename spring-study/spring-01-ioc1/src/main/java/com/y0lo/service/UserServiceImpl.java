package com.y0lo.service;

import com.y0lo.dao.UserDao;
import com.y0lo.dao.UserDaoImpl;
import com.y0lo.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{
//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao2 = new UserDaoMysqlImpl();

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
//        userDao2.getUser();
    }
}
