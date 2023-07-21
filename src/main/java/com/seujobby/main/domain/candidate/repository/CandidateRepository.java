package com.seujobby.main.domain.candidate.repository;

import com.seujobby.main.domain.candidate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> { }
