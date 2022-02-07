package com.y0lo;

import com.y0lo.dao.UserMapper;
import com.y0lo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {


    @Test
    public void test(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
/*        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }*/

/*        User userById = mapper.getUserById(1);
        System.out.println(userById);*/

//        mapper.addUser(new User(9,"HELLO1","111111"));

//        mapper.updateUser(new User(9,"HELLO2","111111"));

        mapper.deleteUser(9);
        sqlSession.close();

    }
}
