package ru.kashtanov.spring_mvc_hw2.models;

import java.util.List;

public class Chief {
    private String firstName;
    private String secondName;
    private String departmentName;
    private List<Employee> employees;

    public Chief(String firstName,
                 String secondName,
                 String departmentName,
                 List<Employee> employees) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
