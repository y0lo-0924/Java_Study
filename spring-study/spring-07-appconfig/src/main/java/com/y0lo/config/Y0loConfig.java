package com.y0lo.config;

import com.y0lo.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// 这个也会Spring容器托管，注册到容器中，因为他本身就是一个@Compoent
// @Configuration代表这是一个配置类，就是和我们之前看的beans.xml是一样的
@ComponentScan("com.y0lo.pojo")
@Import(y0loConfig2.class)
public class Y0loConfig {

    //注册一个bean，就相当于我们之前写的一个bean标签
    //这个方法的名字就相当于bean标签中的id属性
    //这个方法的返回值就相当于bean标签中的class属性
    @Bean
    public User getuser(){
        return new User();  //就是放要注入到bean的对象！
    }
}
