package com.shoulder.service.impl;

import com.shoulder.mapper.RoleMapper;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Set<String> getByUserName(String username) throws Exception {
        return roleMapper.findByUserName(username);
    }
}
