package com.version.company.repository;

import com.version.company.model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationModel, Long> {
}
