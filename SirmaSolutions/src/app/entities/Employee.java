package app.entities;

import java.util.List;

public class Employee {

    private int employeeId;
    private List<Tuple> data;

    public Employee() {
    }

    public Employee(int employeeId, List<Tuple> data) {
        this.employeeId = employeeId;
        this.data = data;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<Tuple> getData() {
        return data;
    }

    public void setData(List<Tuple> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Employee" + employeeId;
    }
}
