package com.Cards.MicroServiceCards.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
@Getter
@Setter
public class ContactInfo_Cards {
    private String message;
    private Map<String,String> ContactDetails;
    private List<String> onCallSupport;
}
