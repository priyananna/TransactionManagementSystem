package com.example.demo.exceptions;

public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(int id){
		super("could not find account" + id);
	}
}
