package com.version.company.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ApplicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long app_id;

    private String app_code;

    private String app_name;

    private String  app_description;

    public ApplicationModel() {
    }

    public ApplicationModel(long app_id, String app_code, String app_name, String app_description) {
        this.app_id = app_id;
        this.app_code = app_code;
        this.app_name = app_name;
        this.app_description = app_description;
    }

    public long getApp_id() {
        return app_id;
    }

    public void setApp_id(long app_id) {
        this.app_id = app_id;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_description() {
        return app_description;
    }

    public void setApp_description(String app_description) {
        this.app_description = app_description;
    }
}
