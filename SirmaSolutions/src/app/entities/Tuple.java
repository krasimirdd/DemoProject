package app.entities;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tuple implements Comparable<Tuple> {

    private Project project;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer workingTime;

    public Tuple() {
    }

    public Tuple(Project project, LocalDate dateFrom, LocalDate dateTo) {
        this.project = project;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.workingTime = Math.toIntExact(DAYS.between(dateFrom, dateTo));
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }


    @Override
    public int compareTo(Tuple o) {
        if (DAYS.between(this.dateFrom, this.dateTo) > DAYS.between(o.dateFrom, o.dateTo)) {
            return 1;
        } else if (DAYS.between(this.dateFrom, this.dateTo) < DAYS.between(o.dateFrom, o.dateTo)) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getWorkingTime() {
        return workingTime;
    }
}
