package com.sitatravels.bonus.models;

import java.util.ArrayList;

public class EmployeeWithBonus {
    private String currency;
    public ArrayList<Employee> employees;
    public EmployeeWithBonus() {
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public EmployeeWithBonus(String currency) {
        this.currency = currency;
    }
}
