package com.paycorepinarozdil.CreditApplicationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotFoundException extends RuntimeException{

    public NotFoundException (String message){
        super(message + " is not found !");
    }
}
