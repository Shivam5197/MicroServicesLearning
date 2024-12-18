package com.Cards.MicroServiceCards.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record ContactInfo_Cards(String message, Map<String ,String> ContactDetails , List<String> onCallSupport) {
}
