package com.DEAiFISH.ssm.mapper;

import com.DEAiFISH.ssm.pojo.User;

public interface UserMapper {
//    @Select("<script>" +
//            "select tb_user where user_name = ${userName} and user_password = ${userPass}"  +
//            "</script>")
    void userLoginUp(User user);

}
