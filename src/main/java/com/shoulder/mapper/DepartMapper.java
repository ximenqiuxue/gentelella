package com.shoulder.mapper;

import com.shoulder.model.department;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartMapper {
    @Select("SELECT * FROM department")
    List<department> findAll() throws Exception;
}
