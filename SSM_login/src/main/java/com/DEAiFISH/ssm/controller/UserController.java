package com.DEAiFISH.ssm.controller;

import com.DEAiFISH.ssm.pojo.User;
import com.DEAiFISH.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String userLogin(HttpServletRequest request){
        String userName = request.getParameter("username");
        String userPassWord = request.getParameter("password");
        User user = new User(userName,userPassWord);
//        System.out.println(user);

        System.out.println(userService.userLoginUp(user));

        return "success";

    }

    /**
     * 用户注册
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/signup/{id}/{password}",method = RequestMethod.POST)
    public String userLoginUp(@PathVariable("id") Integer id,@PathVariable("password") Integer password){

        System.out.println("id = " + id);
        System.out.println("password = " + password);


        return "success";

    }
}
