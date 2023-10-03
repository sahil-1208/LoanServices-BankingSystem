package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.enums.Status;
import com.learning.model.LoanRequest;
import com.learning.model.LoanResponse;
import com.learning.service.LoanService;


@RestController
@RequestMapping("/loan")
public class LoanController {
	
		@Autowired
		private LoanService loanService;
		
		@PostMapping
		public LoanResponse createNewLoan(@RequestBody LoanRequest loanRequest) {
			return loanService.createLoan(loanRequest);
		}

		@GetMapping("/{id}")
		public LoanResponse getExistingLoanById(@PathVariable Integer id) {
			return loanService.findLoanById(id);
		}
		
		@PutMapping("/{id}")
		public LoanResponse updateExistingLoanById(@PathVariable Integer id, @RequestBody LoanRequest loanRequest) {
			return loanService.update(id, loanRequest);
		}
		
		@DeleteMapping("/{id}")
		public Status deleteExistingLoanById(@PathVariable Integer id) {
			return loanService.deleteLoanById(id);	
		}

	}

