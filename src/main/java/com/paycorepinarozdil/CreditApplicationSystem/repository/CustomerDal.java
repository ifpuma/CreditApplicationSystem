package com.paycorepinarozdil.CreditApplicationSystem.repository;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDal extends JpaRepository<Customer,Integer> {

    @Query("SELECT c FROM Customer c WHERE c.identityNumber = :identity_number")
    Optional<Customer> getCustomerByIdentity(@Param("identity_number") String identityNumber);

}
