package com.shoulder.controller;

import com.shoulder.model.Menu;
import com.shoulder.model.Result;
import com.shoulder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) throws Exception {
        List<Menu> menus = menuService.getList();
        model.addAttribute("menus", menus);
        return "menu/list";
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result getMenus() throws Exception {
        return Result.success(menuService.getList());
    }

    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    public Result getMenu(Integer id) throws Exception {
        return Result.success(menuService.findMenu(id));
    }

    @ResponseBody
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public Result addMenu(Menu menu) {
        try {
            boolean flag = menuService.addMenu(menu);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    public Result editMenu(Menu menu) {
        try {
            boolean flag = menuService.updateMenu(menu);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMenu")
    public Result deleteMenu(Integer id) {
        try {
            boolean flag = menuService.deleteMenu(id);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

}
