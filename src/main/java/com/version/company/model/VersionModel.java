package com.version.company.model;

import jakarta.persistence.*;

@Entity
public class VersionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long version_id;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationModel app_id;

    private String version ;

    private String  version_description;

    public VersionModel() {
    }

    public VersionModel(long version_id, ApplicationModel app_id, String version, String version_description) {
        this.version_id = version_id;
        this.app_id = app_id;
        this.version = version;
        this.version_description = version_description;
    }

    public long getVersion_id() {
        return version_id;
    }

    public void setVersion_id(long version_id) {
        this.version_id = version_id;
    }

    public ApplicationModel getApp_id() {
        return app_id;
    }

    public void setApp_id(ApplicationModel app_id) {
        this.app_id = app_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion_description() {
        return version_description;
    }

    public void setVersion_description(String version_description) {
        this.version_description = version_description;
    }
}
