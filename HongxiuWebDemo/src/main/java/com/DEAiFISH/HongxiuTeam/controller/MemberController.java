package com.DEAiFISH.HongxiuTeam.controller;

import com.DEAiFISH.HongxiuTeam.pojo.Member;
import com.DEAiFISH.HongxiuTeam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * 查询所有队员 /member/all --> GET
 * 根据ID查询队员 /member/id/{id} --> GET
 * 根据名字查询队员 /member/name/{name} --> GET
 */


@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;


    /**
     * 查询所有队员
     * @param model
     * @return 跳转到指定页面
     */
    @RequestMapping("/member/all")
    public String getAllMember(Model model){
        ArrayList<Member> list = memberService.getAllMember();
        return "";
    }
}
