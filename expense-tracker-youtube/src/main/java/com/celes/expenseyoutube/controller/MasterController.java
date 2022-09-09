package com.celes.expenseyoutube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.celes.expenseyoutube.model.Expense;
import com.celes.expenseyoutube.service.ExpenseService;

@Controller
public class MasterController {
	@Autowired
	ExpenseService service;
	
@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView=new ModelAndView("home");
		modelAndView.addObject("message", "list of Expenses");
		List<Expense> expenses=service.findAll();
		System.out.println(expenses);
		modelAndView.addObject("expenses", expenses);
		return modelAndView;
		
	}
@RequestMapping("/expense")
public ModelAndView addexpense() {
	ModelAndView modelAndView=new ModelAndView("expense");
	modelAndView.addObject("expense", new Expense());
	return modelAndView;
}
@RequestMapping(value = "/expense", method = RequestMethod.POST)
public String save(@ModelAttribute("expense") Expense expense) {
	service.save(expense);
	return "redirect:/";

}
@RequestMapping(value = "/expense/{id}", method = RequestMethod.GET)
public ModelAndView edit(@PathVariable("id")Long id) {
	ModelAndView andView=new ModelAndView("expense");
	Expense expense2=service.findById(id);
	andView.addObject("expense", expense2);
	return andView;
}
	
}
