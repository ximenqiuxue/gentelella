package com.shoulder.controller;

import com.alibaba.fastjson.JSON;
import com.shoulder.model.Permission;
import com.shoulder.model.Result;
import com.shoulder.model.Role;
import com.shoulder.model.RolePerm;
import com.shoulder.service.PermissionService;
import com.shoulder.service.RolePermService;
import com.shoulder.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/role-perm")
public class RolePermController {

    private static final Logger log = Logger.getLogger(RolePermController.class);

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermService rolePermService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) throws Exception {
        List<Permission> permissions = permissionService.getAllEntity();
        List<Role> roles = roleService.getAll();
        model.addAttribute("permissions", permissions);
        model.addAttribute("roles", roles);
        return "role/role-perm";
    }

    @ResponseBody
    @RequestMapping(value = "/getAuthPerm")
    public Result getAuthPerm(Integer rid) {
        try {
            return Result.success(rolePermService.findAuthPermission(rid));
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/getRoleTree")
    public Result getRoleTree(@RequestParam(value = "rids[]") Integer[] rids,
                              @RequestParam(value = "pids[]") Integer[] pids) throws Exception {
        Set<Integer> rIds = new HashSet<>();
        Set<Integer> pIds = new HashSet<>();
        for (Integer r : rids) {
            rIds.add(r);
            log.info(r);
        }
        for (Integer p : pids) {
            pIds.add(p);
            log.info(p);
        }
        for (Integer r : rIds) {
            log.info(r + "-rids-");
        }
        for (Integer p : pIds) {
            log.info(p + "-pids-");
        }
        return Result.success();
    }


}
