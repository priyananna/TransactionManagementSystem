package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserTransactions;
import com.example.demo.service.UserTransactionsService;

@RestController
public class UserTransactionController {
	
	@Autowired
	public UserTransactionsService userTransactionsService;
	

//In memory database apache Derby is used to store and get the details from the database	
	
	//Populate particular account details whose amount is greater than 10000 and account number is equal given id.
	//Get request using query parameters for account id as input
	@RequestMapping(value="/account/amount", method=RequestMethod.GET)
	public List<UserTransactions> userData(@RequestParam(value="AccountNo",required=true) int id, HttpServletRequest request, HttpServletResponse response) {
		List<UserTransactions> resp = new ArrayList();
		try {
			
		    resp = userTransactionsService.getUserTransData(id); 
		}
		catch(ServiceException e1) {
        	response.setStatus(HttpServletResponse.SC_NOT_FOUND);	
			
		}
		return resp;
	}
	
	//Get account details for a account id
	@GetMapping("/account/{id}")
	public UserTransactions getAccountDetailsForId(@PathVariable int id){
		
		return userTransactionsService.getAccountDetail(id);
	}
	
	//Get all account details
	@GetMapping("/account")
	public List<UserTransactions> getAccountDetailsForId(){
		
		return userTransactionsService.getAllAccountDetails();
	}
	
	
	
	
	//new account creation for amount deposit
	@RequestMapping(value="/account/add", method=RequestMethod.POST)
	public void userData(@RequestBody UserTransactions userTransactions) {
			
		    userTransactionsService.addUserTransData(userTransactions);
		    

	}
	
	//update the account with a new deposit to the bank transaction, if not present then insert.
	//Put request with path parameters as input.
	@PutMapping("/account/update/{id}")
	public UserTransactions userUpdateData(@RequestBody UserTransactions userTransactions, @PathVariable int id){
		
		return userTransactionsService.userUpdateData(userTransactions,id);
			
	}
	
	
	
	
	
	
}
