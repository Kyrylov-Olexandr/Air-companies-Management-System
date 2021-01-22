package com.air.main.models;

public enum FlightStatuses {
    ACTIVE("active"),
    COMPLETED("completed"),
    DELAYED("delayed"),
    PENDING("pending");

    private String title;

    FlightStatuses(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
