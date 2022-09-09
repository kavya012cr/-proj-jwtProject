package com.celes.expenseyoutube.service;

import java.util.List;

import com.celes.expenseyoutube.model.Expense;

public interface ExpenseService {

	List<Expense> findAll();
	void save(Expense expense);
	Expense findById(Long id);
}
