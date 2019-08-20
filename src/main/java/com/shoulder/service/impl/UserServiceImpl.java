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
    public List<User> findEntity() {
        List<User> userList = new ArrayList<User>();
        try {
            userList = userMapper.findAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
