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
        map.put("/user/toUpdateUser.do", "roles[admin]");
        map.put("/**", "url");
        return map;
    }
}
