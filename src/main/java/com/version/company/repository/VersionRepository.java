package com.version.company.repository;

import com.version.company.model.VersionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<VersionModel, Long> {
}
