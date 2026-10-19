package com.tperuch.cleanarch.entrypoint.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Valid
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    private String zipCode;
}
