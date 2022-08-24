package bean;

import java.util.List;

public class Department {
    private Integer deptId;
    private List<Employee> employeeList;
    private String name;
    private String address;

    public Department() {
    }

    public Department(Integer deptId, List<Employee> employeeList, String name, String address) {
        this.deptId = deptId;
        this.employeeList = employeeList;
        this.name = name;
        this.address = address;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", employeeList=" + employeeList +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
