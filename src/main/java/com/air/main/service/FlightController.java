package com.air.main.service;

import com.air.main.models.Airplane;
import com.air.main.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class FlightController {
    private final FlightService FLIGHT_SERVICE;

    @Autowired
    public FlightController(FlightService flight_service) {
        FLIGHT_SERVICE = flight_service;
    }

    @PutMapping(value = "/flights/{id}")
    public ResponseEntity<?> changeCompany(@PathVariable(name = "id") int airplaneId,
                                           @RequestParam(value = "companyId", required = false) int companyId) {
        final boolean changed = AIRPLANE_SERVICE.changeCompany(airplaneId, companyId);
        return changed
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/flights")
    public ResponseEntity<?> create(@RequestBody Flight flight) {
        FLIGHT_SERVICE.create(flight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/flights/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        boolean deleted = AIRPLANE_SERVICE.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/flights/{id}")
    public ResponseEntity<Airplane> read(@PathVariable(name = "id") int id) {
        final Airplane airplane = AIRPLANE_SERVICE.read(id);

        return airplane != null
                ? new ResponseEntity<>(airplane, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

