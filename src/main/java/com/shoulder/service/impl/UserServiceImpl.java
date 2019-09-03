package com.shoulder.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoulder.mapper.UserMapper;
import com.shoulder.model.Department;
import com.shoulder.model.Role;
import com.shoulder.model.User;
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

    @Override
    public PageInfo<User> findEntity(Integer pageIndex, Integer pageSize) throws Exception {
        PageHelper.startPage(pageIndex,pageSize);// 对后边第一个查询接口进行分页查询
        List<Map<String, Object>> userList = userMapper.findAll();
        List<User> users = new ArrayList<>();
        PageInfo pageInfo = new PageInfo(userList);// 放入原始数据，否则得到的total为当前页查询到的条数或者为0
        for (Map<String, Object> u : userList){
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
        pageInfo.setList(users);// 再次放入整型后的数据，并不影响之前查询出的数据统计
        log.info("pageInfo : " + pageInfo);
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
