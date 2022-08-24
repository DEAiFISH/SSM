package mapper;

import bean.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EmployeeMapper {
    @Select("select * from t_emp")
//    @ResultMap("groupWithEmployee")

    @Results(id = "groupWithEmployee", value = {
            @Result(column = "empno", property = "id"),
    })
    List<Employee> selectAllOfEmployee();

    @Results(id = "employeeMap", value = {
            @Result(column = "empno", property = "id"),
            @Result(column = "deptId", property = "department", one = @One(select = "mapper.DepartmentMapper.selectDepartmentById", fetchType = FetchType.LAZY))
    })
    @Select("select * from t_emp where name = #{name}")
    Employee selectEmployeeByName(String name);

    @ResultMap("groupWithEmployee")
    @Select("select empno,name,age,deptId from t_emp where deptId = #{deptId}")
    List<Employee> selectEmpByDeptId(Integer deptId);

    @Delete("delete from t_emp where name = #{name}")
    void deleteEmpByName(String name);


    // 动态SQL

    /*

    where标签
where标签会自动去掉“标签体内前面多余的and/or”

    set标签
使用set标签动态管理set子句，并且动态去掉两端多余的逗号

    trim标签
- prefix属性：指定要动态添加的前缀
- suffix属性：指定要动态添加的后缀
- prefixOverrides属性：指定要动态去掉的前缀，使用“|”分隔有可能的多个值
- suffixOverrides属性：指定要动态去掉的后缀，使用“|”分隔有可能的多个值

    foreach标签
在foreach标签内部如果需要引用遍历得到的具体的一个对象，需要使用item属性声明的名称
collection属性：要遍历的集合
item属性：遍历集合的过程中能得到每一个具体对象，在item属性中设置一个名字，将来通过这个名字引用遍历出来的对象
separator属性：指定当foreach标签的标签体重复拼接字符串时，各个标签体字符串之间的分隔符
open属性：指定整个循环把字符串拼好后，字符串整体的前面要添加的字符串
close属性：指定整个循环把字符串拼好后，字符串整体的后面要添加的字符串
index属性：这里起一个名字，便于后面引用
    遍历List集合，这里能够得到List集合的索引值
    遍历Map集合，这里能够得到Map集合的key
 */


    @Select("<script> SELECT * FROM t_emp " +
            "<where>" +
            "<if test= \"id != null and id != ''\"> empno = #{id} </if>" +
            "<if test= \"name != null and name != ''\"> and name = #{name} </if>" +
            "<if test= \"age != null and name != ''\"> and age = #{age} </if>" +
            "<if test= \"deptId != null and name != ''\"> and deptId = #{deptId} </if>" +
            "</where>" +
            "</script>")
    List<Employee> selectEmployee(Employee employee);


    @Insert("<script> insert into t_emp values" +
            "<foreach collection = 'emps'  item = 'emp' separator = ','>" +
            "(null,#{emp.name},#{emp.age},#{emp.deptId},#{emp.id})" +
            "</foreach>" +
            "</script>")
    void insertMoreEmp(@Param("emps") List<Employee> emps);


    @Delete("<script>" +
            "delete from t_emp where empno in " +
            "<foreach collection = 'empIds' item = 'empId' separator = ',' open = '(' close = ')'>" +
            "#{empId}" +
            "</foreach>" +
            "</script>")
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);

}
