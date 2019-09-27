package com.shoulder.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * 获取所有perm
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> getAllEntity() throws Exception {
        return permissionMapper.findAll();
    }

    /**
     * 根据id获取perm
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Permission getPermission(Integer id) throws Exception {
        return permissionMapper.getPermission(id);
    }

    /**
     * 增加perm
     * @param permission
     * @return
     * @throws Exception
     */
    @Override
    public boolean addPermission(Permission permission) throws Exception {
        Integer flag = permissionMapper.addEntity(permission);
        return flag > 0;
    }

    /**
     * 修改perm
     * @param permission
     * @return
     * @throws Exception
     */
    @Override
    public boolean updatePermission(Permission permission) throws Exception {
        Integer flag = permissionMapper.updateEntity(permission);
        return flag > 0;
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deletePermission(Integer id) throws Exception {
        Integer flag = permissionMapper.deleteEntity(id);
        return flag > 0;
    }

    /**
     * 初始化获取perm权限
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> getPermission(String username) throws Exception {
        return permissionMapper.findPermission(username);
    }

    /**
     * 获取perm授权名称
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Set<String> getPermissionName(String username) throws Exception {
        Set<String> permissionName = new HashSet<String>();
        List<Permission> permissions= getPermission(username);
        for (Permission p : permissions){
            permissionName.add(p.getName());
        }
        return permissionName;
    }

    /**
     * 获取perm授权的url
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Set<String> getPermissionUrls(String username) throws Exception {
        Set<String> permissionUrl = new HashSet<String>();
        List<Permission> permissions= getPermission(username);
        for (Permission p : permissions){
            permissionUrl.add(p.getUrl());
        }
        return permissionUrl;
    }

    /**
     * 获取过滤器权限
     * @param requestUrl
     * @return
     * @throws Exception
     */
    @Override
    public boolean needInterceptor(String requestUrl) throws Exception {
        List<Permission> permissions = getAllEntity();
        for (Permission p : permissions) {
            if(p.getUrl().equals(requestUrl))
                return true;
        }
        return false;
    }
}
