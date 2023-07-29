package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.company.Company;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobResponse {
    private Long id;
    private String jobCode;
    private String description;
    private LocalDateTime createdAt;
    private boolean active;
    private CompanyResponse companyId;
}
