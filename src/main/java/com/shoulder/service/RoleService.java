package com.shoulder.service;

import java.util.Set;

public interface RoleService {

    public Set<String> getByUserName(String username) throws Exception;
}
