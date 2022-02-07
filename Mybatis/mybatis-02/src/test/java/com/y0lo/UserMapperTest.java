package com.y0lo;

import com.y0lo.dao.UserMapper;
import com.y0lo.pojo.User;
import com.y0lo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){

        //第一步：获得SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        //方式一：getMapper
/*
        UserDao userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
*/

        //方式二：
        List<User> objects = sqlSession.selectList("com.y0lo.com.y0lo.dao.UserMapper.getUserList");

        for (User user : objects) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(4, "嘿嘿", "123456"));
        if(user>0){
            System.out.println("插入成功");
        }

        //所有的增删改查都需要提交事务
        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"呵呵","123123"));

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","Hello");
        map.put("userpassword","2222223");

        mapper.addUser2(map);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","com.y0lo");

        User user = mapper.getUserById2(map);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userLike = mapper.getUserLike("%李%");
        for (User user : userLike) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
