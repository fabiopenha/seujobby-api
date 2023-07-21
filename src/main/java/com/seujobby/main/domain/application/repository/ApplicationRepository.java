package com.seujobby.main.domain.application.repository;

import com.seujobby.main.domain.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> { }
