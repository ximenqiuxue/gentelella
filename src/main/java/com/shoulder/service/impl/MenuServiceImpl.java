package com.shoulder.service.impl;


import com.shoulder.mapper.MenuMapper;
import com.shoulder.model.Menu;
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
    MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() throws Exception {
        List<Menu> menus = new ArrayList<>();
        List<Menu> menuData = menuMapper.findAll();
        Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
        for (Menu m : menuData) {
            menuMap.put(m.getId(), m);
        }
        for (Menu m : menuData) {
            Menu child = m;
            if (child.getPid() != null) {
                Menu parent = menuMap.get(child.getPid());
                parent.getChildren().add(child);
            }else {
                menus.add(m);
            }
        }
        return menus;
    }
}
