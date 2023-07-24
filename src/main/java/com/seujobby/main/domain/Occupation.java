package com.seujobby.main.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "occupation")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}