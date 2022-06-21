package com.restapiexample.dummy.model;

import java.util.HashMap;

public class DummyPojo {
    private String name;
    private String salary;
    private int age;
    private int id;
    private String employeename;
    private int employeesalary;
    private int employeeage;
    private String profielimage;

    public HashMap<Object, Object> getEmployeedata() {
        return employeedata;
    }

    public void setEmployeedata(HashMap<Object, Object> employeedata) {
        this.employeedata = employeedata;
    }

    private HashMap<Object, Object> employeedata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public int getEmployeesalary() {
        return employeesalary;
    }

    public void setEmployeesalary(int employeesalary) {
        this.employeesalary = employeesalary;
    }

    public int getEmployeeage() {
        return employeeage;
    }

    public void setEmployeeage(int employeeage) {
        this.employeeage = employeeage;
    }

    public String getProfielimage() {
        return profielimage;
    }

    public void setProfielimage(String profielimage) {
        this.profielimage = profielimage;
    }
}
