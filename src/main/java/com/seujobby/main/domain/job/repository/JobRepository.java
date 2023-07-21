package com.seujobby.main.domain.job.repository;

import com.seujobby.main.domain.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> { }
