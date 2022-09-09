package com.celes.ems.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.celes.ems.dao.EmployeeDao;
import com.celes.ems.dao.RegisterDao;
import com.celes.ems.dto.Employee;
import com.celes.ems.dto.RegisterFormDto;


@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	RegisterDao dao;

	@Autowired
	EmployeeDao dao1;

	@Override
	public RegisterFormDto insertData(RegisterFormDto dto) {
		return dao.save(dto);
	}

	@Override
	public Employee insertDataemp(Employee dto) {
		if (dto.getAge() < 0) {
			return null;
		}
		return dao1.save(dto);
	}

	@Override
	public boolean updateemp(Employee dto) {
		Employee findById = dao1.findById(dto.getId());
		if(dto.getFullname() != null) 
		findById.setFullname(dto.getFullname());
		if(dto.getDesignation() != null)
		findById.setDesignation(dto.getDesignation());
		if(dto.getSalary() != 0)
		findById.setSalary(dto.getSalary());
		if(dto.getAge() != 0)
		findById.setAge(dto.getAge());
		dao1.save(findById);
		return true;
	}

	@Override
	public boolean deleteemp(int id) {
		dao1.deleteById(id);
		return true;

	}

	@Override
	public RegisterFormDto authenticate(RegisterFormDto dto) {
		try {
			RegisterFormDto dto2 = dao.findByEmailid(dto.getEmailid());
			return dto2;
		} catch (Exception e) {
			return null;
		}
	}
	
}
