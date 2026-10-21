package com.tperuch.cleanarch.core.usecase.impl;

import com.tperuch.cleanarch.core.dataprovider.DeleteCustomerById;
import com.tperuch.cleanarch.core.dataprovider.FindCustomerById;
import com.tperuch.cleanarch.core.usecase.DeleteCustomerByIdUseCase;


public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;
    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImpl(
            FindCustomerById findCustomerById,
            DeleteCustomerById deleteCustomerById) {
        this.findCustomerById = findCustomerById;
        this.deleteCustomerById = deleteCustomerById;
    }


    @Override
    public void delete(String id) {
        findCustomerById.findById(id);
        deleteCustomerById.delete(id);
    }
}
