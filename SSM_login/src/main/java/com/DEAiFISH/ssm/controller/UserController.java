package com.DEAiFISH.ssm.controller;

import com.DEAiFISH.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{id}",method = RequestMethod.GET)
    public String userLogin(@PathVariable("id") Integer id){
        System.out.println("id = " + id);

        return "success";

    }
}
