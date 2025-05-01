package com.ironhack.labjpa.service;

import com.ironhack.labjpa.model.FlightBooking;
import com.ironhack.labjpa.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightBookingService {
    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingService(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public List<FlightBooking> getAllBookings() {
        return flightBookingRepository.findAll();
    }

    public FlightBooking getBookingById(Integer id) {
        return flightBookingRepository.findById(id).orElse(null);
    }

    public List<FlightBooking> getByCustomerId(Integer customerId) {
        return flightBookingRepository.findByCustomerId(customerId);
    }

    public List<FlightBooking> getByFlightId(Integer flightId) {
        return flightBookingRepository.findByFlightId(flightId);
    }
}
