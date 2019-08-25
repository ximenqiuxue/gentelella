package com.shoulder.mapper;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleMapper {

    public Set<String> findByUserName(String username) throws Exception;
}
