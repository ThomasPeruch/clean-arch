package com.tperuch.cleanarch.config;

import com.tperuch.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.tperuch.cleanarch.dataprovider.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCaseImpl(
            SendCPFToValidationImpl sendCPFToValidationImpl,
            FindAddressByZipCodeImpl findAddressByZipCodeImpl,
            InsertCustomerImpl insertCustomerImpl
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCodeImpl, sendCPFToValidationImpl, insertCustomerImpl);
    }
}
