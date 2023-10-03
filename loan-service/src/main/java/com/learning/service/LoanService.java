package com.learning.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.document.LoanEntity;
import com.learning.enums.Status;
import com.learning.model.LoanRequest;
import com.learning.model.LoanResponse;
import com.learning.repository.LoanRepository;
import com.learning.utils.Convertor;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepo;

	@Autowired
	private Convertor convertor;

	public LoanResponse createLoan(LoanRequest loanRequest) {
		LoanResponse loanResponse = null;
		if (Objects.nonNull(loanRequest)) {
			LoanEntity loanEntity = convertor.requestToEntity(loanRequest);
			loanEntity = loanRepo.save(loanEntity);
			loanResponse = convertor.entityToResponse(loanEntity);
		}
		return loanResponse;
	}

	public LoanResponse findLoanById(Integer id) {
		LoanResponse loanResponse = null;
		Optional<LoanEntity> optionalEntity = loanRepo.findById(id);
		if (optionalEntity.isPresent()) {
			LoanEntity loanEntity = optionalEntity.get();
			loanResponse = convertor.entityToResponse(loanEntity);
		}
		return loanResponse;
	}

	public LoanResponse update(Integer id, LoanRequest loanRequest) {
		LoanResponse loanResponse = null;
		Optional<LoanEntity> optionalEntity = loanRepo.findById(id);
		if (optionalEntity.isPresent()) {
			LoanEntity loanEntity = optionalEntity.get();
			loanEntity = convertor.update(loanRequest, loanEntity);
			loanEntity = loanRepo.save(loanEntity);
			loanResponse = convertor.entityToResponse(loanEntity);
		}
		return loanResponse;
	}

	public Status deleteLoanById(Integer id) {
		Optional<LoanEntity> optionalEntity = loanRepo.findById(id);
		if (optionalEntity.isPresent()) {
			loanRepo.deleteById(id);
			return Status.SUCCESS;
		} 
		return Status.FAILED;
	}
	
}
