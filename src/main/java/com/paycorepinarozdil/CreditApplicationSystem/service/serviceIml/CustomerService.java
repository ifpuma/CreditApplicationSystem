package com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml;

import com.paycorepinarozdil.CreditApplicationSystem.exception.AlreadyUsedException;
import com.paycorepinarozdil.CreditApplicationSystem.exception.NotFoundException;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.service.ICustomerService;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CustomerDal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerDal customerDal;
    @Autowired
    private CustomerCreditScoreService customerCreditScoreService;

    @Override
    public Customer getCustomerByIdentity(String identityNumber) {
      return customerDal.getCustomerByIdentity(identityNumber).stream().findFirst().orElseThrow(()->new NotFoundException("Customer"));
    }

    @Override
    public Customer updateCustomerByIdentity(String identityNumber,Customer customer) {
      Customer existCustomer = getCustomerByIdentity(identityNumber);
      customer.setId(existCustomer.getId());
      customer.setCreateDate(existCustomer.getCreateDate());
      customer.setUpdateDate(Date.valueOf(LocalDate.now()));
      customerDal.save(customer);
      return customer;
    }

    @Override
    public Customer addCustomer(Customer customer) {
    if(customerDal.getCustomerByIdentity(customer.getIdentityNumber()).isPresent()) {
        throw new AlreadyUsedException(customer.getIdentityNumber());
    }
        customer.setCreateDate(Date.valueOf(LocalDate.now()));
        customer.setUpdateDate(Date.valueOf(LocalDate.now()));
        customerDal.save(customer);
        customerCreditScoreService.addCreditScore(customer);
        return customer;
    }

    @Override
    public Boolean deleteCustomer(String identityNumber) {
        Customer customer = getCustomerByIdentity(identityNumber);
        customerDal.deleteById(customer.getId());
        return true;
    }

}
