package com.shoulder.mapper;

import com.shoulder.model.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> findRole(String username) throws Exception;

    @Select("SELECT * FROM role")
    List<Role> findAll() throws Exception;

    @Insert("INSERT INTO role(name, desc) VALUES(=#{name},=#{desc});")
    Integer addEntity(Role role) throws Exception;
}
