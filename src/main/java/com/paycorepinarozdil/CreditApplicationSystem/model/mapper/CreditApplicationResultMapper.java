package com.paycorepinarozdil.CreditApplicationSystem.model.mapper;

import com.paycorepinarozdil.CreditApplicationSystem.model.CreditApplicationResultDTO;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplicationResult;
import org.mapstruct.Mapper;

@Mapper
public interface CreditApplicationResultMapper {

    CreditApplicationResult toEntity(CreditApplicationResultDTO dto);
    CreditApplicationResultDTO toDto(CreditApplicationResult entity);

}
