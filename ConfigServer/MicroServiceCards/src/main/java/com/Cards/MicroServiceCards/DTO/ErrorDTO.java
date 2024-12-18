package com.Cards.MicroServiceCards.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Error", description = "This will be triggered only when exception thrown !")
public class ErrorDTO {

    @Schema(description = "Api Path", example = "api/create")
    private String apiPath;
    @Schema(description = "Http Status of Exception", example = "500")
    private HttpStatus httpStatus;

    @Schema(description = "Error Message Exception", example = "Failed to Save")
    private String errorMessage;

    @Schema(description = "Error Time Exception")
    private LocalDateTime errorTime;
}
