package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserTransactionsService {
	
	@Autowired
	public UserTransactionRepository userTransactionRepository;

	public List<UserTransactions> getUserTransData(Integer id) {
		
	
			List<UserTransactions> transDetails = new ArrayList<>();
			List<UserTransactions> result = new ArrayList<>();
			
		     userTransactionRepository.findAll().forEach(transDetails::add);;
            for(UserTransactions user : transDetails){
            	if(user.getMonetaryAmt() >10000){
            		result.add(user);
            	}
            }
			 
			return result;
		}

	public void addUserTransData(UserTransactions userTransactions) {
	
		 userTransactionRepository.save(userTransactions);
	}

}
