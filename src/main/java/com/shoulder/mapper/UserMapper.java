package com.shoulder.mapper;

import com.shoulder.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
     * 查询
     * @param id
     * @return
     * @throws Exception
     */
    Map<String, Object> findEntityById(Integer id) throws Exception;

    /**
     * 编辑
     * @param user
     * @return
     */
    @Update("UPDATE user SET username=#{username}, email=#{email}, gender=#{gender}, telephone=#{telephone}, create_time=#{createTime} WHERE id=#{id};")
    Integer updateUserByEntity(User user) throws Exception;

    /**
     * shiro认证
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username =#{username};")
    User findEntityByName(String username);

    /**
     * 新增
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 删除
     * @param userId
     * @return
     * @throws Exception
     */
    Integer deleteUser(Integer userId) throws Exception;
}
