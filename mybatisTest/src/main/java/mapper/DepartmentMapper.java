package mapper;

import bean.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DepartmentMapper {
    @Results(id = "groupWithDepartment", value = {
            @Result(column = "deptName", property = "name"),
            @Result(column = "id", property = "deptId", id = true),
            @Result(column = "id", property = "employeeList", javaType = List.class, many = @Many(select = "mapper.EmployeeMapper.selectEmpByDeptId", fetchType = FetchType.LAZY))
    })
    @Select("select * from t_dept where t_dept.deptName = #{name};")
    Department selectDepartmentByName(String name);

    @ResultMap("groupWithDepartment")
    @Select("select * from t_dept where id = #{id};")
    Department selectDepartmentById(Integer id);

}
