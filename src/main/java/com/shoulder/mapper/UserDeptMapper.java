package com.shoulder.mapper;

import com.shoulder.model.UserDept;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeptMapper {
    /**
     * 修改
     * @param userDept
     * @return
     * @throws Exception
     */
    @Update("update user_dept set dept_id =#{deptId} where uid =#{uid};")
    Integer updateUserDept(UserDept userDept) throws Exception;

    /**
     * 添加
     * @param userDept
     * @return
     */
    Integer addUserDept(UserDept userDept);
}
