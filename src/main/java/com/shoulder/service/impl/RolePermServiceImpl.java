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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RolePermServiceImpl implements RolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAuthPermission(Integer rid) throws Exception {
        List<RolePerm> rolePerms = rolePermMapper.findAuthEntity(rid);
        List<Permission> permissions = permissionMapper.findAll();
        Map<Integer, RolePerm> map = new HashMap<Integer, RolePerm>();
        for (RolePerm rp : rolePerms) {
            map.put(rp.getPid(), rp);
        }
        for (Permission p : permissions) {
            if (map.get(p.getId()) != null){
                p.setChecked(true);
            }
        }
        return permissions;
    }
}
