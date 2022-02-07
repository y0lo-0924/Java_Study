import com.y0lo.pojo.User;
import com.y0lo.pojo.UserT;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)context.getBean("us3r");
        user.show();
        UserT user2 = (UserT)context.getBean("user2");
    }
}
