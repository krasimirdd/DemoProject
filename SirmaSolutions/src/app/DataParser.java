package app;

import app.entities.Employee;
import app.entities.Project;
import app.entities.Tuple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DataParser {
    private static final String SPLIT_TEMPLATE = ", ";

    private Set<Employee> employeeSet = new HashSet<>();
    private Set<Integer> emplIdSet = new HashSet<>();
    private List<Project> projectList = new ArrayList<>();
    private List<Integer> projIds = new ArrayList<>();

    void parse(String line) {
        String[] tokens = line.split(SPLIT_TEMPLATE);

        int emplId = Integer.parseInt(tokens[0]);
        int projectId = Integer.parseInt(tokens[1]);
        LocalDate dateFrom = LocalDate.parse(tokens[2]);
        LocalDate dateTo = parseDateTo(tokens[3]);

        importData(emplId, projectId, dateFrom, dateTo);
    }

    Employee getMostWorkedEmployee() {

        int bestEmplId = 0;
        for (Project project : projectList) {
            List<Employee> emplWorkedOn = new ArrayList<>(project.getEmployeesWorkedOn());

            int currEmployeeWorkingTime;
            int bestWorkingTime = 0;
            for (Employee employee : emplWorkedOn) {
                for (Tuple datum : employee.getData()) {

                    currEmployeeWorkingTime = datum.getWorkingTime();
                    if (currEmployeeWorkingTime > bestWorkingTime) {
                        bestWorkingTime = currEmployeeWorkingTime;
                        bestEmplId = employee.getEmployeeId();
                    }
                }
            }
        }
        for (Employee employee : employeeSet) {
            if (employee.getEmployeeId() == bestEmplId) {
                return employee;
            }
        }
        return null;
    }

//    public void getSecondMostWorkedEmployee() {
//
//        //TODO
//    }

    private void importData(int emplId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        Employee employee = new Employee(emplId, new ArrayList<>());
        Project project = new Project(projectId, new ArrayList<>());

        if (!projIds.contains(projectId)) {
            project.getEmployeesWorkedOn().add(employee);
            projectList.add(project);
            projIds.add(projectId);
        } else {
            for (Project proj : projectList) {

                if (proj.getProjectId() == projectId) {
                    proj.getEmployeesWorkedOn().add(employee);
                }
            }
        }

        if (!emplIdSet.contains(emplId)) {
            List<Tuple> tuples = new ArrayList<>();
            tuples.add(new Tuple(project, dateFrom, dateTo));

            employee.setData(tuples);
            employeeSet.add(employee);

            emplIdSet.add(emplId);
        } else {
            for (Employee empl : employeeSet) {
                if (empl.getEmployeeId() == emplId) {
                    empl.getData().add(new Tuple(project, dateFrom, dateTo));
                }
            }
        }
        System.out.println();
    }

    private LocalDate parseDateTo(String token) {
        if (token.equals("NULL")) {
            return LocalDate.now();
        }
        return LocalDate.parse(token);

    }

}