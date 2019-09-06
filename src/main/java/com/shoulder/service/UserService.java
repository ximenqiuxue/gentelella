package com.shoulder.service;

import com.github.pagehelper.PageInfo;
import com.shoulder.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    PageInfo<Map> findEntity(Integer pageIndex, Integer pageSize) throws Exception;

    Map<String, Object> findUserById(Integer id) throws Exception;

    User findUserByName(String username);
}
