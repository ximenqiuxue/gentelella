package com.shoulder.controller;

import com.shoulder.model.User;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index")
    public String userIndex(Model model) throws Exception {
        List<Map<String, Object>> userList = userService.findEntity();
        model.addAttribute("users", userList);
        return "user/list";
    }

    @RequestMapping(value = "/toUpdateUser")
    public String toEdit(@PathParam("id") Integer id, Model model) throws Exception {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/updateUser")
    public String saveUser(User user) {
        System.out.println("Param User :" + user);
        return "redirect:/user/index.do";
    }
}
