package com.shoulder.service.impl;

import com.shoulder.mapper.PermissionMapper;
import com.shoulder.mapper.RolePermMapper;
import com.shoulder.model.Permission;
import com.shoulder.model.RolePerm;
import com.shoulder.service.PermissionService;
import com.shoulder.service.RolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RolePermServiceImpl implements RolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;
    @Autowired
    private PermissionMapper permissionMapper;

}
