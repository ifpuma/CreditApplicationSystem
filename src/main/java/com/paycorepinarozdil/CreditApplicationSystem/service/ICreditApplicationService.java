package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;

import java.util.List;

public interface ICreditApplicationService {

    List<CreditApplication> getAllCreditApplications();
    CreditApplication getCreditApplication(Integer id);
    CreditApplication addCreditApplication(CreditApplication creditApplication);
    void updateCreditApplication(String identityNumber,Integer applicationStatus);
    void deleteCreditApplication(String identityNumber);
    Boolean createCreditApplication(String identityNumber);
    CreditApplication getCreditApplicationByIdentityNumber(String identityNumber);


}
