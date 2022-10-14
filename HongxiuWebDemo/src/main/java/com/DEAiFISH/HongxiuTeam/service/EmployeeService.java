package com.DEAiFISH.HongxiuTeam.service;


import com.DEAiFISH.HongxiuTeam.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer num);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
