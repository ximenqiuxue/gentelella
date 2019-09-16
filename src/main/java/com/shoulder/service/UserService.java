package com.shoulder.service;

import com.github.pagehelper.PageInfo;
import com.shoulder.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    PageInfo<Map> findEntity(Map map) throws Exception;

    Map<String, Object> findUserById(Integer id) throws Exception;

    User findUserByName(String username);

    boolean addOrupdateUser(User user, String deptId, String rId) throws Exception;

    boolean deleteById(Integer userId) throws Exception;
}
