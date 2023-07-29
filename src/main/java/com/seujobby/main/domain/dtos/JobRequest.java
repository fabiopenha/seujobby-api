package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.company.Company;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobRequest {
    @NotNull(message = "O campo código precisa ser informado")
    private String jobCode;
    @NotNull(message = "O campo descrição precisa ser informado")
    private String description;
    private boolean active;
    @NotNull @Valid
    private CompanyJobRequest companyId;
}
