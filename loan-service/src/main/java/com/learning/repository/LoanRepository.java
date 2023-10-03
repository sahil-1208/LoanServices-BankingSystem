package com.learning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.document.LoanEntity;

public interface LoanRepository extends MongoRepository<LoanEntity, Integer>{

}
