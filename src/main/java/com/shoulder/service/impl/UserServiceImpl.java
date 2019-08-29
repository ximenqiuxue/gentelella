package com.shoulder.service.impl;

import com.shoulder.mapper.UserMapper;
import com.shoulder.model.User;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> findEntity() throws Exception {
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        userList = userMapper.findAll();
        return userList;
    }

    @Override
    public User findUserById(Integer id) throws Exception {
        return userMapper.findEntityById(id);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findEntityByName(username);
    }

}
