package com.Cards.MicroServiceCards.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        title = "CARDS",
        description = "Cards Entities are listed here!"
)
public class CardsDTO {

    @NotEmpty(message = "Mobile number Cannot be empty! ")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card Number Cannot be empty! ")
    @Pattern(regexp="(^$|[0-9]{12})", message = "Mobile Number must be 12 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "789654321591258"
    )
    private String cardNumber;

    @NotEmpty(message = "Card Type Cannot be empty! ")
    @Schema(
            description = "Card type of Customer", example = "Credit Cards"
    )
    private String cardType;


    @Positive(message = "Can not be in negative value")
    @Schema(
            description = "Card total limit of Customer", example = "1500000"
    )
    private Integer  totalLimit;


    @PositiveOrZero(message = "Used amount should be Zero or greater than Zero!")
    @Schema(
            description = "Card used amount of Customer", example = "7894"
    )
    private Integer  amountUsed;


    @PositiveOrZero(message = "Available amount should be Zero or greater than Zero!")
    @Schema(
            description = "Available amount of Customer", example = "7894"
    )
    private Integer  availableAmount;



}
