package com.shoulder.mapper;

import com.shoulder.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    /**
     * 用户页面list
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> findAll() throws Exception;

    /**
     * 用户编辑
     * @param id
     * @return
     * @throws Exception
     */
    @Select("SELECT id, username, email, gender, telephone, create_time FROM user WHERE id=#{id};")
    User findEntityById(Integer id) throws Exception;

    /**
     * shiro认证
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username =#{username};")
    User findEntityByName(String username);
}
