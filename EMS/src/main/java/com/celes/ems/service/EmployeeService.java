package com.celes.ems.service;

import com.celes.ems.dto.Employee;
import com.celes.ems.dto.RegisterFormDto;

public interface EmployeeService {

	RegisterFormDto insertData(RegisterFormDto dto);

	Employee insertDataemp(Employee dto);

	boolean updateemp(Employee dto);

	boolean deleteemp(int id);

	RegisterFormDto authenticate(RegisterFormDto dto);

	

}
