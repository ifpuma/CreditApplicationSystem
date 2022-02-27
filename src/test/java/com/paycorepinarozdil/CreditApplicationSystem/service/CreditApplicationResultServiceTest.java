package com.paycorepinarozdil.CreditApplicationSystem.service;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CreditApplicationResultDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationResultService;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CreditApplicationService;
import com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml.CustomerCreditScoreService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CreditApplicationResultServiceTest {


    @Mock
    CreditApplicationService creditApplicationService;

    @Mock
    CustomerCreditScoreService customerCreditScoreService;

    @InjectMocks
    CreditApplicationResultService creditApplicationResultService;


    @Test
    void getCreditApplicationResultByIdentityNumber_successful(){

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",null,null,new CustomerCreditScore(), new ArrayList<>());

        CustomerCreditScore customerCreditScore = new CustomerCreditScore(1,400,customer);

        CreditApplication creditApplication = new CreditApplication(1,0,null,null,customer);

        CreditApplicationResult creditApplicationResult = new CreditApplicationResult(1,0,"Red", Date.valueOf(LocalDate.now()),creditApplication);

        when(customerCreditScoreService.getCreditScoreByIdentityNumber("12345678912")).thenReturn(customerCreditScore);
        when(creditApplicationService.getCreditApplicationByIdentityNumber("12345678912")).thenReturn(creditApplication);

        CreditApplicationResult actualCreditApplicationResult = creditApplicationResultService.getCreditApplicationResultByIdentityNumber("12345678912");
        actualCreditApplicationResult.setId(1);

        Assert.assertEquals(creditApplicationResult,actualCreditApplicationResult);

    }

    @Test
    void getResultYes_successful(){

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",null,null,new CustomerCreditScore(), new ArrayList<>());

        CustomerCreditScore customerCreditScore = new CustomerCreditScore(1,600,customer);

        CreditApplication creditApplication = new CreditApplication(1,0,null,null,customer);

        CreditApplicationResult creditApplicationResult = new CreditApplicationResult(1,20000,"Onay", Date.valueOf(LocalDate.now()),creditApplication);

        when(customerCreditScoreService.getCreditScoreByIdentityNumber("12345678912")).thenReturn(customerCreditScore);
        when(creditApplicationService.getCreditApplicationByIdentityNumber("12345678912")).thenReturn(creditApplication);

        CreditApplicationResult actualCreditApplicationResult = creditApplicationResultService.getCreditApplicationResultByIdentityNumber("12345678912");
        actualCreditApplicationResult.setId(1);

        Assert.assertEquals(creditApplicationResult,actualCreditApplicationResult);

    }

    @Test
    void getResultNo_successful(){

        Customer customer = new Customer(1,"12345678912","Pınar","Özdil",5500.00,"05397607208",null,null,new CustomerCreditScore(), new ArrayList<>());

        CustomerCreditScore customerCreditScore = new CustomerCreditScore(1,400,customer);

        CreditApplication creditApplication = new CreditApplication(1,0,null,null,customer);

        CreditApplicationResult creditApplicationResult = new CreditApplicationResult(1,0,"Red", Date.valueOf(LocalDate.now()),creditApplication);

        when(customerCreditScoreService.getCreditScoreByIdentityNumber("12345678912")).thenReturn(customerCreditScore);
        when(creditApplicationService.getCreditApplicationByIdentityNumber("12345678912")).thenReturn(creditApplication);

        CreditApplicationResult actualCreditApplicationResult = creditApplicationResultService.getCreditApplicationResultByIdentityNumber("12345678912");
        actualCreditApplicationResult.setId(1);

        Assert.assertEquals(creditApplicationResult,actualCreditApplicationResult);

    }



}
