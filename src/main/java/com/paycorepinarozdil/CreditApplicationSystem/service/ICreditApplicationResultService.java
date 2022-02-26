package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;

import java.util.List;

public interface ICreditApplicationResultService {
    List<CreditApplicationResult> getAllCreditApplicationResults();
    CreditApplicationResult getCreditApplicationResult(Integer id);
    CreditApplicationResult addCreditApplicationResult(CreditApplicationResult creditApplicationResult);
    CreditApplicationResult updateCreditApplicationResult(CreditApplicationResult creditApplicationResult);
    Boolean deleteCreditApplicationResult(Integer id);
    CreditApplicationResult getCreditApplicationResultByIdentityNumber(String identityNumber);
    CreditApplicationResult getResultYes(CreditApplication creditApplication);
    CreditApplicationResult getResultNo(CreditApplication creditApplication);
}
