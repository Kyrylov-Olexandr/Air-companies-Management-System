package com.air.demo.service;

import com.air.demo.model.AirCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @PostMapping(value = "/companies")
    public ResponseEntity<?> create(@RequestBody AirCompany airCompany) {
        airCompanyService.create(airCompany);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/companies")
    public ResponseEntity<List<AirCompany>> read() {
        final List<AirCompany> airCompanies = airCompanyService.readAll();

        return airCompanies != null && !airCompanies.isEmpty()
                ? new ResponseEntity<>(airCompanies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<AirCompany> read(@PathVariable(name = "id") int id) {
        final AirCompany airCompany = airCompanyService.read(id);

        return airCompany != null
                ? new ResponseEntity<>(airCompany, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody AirCompany airCompany) {
        final boolean updated = airCompanyService.update(airCompany, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/companies/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        final boolean deleted = airCompanyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
