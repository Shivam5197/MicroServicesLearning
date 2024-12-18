package com.Loans.MicroServiceLoans.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource, String fieldName , String fieldValue ){

        super(String.format("%s Not found for %s with value %s" , resource,fieldName,fieldValue ));
    }

}
