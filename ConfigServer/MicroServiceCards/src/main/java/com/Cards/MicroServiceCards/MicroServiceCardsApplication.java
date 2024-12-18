package com.Cards.MicroServiceCards;

import com.Cards.MicroServiceCards.DTO.ContactInfo_Cards;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@OpenAPIDefinition(info =
@Info(
		title = "Rest API documentation for Cards!",
		description = "This is service for shivam Banks !",
		version = "v1",
		contact = @Contact(
				name = "Shivam Sharma",
				email = "Shivam511997@gmail.com"
		),
		license = @License(
				name = "Apache 2.0",
				url = "WebsiteLinkforLincenseDEtails.com"
		)

), externalDocs = @ExternalDocumentation(
		description = "This is Related for external persons",
		url = "urlForOutSidersTocheck.com"
)

)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = ContactInfo_Cards.class)
public class MicroServiceCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCardsApplication.class, args);
	}

}
