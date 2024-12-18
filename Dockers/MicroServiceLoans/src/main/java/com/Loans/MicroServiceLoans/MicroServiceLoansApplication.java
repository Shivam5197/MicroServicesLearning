package com.Loans.MicroServiceLoans;

import com.Loans.MicroServiceLoans.DTO.LoansContactInfo;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
@OpenAPIDefinition(info =
@Info(
		title = "Rest API documentation for Loans !",
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
@EnableConfigurationProperties(value = LoansContactInfo.class)
public class MicroServiceLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceLoansApplication.class, args);
	}

}
