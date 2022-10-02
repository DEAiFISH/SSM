package com.DEAiFISH.ssm.mapper;

import com.DEAiFISH.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有员工信息
     *
     * @return
     */
    @Select("select * from tb_emp")
    @Results(id = "EmpResult", value = {
            @Result(column = "emp_id", property = "id"),
            @Result(column = "emp_name", property = "name"),
    })
    List<Employee> getAllEmployee();


}
