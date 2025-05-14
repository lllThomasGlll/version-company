package com.version.company.model;

import jakarta.persistence.*;

@Entity
public class VersionCompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long version_company_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel companyId;
    @ManyToOne
    @JoinColumn(name = "version_id")
    private VersionModel versionId;

    private String  version_company_description;

    public VersionCompanyModel() {
    }

    public VersionCompanyModel(long version_company_id, CompanyModel company_id, VersionModel version_id, String version_company_description) {
        this.version_company_id = version_company_id;
        this.companyId = company_id;
        this.versionId = version_id;
        this.version_company_description = version_company_description;
    }

    public long getVersion_company_id() {
        return version_company_id;
    }

    public void setVersion_company_id(long version_company_id) {
        this.version_company_id = version_company_id;
    }

    public CompanyModel getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyModel companyId) {
        this.companyId = companyId;
    }

    public VersionModel getVersionId() {
        return versionId;
    }

    public void setVersionId(VersionModel versionId) {
        this.versionId = versionId;
    }

    public String getVersion_company_description() {
        return version_company_description;
    }

    public void setVersion_company_description(String version_company_description) {
        this.version_company_description = version_company_description;
    }
}
