package com.shoulder.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("/static/**", "anon");
        map.put("/login.do", "anon");
        map.put("/loginValidate.do", "anon");
        map.put("/common/unauthorized.do", "anon");
        map.put("/logout.do", "anon");
        map.put("/role/index.do", "roles[系统管理员]");
        map.put("/**", "url");
        return map;
    }
}
