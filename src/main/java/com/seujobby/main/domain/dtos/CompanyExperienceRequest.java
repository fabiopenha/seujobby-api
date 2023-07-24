package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyExperienceRequest {
    @NotNull(message = "o campo Empresa precisa ser informado!")
    private Long id;
}
