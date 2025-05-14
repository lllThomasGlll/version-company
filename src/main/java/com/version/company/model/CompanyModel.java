package com.version.company.model;

import jakarta.persistence.*;

@Entity
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_company;

    @Column(name = "codigo_company")
    private String codigoCompany;

    private String name_company;

    private String  description_company;

    public CompanyModel() {
    }

    public CompanyModel(long id_company, String codigo_company, String name_company, String description_company) {
        this.id_company = id_company;
        this.codigoCompany = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
    }

    public long getId_company() {
        return id_company;
    }

    public void setId_company(long id_company) {
        this.id_company = id_company;
    }

    public String getCodigoCompany() {
        return codigoCompany;
    }

    public void setCodigoCompany(String codigoCompany) {
        this.codigoCompany = codigoCompany;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getDescription_company() {
        return description_company;
    }

    public void setDescription_company(String description_company) {
        this.description_company = description_company;
    }
}
