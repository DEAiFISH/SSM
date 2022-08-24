import bean.Department;
import bean.Employee;
import mapper.DepartmentMapper;
import mapper.EmployeeMapper;
import mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static util.SqlSessionFactoryUtils.getSqlSessionFactory;

public class text {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

    @Test
    public void Test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

        List list = mapper.selectAll();

        list.forEach(System.out::println);

        sqlSession.close();

    }

    @Test
    public void Test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.selectAllOfEmployee();

        employees.forEach(System.out::println);

        sqlSession.close();

    }

    @Test
    public void Test3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectEmployeeByName("令狐冲");

        System.out.println("employee = " + employee);

        System.out.println("employee.getDepartment() = " + employee.getDepartment());

        sqlSession.close();

    }

    @Test
    public void Tes4() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.selectDepartmentByName("华山");

        System.out.println(department.getDeptId());

        sqlSession.close();

    }

    @Test
    public void Test5() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.selectEmployee(new Employee(null, null, null, 1));

        employeeList.forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void Text6() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("晁祥翔", 100011, 19, 1));
        employees.add(new Employee("程莉茹", 100012, 19, 1));
        employees.add(new Employee("赵禹", 100013, 19, 1));

        mapper.insertMoreEmp(employees);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void Test7() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        mapper.deleteEmpByName("赵禹");

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void Text8() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Integer[] empIds = new Integer[]{100011, 100012};

        mapper.deleteMoreEmp(empIds);

        sqlSession.commit();

        sqlSession.close();
    }

}
