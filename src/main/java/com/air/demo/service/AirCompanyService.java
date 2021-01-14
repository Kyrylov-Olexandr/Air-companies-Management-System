package com.air.demo.service;

import com.air.demo.model.AirCompany;

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
     * @param id - client ID;
     * @return - client object;
     */
    AirCompany read(int id);
}
