package com.shoulder.service.impl;

import com.shoulder.mapper.PermissionMapper;
import com.shoulder.model.Permission;
import com.shoulder.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Set<String> getByUserName(String username) throws Exception {
        return permissionMapper.findByUserName(username);
    }
}
