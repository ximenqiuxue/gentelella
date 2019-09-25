package com.shoulder.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.shoulder.model.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {

    List<Role> getRole(String username) throws Exception;

    Set<String> getRoleName(String username) throws Exception;

    List<Role> getAll() throws Exception;

    PageInfo<Map> findPageList(Integer page, Integer limit) throws Exception;

    boolean addRole(Role role) throws Exception;

    Role findRole(Integer id) throws Exception;

    boolean updateRole(Role role) throws Exception;

    boolean deleteRole(Integer id) throws Exception;
}
