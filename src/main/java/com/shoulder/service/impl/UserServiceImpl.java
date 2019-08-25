package com.shoulder.service.impl;

import com.shoulder.mapper.UserMapper;
import com.shoulder.model.User;
import com.shoulder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findEntity() throws Exception {
        List<User> userList = new ArrayList<User>();
        userList = userMapper.findAll();
        return userList;
    }

    @Override
    public User findUserById(Integer id) throws Exception {
        return userMapper.findEntityById(id);
    }

}
