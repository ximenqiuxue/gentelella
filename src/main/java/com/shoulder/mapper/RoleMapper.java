package com.shoulder.mapper;

import com.shoulder.model.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> findRole(String username) throws Exception;

    @Select("SELECT * FROM role")
    List<Role> findAll() throws Exception;

    Integer addEntity(Role role) throws Exception;

    @Select("SELECT * FROM role WHERE id=#{id};")
    Role findEntity(Integer id) throws Exception;

    Integer updateEntity(Role role) throws Exception;

    @Delete("DELETE FROM role WHERE id=#{id}")
    Integer deleteEntity(Integer id) throws Exception;
}
