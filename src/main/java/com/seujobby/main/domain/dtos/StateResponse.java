package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StateResponse {
        private Long id;
        private String stateName;
}
