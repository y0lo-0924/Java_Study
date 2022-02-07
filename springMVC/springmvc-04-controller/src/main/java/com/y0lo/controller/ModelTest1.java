package com.y0lo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "test";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model){
        model.addAttribute("msg","ModelTest1.test2");
        //转发
        return "/WEB-INF/jsp/test.jsp";
    }
    @RequestMapping("/m1/t3")
    public String test3(Model model){
        model.addAttribute("msg","ModelTest1.test2");
        //转发
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t4")
    public String test4(Model model){
        model.addAttribute("msg","ModelTest1.test2");
        //重定向
        /*return "redirect:/WEB-INF/jsp/test.jsp";*/
        return "redirect:/index.jsp";
    }
}
