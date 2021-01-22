package com.air.main.service;

import com.air.main.models.Flight;
import com.air.main.models.FlightStatuses;

import java.util.List;

public interface FlightService {
    boolean changeStatus(int id, String status);

    List<Flight> findActive();

    List<Flight> findByStatus(String status);

    int create(Flight flight);

    boolean delete(int id);

    Flight read(int id);

    List<Flight> readAll();

    List<Flight> findCompleted();
}

