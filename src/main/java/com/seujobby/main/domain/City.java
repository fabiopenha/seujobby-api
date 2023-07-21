package com.seujobby.main.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Table(name = "city")
@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @ManyToOne
    private State state;
    private String sigla;
}