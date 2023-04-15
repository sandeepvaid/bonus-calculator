package com.sitatravels.bonus.services;

import com.sitatravels.bonus.dao.EmployeeRepository;
import com.sitatravels.bonus.entities.Employee;
import com.sitatravels.bonus.models.Bonus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersistData {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void persisEmployeeData(List<Bonus> bonusEmployee){

        for(Bonus bonus:bonusEmployee){
            Employee employee = new Employee();
            employee.setAmount(bonus.getAmount());
            employee.setCurrency(bonus.getCurrency());
            employee.setExitDate(bonus.getExitDate());
            employee.setJoiningDate(bonus.getJoiningDate());
            employeeRepository.save(employee);
        }
    }

}
