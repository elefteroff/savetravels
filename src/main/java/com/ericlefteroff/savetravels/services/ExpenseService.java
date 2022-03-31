package com.ericlefteroff.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericlefteroff.savetravels.models.Expense;
import com.ericlefteroff.savetravels.repos.ExpenseRepository;

@Service
public class ExpenseService {

//	Do dependency injection for the REPO
	@Autowired
	private ExpenseRepository expRepo;
	
//	READ ALL
	public List<Expense> allExpenses() {
		return expRepo.findAll();
	}
	
//	CREATE
	public Expense createExpense(Expense exp) {
		return expRepo.save(exp);
	}	

//	READ ONE
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Expense updateExpense(Expense exp) {
		return expRepo.save(exp);
	}
	
//	DELETE
	public void deleteExpense(Long  id) {
		expRepo.deleteById(id);
	}
	
}