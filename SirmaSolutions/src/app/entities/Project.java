package app.entities;

import java.util.List;

public class Project {

    private int projectId;
    private List<Employee> employeesWorkedOn;

    public Project(int projectId) {
        this.projectId = projectId;
    }

    public Project(int projectId, List<Employee> employeesWorkedOn) {

        this.projectId = projectId;
        this.employeesWorkedOn = employeesWorkedOn;
    }

    public Project() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<Employee> getEmployeesWorkedOn() {
        return employeesWorkedOn;
    }

    public void setEmployeesWorkedOn(List<Employee> employeesWorkedOn) {
        this.employeesWorkedOn = employeesWorkedOn;
    }
}
