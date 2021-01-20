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
//    public FlightStatuses getValue (String title) {
//        for (FlightStatuses flightStatuses : FlightStatuses.values()) {
//            if (flightStatuses.getTitle().equals(title)) {
//                return flightStatuses;
//            }
//        }
//        return FlightStatuses.DELAYED;
//    }
}
