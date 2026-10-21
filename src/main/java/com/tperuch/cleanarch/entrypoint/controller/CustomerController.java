package com.tperuch.cleanarch.entrypoint.controller;

import com.tperuch.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.tperuch.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.tperuch.cleanarch.core.usecase.InsertCustomerUseCase;
import com.tperuch.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.tperuch.cleanarch.entrypoint.controller.mapper.CustomerEntrypointMapper;
import com.tperuch.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.tperuch.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerUseCase;

    @Autowired
    private CustomerEntrypointMapper customerEntrypointMapper;

    @PostMapping
    public ResponseEntity<Void> insert (@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerEntrypointMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customerResponse = customerEntrypointMapper.toCustomerResponse(findCustomerByIdUseCase.find(id));
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerEntrypointMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        deleteCustomerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
