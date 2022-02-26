package com.paycorepinarozdil.CreditApplicationSystem.controller;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //@GetMapping(value="/{id}")
    //public Customer getCustomer(@PathVariable @Min(1) Integer id){
    //    return customerService.getCustomer(id);
    //}

    @GetMapping(value="/identity/{identityNumber}")
    public Customer getCustomerByIdentity(@PathVariable String identityNumber){
        return customerService.getCustomerByIdentity(identityNumber);
    }

    @PostMapping (value = "/update/{identityNumber}")
    public Customer updateCustomer(@PathVariable String identityNumber, @RequestBody Customer customer) {
        return customerService.updateCustomerByIdentity(identityNumber,customer);
    }

    @PostMapping (value = "/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping (value = "/delete/{identityNumber}")
    public Boolean deleteCustomer(@PathVariable String identityNumber){
       return customerService.deleteCustomer(identityNumber);
    }

}
