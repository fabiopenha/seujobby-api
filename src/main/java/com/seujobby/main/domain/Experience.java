package com.seujobby.main.domain;

import com.seujobby.main.domain.company.Company;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Occupation jobPosition;
    @ManyToOne
    private Company company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String activityDescription;
    private boolean isCurrentJob;

}
