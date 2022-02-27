package com.paycorepinarozdil.CreditApplicationSystem.model;

import lombok.Data;

@Data
public class CustomerDTO {
    private String identityNumber;
    private String firstname;
    private String lastname;
    private double salary;
    private String phone;

}
