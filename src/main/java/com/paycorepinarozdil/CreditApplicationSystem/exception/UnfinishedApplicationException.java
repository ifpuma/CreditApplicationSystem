package com.paycorepinarozdil.CreditApplicationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class UnfinishedApplicationException extends RuntimeException{
    public UnfinishedApplicationException(String message){
        super("There is an unfinished "+ message + ". Please go Application Result first !");
    }
}
