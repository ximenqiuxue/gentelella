package com.shoulder.service.impl;

import com.shoulder.mapper.PermissionMapper;
import com.shoulder.model.Permission;
import com.shoulder.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getAllEntity() {
        return permissionMapper.findAllEntity();
    }

    @Override
    public boolean deletePermission(Integer id) throws Exception {
        Integer flag = permissionMapper.deleteEntity(id);
        return flag > 0;
    }

    @Override
    public Permission getPermission(Integer id) throws Exception {
        return permissionMapper.getPermission(id);
    }

    @Override
    public boolean addPermission(Permission permission) throws Exception {
        Integer flag = permissionMapper.addEntity(permission);
        return flag > 0;
    }

    @Override
    public boolean updatePermission(Permission permission) throws Exception {
        Integer flag = permissionMapper.updateEntity(permission);
        return flag > 0;
    }

    @Override
    public List<Permission> getPermission(String username) throws Exception {
        return permissionMapper.findPermission(username);
    }

    @Override
    public Set<String> getPermissionName(String username) throws Exception {
        Set<String> permissionName = new HashSet<String>();
        List<Permission> permissions= getPermission(username);
        for (Permission p : permissions){
            permissionName.add(p.getName());
        }
        return permissionName;
    }

    @Override
    public Set<String> getPermissionUrls(String username) throws Exception {
        Set<String> permissionUrl = new HashSet<String>();
        List<Permission> permissions= getPermission(username);
        for (Permission p : permissions){
            permissionUrl.add(p.getUrl());
        }
        return permissionUrl;
    }

    @Override
    public boolean needInterceptor(String requestUrl) {
        List<Permission> permissions = getAllEntity();
        for (Permission p : permissions) {
            if(p.getUrl().equals(requestUrl))
                return true;
        }
        return false;
    }
}
