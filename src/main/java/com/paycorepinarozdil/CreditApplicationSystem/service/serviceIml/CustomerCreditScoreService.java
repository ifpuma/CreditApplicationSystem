package com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml;

import com.paycorepinarozdil.CreditApplicationSystem.exception.NotFoundException;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CustomerCreditScoreDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.ICustomerCreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class CustomerCreditScoreService implements ICustomerCreditScoreService {

    @Autowired
    private CustomerCreditScoreDal customerCreditScoreDal;



    @Override
    public Boolean addCreditScore(Customer customer) {
        SplittableRandom splittableRandom = new SplittableRandom();
        int randomWithSplittableRandom = splittableRandom.nextInt(0, 2000);
        CustomerCreditScore customerCreditScore = new CustomerCreditScore();
        customerCreditScore.setCreditScore(randomWithSplittableRandom);
        customerCreditScore.setCustomer(customer);
        customerCreditScoreDal.save(customerCreditScore);
        return true;
    }

    @Override
    public CustomerCreditScore getCreditScoreByIdentityNumber(String identityNumber) {
        return customerCreditScoreDal.getCreditScoreByIdentity(identityNumber)
                .stream().findFirst().orElseThrow(()->new NotFoundException("Application"));
    }
}
