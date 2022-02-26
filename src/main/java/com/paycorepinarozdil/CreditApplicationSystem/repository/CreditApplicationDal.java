package com.paycorepinarozdil.CreditApplicationSystem.repository;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditApplicationDal extends JpaRepository<CreditApplication,Integer>{

    @Query("SELECT ca FROM CreditApplication ca JOIN ca.customer c WHERE c.identityNumber = :identityNumber")
    Optional<CreditApplication> getCreditApplicationByIdentity(String identityNumber);
    //String createCreditApplication(String identityNumber);

}
