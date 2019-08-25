package com.shoulder.mapper;

import com.shoulder.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionMapper {
    public Set<String> findByUserName(String username) throws Exception;
}
