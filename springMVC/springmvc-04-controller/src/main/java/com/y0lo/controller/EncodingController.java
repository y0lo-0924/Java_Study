package com.y0lo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class EncodingController {

    //过滤器解决乱码
    @PostMapping("/e/t1")
    public String test1(String name, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }
}
