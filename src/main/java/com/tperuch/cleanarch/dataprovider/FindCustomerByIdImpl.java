package com.tperuch.cleanarch.dataprovider;

import com.tperuch.cleanarch.core.dataprovider.FindCustomerById;
import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.dataprovider.repository.CustomerRepository;
import com.tperuch.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id)
                .map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
