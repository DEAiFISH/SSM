package com.DEAiFISH.HongxiuTeam.controller;

import com.DEAiFISH.HongxiuTeam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
}
