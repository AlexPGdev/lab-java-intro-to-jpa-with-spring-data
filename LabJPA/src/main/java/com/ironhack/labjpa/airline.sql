CREATE DATABASE airline;

USE airline;

CREATE TABLE customers (
                           customer_id INT PRIMARY KEY AUTO_INCREMENT,
                           customer_name VARCHAR(255),
                           customer_status VARCHAR(255),
                           total_customer_mileage INT
);

CREATE TABLE aircrafts (
                           aircraft_id INT PRIMARY KEY AUTO_INCREMENT,
                           aircraft VARCHAR(255) ,
                           total_aircraft_seats INT
);

CREATE TABLE flights (
                         flight_id INT PRIMARY KEY AUTO_INCREMENT,
                         flight_number VARCHAR(255),
                         aircraft_id INT,
                         flight_mileage INT,
                         FOREIGN KEY (aircraft_id) REFERENCES aircrafts(aircraft_id)
);

CREATE TABLE bookings (
                          booking_id INT PRIMARY KEY AUTO_INCREMENT,
                          customer_id INT,
                          flight_id INT,
                          FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                          FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
);

INSERT INTO customer (customer_name, customer_status, total_customer_mileage)
VALUES
    ('Agustine Riviera', 'Silver', 115235),
    ('Alaina Sepulvida', 'None', 6008),
    ('Tom Jones', 'Gold', 205767),
    ('Sam Rio', 'None', 2653),
    ('Jessica James', 'Silver', 127656),
    ('Ana Janco', 'Silver', 136773),
    ('Jennifer Cortez', 'Gold', 300582),
    ('Christian Janco', 'Silver', 14642);

INSERT INTO aircrafts (aircraft, total_aircraft_seats)
VALUES
    ('Boeing 747', 400),
    ('Airbus A330', 236),
    ('Boeing 777', 264);


INSERT INTO flight (flight_number, aircraft_id, flight_mileage)
VALUES
    ('DL143', 1, 135),
    ('DL122', 2, 4370),
    ('DL53', 3, 2078),
    ('DL222', 2, 1765),
    ('DL37', 1, 531);

INSERT INTO booking (customer_id, flight_id)
VALUES
    (1, 11),
    (1, 12),
    (2, 12),
    (3, 12),
    (3, 13),
    (3, 14),
    (4, 11),
    (4, 15),
    (5, 11),
    (5, 12),
    (6, 14),
    (7, 14),
    (8, 14);


SELECT COUNT(DISTINCT flight_number) FROM flight;
SELECT AVG(flight_mileage) FROM flight;
SELECT AVG(aircrafts.total_aircraft_seats) FROM aircrafts;
SELECT customer_status, AVG(total_customer_mileage) FROM customer GROUP BY customer_status;
SELECT customer_status, MAX(total_customer_mileage) FROM customer GROUP BY customer_status;
SELECT COUNT(*) FROM aircrafts WHERE aircraft LIKE '%Boeing%';
SELECT * FROM flight WHERE flight_mileage BETWEEN 300 AND 2000;

SELECT c.customer_status, AVG(f.flight_mileage)
FROM booking b
         JOIN customer c ON b.customer_id = c.customer_id
         JOIN flight f ON b.flight_id = f.flight_id
GROUP BY c.customer_status;

SELECT a.aircraft, COUNT(*) AS total_bookings
FROM booking b
         JOIN customer c ON b.customer_id = c.customer_id
         JOIN flight f ON b.flight_id = f.flight_id
         JOIN aircrafts a ON f.aircraft_id = a.aircraft_id
WHERE c.customer_status = 'Gold'
GROUP BY a.aircraft
ORDER BY total_bookings DESC
LIMIT 1;