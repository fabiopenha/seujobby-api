package com.seujobby.main.domain.candidate.repository;

import com.seujobby.main.domain.candidate.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Page<Candidate> findAllByActiveTrue(Pageable pagination);

    boolean existsByEmail(String email);
}
