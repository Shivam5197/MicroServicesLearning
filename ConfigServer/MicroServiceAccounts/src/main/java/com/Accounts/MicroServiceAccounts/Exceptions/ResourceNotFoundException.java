package com.Accounts.MicroServiceAccounts.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, String fieldName , String fieldValue){

        super(String.format("%s not found with the given data %s : %s", resource,fieldName,fieldValue));
    }

}
