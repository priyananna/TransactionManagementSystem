package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTransactions {
	
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;


	//  private UUID randomNum;
	private String description;
	private String date;	
	private double monetaryAmt;
	
	
	public UserTransactions() {
		
	}
	
	
	
	public UserTransactions(String date, String description, double monetaryAmt) {
		super();
		this.date = date;
		this.description = description;
		this.monetaryAmt = monetaryAmt;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	/*
	public UUID getRandomNum() {
		return randomNum;
	}


	public void setRandomNum(UUID randomNum) {
		this.randomNum = randomNum;
	}
*/
	

	public double getMonetaryAmt() {
		return (double) monetaryAmt;
	}


	public void setMonetaryAmt(double monetaryAmt) {
		this.monetaryAmt = monetaryAmt;
	}
	
	public int getAccountId() {
			return accountId;
		}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

}
