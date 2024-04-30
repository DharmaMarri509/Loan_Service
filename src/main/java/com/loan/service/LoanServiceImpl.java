package com.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.entity.Loan;
import com.loan.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepository repo;

	@Override
	public List<Loan> getAllLoans() {
		return repo.findAll();
	}

	@Override
	public Loan saveLoan(Loan loan) {
		return repo.save(loan);
	}

	@Override
	public Loan getLoanById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public String updateLoanById(Long id, Loan loan) {
		Loan l1 = repo.findById(id).get();
		loan.setLoanId(id);
		
		if(loan.getCustomerName().equals(null)) {
			loan.setCustomerName(l1.getCustomerName());
		}
		if(loan.getLoanType().equals(null)) {
			loan.setLoanType(l1.getLoanType());
		}
		if(loan.getAmount()==0.0) {
			loan.setAmount(l1.getAmount());
		}
		repo.save(loan);
		
		return "updated successfully "+loan.getCustomerName()+" -> "+loan.getLoanType()+" -> "+loan.getAmount();
	}

	@Override
	public String deleteLoan(Long id) {
		repo.deleteById(id);
		return "record deleted successfully with id :- "+id;
	}

}
