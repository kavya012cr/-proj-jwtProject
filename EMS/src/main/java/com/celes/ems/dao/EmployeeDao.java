package com.celes.ems.dao;

import org.springframework.data.repository.CrudRepository;

import com.celes.ems.dto.Employee;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	Employee findById(int id);

	
	
}
