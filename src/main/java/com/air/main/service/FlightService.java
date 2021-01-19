package com.air.main.service;

import com.air.main.models.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findActive(String status);

    List<Flight> findByStatus(String status);

    void create(Flight flight);

    boolean delete(int id);

    Flight read(int id);

    List<Flight> readAll();
}

