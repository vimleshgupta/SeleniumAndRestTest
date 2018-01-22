package model;

/**
 * Created by cts1 on 22/1/18.
 */
public class Flight {
    String title;
    String departureTime;
    String arrivalTime;
    String fare;

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
