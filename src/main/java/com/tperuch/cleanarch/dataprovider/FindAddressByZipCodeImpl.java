package com.tperuch.cleanarch.dataprovider;

import com.tperuch.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.tperuch.cleanarch.core.domain.Address;
import com.tperuch.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.tperuch.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        return addressResponseMapper.toAddress(findAddressByZipCodeClient.find(zipCode));
    }
}
