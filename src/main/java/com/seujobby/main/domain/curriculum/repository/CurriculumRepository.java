package com.seujobby.main.domain.curriculum.repository;

import com.seujobby.main.domain.curriculum.Curriculum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {

    @Query("SELECT c FROM Curriculum c WHERE c.candidateId.active = true")
    Page<Curriculum>findAllByActiveTrue(Pageable pagination);
}
