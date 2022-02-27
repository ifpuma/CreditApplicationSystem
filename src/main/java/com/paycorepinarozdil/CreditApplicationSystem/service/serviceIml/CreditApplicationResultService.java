package com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CreditApplicationResultDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.ICreditApplicationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CreditApplicationResultService implements ICreditApplicationResultService {
    @Autowired
    private CreditApplicationResultDal creditApplicationResultDal;
    @Autowired
    private CreditApplicationService creditApplicationService;
    @Autowired
    private CustomerCreditScoreService customerCreditScoreService;

    @Override
    public List<CreditApplicationResult> getAllCreditApplicationResults() {
        return null;
    }

    @Override
    public CreditApplicationResult getCreditApplicationResult(Integer id) {
        return null;
    }

    @Override
    public CreditApplicationResult addCreditApplicationResult(CreditApplicationResult creditApplicationResult) {
        return null;
    }

    @Override
    public CreditApplicationResult updateCreditApplicationResult(CreditApplicationResult creditApplicationResult) {
        return null;
    }

    @Override
    public Boolean deleteCreditApplicationResult(Integer id) {
        return null;
    }

    CreditApplicationResult creditApplicationResult = new CreditApplicationResult();
    CustomerCreditScore customerCreditScore = new CustomerCreditScore();

    @Override
    public CreditApplicationResult getCreditApplicationResultByIdentityNumber(String identityNumber) {
       // creditApplicationService.getCreditApplicationByIdentityNumber(identityNumber).getApplicationStatus().
         //   if(   ){
        //}
    customerCreditScore = customerCreditScoreService.getCreditScoreByIdentityNumber(identityNumber);
       if(customerCreditScore.getCreditScore()<500)
           getResultNo(creditApplicationService.getCreditApplicationByIdentityNumber(identityNumber));
       else
           getResultYes(creditApplicationService.getCreditApplicationByIdentityNumber(identityNumber));
       creditApplicationService.updateCreditApplication(identityNumber,1);
       return creditApplicationResult;
    }

    @Override
    public CreditApplicationResult getResultYes(CreditApplication creditApplication) {
        creditApplicationResult.setCreditApplication(creditApplication);
        creditApplicationResult.setCreditResult("Onay");
        creditApplicationResult.setCreateDate(Date.valueOf(LocalDate.now()));
        if(customerCreditScore.getCreditScore()>=500&&customerCreditScore.getCreditScore()<1000){
            if(customerCreditScore.getCustomer().getSalary()<5000){
                creditApplicationResult.setCreditLimit(10000);
                creditApplicationResultDal.save(creditApplicationResult);
            }else{
                creditApplicationResult.setCreditLimit(20000);
                creditApplicationResultDal.save(creditApplicationResult);
            }
        }else{
            creditApplicationResult.setCreditLimit(customerCreditScore.getCustomer().getSalary()*4);
            creditApplicationResultDal.save(creditApplicationResult);
        }
        return creditApplicationResult;
    }

    @Override
    public CreditApplicationResult getResultNo(CreditApplication creditApplication) {
            creditApplicationResult.setCreditApplication(creditApplication);
            creditApplicationResult.setCreditResult("Red");
        creditApplicationResult.setCreateDate(Date.valueOf(LocalDate.now()));
        creditApplicationResultDal.save(creditApplicationResult);
        return creditApplicationResult;
    }
}
