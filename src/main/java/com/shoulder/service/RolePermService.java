package com.shoulder.service;

import com.shoulder.model.Permission;

import java.util.List;

public interface RolePermService {


    List<Permission> findAuthPermission(Integer rid) throws Exception;
}
