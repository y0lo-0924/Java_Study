import com.y0lo.dao.UserDaoMysqlImpl;
import com.y0lo.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //用户实际调用的是业务层
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();

        //获取ApplicationContext：拿到spring的容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //需要什么就直接get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl)context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
