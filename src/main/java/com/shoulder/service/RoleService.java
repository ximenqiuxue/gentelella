package com.shoulder.service;

import com.shoulder.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    public List<Role> getRole(String username) throws Exception;

    public Set<String> getRoleName(String username) throws Exception;
}
