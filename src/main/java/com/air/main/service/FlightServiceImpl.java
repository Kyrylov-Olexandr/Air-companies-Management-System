package com.air.main.service;

import com.air.main.models.Flight;
import com.air.main.models.FlightStatuses;
import com.air.main.repo.FlightRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Component
public class FlightServiceImpl implements FlightService{
    private final FlightRepository FLIGTH_REPO;
    private final FlightService FLIGHT_SERVICE;
    private static final AtomicInteger FLIGHT_ID_HOLDER = new AtomicInteger();

    public FlightServiceImpl(FlightRepository fligth_repo, FlightService flight_service) {
        FLIGTH_REPO = fligth_repo;
        FLIGHT_SERVICE = flight_service;

    }

    @Override
    public List<Flight> findActive(String status) {
        return null;
    }

    @Override
    public List<Flight> findByStatus(String status) {
        return readAll().stream()
                .filter(flight -> flight.getFlightStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @Override
    public void create(Flight flight) {
        final int id = FLIGHT_ID_HOLDER.incrementAndGet();
        flight.setId(id);
        flight.setFlightStatus(FlightStatuses.DELAYED);
        FLIGTH_REPO.save(flight);
    }

    @Override
    public boolean delete(int id) {
        FLIGTH_REPO.deleteById(id);
        return !FLIGTH_REPO.existsById(id);
    }

    @Override
    public Flight read(int id) {
        return FLIGTH_REPO.findById(id).get();
    }

    @Override
    public List<Flight> readAll() {
        return new ArrayList<>((Collection<? extends Flight>) FLIGTH_REPO.findAll());
    }
}
