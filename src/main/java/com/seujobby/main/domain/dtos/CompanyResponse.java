package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.enums.Sex;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CompanyResponse {
        private Long id;
        private String corporateName;
        private String cnpj;
        private String phone;
        private String description;
        private String site;
        private String responsibleName;
        private String responsibleEmail;
        private boolean active;
        private AddressResponse address;
}
