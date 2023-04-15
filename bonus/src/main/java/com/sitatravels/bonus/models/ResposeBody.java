package com.sitatravels.bonus.models;

import java.util.List;
import java.util.List;

public class ResposeBody {
    private String errorMessage;
    private List<EmployeeWithBonus> data;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<EmployeeWithBonus> getdata() {
        return data;
    }

    public void setdata(List<EmployeeWithBonus> data) {
        this.data = data;
    }

    public ResposeBody() {
    }

    public ResposeBody(String errorMessage, List<EmployeeWithBonus> data) {
        this.errorMessage = errorMessage;
        this.data = data;
    }
}
