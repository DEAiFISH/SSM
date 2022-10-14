package com.DEAiFISH.HongxiuTeam.service.impl;

import com.DEAiFISH.HongxiuTeam.mapper.AdminMapper;
import com.DEAiFISH.HongxiuTeam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
}
