package com.shoulder.controller;

import com.shoulder.model.Role;
import com.shoulder.model.User;
import com.shoulder.model.Department;
import com.shoulder.service.DepartService;
import com.shoulder.service.RoleService;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartService departService;

    @RequestMapping(value = "/index")
    public String userIndex(Model model) throws Exception {
        List<User> users = userService.findEntity();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/toUpdateUser")
    public String toEdit(@PathParam("id") Integer id, Model model) throws Exception {
        Map<String, Object> user = userService.findUserById(id);
        List<Role> roles = roleService.getAll();
        List<Department> departments = departService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        model.addAttribute("departments", departments);
        return "user/edit";
    }

    @RequestMapping(value = "/updateUser")
    public String saveUser(User user) {
        System.out.println("Param User :" + user);
        return "redirect:/user/index.do";
    }
}
