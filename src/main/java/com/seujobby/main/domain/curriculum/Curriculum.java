package com.seujobby.main.domain.curriculum;

import com.seujobby.main.domain.Experience;
import com.seujobby.main.domain.Language;
import com.seujobby.main.domain.candidate.Candidate;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double maxSalaryExpectation;
    private Double minSalaryExpectation;
    @OneToOne
    private Candidate candidateId;
    @OneToMany
    private List<Experience> experience;
    @Embedded
    private Language language;
}