package com.sitatravels.bonus.models;

public class Employee {
    private String name;
    private long amount;

    public Employee() {
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Employee(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }
}
