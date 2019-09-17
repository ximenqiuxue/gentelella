package com.shoulder.service.impl;

import com.shoulder.mapper.RoleMapper;
import com.shoulder.model.Role;
import com.shoulder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getRole(String username) throws Exception {
        return roleMapper.findRole(username);
    }

    @Override
    public Set<String> getRoleName(String username) throws Exception {
        Set<String> roleName = new HashSet<String>();
        List<Role> roles = getRole(username);
        for (Role r : roles) {
            roleName.add(r.getName());
        }
        return roleName;
    }

    @Override
    public List<Role> getAll() throws Exception {
        return roleMapper.findAll();
    }

    @Override
    public boolean addRole(Role role) throws Exception {
        Integer flag = roleMapper.addEntity(role);
        return flag > 0;
    }
}
