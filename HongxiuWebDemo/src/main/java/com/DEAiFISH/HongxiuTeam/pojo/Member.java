package com.DEAiFISH.HongxiuTeam.pojo;

public class Member extends People {

    private Integer grade;

    public Member(Integer grade) {
        this.grade = grade;
    }

    public Member(Integer id, String name, String gender, Integer grade) {
        super(id, name, gender);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


}
