package com.paycorepinarozdil.CreditApplicationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AlreadyUsedException extends RuntimeException {

    public AlreadyUsedException(String message){
        super(message+" is already exist!");
    }

}
