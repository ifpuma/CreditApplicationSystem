package com.paycorepinarozdil.CreditApplicationSystem.repository;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerCreditScoreDal extends JpaRepository<CustomerCreditScore,Integer> {

    @Query("SELECT cc FROM CustomerCreditScore cc JOIN cc.customer c WHERE c.identityNumber = :identityNumber")
    Optional<CustomerCreditScore> getCreditScoreByIdentity(String identityNumber);
    //String createCreditApplication(String identityNumber);

}
