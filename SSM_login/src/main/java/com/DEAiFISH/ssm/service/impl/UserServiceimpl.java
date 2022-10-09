package com.DEAiFISH.ssm.service.impl;

import com.DEAiFISH.ssm.pojo.User;
import com.DEAiFISH.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DEAiFISH.ssm.mapper.UserMapper;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void userLoginUp(User user) {
        userMapper.userLoginUp(user);
    }
}
