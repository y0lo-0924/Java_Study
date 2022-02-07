package com.y0lo.controller;

import com.y0lo.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("a1")
    public void a1(String name, Model model, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if("y0lo".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("a2")
    public List<User> a2(){
        ArrayList<User> userList = new ArrayList<>();
        //添加数据
        userList.add(new User("y0lo",20,"男"));
        userList.add(new User("y0lo菜",20,"男"));
        userList.add(new User("y0lo贼菜",20,"男"));

        return userList;
    }

    @RequestMapping("a3")
    public String a3(String name,String pwd){
        String msg="";
        if(name!=null){
            if("admin".equals(name)){
                msg="ok";
            }else {
                msg="用户名有误！";
            }
        }
        if(pwd!=null){
            if("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="密码有误！";
            }
        }
        return msg;
    }
}
