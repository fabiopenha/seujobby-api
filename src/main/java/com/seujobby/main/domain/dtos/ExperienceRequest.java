package com.seujobby.main.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceRequest {
    @NotNull @Valid
    private OccupationRequest jobPosition;

    @NotNull @Valid
    private CompanyExperienceRequest company;

    @NotNull(message = "o campo data Inicial precisa ser informado")
    @Past(message = "Não é permitido inserir datas futuras!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @NotNull(message = "o campo data final precisa ser informado")
    @Past(message = "Não é permitido inserir datas futuras!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @NotNull(message = "o campo descrição precisa ser informado")
    private String activityDescription;

    private boolean currentJob;
}
