package com.air.demo.service;

import com.air.demo.model.AirCompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AirCompanyServiceImpl implements AirCompanyService {
    private static final Map<Integer, AirCompany> AIR_COMPANY_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger AIR_COMPANY_ID_HOLDER = new AtomicInteger();


    @Override
    public void create(AirCompany airCompany) {
        final int airCompanyId = AIR_COMPANY_ID_HOLDER.incrementAndGet();
        airCompany.setId(airCompanyId);
        AIR_COMPANY_REPOSITORY_MAP.put(airCompanyId, airCompany);
    }

    @Override
    public boolean delete(int id) {
        return AIR_COMPANY_REPOSITORY_MAP.remove(id) != null;
    }

    @Override
    public boolean update(AirCompany airCompany, int id) {
        if (AIR_COMPANY_REPOSITORY_MAP.containsKey(id)) {
            airCompany.setId(id);
            AIR_COMPANY_REPOSITORY_MAP.put(id, airCompany);
            return true;
        }

        return false;
    }

    @Override
    public List<AirCompany> readAll() {
        return new ArrayList<>(AIR_COMPANY_REPOSITORY_MAP.values());
    }

    @Override
    public AirCompany read(int id) {
        return AIR_COMPANY_REPOSITORY_MAP.get(id);
    }
}
