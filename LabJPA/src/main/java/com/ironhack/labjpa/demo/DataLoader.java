package com.ironhack.labjpa.demo;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.Flight;
import com.ironhack.labjpa.model.FlightBooking;
import com.ironhack.labjpa.model.enums.CustomerStatus;
import com.ironhack.labjpa.repository.CustomerRepository;
import com.ironhack.labjpa.repository.FlightBookingRepository;
import com.ironhack.labjpa.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("data-loader")
@SpringBootApplication
public class DataLoader {
    public static void main(String[] args) {
        SpringApplication.run(DataLoader.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo,
                          FlightRepository flightRepo,
                          FlightBookingRepository bookingRepo) {
        return args -> {
            Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Customer bob = customerRepo.save(new Customer("Bob", CustomerStatus.SILVER, 90000));
            Customer charlie = customerRepo.save(new Customer("Charlie", CustomerStatus.NONE, 40000));

            Flight flight1 = flightRepo.save(new Flight("AB123", "Boeing 747", 400));
            Flight flight2 = flightRepo.save(new Flight("XY456", "Airbus A320", 300));
            Flight flight3 = flightRepo.save(new Flight("CD789", "Boeing 777", 500));

            bookingRepo.save(new FlightBooking(alice.getId(), flight1.getFlightId()));
            bookingRepo.save(new FlightBooking(bob.getId(), flight2.getFlightId()));
            bookingRepo.save(new FlightBooking(charlie.getId(), flight3.getFlightId()));
        };
    }
}
