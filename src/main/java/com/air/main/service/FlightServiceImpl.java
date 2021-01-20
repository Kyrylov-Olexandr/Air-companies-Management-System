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
    private final FlightRepository flightRepo;
    private static final AtomicInteger ID_HOLDER = new AtomicInteger();

    public FlightServiceImpl(FlightRepository flightRepo) {
        this.flightRepo = flightRepo;
    }

//    @Override
//    public boolean changeStatus(int id, String status) {
//        boolean founded = flightRepo.findById(id).isPresent();
//        if (founded) {
//            Flight flight = flightRepo.findById(id).get();
//            if (FlightStatuses.DELAYED.getTitle().equals(status)) {
//                flight.setDelayStartedAt();
//            } else if (FlightStatuses.ACTIVE.getTitle().equals(status)) {
//                flight.setStartedAt();
//            } else if (FlightStatuses.COMPLETED.getTitle().equals(status)) {
//                flight.setEndedAt();
//            }
//            flight.setStatus(status);
//            flightRepo.save(flight);
//        }
//        return founded;
//    }

    @Override
    public List<Flight> findActive() {
        return findByStatus("active");
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
