package com.shoulder.service;

import com.shoulder.model.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    boolean addRoleMenus(Integer[] rids, Integer[] mids) throws Exception;

    boolean deleteRoleMenu(Integer[] rids) throws Exception;
}
