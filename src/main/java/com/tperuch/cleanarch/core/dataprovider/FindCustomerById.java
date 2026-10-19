package com.tperuch.cleanarch.core.dataprovider;

import com.tperuch.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {
    Optional<Customer> findById(String id);
}
