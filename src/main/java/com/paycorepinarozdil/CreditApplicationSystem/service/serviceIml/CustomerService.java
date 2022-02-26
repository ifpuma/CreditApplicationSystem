package com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml;

import com.paycorepinarozdil.CreditApplicationSystem.exception.AlreadyUsedException;
import com.paycorepinarozdil.CreditApplicationSystem.exception.NotFoundException;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.service.ICustomerService;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CustomerDal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerDal customerDal;
    private final CustomerCreditScoreService customerCreditScoreService;

   // @Override
   // public List<Customer> getAllCustomers() { return customerDal.findAll();  }

    //@Override
    //public Customer getCustomer(Integer id) {
    //    Optional<Customer> customerById = customerDal.findById(id);
    //    return customerById.orElseThrow(()-> new NotFoundException("Customer"));
    //}

    @Override
    public Customer getCustomerByIdentity(String identityNumber) {
      return customerDal.getCustomerByIdentity(identityNumber).stream().findFirst().orElseThrow(()->new NotFoundException("Customer"));
    }

    @Override //kontrol et customerda tc yi request bodye yazmadan nasıl update ederim bak.
    public Customer updateCustomerByIdentity(String identityNumber,Customer customer) {
      Customer customer1 = getCustomerByIdentity(identityNumber);
      customer.setId(customer1.getId());
      customerDal.save(customer);
      return customer;
    }

    @Override //if kalkabilir mi ?
    public Customer addCustomer(Customer customer) {
    if(customerDal.getCustomerByIdentity(customer.getIdentityNumber()).isPresent()) {
        throw new AlreadyUsedException(customer.getIdentityNumber());
    }

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
