package com.tperuch.cleanarch.entrypoint.controller;

import com.tperuch.cleanarch.core.usecase.InsertCustomerUseCase;
import com.tperuch.cleanarch.entrypoint.controller.mapper.CustomerRequestMapper;
import com.tperuch.cleanarch.entrypoint.controller.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private CustomerRequestMapper customerRequestMapper;

    public ResponseEntity<Void> insert (@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

}
