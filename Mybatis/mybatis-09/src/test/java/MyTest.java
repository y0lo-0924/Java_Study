import com.y0lo.dao.UserMapper;
import com.y0lo.pojo.User;
import com.y0lo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        //手动清理一级缓存
        sqlSession.clearCache();

        System.out.println("========================");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        System.out.println(user==user1);

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        User user = new User(2,"test","1");
        mapper.updateUser(user);

        System.out.println("================");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1==user2);

    }
}
