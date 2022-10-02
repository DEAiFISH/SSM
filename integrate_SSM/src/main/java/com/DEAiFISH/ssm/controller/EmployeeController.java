package com.DEAiFISH.ssm.controller;

import com.DEAiFISH.ssm.pojo.Employee;
import com.DEAiFISH.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 查询所有员工信息 --> /employee --> GET
 * 查询所有员工的分页信息 --> /employee/page/1 --> GET
 * 查询指定员工的信息 --> /employee/{id} --> GET
 * 跳转到添加页面 --> /to/add --> GET
 * 新增员工 --> /employee --> POST
 * 跳转到修改页面 --> /employee --> PUT
 * 删除员工信息 --> /employee/{id} --> DELETE
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{num}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("num") Integer num, Model model) {
        //获取员工分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(num);
        //将分页数据共享到请求域中
        model.addAttribute("page", page);
        //跳转页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        //查询所有员工
        List<Employee> employees = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("employees", employees);

        return "employee_list";
    }
}
