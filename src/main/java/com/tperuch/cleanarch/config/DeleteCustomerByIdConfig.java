package com.tperuch.cleanarch.config;

import com.tperuch.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCaseImpl(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
            DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCaseImpl, deleteCustomerById);
    }
}
