package com.learning.utils;

import org.springframework.stereotype.Component;

import com.learning.document.LoanEntity;
import com.learning.model.LoanRequest;
import com.learning.model.LoanResponse;

@Component
public class Convertor {

	public LoanEntity requestToEntity(LoanRequest loanRequest) {
		LoanEntity loanEntity = new LoanEntity();
		loanEntity.setId(loanRequest.getId());
		loanEntity.setAmount(loanRequest.getAmount());
		loanEntity.setTerm(loanRequest.getTerm());
		loanEntity.setUid(loanRequest.getUid());
		loanEntity.setSuggestions(loanRequest.getSuggestions());
		return loanEntity;
	}

	public LoanResponse entityToResponse(LoanEntity loanEntity) {
		LoanResponse loanResponse = new LoanResponse();
		loanResponse.setId(loanEntity.getId());
		loanResponse.setAmount(loanEntity.getAmount());
		loanResponse.setTerm(loanEntity.getTerm());
		loanResponse.setUid(loanEntity.getUid());
		loanResponse.setSuggestions(loanEntity.getSuggestions());
		return loanResponse;
	}
	
	public LoanEntity update(LoanRequest loanRequest, LoanEntity loanEntity) {
		loanEntity.setAmount(loanRequest.getAmount());
		loanEntity.setTerm(loanRequest.getTerm());
		loanEntity.setSuggestions(loanRequest.getSuggestions());
		return loanEntity;
	}
}
