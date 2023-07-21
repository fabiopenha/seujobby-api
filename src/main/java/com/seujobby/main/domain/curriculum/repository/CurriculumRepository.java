package com.seujobby.main.domain.curriculum.repository;

import com.seujobby.main.domain.curriculum.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> { }
