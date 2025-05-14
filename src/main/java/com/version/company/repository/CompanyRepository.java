package com.version.company.repository;

import com.version.company.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

    Optional<CompanyModel> findByCodigoCompany(String codigo_company);
}
