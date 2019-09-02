package com.shoulder.service.impl;

import com.shoulder.mapper.UserMapper;
import com.shoulder.model.Department;
import com.shoulder.model.Role;
import com.shoulder.model.User;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findEntity() throws Exception {
        List<Map<String, Object>> userList = userMapper.findAll();
        List<User> users = new ArrayList<>();
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
        return users;
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
