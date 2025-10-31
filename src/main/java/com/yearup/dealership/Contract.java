package com.yearup.dealership;

import java.time.LocalDate;

public class Contract {
    private LocalDate contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(LocalDate contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    // Abstract methods - must be implemented by subclasses
//    public abstract double getTotalPrice();
//    public abstract double getMonthlyPayment();

    @Override
    public String toString() {
        return "Contract{" +
                "Date=" + contractDate +
                ", Name='" + customerName + '\'' +
                ", Email='" + customerEmail + '\'' +
                ", Vehicle=" + vehicleSold +
                '}';
    }
}