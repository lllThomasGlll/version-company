package com.version.company.repository;

import com.version.company.model.CompanyModel;
import com.version.company.model.VersionCompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionCompanyRepository extends JpaRepository<VersionCompanyModel, Long> {
    Optional<VersionCompanyModel> findFirstByCompanyId(CompanyModel companyId);
}
