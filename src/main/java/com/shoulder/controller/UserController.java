package com.shoulder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/index")
    public String userIndex() {
        return "user/list";
    }
}
