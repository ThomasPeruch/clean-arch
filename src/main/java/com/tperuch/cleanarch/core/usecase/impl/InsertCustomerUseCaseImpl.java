package com.tperuch.cleanarch.core.usecase.impl;

import com.tperuch.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.tperuch.cleanarch.core.dataprovider.InsertCustomer;
import com.tperuch.cleanarch.core.domain.Address;
import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer) {
                this.findAddressByZipCode = findAddressByZipCode;
                this.insertCustomer = insertCustomer;
    }

    private FindAddressByZipCode findAddressByZipCode;
    private InsertCustomer insertCustomer;


    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
