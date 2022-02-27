package com.paycorepinarozdil.CreditApplicationSystem.model.mapper;

import com.paycorepinarozdil.CreditApplicationSystem.model.CustomerDTO;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO toDto(Customer entity);

    Customer toEntity(CustomerDTO dto);

}
