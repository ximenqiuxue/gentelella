package com.shoulder.service.impl;


import com.shoulder.mapper.MenuMapper;
import com.shoulder.mapper.RoleMenuMapper;
import com.shoulder.model.Menu;
import com.shoulder.model.RoleMenu;
import com.shoulder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 系统初始化菜单
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public List<Menu> getAuthMenu(String username) throws Exception {
        List<Menu> menus = new ArrayList<>();
        List<Menu> data = menuMapper.findAuthMenu(username);
        return getMenus(menus, data);
    }

    /**
     * menu列表显示父级菜单以及select下拉框
     * @return
     * @throws Exception
     */
    @Override
    public List<Menu> getList() throws Exception{
        Map <Integer, Menu> map = new HashMap<Integer, Menu>();
        List<Menu> menus = menuMapper.findList();
        for (Menu m : menus) {
            map.put(m.getId(), m);
        }
        for (Menu m : menus) {
            if (m.getPid() != null){
                m.setParent(map.get(m.getPid()));
            }else {
                m.setParent(new Menu());
            }
        }
        return menus;
    }

    /**
     * 获取menu树
     * @return
     * @throws Exception
     */
    @Override
    public List<Menu> getTreeMenu() throws Exception {
        List<Menu> menus = new ArrayList<>();
        List<Menu> data = menuMapper.findList();
        return getMenus(menus, data);
    }

    @Override
    public List<Menu> getTreeMenu(Integer id) throws Exception {
        List<Menu> menus = new ArrayList<>();
        List<Menu> data = menuMapper.findList();
        List<RoleMenu> roleMenus = roleMenuMapper.findEntity(id);
        Map<Integer, RoleMenu> roleMenuMap = new HashMap<Integer, RoleMenu>();
        for (RoleMenu rm: roleMenus) {
            roleMenuMap.put(rm.getMid(), rm);
        }
        for (Menu m: data) {
            if (roleMenuMap.get(m.getId()) != null){
                m.setChecked(true);
            }
        }
        return getMenus(menus, data);
    }

    private List<Menu> getMenus(List<Menu> menus, List<Menu> menuData) {
        Map<Integer, Menu> map = new HashMap<Integer, Menu>();
        for (Menu m : menuData) {
            map.put(m.getId(), m);
        }
        for (Menu m : menuData) {
            Menu child = m;
            if (child.getPid() != null) {
                Menu parent = map.get(child.getPid());
                parent.getChildren().add(child);
            }else {
                menus.add(m);
            }
        }
        return menus;
    }


    @Override
    public boolean deleteMenu(Integer id) throws Exception {
        Integer flag = menuMapper.deleteEntity(id);
        return flag > 0;
    }

    @Override
    public boolean updateMenu(Menu menu) throws Exception {
        Integer flag = menuMapper.updateEntity(menu);
        return flag > 0;
    }

    @Override
    public boolean addMenu(Menu menu) throws Exception {
        Integer flag = menuMapper.addEntity(menu);
        return flag > 0;
    }

    @Override
    public Menu findMenu(Integer id) throws Exception{
        return menuMapper.findEntity(id);
    }
}
