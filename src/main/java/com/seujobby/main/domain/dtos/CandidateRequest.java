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
public class CandidateRequest {
        @NotNull(message = "O campo nome é obrigatório!")
        private String name;

        @NotNull(message = "O campo email é obrigatório!")
        @Email
        private String email;

        @NotNull(message = "O campo telefone é obrigatório!")
        private String phone;

        @NotNull(message = "O campo data de nascimento é obrigatório!")
        @Past(message = "Não é permitido inserir datas futuras!")
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate birthDate;

        @NotNull(message = "O campo sexo é obrigatório!")
        private Sex sex;

        @NotNull(message = "O campo cpf é obrigatório!")
        @Pattern(regexp = "^\\d{11}$", message = "Digite apenas os números do CPF!")
        private String cpf;

        @NotNull @Valid
        private AddressRequest address;
}
