package com.tperuch.cleanarch.dataprovider;

import com.tperuch.cleanarch.core.dataprovider.SendCPFToValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCPFToValidationImpl implements SendCPFToValidation {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("topic-cpf-for-validation", cpf);
    }
}
