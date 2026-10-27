package com.tperuch.cleanarch.entrypoint.controller.mapper;

import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.tperuch.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntrypointMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
