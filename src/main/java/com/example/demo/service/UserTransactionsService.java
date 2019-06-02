package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AccountNotFoundException;
import com.example.demo.model.UserTransactions;
import com.example.demo.repository.UserTransactionRepository;


@Service
public class UserTransactionsService {
	
	@Autowired
	public UserTransactionRepository userTransactionRepository;

	public List<UserTransactions> getUserTransData(int id) {
		
	
			List<UserTransactions> transDetails = new ArrayList<>();
			List<UserTransactions> result = new ArrayList<>();
			
		     userTransactionRepository.findAll().forEach(transDetails::add);
            for(UserTransactions user : transDetails){
            	if(id == user.getAccountId() && user.getMonetaryAmt() > 10000){
            		result.add(user); 
           
            	}
            }
			 
			return result;
		}

	public void addUserTransData(UserTransactions userTransactions) {
	
		 userTransactionRepository.save(userTransactions);
	}

	public UserTransactions userUpdateData(UserTransactions userTransactions, int id) {
		return  userTransactionRepository.findById(id).map(transaction -> {
			transaction.setDate(userTransactions.getDate());
	        transaction.setDescription(userTransactions.getDescription());
	        transaction.setMonetaryAmt(userTransactions.getMonetaryAmt());
	        return userTransactionRepository.save(transaction);
	        }).orElseGet(() -> {
	         return userTransactionRepository.save(userTransactions);
	        });
		
	}

	public UserTransactions getAccountDetail(int id) {
		// TODO Auto-generated method stub
		return userTransactionRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
	}

	public List<UserTransactions> getAllAccountDetails() {
		// TODO Auto-generated method stub
		List<UserTransactions> response = new ArrayList<>();
		Iterable<UserTransactions> transDetails = userTransactionRepository.findAll();
		for(UserTransactions user : transDetails){
			UserTransactions userTrans = new UserTransactions();
			userTrans.setAccountId(user.getAccountId());
			userTrans.setDate(user.getDate());
			userTrans.setDescription(user.getDescription());
			userTrans.setMonetaryAmt(user.getMonetaryAmt());
			response.add(userTrans);
		}		
		
	    return response;
	}

}
