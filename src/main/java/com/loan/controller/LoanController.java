package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loan.entity.Loan;
import com.loan.service.LoanService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class LoanController {

	@Autowired
	LoanService service;
	
	
	
	@PostMapping("/save")
	public Loan addLoan(@Valid @RequestBody Loan loan) {
		return service.saveLoan(loan);
	}
	
	@GetMapping("/getAll")
	public List<Loan> getAllLoans() {
		return service.getAllLoans();
	}
	
	@GetMapping("/get")
	public Loan getLoanById(@RequestParam("id") Long id) {
		return service.getLoanById(id);
	}
	
	@PutMapping("/update")
	public String updateLoanById(Long id, Loan loan) {
		return service.updateLoanById(id, loan);
	}
	
	@DeleteMapping("/delete")
	public String deleteLoan(Long id) {
		return service.deleteLoan(id);
	}
}
