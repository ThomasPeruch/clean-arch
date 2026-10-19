package com.tperuch.cleanarch.core.usecase;

import com.tperuch.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer, String zipCode);
}
