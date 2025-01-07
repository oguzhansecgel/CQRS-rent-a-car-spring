package com.os.customer_service.mapper;

import com.os.customer_service.dto.GetByIdCustomerResponse;
import com.os.customer_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapping {


    CustomerMapping INSTANCE = Mappers.getMapper(CustomerMapping.class);

    @Mapping(source = "firstname", target = "firstName")
    @Mapping(source = "lastname", target = "lastName")
    GetByIdCustomerResponse getByIdCustomer(User user);
}
