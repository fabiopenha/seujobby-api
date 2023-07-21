package com.seujobby.main.domain;

import jakarta.persistence.*;

@Table(name = "state")
@Entity
public class State {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
}