package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.enums.Sex;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidateResponse {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private LocalDate birthDate;
        private Sex sex;
        private String cpf;
        private AddressResponse address;
}
