package com.DEAiFISH.HongxiuTeam.controller;

import com.DEAiFISH.HongxiuTeam.pojo.Employee;
import com.DEAiFISH.HongxiuTeam.service.EmployeeService;
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
 * 修改员工页面 --> /employee --> PUT
 * 删除员工信息 --> /employee/{id} --> DELETE
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 通过id删除员工
     * @param id
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/employee/{pageNum}/{id}",method = RequestMethod.DELETE)
    public String deleteEmployeeById(@PathVariable("id") Integer id,@PathVariable("pageNum") Integer pageNum){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee/page/" + pageNum;
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }

    /**
     * 根据id查询指定员工并跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    /**
     * 分页查询所有员工
     * @param num
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/page/{num}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("num") Integer num, Model model) {
        //获取员工分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(num);
        //将分页数据共享到请求域中
        model.addAttribute("page", page);
        //跳转页面
        return "employee_list";
    }

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        //查询所有员工
        List<Employee> employees = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("employees", employees);

        return "employee_list";
    }
}
