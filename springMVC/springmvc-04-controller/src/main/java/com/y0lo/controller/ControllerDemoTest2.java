package com.y0lo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类会被Spring接管，被这个注解的类，中的所有方法，如果返回值是String，并且有具体的页面可以跳转，就会被视图解析器解析
public class ControllerDemoTest2 {
    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest2");
//        return "hello";  //WEB-INF/jsp/hello.jsp  不存在   404 未找到
        return "test";
    }

    @RequestMapping("/t3")
    public String test2(Model model){
        model.addAttribute("msg","test3");
//        return "hello";  //WEB-INF/jsp/hello.jsp  不存在   404 未找到
        return "test";
    }
}
