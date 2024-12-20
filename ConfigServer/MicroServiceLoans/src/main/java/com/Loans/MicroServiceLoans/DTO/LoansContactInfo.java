package com.Loans.MicroServiceLoans.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
@Getter
@Setter

public class LoansContactInfo{
    private String message;
    private Map<String,String> ContactDetails;
    private List<String> onCallSupport;
}
