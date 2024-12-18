package com.Accounts.MicroServiceAccounts.Service;

import com.Accounts.MicroServiceAccounts.Dto.AccountDto;
import com.Accounts.MicroServiceAccounts.Dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchCustomer(String mobileNumber);

    boolean UpdateDetails(CustomerDto customerDto);

    boolean DeleteDetails(String mobileNumber);
}
