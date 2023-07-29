package com.seujobby.main.domain.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobUpdatedRequest {
    @NotNull(message = "O campo id precisa ser informado")
    private Long id;
    @NotNull(message = "O campo código precisa ser informado")
    private String jobCode;
    @NotNull(message = "O campo descrição precisa ser informado")
    private String description;
    private boolean active;
    @NotNull @Valid
    private CompanyJobRequest companyId;
}
