package com.ericlefteroff.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ericlefteroff.savetravels.models.Expense;
import com.ericlefteroff.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {


//	Dependency injection for the service
	@Autowired
	private ExpenseService expServe;
	
//	Create expense render
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
//		List<Expense> expenses = expServe.allExpenses();
//		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
//	Create expense post
	@PostMapping("/newExpense")
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense,
								BindingResult res) {
		System.out.println("Is this printing");
		if (res.hasErrors()) {
			return "index.jsp";
		} else {
			expServe.createExpense(expense);
			return "redirect:/";
		}
	}
	
// All expenses
	@GetMapping("/all")
	public String all(Model model) {
		List<Expense> allExpenses = expServe.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "all.jsp";
	}
	
// One expense
	@GetMapping("/details/{id}")
	public String one(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expServe.findExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "details.jsp";
	}
	
//	Edit expenses
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense thisExpense = expServe.findExpense(id);
		model.addAttribute("thisExpense", thisExpense);
		return "edit.jsp";
	}
	
	@PutMapping("/prod/{id}/edit")
	public String editingExpense(@Valid @ModelAttribute("thisExpense") Expense expense,
								BindingResult res) {
		if (res.hasErrors()) {
			return "edit.jsp";
		} else {
			expServe.updateExpense(expense);
			return "redirect:/all";
		}
	}
	
//	Delete expense
	@DeleteMapping("/index/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expServe.deleteExpense(id);
		return "redirect:/all";
	}
	
}
