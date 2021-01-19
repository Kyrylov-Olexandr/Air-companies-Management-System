package com.air.main.service;

import com.air.main.models.Airplane;
import com.air.main.repo.AirplaneRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AirplaneServiceImpl implements AirplaneService{
    private final AirplaneRepository AIRPLANE_REPO;
    private static final AtomicInteger PLANE_ID_HOLDER = new AtomicInteger();


    public AirplaneServiceImpl(AirplaneRepository airplane_repo) {
        AIRPLANE_REPO = airplane_repo;
    }

    @Override
    public boolean changeCompany(int airplaneId, int airCompanyId) {
        Airplane airplane = AIRPLANE_REPO.findById(airplaneId).get();
        airplane.setAirCompanyId(airCompanyId);
        AIRPLANE_REPO.save(airplane);
        return airplane.getAirCompanyId() == airCompanyId;
    }

    @Override
    public void create(Airplane airplane) {
        final int companyId = PLANE_ID_HOLDER.incrementAndGet();
        airplane.setId(companyId);
        AIRPLANE_REPO.save(airplane);
    }

    @Override
    public boolean delete(int id) {
        AIRPLANE_REPO.deleteById(id);
        return !AIRPLANE_REPO.existsById(id);
    }

    @Override
    public Airplane read(int id) {
        return AIRPLANE_REPO.findById(id).get();
    }
}
