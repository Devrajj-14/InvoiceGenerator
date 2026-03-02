package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    public final int totalRides;
    public final double totalFare;
    public final double averageFarePerRide;

    public InvoiceSummary(int totalRides, double totalFare) {
        if (totalRides <= 0) throw new IllegalArgumentException("Total rides must be > 0");
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = totalFare / totalRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return totalRides == that.totalRides
                && Math.abs(totalFare - that.totalFare) < 0.0001
                && Math.abs(averageFarePerRide - that.averageFarePerRide) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, averageFarePerRide);
    }
}