package com.air.main.service;

import com.air.main.models.Airplane;
import com.air.main.repo.AirplaneRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PlaneServiceImpl implements PlaneService {
    private final AirplaneRepository planeRepo;
    private static final AtomicInteger ID_HOLDER = new AtomicInteger();


    public PlaneServiceImpl(AirplaneRepository planeRepo) {
        this.planeRepo = planeRepo;
    }

    @Override
    public boolean changeCompany(int airplaneId, int airCompanyId) {
        Airplane airplane = planeRepo.findById(airplaneId).get();
        airplane.setAirCompanyId(airCompanyId);
        planeRepo.save(airplane);
        return airplane.getAirCompanyId() == airCompanyId;
    }

    @Override
    public int create(Airplane airplane) {
        final int id = ID_HOLDER.incrementAndGet();
        airplane.setId(id);
        planeRepo.save(airplane);
        return id;
    }

    @Override
    public boolean delete(int id) {
        planeRepo.deleteById(id);
        return !planeRepo.existsById(id);
    }

    @Override
    public Airplane read(int id) {
        return planeRepo.findById(id).get();
    }

}
