package com.Accounts.MicroServiceAccounts.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(name = "Error", description = "This will be triggered only when excepetion thrown !")
public class ErrorDto {

    @Schema(description = "Api Path", example = "api/create")
    private String apiPath;
    private HttpStatus httpStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
