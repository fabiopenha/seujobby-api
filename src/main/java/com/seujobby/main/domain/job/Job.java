package com.seujobby.main.domain.job;

import com.seujobby.main.domain.company.Company;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobCode;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean isActive= true;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
}
