package com.shoulder.service;

import com.shoulder.model.User;

import java.util.List;

public interface UserService {

    List<User> findEntity() throws Exception;

    User findUserById(Integer id) throws Exception;
}
