package com.shoulder.mapper;

import com.shoulder.model.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    /**
     * 初始化获取授权菜单
     * @param username
     * @return
     * @throws Exception
     */
    List<Menu> findAuthMenu(String username) throws Exception;

    /**
     * 获取menu
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM menu")
    List<Menu> findList() throws Exception;

    @Select("SELECT * FROM menu WHERE id=#{id};")
    Menu findEntity(Integer id);

    @Insert("INSERT INTO menu(name,url,icon,pid) VALUES(#{name},#{url},#{icon},#{pid});")
    Integer addEntity(Menu menu) throws Exception;

    @Update("UPDATE menu SET name=#{name}, url=#{url}, icon=#{icon}, pid=#{pid} WHERE id=#{id};")
    Integer updateEntity(Menu menu) throws Exception;

    @Delete("DELETE FROM menu WHERE id=#{id};")
    Integer deleteEntity(Integer id) throws Exception;
}
