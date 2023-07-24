package com.seujobby.main.domain.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CurriculumUpdatedRequest {
    @NotNull(message = "o campo Salário máximo precisa ser informado!")
    private Double maxSalaryExpectation;
    @NotNull(message = "o campo Salário minimo precisa ser informado!")
    private Double minSalaryExpectation;
    @NotNull @Valid
    private CandidateExperienceRequest candidateId;
    @NotNull @Valid
    private List<ExperienceUpdatedRequest> experience;
    @NotNull @Valid
    private LanguageResquest language;
}
