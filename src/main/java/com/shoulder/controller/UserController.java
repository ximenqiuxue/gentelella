package com.shoulder.controller;

import com.github.pagehelper.PageInfo;
import com.shoulder.constants.PageConst;
import com.shoulder.model.Role;
import com.shoulder.model.User;
import com.shoulder.model.Department;
import com.shoulder.service.DepartService;
import com.shoulder.service.RoleService;
import com.shoulder.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartService departService;

    @RequestMapping(value = "/index")
    public String userIndex(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, Model model) throws Exception {
        PageInfo<User> pageInfo = userService.findEntity(pageIndex, PageConst.PAGESIZE);
        List<User> users = pageInfo.getList();
        model.addAttribute("users", users);
        model.addAttribute("pageInfo", pageInfo);
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
