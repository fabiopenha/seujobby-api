package com.seujobby.main.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceResponse {
    private Long id;
    private OccupationResponse jobPosition;
    private CompanyExperienceResponse company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String activityDescription;
    private boolean currentJob;
}
