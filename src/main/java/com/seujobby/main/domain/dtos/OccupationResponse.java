package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OccupationResponse {
    private Long id;
    private String name;
}
