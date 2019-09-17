package com.shoulder.service;

import com.shoulder.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getRole(String username) throws Exception;

    Set<String> getRoleName(String username) throws Exception;

    List<Role> getAll() throws Exception;

    boolean addRole(Role role) throws Exception;
}
