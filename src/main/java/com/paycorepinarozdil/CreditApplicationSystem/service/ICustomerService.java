package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;

public interface ICustomerService {

    //List<Customer> getAllCustomers();
    //Customer getCustomer(Integer id);
    Customer getCustomerByIdentity(String identityNumber);
    Customer updateCustomerByIdentity(String identityNumber, Customer customer);
    Customer addCustomer(Customer customer);
    Boolean deleteCustomer(String identityNumber);

}
