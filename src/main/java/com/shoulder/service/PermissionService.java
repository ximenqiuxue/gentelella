package com.shoulder.service;

import com.shoulder.model.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    List<Permission> getAllEntity();

    List<Permission> getPermission(String username) throws Exception;

    Set<String> getPermissionName(String username) throws Exception;

    Set<String> getPermissionUrls(String username) throws Exception;

    boolean needInterceptor(String requestUrl);

    Permission getPermission(Integer id) throws Exception;

    boolean addPermission(Permission permission) throws Exception;

    boolean updatePermission(Permission permission) throws Exception;

    boolean deletePermission(Integer id) throws Exception;
}
