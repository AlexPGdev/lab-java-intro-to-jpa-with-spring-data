package com.ironhack.labjpa.controller;

import com.ironhack.labjpa.model.Flight;
import com.ironhack.labjpa.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Integer id) {
        return flightService.getFlightById(id);
    }
}
