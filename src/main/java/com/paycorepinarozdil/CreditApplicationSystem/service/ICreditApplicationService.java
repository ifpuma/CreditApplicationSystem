package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;

public interface ICreditApplicationService {

    void updateCreditApplication(String identityNumber,Integer applicationStatus);
    Boolean createCreditApplication(String identityNumber);
    CreditApplication getCreditApplicationByIdentityNumber(String identityNumber);


}
