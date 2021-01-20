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
    private AirCompanyService companyService;

    @Autowired
    public AirCompanyController(AirCompanyService companyService, AirCompanyRepository AIR_COMPANY_REPO) {
        this.companyService = companyService;
    }

    @PostMapping(value = "/companies")
    public ResponseEntity<?> create(@RequestBody AirCompany airCompany) {
        companyService.create(airCompany);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/companies")
    public ResponseEntity<List<AirCompany>> read() {
        final List<AirCompany> airCompanies = companyService.readAll();

        return airCompanies != null && !airCompanies.isEmpty()
                ? new ResponseEntity<>(airCompanies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<AirCompany> read(@PathVariable(name = "id") int id) {
        final AirCompany airCompany = companyService.read(id);

        return airCompany != null
                ? new ResponseEntity<>(airCompany, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody AirCompany airCompany) {
        final boolean updated = companyService.update(airCompany, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/companies/{id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int id) {
        boolean deleted = companyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
