package com.shoulder.service;

import com.shoulder.model.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 获取授权菜单
     * @param username
     * @return
     * @throws Exception
     */
    List<Menu> getAuthMenu(String username) throws Exception;

    /**
     * 获取menu
     * @return
     * @throws Exception
     */
    List<Menu> getList() throws Exception;

    Menu findMenu(Integer id) throws Exception;

    boolean addMenu(Menu menu) throws Exception;

    boolean updateMenu(Menu menu) throws Exception;

    boolean deleteMenu(Integer id) throws Exception;
}
