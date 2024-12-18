package com.Accounts.MicroServiceAccounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditorAwareImpl")
@OpenAPIDefinition(info =
@Info(
        title = "Rest API documentation for Accounts!",
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
public class MicroServiceAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceAccountsApplication.class, args);
    }

}
