package com.tperuch.cleanarch.entrypoint.consumer.mapper;

import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
