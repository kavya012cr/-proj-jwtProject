package com.celes.ems.dao;

import org.springframework.data.repository.CrudRepository;

import com.celes.ems.dto.RegisterFormDto;

public interface RegisterDao extends CrudRepository<RegisterFormDto, Integer> {
 RegisterFormDto findByEmailid(String emailid);

}
