package com.Accounts.MicroServiceAccounts.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerID;
    private String name;
    private String email;
    private String mobileNumber;

}

