package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CustomerCreditScoreDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerCreditScoreService;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerCreditScoreServiceTest {

    @Mock
    CustomerService customerService;

    @Mock
    CustomerCreditScoreDal customerCreditScoreDal;

    @InjectMocks
    CustomerCreditScoreService customerCreditScoreService;

    @Test
    void addCreditScore(){

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",null,null,new CustomerCreditScore(), new ArrayList<>());

        CustomerCreditScore customerCreditScore = new CustomerCreditScore();
        customerCreditScore.setCustomer(customer);
        ArgumentCaptor<CustomerCreditScore> creditScoreArgumentCaptor = ArgumentCaptor.forClass(CustomerCreditScore.class);

        Boolean creditScoreStatus = customerCreditScoreService.addCreditScore(customer);

        verify(customerCreditScoreDal).save(creditScoreArgumentCaptor.capture());

        CustomerCreditScore customerCreditScoreActual = creditScoreArgumentCaptor.getValue();

        assertThat(customerCreditScore.getCustomer()).isEqualTo(customer);

        Assert.assertTrue(creditScoreStatus);

    }

    @Test
    void getCreditScoreByIdentityNumber(){
        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",null,null,new CustomerCreditScore(), new ArrayList<>());

      CustomerCreditScore customerCreditScore = new CustomerCreditScore(1,400,customer);

      when(customerCreditScoreDal.getCreditScoreByIdentity("12345678912")).thenReturn(java.util.Optional.of(customerCreditScore));

      CustomerCreditScore actualCustomerCreditScore = customerCreditScoreService.getCreditScoreByIdentityNumber("12345678912");

      Assert.assertEquals(customerCreditScore,actualCustomerCreditScore);

    }

}
