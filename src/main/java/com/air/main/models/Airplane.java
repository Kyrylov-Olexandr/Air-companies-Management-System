package com.air.main.models;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airplane {
    @Id
    private int id;
    private String name;
    private int factorySerialNumber;
    private int airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private String manufacturerCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(int factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public int getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }
}
