package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.State;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityRequest {
        @NotBlank(message = "o campo cidade é obrigatório!")
        private String name;
        @NotNull @Valid
        private StateRequest state;
        @NotBlank(message = "o campo uf é obrigatório!")
        private String sigla;
}
