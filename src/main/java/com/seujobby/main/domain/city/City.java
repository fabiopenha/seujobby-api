package com.seujobby.main.domain.city;

import com.seujobby.main.domain.State;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "city")
@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @ManyToOne()
    private State state;
    private String sigla;
}