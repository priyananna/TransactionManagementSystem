package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserTransactions;

@Repository
public interface UserTransactionRepository extends CrudRepository<UserTransactions, Integer>{

	Iterable<UserTransactions> findAll();
	
	
	
}
