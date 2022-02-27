package com.paycorepinarozdil.CreditApplicationSystem.controller;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-application")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditApplicationController {

    @Autowired
    private CreditApplicationService creditApplicationService;


    @PostMapping(value = "/add/{identityNumber}")
    public Boolean createCreditApplication(@PathVariable String identityNumber ){
     return creditApplicationService.createCreditApplication(identityNumber);
    }

    @GetMapping(value = "/get/{identityNumber}")
    public CreditApplication getCreditApplication(@PathVariable String identityNumber){

        return creditApplicationService.getCreditApplicationByIdentityNumber(identityNumber);
    }
}
