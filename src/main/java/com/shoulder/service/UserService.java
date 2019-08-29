package com.shoulder.service;

import com.shoulder.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String, Object>> findEntity() throws Exception;

    User findUserById(Integer id) throws Exception;

    User findUserByName(String username);
}
