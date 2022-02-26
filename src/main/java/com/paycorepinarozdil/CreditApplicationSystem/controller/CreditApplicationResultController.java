package com.paycorepinarozdil.CreditApplicationSystem.controller;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-result")
@Controller
public class CreditApplicationResultController {

    @Autowired
    private CreditApplicationResultService creditApplicationResultService;

    @GetMapping(value="/identity/{identityNumber}")
    public CreditApplicationResult getResultByIdentity(@PathVariable String identityNumber){
        return creditApplicationResultService.getCreditApplicationResultByIdentityNumber(identityNumber);
    }

}
