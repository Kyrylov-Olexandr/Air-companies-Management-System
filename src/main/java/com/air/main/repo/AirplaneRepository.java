package com.air.main.repo;

import com.air.main.models.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
}
