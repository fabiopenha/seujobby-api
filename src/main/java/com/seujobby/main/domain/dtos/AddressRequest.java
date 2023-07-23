package com.seujobby.main.domain.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressRequest{
        @NotBlank(message = "o campo rua é obrigatório!")
        private String street;
        @NotBlank(message = "o campo número é obrigatório!")
        private String number;
        private String supplement;
        @NotBlank(message = "o campo bairro é obrigatório!")
        private String district;
        @NotBlank(message = "o campo cep é obrigatório!")
        @Pattern(regexp = "^\\d{8}$")
        private String zipCode;
        @NotNull @Valid
        private CityRequest city;
}
