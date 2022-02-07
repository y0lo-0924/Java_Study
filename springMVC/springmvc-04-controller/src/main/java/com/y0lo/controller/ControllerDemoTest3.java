package com.y0lo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerDemoTest3 {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","ControllerDemoTest3");
        return "admin/test";
    }
}
