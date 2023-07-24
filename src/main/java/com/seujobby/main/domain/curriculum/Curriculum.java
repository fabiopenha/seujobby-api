package com.seujobby.main.domain.curriculum;

import com.seujobby.main.domain.Experience;
import com.seujobby.main.domain.Language;
import com.seujobby.main.domain.candidate.Candidate;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "curriculum")
public class Curriculum {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double maxSalaryExpectation;
    private Double minSalaryExpectation;
    @OneToOne
    private Candidate candidateId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Experience> experience;
    @Embedded
    private Language language;
}