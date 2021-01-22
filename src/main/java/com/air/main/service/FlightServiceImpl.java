package com.air.main.service;

import com.air.main.models.Flight;
import com.air.main.models.FlightStatuses;
import com.air.main.repo.FlightRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class FlightServiceImpl implements FlightService{
    private final FlightRepository flightRepo;
    private static final AtomicInteger ID_HOLDER = new AtomicInteger();

    public FlightServiceImpl(FlightRepository flightRepo) {
        this.flightRepo = flightRepo;
    }

    @Override
    public boolean changeStatus(int id, String status) {
        boolean founded = flightRepo.findById(id).isPresent();
        Date today = new Date();
        Timestamp timestamp = new Timestamp(today.getTime());

        if (founded) {
            Flight flight = flightRepo.findById(id).get();
            if (FlightStatuses.DELAYED.getTitle().equals(status)) {
                flight.setDelayStartedAt(timestamp);
            } else if (FlightStatuses.ACTIVE.getTitle().equals(status)) {
                flight.setStartedAt(timestamp);
            } else if (FlightStatuses.COMPLETED.getTitle().equals(status)) {
                flight.setEndedAt(timestamp);
            }
            flight.setStatus(status);
            flightRepo.save(flight);
        }
        return founded;
    }

    @Override
    public List<Flight> findActive() {
        Date today = new Date();
        long todayInMillis = today.getTime();
        long previosDayInMillis = todayInMillis - 86400000;
        var activeFlights = findByStatus("active");
        activeFlights.removeIf(flight ->
                flight.getStartedAt().getTime() > previosDayInMillis);
        return activeFlights;
    }
    @Override
    public List<Flight> findCompleted() {
        var completedFlights = findByStatus("completed");
        completedFlights.removeIf(flight -> {
            long difference = flight.getStartedAt().getTime() - flight.getEndedAt().getTime();
            long estimatedTimeInMillis = flight.getEstimatedTime().getTime();
            return difference > estimatedTimeInMillis;
        });
        return completedFlights;
    }

    @Override
    public List<Flight> findByStatus(String status) {
        return readAll().stream()
                .filter(flight -> flight.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @Override
    public int create(Flight flight) {
        final int id = ID_HOLDER.incrementAndGet();
        flight.setId(id);
        flight.setStatus(FlightStatuses.PENDING.getTitle());
        flightRepo.save(flight);
        return id;
    }

    @Override
    public boolean delete(int id) {
        flightRepo.deleteById(id);
        return !flightRepo.existsById(id);
    }

    @Override
    public Flight read(int id) {
        return flightRepo.findById(id).get();
    }

    @Override
    public List<Flight> readAll() {
        return new ArrayList<>((Collection<? extends Flight>) flightRepo.findAll());
    }

}
