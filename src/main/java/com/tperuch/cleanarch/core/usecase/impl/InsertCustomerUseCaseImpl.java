package com.tperuch.cleanarch.core.usecase.impl;

import com.tperuch.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.tperuch.cleanarch.core.dataprovider.InsertCustomer;
import com.tperuch.cleanarch.core.dataprovider.SendCPFToValidation;
import com.tperuch.cleanarch.core.domain.Address;
import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            SendCPFToValidation sendCPFToValidation,
            InsertCustomer insertCustomer) {
                this.findAddressByZipCode = findAddressByZipCode;
                this.insertCustomer = insertCustomer;
                this.sendCPFToValidation = sendCPFToValidation;
    }

    private FindAddressByZipCode findAddressByZipCode;
    private InsertCustomer insertCustomer;
    private SendCPFToValidation sendCPFToValidation;


    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCode.find(zipCode);
        sendCPFToValidation.send(customer.getCpf());
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
