package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends CrudRepository<UserTransactions, Integer>{

	Iterable<UserTransactions> findAll();
	
}
