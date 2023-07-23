package com.seujobby.main.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seujobby.main.domain.Address;
import com.seujobby.main.domain.enums.Sex;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CompanyRequest{
        @NotNull(message = "O campo nome fantasia é obrigatório!")
        private String corporateName;
        @NotNull(message = "O campo cnpj é obrigatório!")
        @Pattern(regexp = "^\\d{14}$", message = "Digite apenas os números do CNPJ!")
        private String cnpj;

        @NotNull(message = "O campo telefone é obrigatório!")
        private String phone;

        @NotNull(message = "O campo descrição é obrigatório!")
        private String description;
        @NotNull(message = "O campo site é obrigatório!")
        private String site;
        @NotNull(message = "O nome do responsável é obrigatório!")
        private String responsibleName;

        @Email(message = "Insira um e-mail válido")
        @NotNull(message = "O campo email do responsável é obrigatório!")
        private String responsibleEmail;
        private boolean active;

        @NotNull @Valid
        private AddressRequest address;
}
