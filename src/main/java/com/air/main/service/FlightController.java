package com.air.main.service;

import com.air.main.models.AirCompany;
import com.air.main.models.Airplane;
import com.air.main.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping(value = "/flights/{id}/")
    public ResponseEntity<?> changeStatus (@PathVariable(name = "id") int id,
                                           @RequestParam(value = "status") String status) {
        boolean changed = flightService.changeStatus(id, status);

        return changed
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/flights")
    public ResponseEntity<?> create(@RequestBody Flight flight) {
        flightService.create(flight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/flights/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        boolean deleted = flightService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/flights/{id}")
    public ResponseEntity<Flight> read(@PathVariable(name = "id") int id) {
        final Flight flight= flightService.read(id);

        return flight != null
                ? new ResponseEntity<>(flight, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/flights")
    public ResponseEntity<List<Flight>> read() {
        final List<Flight> flights = flightService.readAll();

        return flights != null && !flights.isEmpty()
                ? new ResponseEntity<>(flights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/flights/status")
    public ResponseEntity<List<Flight>> findByStatus (@RequestParam(value = "status") String status) {
        List flights = flightService.findByStatus(status);
        return flights != null && !flights.isEmpty()
                ? new ResponseEntity<>(flights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/flights/status/active")
    public ResponseEntity<List<Flight>> findActive() {
        List flights = flightService.findActive();
        return flights != null && !flights.isEmpty()
                ? new ResponseEntity<>(flights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/flights/status/completed")
    public ResponseEntity<List<Flight>> findCompleted() {
        List flights = flightService.findCompleted();
        return flights != null && !flights.isEmpty()
                ? new ResponseEntity<>(flights, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

