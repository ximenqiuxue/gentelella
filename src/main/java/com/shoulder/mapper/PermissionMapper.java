package com.shoulder.mapper;

import com.shoulder.model.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PermissionMapper {

    List<Permission> findPermission(String username) throws Exception;

    @Select("SELECT * FROM permission;")
    List<Permission> findAllEntity();
}
