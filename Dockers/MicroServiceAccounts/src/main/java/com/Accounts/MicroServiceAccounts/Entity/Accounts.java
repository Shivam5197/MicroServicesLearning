package com.Accounts.MicroServiceAccounts.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class Accounts extends BaseEntity{

    @Id
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
}
