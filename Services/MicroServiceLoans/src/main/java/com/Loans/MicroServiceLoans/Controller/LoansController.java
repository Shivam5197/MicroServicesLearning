package com.Loans.MicroServiceLoans.Controller;

import com.Loans.MicroServiceLoans.Constants.LoansConstants;
import com.Loans.MicroServiceLoans.DTO.ErrorDto;
import com.Loans.MicroServiceLoans.DTO.LoansDTO;
import com.Loans.MicroServiceLoans.DTO.ResponseDTO;
import com.Loans.MicroServiceLoans.Service.ILoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(
        name = "Loans Controller used to perform CRUD operations !",
        description = "Good description of what this Controller does"
)
@AllArgsConstructor
public class LoansController {


    private ILoanService loanService;


    @Operation(
            summary = "Create Loan REST API",
            description = "REST API to create new loan inside EazyBank"
    )
    @ApiResponses({

            @ApiResponse(responseCode = "201",
                    description = "Loan created Successfully."
            ), @ApiResponse(
            responseCode = "500",
            description = "HTTP Status Internal Server Error",
            content = @Content(
                    schema = @Schema(implementation = ErrorDto.class)
            )
    )
    })
    @PostMapping("/createLoan")
    public ResponseEntity<ResponseDTO> saveLoans(@RequestParam
                                                 @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits!")
                                                 String mobileNumber) {

        loanService.createLoan(mobileNumber);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));

    }



    @Operation(
            summary = "Fetch Loan REST API",
            description = "REST API to Fetch loan inside EazyBank"
    )
    @ApiResponses({

            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully"
            ), @ApiResponse(
            responseCode = "500",
            description = "HTTP Status Internal Server Error",
            content = @Content(
                    schema = @Schema(implementation = ErrorDto.class)
            )
    )
    })
    @GetMapping("/fetchLoans")
    public ResponseEntity<LoansDTO> fetchLoans(@RequestParam
                                                  @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits!")
                                                  String mobileNumber) {

        LoansDTO loansDTO =  loanService.fetchLoan(mobileNumber);

    return ResponseEntity.status(HttpStatus.OK).body(loansDTO);
    }




    @Operation(
            summary = "Update Loan REST API",
            description = "REST API to update loan inside EazyBank"
    )
    @ApiResponses({

            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully"
            ), @ApiResponse(
            responseCode = "417",
            description = "Update operation failed. Please try again or contact Dev team",
            content = @Content(
                    schema = @Schema(implementation = ErrorDto.class)
            )
    )
    })
    @PutMapping("/updateLoan")
    public ResponseEntity<ResponseDTO> updateLoans(@Valid @RequestBody LoansDTO loansDTO){

      boolean isUpdated =   loanService.updateLoan(loansDTO);

      if(isUpdated) {
          return ResponseEntity.status(HttpStatus.OK).body(
                  new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200)
        );
      }

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
              new ResponseDTO(LoansConstants.STATUS_417,LoansConstants.MESSAGE_417_UPDATE)
      );
    }



    @Operation(
            summary = "Update Loan REST API",
            description = "REST API to update loan inside EazyBank"
    )
    @ApiResponses({

            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully"
            ), @ApiResponse(
            responseCode = "417",
            description = "Delete operation failed. Please try again or contact Dev team",
            content = @Content(
                    schema = @Schema(implementation = ErrorDto.class)
            )
    )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLoans(@RequestParam
                                                       @Pattern(regexp = "$|[0-9]{10}", message = "Mobile number must be 10 digits!")
                                                       String mobileNumber){

        boolean isUpdated =   loanService.deleteLoan(mobileNumber);

        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200)
            );
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseDTO(LoansConstants.STATUS_417,LoansConstants.MESSAGE_417_DELETE)
        );
    }





}
