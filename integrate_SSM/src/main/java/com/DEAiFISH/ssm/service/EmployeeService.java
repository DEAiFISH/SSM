package com.DEAiFISH.ssm.service;

import com.DEAiFISH.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer num);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
