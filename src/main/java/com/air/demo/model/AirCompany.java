package com.air.demo.model;

public class AirCompany {
    private int id;
    private String name;
    private String companyType;
    private String foundedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(String foundedAt) {
        this.foundedAt = foundedAt;
    }
}
