package com.tperuch.cleanarch.config;

import com.tperuch.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.tperuch.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl(
            FindCustomerByIdImpl findCustomerByIdImpl
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerByIdImpl);
    }
}
