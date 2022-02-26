package com.paycorepinarozdil.CreditApplicationSystem.exception;


public class AlreadyUsedException extends RuntimeException {

    public AlreadyUsedException(String message){
        super(message+" is already exist!");
    }

}
