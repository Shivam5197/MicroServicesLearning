package com.Accounts.MicroServiceAccounts.Service.Impl;

import com.Accounts.MicroServiceAccounts.Constants.AccountsConstant;
import com.Accounts.MicroServiceAccounts.Dto.AccountDto;
import com.Accounts.MicroServiceAccounts.Dto.CustomerDto;
import com.Accounts.MicroServiceAccounts.Entity.Accounts;
import com.Accounts.MicroServiceAccounts.Entity.Customer;
import com.Accounts.MicroServiceAccounts.Exceptions.CustomerAlreadyExistException;
import com.Accounts.MicroServiceAccounts.Exceptions.ResourceNotFoundException;
import com.Accounts.MicroServiceAccounts.Repository.AccountRepository;
import com.Accounts.MicroServiceAccounts.Repository.CustomerRepository;
import com.Accounts.MicroServiceAccounts.Service.IAccountService;
import com.Accounts.MicroServiceAccounts.mapper.AccountsMapper;
import com.Accounts.MicroServiceAccounts.mapper.CustomersMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor

public class AccountServiceImpl implements IAccountService {


    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomersMapper.mapToCustomersEntity(new Customer(), customerDto);
        System.out.println("Saved Customer  ! !! " + customer);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer with this " + customer.getMobileNumber() + " mobile number already exists");
        }
        //       customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("Shivam Anynomyon");
        Customer savedCustomer = customerRepository.save(customer);

        System.out.println("Saved Customer Details ! !! " + savedCustomer);
        accountRepository.save(CreateAccount(savedCustomer));

    }

    private Accounts CreateAccount(Customer customer) {

        Accounts newAccount = new Accounts();
        Long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
        System.out.println("Accounts Create " + customer);
        newAccount.setCustomerId(customer.getCustomerID());
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstant.SAVINGS);
        newAccount.setBranchAddress(AccountsConstant.ADDRESS);
        //  newAccount.setCreatedAt(LocalDateTime.now());
        //  newAccount.setCreatedBy("Shivam Anynomyon");


        return newAccount;
    }


    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile Number ", mobileNumber)
        );

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerID()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customer Id", customer.getCustomerID().toString())
        );

        CustomerDto customerDto = CustomersMapper.mapToCustomersDto(customer, new CustomerDto());
        AccountDto accountDto = AccountsMapper.mapToAccountsDto(accounts, new AccountDto());
        customerDto.setAccountDto(accountDto);
        return customerDto;
    }


    /**
     * @param customerDto
     * @return
     */
    @Override
    public boolean UpdateDetails(CustomerDto customerDto) {

        boolean isSaved = false;
        AccountDto accountDto = customerDto.getAccountDto();
        if (accountDto != null) {
            Accounts accounts = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Accounts", "Account Number", accountDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccountsEntity(accounts, accountDto);
            accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "Customer ID", customerId.toString())
            );
            CustomersMapper.mapToCustomersEntity(customer, customerDto);
            customerRepository.save(customer);

            isSaved = true;
        }
        return isSaved;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean DeleteDetails(String mobileNumber) {

        boolean isDeleted = false;

        if (mobileNumber != null) {
            Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber)
            );
            Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerID()).orElseThrow(
                    () -> new ResourceNotFoundException("Accounts", "Customer", customer.getCustomerID().toString())
            );

            accountRepository.deleteByCustomerId(customer.getCustomerID());
            customerRepository.deleteById(customer.getCustomerID());
            isDeleted = true;
        }

        return isDeleted;
    }


}
