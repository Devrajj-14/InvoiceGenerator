package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    @Test
    void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        double fare = generator.calculateFare(2.0, 5);
        assertEquals(25.0, fare, 0.0001);
    }

    @Test
    void givenSmallRide_shouldReturnMinimumFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        double fare = generator.calculateFare(0.1, 0);
        assertEquals(5.0, fare, 0.0001);
    }

    @Test
    void negativeDistance_shouldThrow() {
        InvoiceGenerator generator = new InvoiceGenerator();
        assertThrows(IllegalArgumentException.class, () -> generator.calculateFare(-1.0, 5));
    }

    @Test
    void negativeTime_shouldThrow() {
        InvoiceGenerator generator = new InvoiceGenerator();
        assertThrows(IllegalArgumentException.class, () -> generator.calculateFare(1.0, -5));
    }
    @Test
    void givenMultipleRides_shouldReturnAggregateFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 0)
        };
        double total = generator.calculateFare(rides);
        // First ride = 25, second ride = min 5 => total 30
        assertEquals(30.0, total, 0.0001);
    }
}