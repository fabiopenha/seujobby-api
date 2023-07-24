package com.seujobby.main.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seujobby.main.domain.enums.Sex;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidateExperienceRequest {
        @NotNull(message = "O campo nome é obrigatório!")
        private Long id;
}
