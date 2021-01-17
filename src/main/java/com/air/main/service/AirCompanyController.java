package com.air.main.service;

import com.air.main.models.AirCompany;
import com.air.main.repo.AirCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirCompanyController {
    private final AirCompanyService AIR_COMPANY_SERVICE;
    private final AirCompanyRepository AIR_COMPANY_REPO;

    @Autowired
    public AirCompanyController(AirCompanyService AIR_COMPANY_SERVICE, AirCompanyRepository AIR_COMPANY_REPO) {
        this.AIR_COMPANY_SERVICE = AIR_COMPANY_SERVICE;
        this.AIR_COMPANY_REPO = AIR_COMPANY_REPO;
    }

    @PostMapping(value = "/companies")
    public ResponseEntity<?> create(@RequestBody AirCompany airCompany) {
        AIR_COMPANY_SERVICE.create(airCompany);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/companies")
    public ResponseEntity<List<AirCompany>> read() {
        final List<AirCompany> airCompanies = AIR_COMPANY_SERVICE.readAll();

        return airCompanies != null && !airCompanies.isEmpty()
                ? new ResponseEntity<>(airCompanies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<AirCompany> read(@PathVariable(name = "id") int id) {
        final AirCompany airCompany = AIR_COMPANY_SERVICE.read(id);

        return airCompany != null
                ? new ResponseEntity<>(airCompany, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody AirCompany airCompany) {
        final boolean updated = AIR_COMPANY_SERVICE.update(airCompany, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/companies/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        boolean deleted = AIR_COMPANY_SERVICE.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
