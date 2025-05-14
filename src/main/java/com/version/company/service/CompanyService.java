package com.version.company.service;

import com.version.company.model.CompanyAppDTO;
import com.version.company.model.CompanyModel;
import com.version.company.model.CompanyRequest;
import com.version.company.model.VersionCompanyModel;
import com.version.company.repository.CompanyRepository;
import com.version.company.repository.VersionCompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private  final VersionCompanyRepository versionCompanyRepository;

    public CompanyService(CompanyRepository companyRepository, VersionCompanyRepository versionCompanyRepository) {
        this.companyRepository = companyRepository;
        this.versionCompanyRepository = versionCompanyRepository;
    }

    public CompanyAppDTO getCompanyAppVersion(String codigo_company) {
        CompanyModel company = companyRepository.findByCodigoCompany(codigo_company)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        VersionCompanyModel versionCompany = versionCompanyRepository
                .findFirstByCompanyId(company)
                .orElseThrow(() -> new RuntimeException("VersionCompany not found"));

        return new CompanyAppDTO(
                company.getCodigoCompany(),
                company.getName_company(),
                versionCompany.getVersionId().getApp_id().getApp_name(),
                versionCompany.getVersionId().getVersion()
        );
    }

    public List<CompanyModel> findAll() {
        return companyRepository.findAll();
    }

    public Optional<CompanyModel> finById(Long id) {
        return companyRepository.findById(id);
    }

    public ResponseEntity<?> create(CompanyModel company) {
        Optional<CompanyModel> existingCompany = companyRepository.findByCodigoCompany(company.getCodigoCompany());

        if (existingCompany.isPresent()) {
            return ResponseEntity.badRequest().body("Ya existe una compañía con el código: " + company.getCodigoCompany());
        }

        CompanyModel savedCompany = companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
    }

    public Optional<CompanyModel> update(Long id, CompanyRequest companyNew) {
        return companyRepository.findById(id).map(company -> {

            company.setCodigoCompany(companyNew.getCodigoCompany());
            company.setName_company(companyNew.getName_company());
            company.setDescription_company(companyNew.getDescription_company());
            return companyRepository.save(company);
        });
    }

    public boolean delete(Long id) {

        if (companyRepository.existsById(id) && versionCompanyRepository.existsById(id)) {
            versionCompanyRepository.deleteById(id);
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
