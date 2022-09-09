package com.celes.expenseyoutube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celes.expenseyoutube.model.Expense;
import com.celes.expenseyoutube.repository.ExpenseRepository;

@Service
public class ExpenseServiceImplementation implements ExpenseService{

	@Autowired
	ExpenseRepository expenserepo;
	@Override
	public List<Expense> findAll() {
		// TODO Auto-generated method stub
		return expenserepo.findAll();
	}
	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
        expenserepo.save(expense);		
	}
	@Override
	public Expense findById(Long id) {
		if (expenserepo.findById(id).isPresent()) {
			return expenserepo.findById(id).get();

		}
		return null;
	}

}
