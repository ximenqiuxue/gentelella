package com.shoulder.mapper;

import com.shoulder.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    public List<Role> findRole(String username) throws Exception;
}
