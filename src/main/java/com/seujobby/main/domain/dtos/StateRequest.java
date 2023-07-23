package com.seujobby.main.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StateRequest{
        @NotNull(message = "O campo estado é obrigatório!")
        private Long id;
}
