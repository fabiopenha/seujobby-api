package com.seujobby.main.domain.application;

import com.seujobby.main.domain.candidate.Candidate;
import com.seujobby.main.domain.company.Company;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "application")
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long jobId;
    private LocalDate dataCriacao;
    @ManyToOne
    private Company company;
    @ManyToMany()
    @JoinTable(name = "application_candidate",
    joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private List<Candidate> candidates;
}
