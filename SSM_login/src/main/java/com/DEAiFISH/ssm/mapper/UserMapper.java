package com.DEAiFISH.ssm.mapper;

import com.DEAiFISH.ssm.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("<script>" +
            "select * from tb_user where user_name = #{userName} and user_password = #{userPassword}"  +
            "</script>")
    User userLoginUp(User user);

}
