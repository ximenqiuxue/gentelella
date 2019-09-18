package com.shoulder.controller;

import com.shoulder.model.Result;
import com.shoulder.model.Role;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public Result addRole(Role role) throws Exception {
        boolean flag = roleService.addRole(role);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public Result getRole(Integer id) throws Exception {
        Role role = roleService.findRole(id);
        return Result.success(role);
    }

    @ResponseBody
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public Result updateROle(Role role) throws Exception {
        boolean flag = roleService.updateRole(role);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole")
    public Result deleteRole(Integer id) throws Exception {
        boolean flag = roleService.deleteRole(id);
        return Result.success();
    }

}
