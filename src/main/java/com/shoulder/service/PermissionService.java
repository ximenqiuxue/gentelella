package com.shoulder.service;

import com.github.pagehelper.PageInfo;
import com.shoulder.model.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    /**
     * 获取所有perm
     * @return
     * @throws Exception
     */
    List<Permission> getAllEntity() throws Exception;

    /**
     * 获取带有分页信息的perm
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    PageInfo findPageList(Integer page, Integer limit) throws Exception;

    /**
     * 根据id获取perm
     * @param id
     * @return
     * @throws Exception
     */
    Permission getPermission(Integer id) throws Exception;

    /**
     * 新增
     * @param permission
     * @return
     * @throws Exception
     */
    boolean addPermission(Permission permission) throws Exception;

    /**
     * 修改
     * @param permission
     * @return
     * @throws Exception
     */
    boolean updatePermission(Permission permission) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    boolean deletePermission(Integer id) throws Exception;

    /**
     * 初始化获取perm权限
     * @param username
     * @return
     * @throws Exception
     */
    List<Permission> getPermission(String username) throws Exception;

    /**
     * 获取perm授权名称
     * @param username
     * @return
     * @throws Exception
     */
    Set<String> getPermissionName(String username) throws Exception;

    /**
     * 获取perm授权的url
     * @param username
     * @return
     * @throws Exception
     */
    Set<String> getPermissionUrls(String username) throws Exception;

    /**
     * 获取过滤器权限
     * @param requestUrl
     * @return
     * @throws Exception
     */
    boolean needInterceptor(String requestUrl) throws Exception;
}
