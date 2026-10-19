package com.tperuch.cleanarch.dataprovider.repository.entity;

import com.tperuch.cleanarch.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private Long id;
    private String name;
    private String cpf;
    private Address address;
    private Boolean isValidCpf;
}
