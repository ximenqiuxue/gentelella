package com.shoulder.mapper;

import com.shoulder.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT id, username, email, telephone, create_time FROM user;")
    List<User> findAll() throws Exception;

    User findEntityById(Integer id) throws Exception;
}
