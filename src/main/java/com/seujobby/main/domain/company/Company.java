package com.seujobby.main.domain.company;

import com.seujobby.main.domain.Address;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String corporateName;
    @Column(unique = true)
    private String cnpj;
    private String phone;
    private String description;
    private String site;
    private String responsibleName;

    @Column(unique = true, length = 5000)
    private String responsibleEmail;
    private boolean active;
    @Embedded
    private Address address;
}
