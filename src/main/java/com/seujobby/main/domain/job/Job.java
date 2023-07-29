package com.seujobby.main.domain.job;

import com.seujobby.main.domain.company.Company;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job")
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobCode;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean active= true;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;
}
