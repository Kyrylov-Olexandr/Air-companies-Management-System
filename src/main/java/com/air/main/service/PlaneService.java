package com.air.main.service;


import com.air.main.models.Airplane;

public interface PlaneService {
    boolean changeCompany(int airplaneId, int airCompanyId);

    int create(Airplane airplane);

    boolean delete(int id);

    Airplane read(int id);

    boolean update(Airplane airplane, int id);
}
