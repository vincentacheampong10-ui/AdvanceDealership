package com.yearup.dealership;


import java.time.LocalDate;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee = 100.00;
    private double processingFee;
    private boolean financeOption; // true = financed, false = cash
    private double monthlyPayment;

    // Constructor
    public SalesContract(LocalDate contractDate, String customerName, String customerEmail,
                         Vehicle vehicleSold, boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;

        // Compute fixed values
        double price = vehicleSold.getPrice();
        this.salesTaxAmount = price * 0.05; // 5%
        this.processingFee = (price < 10000) ? 295 : 495;
    }

    // Getters and setters
    public double getSalesTaxAmount() { return salesTaxAmount; }
    public void setSalesTaxAmount(double salesTaxAmount) { this.salesTaxAmount = salesTaxAmount; }

    public double getRecordingFee() { return recordingFee; }
    public void setRecordingFee(double recordingFee) { this.recordingFee = recordingFee; }

    public double getProcessingFee() { return processingFee; }
    public void setProcessingFee(double processingFee) { this.processingFee = processingFee; }

    public boolean isFinanceOption() { return financeOption; }
    public void setFinanceOption(boolean financeOption) { this.financeOption = financeOption; }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        return price + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) {
            return 0.0; // No financing
        }

        double price = getTotalPrice();
        double rate;
        int months;

        if (price >= 10000) {
            rate = 0.0425 / 12; // All loans are at 4.25% for 48 months if the price is $10,000 or more
            months = 48;
        } else {
            rate = 0.0525 / 12; // Otherwise all loans are at 5.25% for 24 month
            months = 24;
        }

        // Monthly payment formula: (r * P) / (1 - (1 + r)^-n)
        double monthly = (rate * price) / (1 - Math.pow(1 + rate, -months));
        this.monthlyPayment = monthly;
        return monthly;
    }
}