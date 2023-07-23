package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StateRequest{
        @NotBlank(message = "O campo estado é obrigatório!")
        private String stateName;
}
