package com.shoulder.controller;

import com.shoulder.model.User;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index")
    public String userIndex(Model model) {
        List<User> userList = userService.findEntity();
        model.addAttribute("users", userList);
        return "user/list";
    }
}
