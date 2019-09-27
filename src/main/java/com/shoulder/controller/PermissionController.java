package com.shoulder.controller;

import com.github.pagehelper.PageInfo;
import com.shoulder.model.PageResult;
import com.shoulder.model.Permission;
import com.shoulder.model.Result;
import com.shoulder.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/index")
    public String toIndex(Model model) throws Exception {
        List<Permission> permissions = permissionService.getAllEntity();
        model.addAttribute("permissions", permissions);
        return "permission/list";
    }

    @ResponseBody
    @RequestMapping(value = "/getPermList", method = RequestMethod.GET)
    public Result permissionList(Integer page, Integer limit) {
        try {
            return Result.success(permissionService.getAllEntity());
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getPermission", method = RequestMethod.GET)
    public Result getPermission(Integer id) {
        try {
            Permission permission = permissionService.getPermission(id);
            return Result.success(permission);
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public Result addPerm(Permission permission) {
        try {
            boolean flag = permissionService.addPermission(permission);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
    public Result updatePerm(Permission permission){
        try {
            boolean flag = permissionService.updatePermission(permission);
            return Result.success();
        } catch (Exception e) {
            return  Result.failure(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deletePermission")
    public Result deletePerm(Integer id) {
        try {
            boolean flag = permissionService.deletePermission(id);
            return Result.success();
        } catch (Exception e) {
            return Result.failure(e.getMessage());
        }
    }
}
