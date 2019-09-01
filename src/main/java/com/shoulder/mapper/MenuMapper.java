package com.shoulder.mapper;

import com.shoulder.model.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    @Select("SELECT * FROM menu")
    List<Menu> findAll() throws Exception;
}
