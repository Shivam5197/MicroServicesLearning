package com.Loans.MicroServiceLoans.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
public record LoansContactInfo(String message, Map<String,String> ContactDetails, List<String> onCallSupport) {
}
