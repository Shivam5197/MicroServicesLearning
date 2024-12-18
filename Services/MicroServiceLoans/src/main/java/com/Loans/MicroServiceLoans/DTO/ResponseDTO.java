package com.Loans.MicroServiceLoans.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
public class ResponseDTO {


    @Schema(
            description = "Status code or Response!", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status Message in the Response!", example = "Saved Successfully"
    )
    private String statusMsg;


}
