package com.shoulder.mapper;

import com.shoulder.model.RolePerm;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermMapper {

    @Select("SELECT * FROM role_permission WHERE rid =#{rid};")
    List<RolePerm> findAuthEntity(Integer id) throws Exception;
}
