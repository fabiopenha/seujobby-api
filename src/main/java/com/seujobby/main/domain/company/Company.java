package com.seujobby.main.domain.company;

import com.seujobby.main.domain.Address;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String corporateName;
    private String cnpj;
    private String phone;
    private String description;
    private String site;
    private String responsibleName;
    private String responsibleEmail;
    private boolean isActive;
    @Embedded
    private Address address;
}
