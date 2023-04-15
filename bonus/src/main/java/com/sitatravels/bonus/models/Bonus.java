package com.sitatravels.bonus.models;

public class Bonus {
    private String empName;
    private int amount;
    private String currency;
    private String joiningDate;
    private String exitDate;
    
    public Bonus(String empName, int amount, String currency, String joiningDate, String exitDate) {
        this.empName = empName;
        this.amount = amount;
        this.currency = currency;
        this.joiningDate = joiningDate;
        this.exitDate = exitDate;
    }

    public Bonus() {
    }

    @Override
    public String toString() {
        return "Bonus [empName=" + empName + ", amount=" + amount + ", currency=" + currency + ", joiningDate="
                + joiningDate + ", exitDate=" + exitDate + "]";
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

}
