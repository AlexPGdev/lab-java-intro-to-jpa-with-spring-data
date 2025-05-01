package com.ironhack.labjpa.controller;

import com.ironhack.labjpa.model.FlightBooking;
import com.ironhack.labjpa.service.FlightBookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GetMapping
    public List<FlightBooking> getAll() {
        return flightBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public FlightBooking getById(@PathVariable Integer id) {
        return flightBookingService.getBookingById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<FlightBooking> getByCustomerId(@PathVariable Integer customerId) {
        return flightBookingService.getByCustomerId(customerId);
    }

    @GetMapping("/flight/{flightId}")
    public List<FlightBooking> getByFlightId(@PathVariable Integer flightId) {
        return flightBookingService.getByFlightId(flightId);
    }
}
