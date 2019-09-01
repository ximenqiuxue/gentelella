package com.shoulder.controller;

import com.shoulder.model.Menu;
import com.shoulder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Menu> getMenus() throws Exception {
        return menuService.getAll();
    }
}
