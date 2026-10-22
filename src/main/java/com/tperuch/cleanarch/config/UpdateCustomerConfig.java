package com.tperuch.cleanarch.config;

import com.tperuch.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.tperuch.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.tperuch.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
            FindAddressByZipCodeImpl findAddressByZipCodeImpl,
            UpdateCustomerImpl updateCustomerImpl
    ) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCaseImpl, findAddressByZipCodeImpl, updateCustomerImpl);
    }
}
