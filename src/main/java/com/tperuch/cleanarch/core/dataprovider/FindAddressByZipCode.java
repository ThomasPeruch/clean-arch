package com.tperuch.cleanarch.core.dataprovider;

import com.tperuch.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
    Address find(String zipCode);
}
