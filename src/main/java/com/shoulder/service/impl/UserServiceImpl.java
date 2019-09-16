package com.shoulder.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoulder.mapper.UserDeptMapper;
import com.shoulder.mapper.UserMapper;
import com.shoulder.mapper.UserRoleMapper;
import com.shoulder.model.*;
import com.shoulder.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDeptMapper userDeptMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public boolean addOrupdateUser(User user, String deptId, String rId) throws Exception {
        UserDept userDept = new UserDept();
        userDept.setDeptId(Integer.parseInt(deptId));
        UserRole userRole = new UserRole();
        userRole.setRid(Integer.parseInt(rId));
        log.info(user);
        if (user.getId() != null) {
            userDept.setUid(user.getId());
            userRole.setUid(user.getId());
            Integer userFlag = userMapper.updateUserByEntity(user);
            Integer deptFlag = userDeptMapper.updateUserDept(userDept);
            Integer roleFlag = userRoleMapper.updateUserRole(userRole);
            log.info("returnparam :" + userFlag + ":" + deptFlag + ":" + roleFlag);
            return userFlag > 0 & deptFlag > 0 & roleFlag > 0;
        } else {
            Integer generatedKey = userMapper.addUser(user);
            userDept.setUid(user.getId());
            userRole.setUid(user.getId());
            Integer deptFlag = userDeptMapper.addUserDept(userDept);
            Integer roleFlag = userRoleMapper.addUserRole(userRole);
            return generatedKey > 0 & deptFlag > 0 & roleFlag > 0;
        }

    }

    @Override
    public PageInfo<Map> findEntity(Map map) throws Exception {
        Integer start = Integer.parseInt(String.valueOf(map.get("start")));
        Integer limit = Integer.parseInt(String.valueOf(map.get("limit")));
        String orderBy = String.valueOf(map.get("orderBy"));
        log.info(orderBy);
        Integer pageNum = (start / limit) + 1;
        // 对后边第一个查询接口进行分页查询
        PageHelper.startPage(pageNum, limit, orderBy);
        List<Map<String, Object>> userList = userMapper.findAll();
        List<User> users = new ArrayList<>();
        // 放入原始数据，否则得到的total为当前页查询到的条数或者为0
        PageInfo pageInfo = new PageInfo(userList);
        for (Map<String, Object> u : userList) {
            User user = new User();
            Department department = new Department();
            Role role = new Role();
            user.setId((Integer) u.get("id"));
            user.setUsername((String) u.get("username"));
            user.setGender((String) u.get("gender"));
            user.setEmail((String) u.get("email"));
            user.setTelephone((String) u.get("telephone"));
            user.setCreateTime((String) u.get("createTime"));
            department.setId((Integer) u.get("deptId"));
            department.setName((String) u.get("deptName"));
            role.setId((Integer) u.get("rId"));
            role.setName((String) u.get("roleName"));
            user.setDept(department);
            user.setRole(role);
            users.add(user);
        }
        // 再次放入整型后的数据，并不影响之前查询出的数据统计
        pageInfo.setList(users);
        return pageInfo;
    }

    @Override
    public Map<String, Object> findUserById(Integer id) throws Exception {
        return userMapper.findEntityById(id);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findEntityByName(username);
    }

}
