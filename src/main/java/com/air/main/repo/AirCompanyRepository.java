package com.air.main.repo;

import com.air.main.models.AirCompany;
import org.springframework.data.repository.CrudRepository;

public interface AirCompanyRepository extends CrudRepository<AirCompany, Integer> {
}

