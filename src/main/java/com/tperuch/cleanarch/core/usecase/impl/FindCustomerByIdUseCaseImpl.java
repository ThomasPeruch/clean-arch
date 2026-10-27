package com.tperuch.cleanarch.core.usecase.impl;

import com.tperuch.cleanarch.core.dataprovider.FindCustomerById;
import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    public FindCustomerByIdUseCaseImpl(
            FindCustomerById findCustomerById){
            this.findCustomerById = findCustomerById;
    }
    private final FindCustomerById findCustomerById;

    @Override
    public Customer find(String id) {
        return findCustomerById.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
