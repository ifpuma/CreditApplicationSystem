package com.paycorepinarozdil.CreditApplicationSystem.service.serviceIml;

import com.paycorepinarozdil.CreditApplicationSystem.exception.NotFoundException;
import com.paycorepinarozdil.CreditApplicationSystem.exception.UnfinishedApplicationException;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import com.paycorepinarozdil.CreditApplicationSystem.repository.CreditApplicationDal;
import com.paycorepinarozdil.CreditApplicationSystem.service.ICreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CreditApplicationService implements ICreditApplicationService {

    @Autowired
    private CreditApplicationDal creditApplicationDal;
    @Autowired
    private CustomerService customerService;

    @Override
    public void updateCreditApplication(String identityNumber,Integer applicationStatus) {
        CreditApplication creditApplication = getCreditApplicationByIdentityNumber(identityNumber);
        creditApplication.setApplicationStatus(applicationStatus);
        creditApplication.setUpdateDate(java.sql.Date.valueOf(LocalDate.now()));
        creditApplicationDal.save(creditApplication);
    }

    @Override
    public Boolean createCreditApplication(String identityNumber) {
        Customer customer = customerService.getCustomerByIdentity(identityNumber);
        if(customer.getCreditApplications().stream().anyMatch(creditApplication -> creditApplication.getApplicationStatus()==0)) {
            throw new UnfinishedApplicationException("Credit Application");
        }
          CreditApplication creditApplication = new CreditApplication();
          creditApplication.setCustomer(customer);
          creditApplication.setCreateDate(new Date());
          creditApplication.setUpdateDate(new Date());
          creditApplicationDal.save(creditApplication);
        return true;
    }

    @Override
    public CreditApplication getCreditApplicationByIdentityNumber(String identityNumber) {
     return creditApplicationDal.getCreditApplicationByIdentity(identityNumber)
             .filter(creditApplication -> creditApplication.getApplicationStatus()==0).orElseThrow(()->new NotFoundException("Not Resulted Application"));
    }

}
