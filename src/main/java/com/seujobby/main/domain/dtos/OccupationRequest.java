package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OccupationRequest {
    @NotNull(message = "o campo Profissão precisa ser informado!")
    private Long id;
}
