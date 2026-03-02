package com.bridgelabz;

public class Ride {
    public final double distanceKm;
    public final int timeMin;
    public final RideCategory category;

    public Ride(double distanceKm, int timeMin) {
        this(distanceKm, timeMin, RideCategory.NORMAL);
    }

    public Ride(double distanceKm, int timeMin, RideCategory category) {
        if (category == null) throw new IllegalArgumentException("Ride category cannot be null");
        this.distanceKm = distanceKm;
        this.timeMin = timeMin;
        this.category = category;
    }
}