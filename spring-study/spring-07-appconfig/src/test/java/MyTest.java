import com.y0lo.config.Y0loConfig;
import com.y0lo.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //如果完全使用了配置类方式去做，我们就只能通过 AnnotationConfigApplicationContext 上下文来获取容器，通过配置类的class对象加载！
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Y0loConfig.class);
        User getUser = (User) context.getBean("getuser");
        System.out.println(getUser.getName());
    }
}
