package com.yearup.dealership;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private double expectedEndingValue;   // 50% of the original price
    private double leaseFee;              // 7% of the original price


    public LeaseContract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);

        double price = vehicleSold.getPrice();

        /// Calculate expected ending value and lease fee
        this.expectedEndingValue = price * 0.5; /// Vehicle loses 50% value
        this.leaseFee = price * 0.07;          /// 7% leasing fee
    }


    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    /// Calculate total price of the lease (depreciation + lease fee)
    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        return leaseFee + (price - expectedEndingValue);
    }

    // Calculate monthly payment
    @Override
    public double getMonthlyPayment() {
        double totalLeaseCost = getTotalPrice();
        int months = 36;
        double annualRate = 0.04;      // 4% annual interest
        double monthlyRate = annualRate / 12;

        // Monthly payment formula: (r * P) / (1 - (1 + r)^-n)
        double denominator = 1 - Math.pow(1 + monthlyRate, -months);
        double monthlyPayment = (monthlyRate * totalLeaseCost) / denominator;

        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "Total Price=" + String.format("%.2f", getTotalPrice()) +
                ", Monthly Payment=" + String.format("%.2f", getMonthlyPayment()) +
                '}';
    }
}