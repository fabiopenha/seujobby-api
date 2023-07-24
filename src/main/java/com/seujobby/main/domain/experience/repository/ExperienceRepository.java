package com.seujobby.main.domain.experience.repository;

import com.seujobby.main.domain.experience.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> { }
