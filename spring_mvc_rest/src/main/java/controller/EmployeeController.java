package controller;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.Employee;

import java.util.Collection;

/**
 * 查询所有员工信息 --> /employee --> GET
 * 跳转到添加页面 --> /to/add --> GET
 * 新增员工 --> /employee --> POST
 * 跳转到修改页面 --> /employee --> PUT
 * 删除员工信息 --> /employee/id --> DELETE
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 获取所有员工
      * @param model
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("allEmployee", employeeList);
        return "employee_list";
    }

    /**
     * 添加或者修改员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = {RequestMethod.POST,RequestMethod.PUT})
    public String addEmployee(Employee employee) {

        //重定向到列表功能/employee
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * 修改员工
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }



    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
