package com.shoulder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class loginController {

    @RequestMapping(value = "login")
    public String toIndex() {
        System.out.println("已登录");
        return "redirect:/common/index.do";
    }
}
