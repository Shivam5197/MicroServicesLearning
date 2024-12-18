package com.Cards.MicroServiceCards.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Schema(name = "Response")
public class ResponseDTO {

    @Schema(
            description = "Status code or Response!", example = "200"
    )
    private String httpStatus;

    @Schema(
            description = "Status Message in the Response!", example = "Saved Successfully"
    )
    private String statusMsg;



}
