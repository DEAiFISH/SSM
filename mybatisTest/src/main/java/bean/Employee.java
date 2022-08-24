package bean;

public class Employee {
    private String name;
    private Integer id;
    private Integer age;
    private Integer deptId;

    private Department department;

    public Employee() {
    }

    public Employee(String name, Integer id, Integer age, Integer deptId) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return deptId;
    }

    public void setEmpId(Integer empId) {
        this.deptId = empId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", deptId=" + deptId +
                '}';
    }
}
