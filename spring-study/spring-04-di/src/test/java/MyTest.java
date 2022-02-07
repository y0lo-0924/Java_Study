import com.y0lo.pojo.Student;
import com.y0lo.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = (User)context.getBean("user2");
        User user2 = (User)context.getBean("user2");
        System.out.println(user==user2);
    }
}

