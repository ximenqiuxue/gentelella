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
import java.util.Arrays;
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
    public String toIndex() {
        return "user/index";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public Map userIndex(@RequestParam(value = "draw") String draw,
                         @RequestParam(value = "start") String start,
                         @RequestParam(value = "limit") String limit,
                         @RequestParam(value = "order") String order) throws Exception {
        log.info("order"+order);
        Map params = new HashMap();
        params.put("start", start);
        params.put("limit", limit);
        params.put("orderBy", order);
        PageInfo<Map> pageInfo = userService.findEntity(params);
        Map returnMap = new HashMap();
        returnMap.put("users",pageInfo.getList());
        returnMap.put("draw",draw);
        returnMap.put("total",pageInfo.getTotal());
        return returnMap;
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
