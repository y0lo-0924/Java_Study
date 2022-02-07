package com.y0lo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="com.y0lo.pojo.User"/>
//@Component组件
@Component
@Scope("prototype")
public class User {

    //相当于<property name="name" value="y0lo"/>
    public String name;

    @Value("y0lo")
    public void setName(String name) {
        this.name = name;
    }
}
