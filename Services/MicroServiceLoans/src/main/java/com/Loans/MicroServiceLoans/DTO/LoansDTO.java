package com.Loans.MicroServiceLoans.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        description = "Loans Schema to check the enities!",
        title = "Loans"
)
public class LoansDTO {

    @NotEmpty(message = "Mobile number Cannot be empty! ")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;



    @Schema(
            description ="Loan type !" , example = "Car Loan"
    )
    @NotEmpty(message = "Loan Type Cannot be empty! ")
    private String loanType;




    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    @NotEmpty(message = " Loan Number Cannot be empty! ")
    private String loanNumber;


    @Schema(
            description = "Total loan amount", example = "100000"
    )
    @Positive(message = "Total Loan cannot be zero or in negative!")
    private Integer totalLoan;




    @PositiveOrZero(message = "Amount paid Cannot be a negative value!")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private Integer amountPaid;




    @PositiveOrZero(message = "OutStanding amount Cannot be a negative value!")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private Integer outstandingAmount;


}
