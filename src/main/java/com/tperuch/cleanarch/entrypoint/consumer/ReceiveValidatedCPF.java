package com.tperuch.cleanarch.entrypoint.consumer;

import com.tperuch.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.tperuch.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.tperuch.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCPF {

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;


    @KafkaListener(topics = "topic-cpf-validated", groupId = "peruch")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());


    }
}
