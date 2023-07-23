package com.seujobby.main.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "state")
@Entity
public class State {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String stateName;
}