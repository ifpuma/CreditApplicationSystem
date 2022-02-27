package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;

public interface ICustomerService {

    Customer getCustomerByIdentity(String identityNumber);
    Customer updateCustomerByIdentity(String identityNumber, Customer customer);
    Customer addCustomer(Customer customer);
    Boolean deleteCustomer(String identityNumber);

}
