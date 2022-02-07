package com.y0lo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

//这里这个注解的意思，就是说明这个类被Spring接管了，注册到了容器中。
@Controller
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("y0lo")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
