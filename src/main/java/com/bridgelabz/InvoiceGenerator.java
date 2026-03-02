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
}