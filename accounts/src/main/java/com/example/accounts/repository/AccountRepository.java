package com.example.accounts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.accounts.modal.Accounts;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Long> {

Accounts findByCustomerId(Integer customerId);	
	
}
