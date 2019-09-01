package com.shoulder.controller;

import com.shoulder.model.Role;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/index")
    public String getRoles(Model model) throws Exception {
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        return "role/list";
    }

}