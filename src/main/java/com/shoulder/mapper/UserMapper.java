package com.shoulder.mapper;

import com.shoulder.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT id, username, email, gender, telephone, create_time FROM user;")
    List<User> findAll() throws Exception;

    @Select("SELECT id, username, email, gender, telephone, create_time FROM user WHERE id=#{id};")
    User findEntityById(Integer id) throws Exception;

    @Select("SELECT * FROM user WHERE username =#{username};")
    User findEntityByName(String username);
}
