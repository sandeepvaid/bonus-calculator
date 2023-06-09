package com.sitatravels.bonus.CalculateBonusController;

import java.util.List;
import java.util.Map;

import com.sitatravels.bonus.dao.EmployeeRepository;
import com.sitatravels.bonus.entities.Employee;
import com.sitatravels.bonus.models.EmployeeWithBonus;
import com.sitatravels.bonus.models.ResposeBody;
import com.sitatravels.bonus.services.EmployeeMapper;
import com.sitatravels.bonus.services.PersistData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.sitatravels.bonus.models.Bonus;
import com.sitatravels.bonus.services.BonusCalculator;

import javax.xml.bind.DataBindingException;

@RestController
public class bonusController {
    
    @Autowired
    private BonusCalculator bonusCalculator;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private PersistData persistData;

    @PostMapping("/tci/bonus/eligibility")
    
    public ResposeBody getBonus(@RequestBody List<Bonus> bonus){
        ResposeBody resposeBody = new ResposeBody();
        try{
            persistData.persisEmployeeData(bonus);

        }catch (DataBindingException e){
            resposeBody.setErrorMessage(String.valueOf(e));
            return resposeBody;
        }
        try{
            List<Bonus> bonusList = this.bonusCalculator.getEligibleBonusList(bonus);
            List<EmployeeWithBonus> finalList = this.employeeMapper.getEmployeeWithBonus(bonusList);
            resposeBody.setErrorMessage("");

            resposeBody.setdata(finalList);
            return resposeBody;
        }catch (RuntimeException e){
            resposeBody.setErrorMessage(String.valueOf(e));
            return resposeBody;
        }
    }

}
