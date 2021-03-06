package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CreditApplicationDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationService;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CreditApplicationServiceTest {

    @Mock
    private CreditApplicationDal creditApplicationDal;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CreditApplicationService creditApplicationService;


    @Test
    void createCreditApplication_successful() {

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(), new ArrayList<>());

        CreditApplication updatedCreditApplication = new CreditApplication(1,0,new Date(),new Date(),customer,new CreditApplicationResult());

        ArgumentCaptor<CreditApplication> creditApplicationArgumentCaptor = ArgumentCaptor.forClass(CreditApplication.class);

       when(customerService.getCustomerByIdentity("12345678912")).thenReturn(customer);

        Boolean statusCreditApplication = creditApplicationService.createCreditApplication("12345678912");

       verify(creditApplicationDal).save(creditApplicationArgumentCaptor.capture());

       CreditApplication creditApplication = creditApplicationArgumentCaptor.getValue();

       assertThat(creditApplication.getCustomer()).isEqualTo(customer);
       Assert.assertEquals(creditApplication.getApplicationStatus().intValue(),0);

        Assert.assertTrue(statusCreditApplication);

    }

    @Test
    void updateCreditApplication_successful(){

      Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(), new ArrayList<>());

      CreditApplication creditApplication = new CreditApplication(1,0,new Date(),new Date(),customer,new CreditApplicationResult());

      when(creditApplicationDal.getCreditApplicationByIdentity("12345678912")).thenReturn(Optional.of(creditApplication));

      creditApplicationService.updateCreditApplication("12345678912",1);

      Assert.assertEquals(creditApplication.getApplicationStatus().intValue(),1);


    }

    @Test
    void getCreditApplication_successful(){

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",new Date(),new Date(),new CustomerCreditScore(), new ArrayList<>());

        CreditApplication creditApplication = new CreditApplication(1,0,new Date(),new Date(),customer,new CreditApplicationResult());

        when(creditApplicationDal.getCreditApplicationByIdentity("12345678912")).thenReturn(Optional.of(creditApplication));

        CreditApplication actualCreditApplication = creditApplicationService.getCreditApplicationByIdentityNumber("12345678912");

        Assert.assertEquals(creditApplication,actualCreditApplication);


    }


}
