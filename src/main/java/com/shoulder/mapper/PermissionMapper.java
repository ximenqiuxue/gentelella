package com.shoulder.mapper;

import com.shoulder.model.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PermissionMapper {

    List<Permission> findPermission(String username) throws Exception;

    @Select("SELECT * FROM permission ORDER BY name")
    List<Permission> findAll() throws Exception;

    @Select("SELECT * FROM permission WHERE id=#{id}")
    Permission getPermission(Integer id) throws Exception;

    @Insert("INSERT INTO permission(name,url,description) VALUES(#{name},#{url},#{description});")
    Integer addEntity(Permission permission) throws Exception;

    @Update("UPDATE permission SET name=#{name},url=#{url},description=#{description} WHERE id=#{id};")
    Integer updateEntity(Permission permission) throws Exception;

    @Delete("DELETE FROM permission WHERE id=#{id};")
    Integer deleteEntity(Integer id) throws Exception;
}
