package com.Accounts.MicroServiceAccounts.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountCreatorInfo {

    private String message;
    private Map<String,String> ContactDetails;
    private List<String> onCallSupport;
}
