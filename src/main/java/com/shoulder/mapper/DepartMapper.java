package com.shoulder.mapper;

import com.shoulder.model.Department;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartMapper {
    @Select("SELECT * FROM department")
    List<Department> findAll() throws Exception;
}
