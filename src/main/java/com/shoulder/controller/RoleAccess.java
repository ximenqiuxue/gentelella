package com.shoulder.controller;

import com.shoulder.model.Menu;
import com.shoulder.model.Result;
import com.shoulder.model.Role;
import com.shoulder.model.RoleMenu;
import com.shoulder.service.MenuService;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/role-access")
public class RoleAccess {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) throws Exception{
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        return "role/role-access";
    }

    @ResponseBody
    @RequestMapping(value = "/getMenuTree")
    public List<Menu> getTree() throws Exception {
        return menuService.getTreeMenu();
    }

    @ResponseBody
    @RequestMapping(value = "/getTreeMenuById")
    public List<Menu> getRoleMenus(Integer id) throws Exception {
        return menuService.getTreeMenu(id);
    }
}
