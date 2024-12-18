package com.Accounts.MicroServiceAccounts.mapper;

import com.Accounts.MicroServiceAccounts.Dto.AccountDto;
import com.Accounts.MicroServiceAccounts.Dto.CustomerDto;
import com.Accounts.MicroServiceAccounts.Entity.Accounts;
import com.Accounts.MicroServiceAccounts.Entity.Customer;

public class CustomersMapper {


    public static Customer mapToCustomersEntity(Customer customerEntity, CustomerDto customerDto){

        customerEntity.setName(customerDto.getName());
        customerEntity.setMobileNumber(customerDto.getMobileNumber());
        customerEntity.setEmail(customerDto.getEmail());
        return customerEntity;
    }



    public static CustomerDto mapToCustomersDto(Customer customerEntity, CustomerDto customerDto){

        customerDto.setName(customerEntity.getName());
        customerDto.setMobileNumber(customerEntity.getMobileNumber());
        customerDto.setEmail(customerEntity.getEmail());

        return customerDto;
    }

}
