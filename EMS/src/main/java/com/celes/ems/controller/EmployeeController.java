package com.celes.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.celes.ems.dto.Employee;
import com.celes.ems.dto.RegisterFormDto;
import com.celes.ems.service.EmployeeService;



@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginData(@RequestBody RegisterFormDto dto) {
		RegisterFormDto dto1 = service.authenticate(dto);
		if (dto == null) {
			return new ResponseEntity<>("sorry invalid Emailid please check",HttpStatus.INTERNAL_SERVER_ERROR);
		} else if(dto1.getPassword().equals(dto.getPassword())){
			return new ResponseEntity<>("Login Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Sorry invaild password please ckeck",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<?> insertData(@RequestBody RegisterFormDto dto) {
		try {
			RegisterFormDto data = service.insertData(dto);
			if(data != null) {
				return new ResponseEntity<RegisterFormDto>(data, HttpStatus.OK); 
			}else {
			return new ResponseEntity<>("please enter a valid inputs...", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Data Inserted UnSuccessfully...", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping("/insertemp")
	public ResponseEntity<?> insertEmp(@RequestBody Employee dto) {
		try {
			Employee dto1 = service.insertDataemp(dto);
			if(dto!=null){
				return new ResponseEntity<Employee>(dto1, HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("please enter a valid age" , HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Data Inserted UnSuccessfully...", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateemp")
	public ResponseEntity<?> updateemp(@RequestBody Employee dto) {
		try {
			service.updateemp(dto);
			return new ResponseEntity<>("Data Updateded Successfully..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Data Updateded UnSuccessfully...", HttpStatus.NOT_MODIFIED);
		}
	}
	@DeleteMapping("/deleteemp")
	public ResponseEntity<?> deleteemp(int id) {
		try {
			service.deleteemp(id);
			return new ResponseEntity<>("Data Deleted Successfully...", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Data Deleted UnSuccessfully....", HttpStatus.NOT_FOUND);
		}
		
	}

}
