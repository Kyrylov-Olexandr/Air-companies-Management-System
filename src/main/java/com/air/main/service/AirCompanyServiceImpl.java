package com.air.main.service;

import com.air.main.models.AirCompany;
import com.air.main.repo.AirCompanyRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AirCompanyServiceImpl implements AirCompanyService {
    private static final AtomicInteger ID_HOLDER = new AtomicInteger();
    private final AirCompanyRepository companyRepo;

    public AirCompanyServiceImpl(AirCompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public int create(AirCompany airCompany) {
        final int companyId = ID_HOLDER.incrementAndGet();
        airCompany.setId(companyId);
        companyRepo.save(airCompany);
        return companyId;
    }

    @Override
    public boolean delete(int id) {
        companyRepo.deleteById(id);
        return !companyRepo.existsById(id);
    }

    @Override
    public boolean update(AirCompany airCompany, int id) {
        if (companyRepo.existsById(id)) {
            airCompany.setId(id);
            companyRepo.save(airCompany);
            return true;
        }

        return false;
    }

    @Override
    public List<AirCompany> readAll() {
        return new ArrayList<>((Collection<? extends AirCompany>) companyRepo.findAll());
    }

    @Override
    public AirCompany read(int id) {
        return companyRepo.findById(id).get();
    }
}
