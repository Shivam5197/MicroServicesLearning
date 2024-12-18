package com.Accounts.MicroServiceAccounts.Dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountCreatorInfo(String message, Map<String,String> ContactDetails, List<String> onCallSupport) {
}
