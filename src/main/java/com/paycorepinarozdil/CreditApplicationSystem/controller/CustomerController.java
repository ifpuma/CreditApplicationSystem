package com.paycorepinarozdil.CreditApplicationSystem.controller;

import com.paycorepinarozdil.CreditApplicationSystem.exception.ValidationException;
import com.paycorepinarozdil.CreditApplicationSystem.model.CustomerDTO;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.mapper.CustomerMapper;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private static final CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    //@GetMapping(value="/{id}")
    //public Customer getCustomer(@PathVariable @Min(1) Integer id){
    //    return customerService.getCustomer(id);
    //}

    @GetMapping(value="/identity/{identityNumber}")
    public CustomerDTO getCustomerByIdentity(@PathVariable String identityNumber){
        return CUSTOMER_MAPPER.toDto(customerService.getCustomerByIdentity(identityNumber));
    }

    @PostMapping (value = "/update/{identityNumber}")
    public CustomerDTO updateCustomer(@PathVariable String identityNumber, @Valid @RequestBody CustomerDTO customerDTO) {
        return CUSTOMER_MAPPER.toDto(customerService.updateCustomerByIdentity(identityNumber,CUSTOMER_MAPPER.toEntity(customerDTO)));
    }

    @PostMapping (value = "/add")
    public CustomerDTO addCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        ResponseEntity.badRequest().body(new ValidationException());
        return CUSTOMER_MAPPER.toDto(customerService.addCustomer(CUSTOMER_MAPPER.toEntity(customerDTO)));
    }

//    @PostMapping(value = "/add/{identityNumber}")
//    public Boolean createCreditApplication(@Valid @RequestBody CreditApplicationDTO creditApplicationDTO){
//        // CreditApplication creditApplication = CREDIT_APPLICATION_MAPPER.toEntity(creditApplicationDTO);
//        if(creditApplicationService.getCreditApplicationByIdentityNumber(creditApplicationDTO.getCustomer().getIdentityNumber()).getApplicationStatus()==0){
//            throw new UnfinishedApplicationException("Credit Application");
//        }
//        return creditApplicationService.createCreditApplication(CREDIT_APPLICATION_MAPPER.toEntity(creditApplicationDTO));
//    }

    @GetMapping (value = "/delete/{identityNumber}")
    public Boolean deleteCustomer(@PathVariable String identityNumber){
       return customerService.deleteCustomer(identityNumber);
    }

}
