package com.Accounts.MicroServiceAccounts.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Customer will be holding information about Customer and Accounts"

)
public class CustomerDto {

    @Schema(description = "Customer Name",example = "Shivam Sharma")
    @NotEmpty
    @Size(min = 5 , max = 30 , message = "Name length should be between 5 to 30 characters !")
    private String name;

    @NotEmpty(message = "Email is mandatory !")
    @Email(message = "Email address is not correct")
    private String email;

    @NotEmpty(message = "Mobile number is mandatory !")
    @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits! ")
    private String mobileNumber;

    private AccountDto accountDto;
}
