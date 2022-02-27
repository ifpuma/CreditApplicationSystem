package com.paycorepinarozdil.CreditApplicationSystem.controller;

import com.paycorepinarozdil.CreditApplicationSystem.model.CreditApplicationResultDTO;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import com.paycorepinarozdil.CreditApplicationSystem.model.mapper.CreditApplicationResultMapper;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationResultService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-result")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditApplicationResultController {

    @Autowired
    private CreditApplicationResultService creditApplicationResultService;

    private static final CreditApplicationResultMapper CREDIT_APPLICATION_RESULT_MAPPER = Mappers.getMapper(CreditApplicationResultMapper.class);

    @GetMapping(value="/get/{identityNumber}")
    public CreditApplicationResultDTO getResultByIdentity(@PathVariable String identityNumber){
        return CREDIT_APPLICATION_RESULT_MAPPER.toDto(creditApplicationResultService.getCreditApplicationResultByIdentityNumber(identityNumber));
    }

}
