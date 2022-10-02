package com.DEAiFISH.ssm.service.impl;

import com.DEAiFISH.ssm.mapper.EmployeeMapper;
import com.DEAiFISH.ssm.pojo.Employee;
import com.DEAiFISH.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {

        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer num) {
        //开启分页功能
        PageHelper.startPage(num,20);
        //查询所有员工信息
        List<Employee> employeeList = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);
        return pageInfo;
    }
}
