package com.tperuch.cleanarch.core.usecase;

import com.tperuch.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(String id);
}
