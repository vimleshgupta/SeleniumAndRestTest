package model;

public class Flight {
    private String title;
    private String departureTime;
    private String arrivalTime;
    private String fare;

    public Flight(String title, String departureTime, String arrivalTime, String fare) {
        this.title = title;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getFare() {
        return fare;
    }
}
