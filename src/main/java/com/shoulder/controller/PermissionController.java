package com.shoulder.controller;

import com.shoulder.model.Permission;
import com.shoulder.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) {
        List<Permission> permissions = permissionService.getAllEntity();
        model.addAttribute("permissions", permissions);
        return "permission/list";
    }
}
