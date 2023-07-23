package com.seujobby.main.domain.candidate;

import com.seujobby.main.domain.Address;
import com.seujobby.main.domain.application.Application;
import com.seujobby.main.domain.enums.Sex;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Table(name = "candidate")
@Entity
@Data
public class Candidate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String phone;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(unique = true)
    private String cpf;
    private boolean active = true;
    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "candidates")
    private List<Application>applications;
}
