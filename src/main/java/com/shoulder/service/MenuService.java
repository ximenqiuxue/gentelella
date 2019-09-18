package com.shoulder.service;

import com.shoulder.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAll() throws Exception;

    List<Menu> getList() throws Exception;

    Menu findMenu(Integer id) throws Exception;

    boolean addMenu(Menu menu) throws Exception;

    boolean updateMenu(Menu menu) throws Exception;

    boolean deleteMenu(Integer id) throws Exception;
}
