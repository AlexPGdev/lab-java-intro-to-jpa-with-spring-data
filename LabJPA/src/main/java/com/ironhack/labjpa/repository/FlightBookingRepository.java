package com.ironhack.labjpa.repository;

import com.ironhack.labjpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    List<FlightBooking> findByCustomerId(Integer customerId);
    List<FlightBooking> findByFlightId(Integer flightId);
}
