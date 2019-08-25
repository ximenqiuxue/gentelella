package com.shoulder.service;

import com.shoulder.model.Permission;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PermissionService {

    public Set<String> getByUserName(String username) throws Exception;
}
