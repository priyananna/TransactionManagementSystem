package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserTransactions;
import com.example.demo.service.UserTransactionsService;

@RestController
public class UserTransactionController {
	
	@Autowired
	public UserTransactionsService userTransactionsService;
	

	@RequestMapping(value="/tranactions", method=RequestMethod.GET)
	public List<UserTransactions> userData(@RequestParam(value="AccountNo",required=true) Integer id, HttpServletRequest request, HttpServletResponse response) {
		List<UserTransactions> resp = new ArrayList();
		try {
			
		    resp = userTransactionsService.getUserTransData(id); 
		}
		catch(ServiceException e1) {
        	response.setStatus(HttpServletResponse.SC_NOT_FOUND);	
			
		}
		return resp;
	}
	
	
	@RequestMapping(value="/tranactions/add", method=RequestMethod.POST)
	public void userData(@RequestBody UserTransactions userTransactions) {
			
		    userTransactionsService.addUserTransData(userTransactions);
		    

	}
	
	
	
	
}
