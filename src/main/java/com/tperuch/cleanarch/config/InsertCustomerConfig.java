package com.tperuch.cleanarch.config;

import com.tperuch.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.tperuch.cleanarch.core.dataprovider.FindCustomerById;
import com.tperuch.cleanarch.core.dataprovider.UpdateCustomer;
import com.tperuch.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.tperuch.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.tperuch.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.tperuch.cleanarch.dataprovider.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCaseImpl(
            FindAddressByZipCodeImpl findAddressByZipCodeImpl,
            InsertCustomerImpl insertCustomerImpl
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCodeImpl, insertCustomerImpl);
    }
}
