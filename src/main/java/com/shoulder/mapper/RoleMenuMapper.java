package com.shoulder.mapper;

import com.shoulder.model.RoleMenu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuMapper {

    @Select("SELECT * FROM role_menu WHERE rid=#{rid}")
    List<RoleMenu> findEntity(Integer id) throws Exception;

    Integer addEntity(List<RoleMenu> roleMenus) throws Exception;

    Integer deleteEntity(List<Integer> rids) throws Exception;
}
