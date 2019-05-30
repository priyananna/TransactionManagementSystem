package com.example.demo.service;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTransactions {
	
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String date;
	private String description;
	private UUID randomNum;
	private double monetaryAmt;
	
	
	public UserTransactions() {
		
	}
	
	
	
	public UserTransactions(String date, String description, UUID randomNum, Integer monetaryAmt) {
		super();
		this.date = date;
		this.description = description;
		this.randomNum = randomNum;
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


	public UUID getRandomNum() {
		return randomNum;
	}


	public void setRandomNum(UUID randomNum) {
		this.randomNum = randomNum;
	}


	public int getMonetaryAmt() {
		return (int) monetaryAmt;
	}


	public void setMonetaryAmt(Integer monetaryAmt) {
		this.monetaryAmt = monetaryAmt;
	}
	
	

}
