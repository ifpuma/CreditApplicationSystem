package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;

import java.util.List;

public interface ICreditApplicationResultService {

    CreditApplicationResult getCreditApplicationResultByIdentityNumber(String identityNumber);
    CreditApplicationResult getResultYes(CreditApplication creditApplication);
    CreditApplicationResult getResultNo(CreditApplication creditApplication);
}
