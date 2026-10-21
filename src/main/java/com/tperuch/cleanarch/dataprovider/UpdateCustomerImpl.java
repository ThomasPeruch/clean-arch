package com.tperuch.cleanarch.dataprovider;

import com.tperuch.cleanarch.core.dataprovider.UpdateCustomer;
import com.tperuch.cleanarch.core.domain.Customer;
import com.tperuch.cleanarch.dataprovider.repository.CustomerRepository;
import com.tperuch.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
    }
}
