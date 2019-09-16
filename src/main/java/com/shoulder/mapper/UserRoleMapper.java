package com.shoulder.mapper;

import com.shoulder.model.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    /**
     * 修改
     * @param userRole
     * @return
     * @throws Exception
     */
    @Update("UPDATE user_role SET rid =#{rid} WHERE uid =#{uid};")
    Integer updateUserRole(UserRole userRole) throws Exception;

    /**
     * 添加
     * @param userRole
     */
    Integer addUserRole(UserRole userRole) throws Exception;


}
