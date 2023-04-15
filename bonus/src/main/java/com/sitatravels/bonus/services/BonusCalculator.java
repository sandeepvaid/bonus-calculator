package com.sitatravels.bonus.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sitatravels.bonus.exception.bonusexception;
import org.springframework.stereotype.Component;

import com.sitatravels.bonus.models.Bonus;

@Component
public class BonusCalculator {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-yyyy");

    private static String capitalizeFirstLetter(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
    public List<Bonus> getEligibleBonusList(List<Bonus> bonus) {
        List<Bonus> elegibleEmployee = new ArrayList<>();
        LocalDate now = LocalDate.now();

        try{
            List<Bonus> capitalizedDates = bonus.stream()
                    .map(e -> new Bonus(
                            e.getEmpName(),
                            e.getAmount(),
                            e.getCurrency(),
                            capitalizeFirstLetter(e.getJoiningDate()),
                            capitalizeFirstLetter(e.getExitDate())))
                    .collect(Collectors.toList());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
            elegibleEmployee = capitalizedDates.stream()
                    .filter(e -> LocalDate.parse(e.getJoiningDate(),formatter).isAfter(now) || LocalDate.parse(
                            e.getExitDate(),formatter).isBefore(now))
                    .collect(Collectors.toList());
        }catch (RuntimeException e){
            throw  new bonusexception(String.format("Not able to filter the array %s",e));
        }

        return elegibleEmployee;
    }




}
