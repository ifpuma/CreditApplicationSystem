package com.paycorepinarozdil.CreditApplicationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException (){
        super();
    } //bunu test et !!!

    public NotFoundException (String message){
        super(message + " not found !");
    }
}
