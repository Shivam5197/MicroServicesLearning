package com.Accounts.MicroServiceAccounts.Controller;

import com.Accounts.MicroServiceAccounts.Constants.AccountsConstant;
import com.Accounts.MicroServiceAccounts.Dto.CustomerDto;
import com.Accounts.MicroServiceAccounts.Dto.ErrorDto;
import com.Accounts.MicroServiceAccounts.Dto.ResponseDto;
import com.Accounts.MicroServiceAccounts.Service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
@Tag(
        name = "Account Controller used to perform CRUD operations !",
        description = "Good description of what this Controller does"
)
public class AccountController {

    private IAccountService accountService;


    @Operation(
            summary = "Method to create an account!",
            description = "Good description on how to create a Account!"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Account created Successfully."

    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountService.createAccount(customerDto);

        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESSAGE_201));
    }


    @GetMapping("/findCustomer")
    public ResponseEntity<CustomerDto> getCustomerByMobileNumber(@RequestParam
                                                                 @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits!")
                                                                 String mobileNumber) {

        CustomerDto customerDto = accountService.fetchCustomer(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Update success!"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {

        boolean isSaved = accountService.UpdateDetails(customerDto);

        if (isSaved) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstant.STATUS_500, AccountsConstant.MESSAGE_500));

        }

    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam
                                                     @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits!")
                                                     String mobileNumber) {

        boolean isDeleted = accountService.DeleteDetails(mobileNumber);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstant.STATUS_500, AccountsConstant.MESSAGE_500));

        }
    }


}