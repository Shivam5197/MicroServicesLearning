package com.Accounts.MicroServiceAccounts.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

    @NotEmpty(message = "Account number is mandatory !")
    @Pattern(regexp = "$|[0-9]{10}", message = "Account number must be 10 digits! ")
    private Long accountNumber;

    @NotEmpty(message = "Account Type is mandatory !")
    private String accountType;

    @NotEmpty(message = "Branch address is mandatory !")
    private String branchAddress;
}
