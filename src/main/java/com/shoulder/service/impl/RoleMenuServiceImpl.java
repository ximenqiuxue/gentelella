package com.shoulder.service.impl;

import com.shoulder.mapper.RoleMenuMapper;
import com.shoulder.model.RoleMenu;
import com.shoulder.service.RoleMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@Transactional
public class RoleMenuServiceImpl implements RoleMenuService {

    private static final Logger log = Logger.getLogger(RoleMenuServiceImpl.class);

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public boolean deleteRoleMenu(Integer[] rids) throws Exception {
        Integer flag = roleMenuMapper.deleteEntity(Arrays.asList(rids));
        return flag > 0;
    }

    @Override
    public boolean addRoleMenus(Integer[] rids, Integer[] mids) throws Exception {
        List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
        deleteRoleMenu(rids);
        for (Integer rid : rids){
            for (Integer mid : mids) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRid(rid);
                roleMenu.setMid(mid);
                roleMenus.add(roleMenu);
            }
        }
        Integer flag = roleMenuMapper.addEntity(roleMenus);
        return flag > 0;
    }
}
