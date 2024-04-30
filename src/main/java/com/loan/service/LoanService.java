package com.loan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loan.entity.Loan;

@Service
public interface LoanService {

	List<Loan> getAllLoans();
	Loan saveLoan(Loan loan);
	Loan getLoanById(Long id);
	String updateLoanById(Long id, Loan loan);
	String deleteLoan(Long id);
	
	
}
