package com.sitatravels.bonus.dao;

import com.sitatravels.bonus.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
