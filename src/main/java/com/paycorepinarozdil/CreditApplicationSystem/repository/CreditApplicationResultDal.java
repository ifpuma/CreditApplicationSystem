package com.paycorepinarozdil.CreditApplicationSystem.repository;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditApplicationResultDal extends JpaRepository<CreditApplicationResult,Integer> {
}
