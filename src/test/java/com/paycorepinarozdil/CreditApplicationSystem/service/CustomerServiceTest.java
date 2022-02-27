package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.exception.AlreadyUsedException;
import com.paycorepinarozdil.CreditApplicationSystem.exception.NotFoundException;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CustomerDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerCreditScoreService;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceTest {

@Mock
    private CustomerDal customerDal;

@InjectMocks
    private CustomerService customerService;


@Test
    void getCustomer_successful(){
    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.of(expectedCustomer));

    Customer actualCustomer = customerService.getCustomerByIdentity("12345678912");

    Assert.assertEquals(expectedCustomer,actualCustomer);
}

@Test
    void getCustomer_not_found(){

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.empty());

    Assert.assertThrows(NotFoundException.class, ()-> {Customer actualCustomer = customerService.getCustomerByIdentity("12345678912");});

}

@Test
    void addCustomer_successful(){

    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.save(expectedCustomer)).thenReturn(expectedCustomer);

    Customer actualCustomer = customerService.addCustomer(expectedCustomer);

    verify(customerDal,times(1)).save(expectedCustomer);
}

@Test()
    void addCustomer_already_exist(){

    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.of(expectedCustomer));

    Customer actualCustomer = new Customer(2,"12345678912","Ayşe","Yılmaz",7000.00,"05345632635",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    //customerService.addCustomer(actualCustomer);

    Assert.assertThrows(AlreadyUsedException.class,()->customerService.addCustomer(actualCustomer));

}

@Test
    void updateCustomer_successful(){

    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.of(expectedCustomer));

    Customer actualCustomer = customerService.updateCustomerByIdentity("12345678912",expectedCustomer);

    Assert.assertEquals(expectedCustomer.getId(),actualCustomer.getId());
    Assert.assertEquals(expectedCustomer.getIdentityNumber(),actualCustomer.getIdentityNumber());

}

@Test
    void updateCustomer_not_found(){

    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.empty());

    Assert.assertThrows(NotFoundException.class, ()-> {Customer actualCustomer = customerService.updateCustomerByIdentity("12345678912",expectedCustomer);});

}

@Test
    void deleteCustomer_successful(){

    Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

    when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.of(expectedCustomer));

    Boolean actualCustomerStatus = customerService.deleteCustomer("12345678912");

    Assert.assertTrue(actualCustomerStatus);
}

    @Test
    void deleteCustomer_not_found(){

        Customer expectedCustomer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(),new ArrayList<CreditApplication>());

        when(customerDal.getCustomerByIdentity("12345678912")).thenReturn(Optional.empty());

        Assert.assertThrows(NotFoundException.class, ()-> {Boolean actualCustomerStatus = customerService.deleteCustomer("12345678912");});

    }

}
