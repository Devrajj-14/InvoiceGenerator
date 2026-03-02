package com.bridgelabz;

public class InvoiceGenerator {

    public static final double COST_PER_KM_NORMAL = 10.0;
    public static final int COST_PER_MIN_NORMAL = 1;
    public static final double MIN_FARE_NORMAL = 5.0;

    public double calculateFare(double distanceKm, int timeMin) {
        if (distanceKm < 0) throw new IllegalArgumentException("Distance cannot be negative");
        if (timeMin < 0) throw new IllegalArgumentException("Time cannot be negative");

        double fare = distanceKm * COST_PER_KM_NORMAL + timeMin * COST_PER_MIN_NORMAL;
        return Math.max(fare, MIN_FARE_NORMAL);
    }
    public double calculateFare(Ride[] rides) {
        if (rides == null) throw new IllegalArgumentException("Rides cannot be null");
        double total = 0.0;
        for (Ride ride : rides) {
            total += calculateFare(ride);
        }
        return total;
    }
    public InvoiceSummary calculateInvoice(Ride[] rides) {
        if (rides == null) throw new IllegalArgumentException("Rides cannot be null");
        if (rides.length == 0) throw new IllegalArgumentException("At least one ride is required");

        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }
    public static final double COST_PER_KM_PREMIUM = 15.0;
    public static final int COST_PER_MIN_PREMIUM = 2;
    public static final double MIN_FARE_PREMIUM = 20.0;
    public double calculateFare(Ride ride) {
        if (ride == null) throw new IllegalArgumentException("Ride cannot be null");
        if (ride.distanceKm < 0) throw new IllegalArgumentException("Distance cannot be negative");
        if (ride.timeMin < 0) throw new IllegalArgumentException("Time cannot be negative");

        if (ride.category == RideCategory.PREMIUM) {
            double fare = ride.distanceKm * COST_PER_KM_PREMIUM + ride.timeMin * COST_PER_MIN_PREMIUM;
            return Math.max(fare, MIN_FARE_PREMIUM);
        } else {
            return calculateFare(ride.distanceKm, ride.timeMin);
        }
    }
}