package com.sitatravels.bonus;


import com.sitatravels.bonus.models.Bonus;
import com.sitatravels.bonus.services.BonusCalculator;
import com.sitatravels.bonus.services.EmployeeMapper;
import com.sitatravels.bonus.services.PersistData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BonusApplicationTests {
	@Autowired
	private BonusCalculator bonusCalculator;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private PersistData persistData;


	@Test
	void bonusCalculatorTest() {
		List<Bonus> bonusList= new ArrayList<>();
		Bonus bonus1 = new Bonus("sandeep",1000,"USD","may-02-2021","may-02-2022");
		Bonus bonus2 = new Bonus("kanu",1000,"INR","may-02-2021","may-02-2022");
		Bonus bonus3 = new Bonus("ramesh",1000,"USD","may-02-2021","may-02-2022");
		bonusList.add(bonus1);
		bonusList.add(bonus2);
		bonusList.add(bonus3);
		System.out.println(bonusCalculator.getEligibleBonusList(bonusList));
	}

	void employeeMapperTest(){
		List<Bonus> bonusList= new ArrayList<>();
		Bonus bonus1 = new Bonus("sandeep",1000,"USD","may-02-2021","may-02-2022");
		Bonus bonus2 = new Bonus("kanu",1000,"INR","may-02-2021","may-02-2022");
		Bonus bonus3 = new Bonus("ramesh",1000,"USD","may-02-2021","may-02-2022");
		bonusList.add(bonus1);
		bonusList.add(bonus2);
		bonusList.add(bonus3);
		System.out.println(employeeMapper.getEmployeeWithBonus(bonusList));
	}

	void persistDataTest(){
		List<Bonus> bonusList= new ArrayList<>();
		Bonus bonus1 = new Bonus("sandeep",1000,"USD","may-02-2021","may-02-2022");
		Bonus bonus2 = new Bonus("kanu",1000,"INR","may-02-2021","may-02-2022");
		Bonus bonus3 = new Bonus("ramesh",1000,"USD","may-02-2021","may-02-2022");
		bonusList.add(bonus1);
		bonusList.add(bonus2);
		bonusList.add(bonus3);
		persistData.persisEmployeeData(bonusList);
	}

}
