package com.Accounts.MicroServiceAccounts.mapper;

import com.Accounts.MicroServiceAccounts.Dto.AccountDto;
import com.Accounts.MicroServiceAccounts.Entity.Accounts;

public class AccountsMapper {


    public static Accounts mapToAccountsEntity(Accounts accountsEntity, AccountDto accountDto){

        accountsEntity.setAccountNumber(accountDto.getAccountNumber());
        accountsEntity.setAccountType(accountDto.getAccountType());
        accountsEntity.setBranchAddress(accountDto.getBranchAddress());
        return accountsEntity;
    }



    public static AccountDto mapToAccountsDto(Accounts accountsEntity, AccountDto accountDto){

        accountDto.setAccountNumber(accountsEntity.getAccountNumber());
        accountDto.setAccountType(accountsEntity.getAccountType());
        accountDto.setBranchAddress(accountsEntity.getBranchAddress());

        return accountDto;
    }

}
