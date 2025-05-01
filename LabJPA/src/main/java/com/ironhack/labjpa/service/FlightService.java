package com.ironhack.labjpa.service;

import com.ironhack.labjpa.model.Flight;
import com.ironhack.labjpa.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id).orElse(null);
    }
}
