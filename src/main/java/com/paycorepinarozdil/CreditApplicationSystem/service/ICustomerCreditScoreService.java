package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;

public interface ICustomerCreditScoreService {

    Boolean addCreditScore(Customer customer);

    CustomerCreditScore getCreditScoreByIdentityNumber(String identityNumber);
}
