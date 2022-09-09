package com.celes.expenseyoutube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celes.expenseyoutube.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
