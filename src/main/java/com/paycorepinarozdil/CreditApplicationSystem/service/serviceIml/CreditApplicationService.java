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
    public List<CreditApplication> getAllCreditApplications() {
        return null;
    }

    @Override
    public CreditApplication getCreditApplication(Integer id) {
        return null;
    }

    @Override
    public CreditApplication addCreditApplication(CreditApplication creditApplication) {

        return null;
    }

    @Override
    public void updateCreditApplication(String identityNumber,Integer applicationStatus) {
        CreditApplication creditApplication1 = getCreditApplicationByIdentityNumber(identityNumber);
        creditApplication1.setApplicationStatus(applicationStatus);
        creditApplicationDal.save(creditApplication1);
    }

    @Override
    public void deleteCreditApplication(String identityNumber) {
        creditApplicationDal.delete(getCreditApplicationByIdentityNumber(identityNumber));
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
       // Customer customer = customerService.getCustomerByIdentity(identityNumber);
     return creditApplicationDal.getCreditApplicationByIdentity(identityNumber)
             .filter(creditApplication -> creditApplication.getApplicationStatus()==0).orElseThrow(()->new NotFoundException("Application"));
    }
}
