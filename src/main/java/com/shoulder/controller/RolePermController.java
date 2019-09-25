package com.shoulder.controller;

import com.shoulder.model.Permission;
import com.shoulder.model.Result;
import com.shoulder.model.Role;
import com.shoulder.model.RolePerm;
import com.shoulder.service.PermissionService;
import com.shoulder.service.RolePermService;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/role-perm")
public class RolePermController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) throws Exception {
        /*List<Permission> permissions = permissionService.getAllEntity();
        model.addAttribute("permissions", permissions);*/
        return "role/role-perm";
    }

    @ResponseBody
    @RequestMapping(value = "/getRoleTree")
    public List<Role> getRoleTree() throws Exception {
        return roleService.getAll();
    }



}
