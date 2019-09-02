package com.shoulder.service;

import com.shoulder.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findEntity() throws Exception;

    Map<String, Object> findUserById(Integer id) throws Exception;

    User findUserByName(String username);
}
