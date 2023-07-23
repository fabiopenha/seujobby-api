package com.seujobby.main.domain.company.repository;

import com.seujobby.main.domain.company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Page<Company> findAllByActiveTrue(Pageable pagination);

    boolean existsByResponsibleEmail(String email);
}
