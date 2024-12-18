package com.Accounts.MicroServiceAccounts.Repository;

import com.Accounts.MicroServiceAccounts.Dto.CustomerDto;
import com.Accounts.MicroServiceAccounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

     Optional<Customer> findByMobileNumber(String mobileNumber);


}
