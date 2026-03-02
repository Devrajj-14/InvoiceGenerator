package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceServiceTest {

    @Test
    void givenUserId_shouldReturnInvoiceFromRepositoryRides() {
        RideRepository stubRepo = userId -> new Ride[]{
                new Ride(2.0, 5),  // 25
                new Ride(0.1, 0)   // 5
        };

        InvoiceService service = new InvoiceService(stubRepo);
        InvoiceSummary summary = service.getInvoice("user-1");

        assertEquals(2, summary.totalRides);
        assertEquals(30.0, summary.totalFare, 0.0001);
        assertEquals(15.0, summary.averageFarePerRide, 0.0001);
    }

    @Test
    void emptyUserId_shouldThrow() {
        RideRepository stubRepo = userId -> new Ride[]{ new Ride(1.0, 1) };
        InvoiceService service = new InvoiceService(stubRepo);

        assertThrows(IllegalArgumentException.class, () -> service.getInvoice(" "));
    }
}