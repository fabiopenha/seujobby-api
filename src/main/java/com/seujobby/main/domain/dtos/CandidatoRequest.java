package com.seujobby.main.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seujobby.main.domain.enums.Sex;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CandidatoRequest(
        @NotNull(message = "O campo nome é obrigatório!")
        String name,

        @NotNull(message = "O campo email é obrigatório!")
        @Email
        String email,
        @NotNull(message = "O campo telefone é obrigatório!")
        String phone,

        @NotNull(message = "O campo data de nascimento é obrigatório!")
        @Past(message = "Não é permitido inserir datas futuras!")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        @NotNull(message = "O campo sexo é obrigatório!")
        Sex sex,
        @NotNull(message = "O campo cpf é obrigatório!")
        @Pattern(regexp = "^\\d{11}$", message = "Digite apenas os números do CPF!")
        String cpf,
        @NotNull(message = "O campo cpf é obrigatório!")
        boolean isActive,
        @NotNull @Valid
        AddressRequest address
) {
}
