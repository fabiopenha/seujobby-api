package com.seujobby.main.domain.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data public class CompanyJobRequest {
    @NotNull(message = "O campo id é obrigatório!")
    private Long id;
}
