package ru.kashtanov.spring_mvc_hw2.models;

public class Employee {
    private int id;
    private String firstName;
    private String secondName;
    private String position;

    public Employee() {
    }

    public Employee(int id, String firstName, String secondName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
