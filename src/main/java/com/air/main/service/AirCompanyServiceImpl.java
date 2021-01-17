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
    private static final AtomicInteger COMPANY_ID_HOLDER = new AtomicInteger();
    private final AirCompanyRepository AIR_COMPANY_REPO;

    public AirCompanyServiceImpl(AirCompanyRepository AIR_COMPANY_REPO) {
        this.AIR_COMPANY_REPO = AIR_COMPANY_REPO;
    }

    @Override
    public void create(AirCompany airCompany) {
        final int companyId = COMPANY_ID_HOLDER.incrementAndGet();
        airCompany.setId(companyId);
        AIR_COMPANY_REPO.save(airCompany);
    }

    @Override
    public boolean delete(int id) {
        AIR_COMPANY_REPO.deleteById(id);
        return AIR_COMPANY_REPO.existsById(id);
    }

    @Override
    public boolean update(AirCompany airCompany, int id) {
        if (AIR_COMPANY_REPO.existsById(id)) {
            airCompany.setId(id);
            //AirCompany airCompany1 = AIR_COMPANY_REPO.findById(id).get();
            AIR_COMPANY_REPO.save(airCompany);
            return true;
        }

        return false;
    }

    @Override
    public List<AirCompany> readAll() {
        return new ArrayList<>((Collection<? extends AirCompany>) AIR_COMPANY_REPO.findAll());
    }

    @Override
    public AirCompany read(int id) {
        return AIR_COMPANY_REPO.findById(id).get();
    }
}
