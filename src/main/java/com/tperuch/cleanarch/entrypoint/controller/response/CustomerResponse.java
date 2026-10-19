package com.tperuch.cleanarch.entrypoint.controller.response;

import com.tperuch.cleanarch.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String name;
    private String cpf;
    private AddressResponse address;
    private Boolean isValidCpf;
}
