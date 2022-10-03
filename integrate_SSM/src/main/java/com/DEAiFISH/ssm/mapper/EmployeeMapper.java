package com.DEAiFISH.ssm.mapper;

import com.DEAiFISH.ssm.pojo.Employee;
import org.apache.ibatis.annotations.*;

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


    @Select("select * from tb_emp where emp_id = #{id}")
    @ResultMap("EmpResult")
    Employee getEmployeeById(@Param("id") Integer id);

    @Update("update tb_emp set emp_name = #{name},age = #{age},gender = #{gender},email = #{email} " +
            "where emp_id = #{id}")
    void updateEmployee(Employee employee);

    @Delete("delete from tb_emp where emp_id = #{id}")
    void deleteEmployeeById(@Param("id") Integer id);
}
