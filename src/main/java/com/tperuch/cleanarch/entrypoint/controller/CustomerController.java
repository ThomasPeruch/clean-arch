package com.tperuch.cleanarch.entrypoint.controller;

import com.tperuch.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.tperuch.cleanarch.core.usecase.InsertCustomerUseCase;
import com.tperuch.cleanarch.entrypoint.controller.mapper.CustomerEntrypointMapper;
import com.tperuch.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.tperuch.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private CustomerEntrypointMapper customerEntrypointMapper;

    @PostMapping
    public ResponseEntity<Void> insert (@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerEntrypointMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customerResponse = customerEntrypointMapper.toCustomerResponse(findCustomerByIdUseCase.find(id));
        return ResponseEntity.ok(customerResponse);
    }

}
