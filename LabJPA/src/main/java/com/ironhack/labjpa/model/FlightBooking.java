package com.ironhack.labjpa.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "flight_id", nullable = false)
    private Integer flightId;

    public FlightBooking() {
    }

    public FlightBooking(Long customer_id, Integer flight_id) {
        this.customerId = customer_id;
        this.flightId = flight_id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Long getCustomer() {
        return customerId;
    }

    public void setCustomer(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getFlight() {
        return flightId;
    }

    public void setFlight(Integer flightId) {
        this.flightId = flightId;
    }
}
