package com.y0lo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //http://localhost:8080/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation!");
        return "hello";     //会被视图解析器处理
    }
}
