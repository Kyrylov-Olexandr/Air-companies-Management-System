package com.air.main.service;

import com.air.main.models.AirCompany;

import java.util.List;

public interface AirCompanyService {
    /**
     * Create new company
     * @param airCompany - company to create;
     */
    void create(AirCompany airCompany);

    /**
     * Delete company by ID
     * @param id - company ID;
     * @return - true if deleted else - false
     */
    boolean delete(int id);

    /**
     *
     * @param airCompany - company according to which you need to update
     * @param id - ID of the company to be updated
     * @return true if updated else - false
     */
    boolean update(AirCompany airCompany, int id);

    /**
     * return all companies
     * @return list of companies
     */
    List<AirCompany> readAll();

    /**
     *
     * @param id - company ID;
     * @return - AirCompany object;
     */
    AirCompany read(int id);
}
