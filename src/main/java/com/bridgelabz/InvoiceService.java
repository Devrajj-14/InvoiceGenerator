package com.bridgelabz;

public class InvoiceService {

    private final RideRepository repository;
    private final InvoiceGenerator generator;

    public InvoiceService(RideRepository repository) {
        if (repository == null) throw new IllegalArgumentException("Repository cannot be null");
        this.repository = repository;
        this.generator = new InvoiceGenerator();
    }

    public InvoiceSummary getInvoice(String userId) {
        if (userId == null || userId.trim().isEmpty())
            throw new IllegalArgumentException("UserId cannot be empty");

        Ride[] rides = repository.getRides(userId);
        if (rides == null || rides.length == 0)
            throw new IllegalArgumentException("No rides found for user");

        return generator.calculateInvoice(rides);
    }
}