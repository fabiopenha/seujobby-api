package com.seujobby.main.domain.dtos;

import com.seujobby.main.domain.candidate.Candidate;
import lombok.Data;

import java.util.List;

@Data
public class CurriculumResponse {
    private Long id;
    private Double maxSalaryExpectation;
    private Double minSalaryExpectation;
    private CandidateResponse candidateId;
    private List<ExperienceResponse> experience;
    private LanguageResponse language;
}
