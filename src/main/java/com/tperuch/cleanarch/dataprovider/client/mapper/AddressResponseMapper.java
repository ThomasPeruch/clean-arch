package com.tperuch.cleanarch.dataprovider.client.mapper;

import com.tperuch.cleanarch.core.domain.Address;
import com.tperuch.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse  addressResponse);
}
