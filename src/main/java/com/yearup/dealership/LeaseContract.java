package com.yearup.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leasingFee;

    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5; // vehicle expected to lose 50% value
        this.leasingFee = vehicleSold.getPrice() * 0.07; // 7% leasing fee
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + leasingFee;
    }

    @Override
    public double getMonthlyPayment() {
        double depreciation = getVehicleSold().getPrice() - expectedEndingValue;
        double totalLeaseCost = depreciation + leasingFee;
        int months = 36;
        return totalLeaseCost / months;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "Total Price=" + String.format("%.2f", getTotalPrice()) +
                ", Monthly Payment=" + String.format("%.2f", getMonthlyPayment()) +
                '}';
    }
}
