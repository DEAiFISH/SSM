package com.DEAiFISH.HongxiuTeam.service.impl;

import com.DEAiFISH.HongxiuTeam.mapper.MemberMapper;
import com.DEAiFISH.HongxiuTeam.pojo.Member;
import com.DEAiFISH.HongxiuTeam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public ArrayList<Member> getAllMember() {
        return memberMapper.getAllMember();
    }
}
