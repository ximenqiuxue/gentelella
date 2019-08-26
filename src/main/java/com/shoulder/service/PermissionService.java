package com.shoulder.service;

import com.shoulder.model.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    public List<Permission> getAllEntity();

    public List<Permission> getPermission(String username) throws Exception;

    public Set<String> getPermissionName(String username) throws Exception;

    public Set<String> getPermissionUrls(String username) throws Exception;

    public boolean needInterceptor(String requestUrl);


}
