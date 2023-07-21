package com.seujobby.main.domain.candidate;

import com.seujobby.main.domain.Address;
import com.seujobby.main.domain.application.Application;
import com.seujobby.main.domain.enums.Sex;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "candidate")
@Entity
public class Candidate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String cpf;
    private boolean isActive;
    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "candidates")
    private List<Application>applications;
}
