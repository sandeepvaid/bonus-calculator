package com.sitatravels.bonus.services;

import com.sitatravels.bonus.exception.bonusexception;
import com.sitatravels.bonus.models.Bonus;
import com.sitatravels.bonus.models.Employee;
import com.sitatravels.bonus.models.EmployeeWithBonus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeMapper {

    public List<EmployeeWithBonus> getEmployeeWithBonus(List<Bonus> bonuses){
        Map<String,Boolean> checkCurrency = new HashMap<>();
        List<EmployeeWithBonus> finalList = new ArrayList<>();
        try{
            for(Bonus bonus:bonuses){
                if(checkCurrency.containsKey(bonus.getCurrency())){
                    Employee employee = new Employee();
                    employee.setname(bonus.getEmpName());
                    employee.setAmount(bonus.getAmount());

                    for (EmployeeWithBonus employeeWithBonus:finalList){
                        if(employeeWithBonus.getCurrency().contains(bonus.getCurrency())){
                            ArrayList<Employee> employeeArr = new ArrayList<>();
                            employeeArr=employeeWithBonus.getEmployees();
                            employeeArr.add(employee);
                            employeeWithBonus.setEmployees(employeeArr);
                        }
                    }
                }else{
                    ArrayList <Employee> employee = new ArrayList<>();
                    Employee employe = new Employee(bonus.getEmpName(),bonus.getAmount());
                    employee.add(employe);
                    EmployeeWithBonus employeeWithBonus = new EmployeeWithBonus();
                    employeeWithBonus.setCurrency(bonus.getCurrency());
                    employeeWithBonus.setEmployees(employee);
                    finalList.add(employeeWithBonus);
                }
            }
        }catch (RuntimeException e){
            throw  new bonusexception(String.format("Not able to generate final bonus list of  the array %s",e));
        }

        return finalList;
    }

}
