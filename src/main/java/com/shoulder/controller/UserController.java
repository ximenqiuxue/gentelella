package com.shoulder.controller;

import com.github.pagehelper.PageInfo;
import com.shoulder.model.Result;
import com.shoulder.model.Role;
import com.shoulder.model.User;
import com.shoulder.model.Department;
import com.shoulder.service.DepartService;
import com.shoulder.service.RoleService;
import com.shoulder.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "user/list";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public Result userIndex(@RequestParam(value = "draw") String draw,
                            @RequestParam(value = "start", defaultValue = "0") String start,
                            @RequestParam(value = "limit", defaultValue = "10") String limit,
                            @RequestParam(value = "order") String order) throws Exception {
        Map params = new HashMap();
        params.put("start", start);
        params.put("limit", limit);
        params.put("orderBy", order);
        PageInfo<Map> pageInfo = userService.findEntity(params);
        Map returnMap = new HashMap();
        returnMap.put("users", pageInfo.getList());
        returnMap.put("draw", draw);
        returnMap.put("total", pageInfo.getTotal());
        return Result.success(returnMap);
    }

    @ResponseBody
    @RequestMapping(value = "/toAddOrUpdate")
    public Map toAddOrUpdate(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        Map returnMap = new HashMap();
        if (id != null) {
            Map<String, Object> user = userService.findUserById(id);
            returnMap.put("user", user);
        }
        List<Role> roles = roleService.getAll();
        List<Department> departments = departService.getAll();
        returnMap.put("roles", roles);
        returnMap.put("departments", departments);
        return returnMap;
    }

    @ResponseBody
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Result saveUser(User user, String deptId, String rId) throws Exception {
        log.info("user"+user);
        boolean returnFlag = userService.addOrupdateUser(user, deptId, rId);
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser")
    public Result deleteUser(Integer id) throws Exception {
        boolean flag = userService.deleteById(id);
        return Result.success();
    }
}
