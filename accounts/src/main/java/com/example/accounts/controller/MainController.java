package com.example.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accounts.modal.Accounts;
import com.example.accounts.modal.Customer;
import com.example.accounts.repository.AccountRepository;

@RestController
public class MainController {

	@Autowired
	private AccountRepository accountRepository;
	
	
	@PostMapping("/myAccounts")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts account = accountRepository.findByCustomerId(customer.getCustomerId());
		
		if(account!= null)
		return account;
		else
			return null;
	}
	
}
