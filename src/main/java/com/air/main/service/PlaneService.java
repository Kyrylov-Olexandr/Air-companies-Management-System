package com.air.main.service;

import com.air.main.models.AirCompany;
import com.air.main.models.Airplane;

import java.util.List;

public interface PlaneService {
    boolean changeCompany(int airplaneId, int airCompanyId);

    int create(Airplane airplane);

    boolean delete(int id);

    Airplane read(int id);
}
