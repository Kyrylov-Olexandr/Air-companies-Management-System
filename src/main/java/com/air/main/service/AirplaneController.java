package com.air.main.service;

import com.air.main.models.AirCompany;
import com.air.main.models.Airplane;
import com.air.main.repo.AirCompanyRepository;
import com.air.main.repo.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirplaneController {
    private final AirplaneService AIRPLANE_SERVICE;

    @Autowired
    public AirplaneController(AirplaneService airplane_service) {
        AIRPLANE_SERVICE = airplane_service;
    }

    @PutMapping(value = "/airplanes/{id}")
    public ResponseEntity<?> changeCompany(@PathVariable(name = "id") int airplaneId,
                                           @RequestParam(value = "companyId", required = false) int companyId) {
        final boolean changed = AIRPLANE_SERVICE.changeCompany(airplaneId, companyId);
        return changed
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/airplanes")
    public ResponseEntity<?> create(@RequestBody Airplane airplane) {
        AIRPLANE_SERVICE.create(airplane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/airplanes/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        boolean deleted = AIRPLANE_SERVICE.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/airplanes/{id}")
    public ResponseEntity<Airplane> read(@PathVariable(name = "id") int id) {
        final Airplane airplane = AIRPLANE_SERVICE.read(id);

        return airplane != null
                ? new ResponseEntity<>(airplane, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
