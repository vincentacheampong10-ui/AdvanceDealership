package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ContractDataManager {

    private static final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
            Vehicle vehicle = contract.getVehicleSold();


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(contract.getContractDate().format(formatter)).append("|");
            stringBuilder.append(contract.getCustomerName()).append("|");
            stringBuilder.append(contract.getCustomerEmail()).append("|");
            stringBuilder.append(vehicle.getVin()).append("|");
            stringBuilder.append(vehicle.getYear()).append("|");
            stringBuilder.append(vehicle.getMake()).append("|");
            stringBuilder.append(vehicle.getModel()).append("|");
            stringBuilder.append(vehicle.getVehicleType()).append("|");
            stringBuilder.append(vehicle.getColor()).append("|");
            stringBuilder.append(vehicle.getOdometer()).append("|");
            stringBuilder.append(vehicle.getPrice()).append("|");

            // Use instanceof to determine contract type
            if (contract instanceof SalesContract) {
                SalesContract sale = (SalesContract) contract;
                stringBuilder.append("SALE=");
                stringBuilder.append(sale.getSalesTaxAmount()).append("|");
                stringBuilder.append(sale.getRecordingFee()).append("|");
                stringBuilder.append(sale.getProcessingFee()).append("|");
                stringBuilder.append(sale.isFinanceOption()).append("|");
                stringBuilder.append(sale.getTotalPrice()).append("|");
                stringBuilder.append(String.format("%.2f", sale.getMonthlyPayment()));

            } else if (contract instanceof LeaseContract) {
                LeaseContract lease = (LeaseContract) contract;
                stringBuilder.append("LEASE=");
                stringBuilder.append(lease.getExpectedEndingValue()).append("|");
                stringBuilder.append(lease.getLeaseFee()).append("|");
                stringBuilder.append(lease.getTotalPrice()).append("|");
                stringBuilder.append(String.format("%.2f", lease.getMonthlyPayment()));
            }

            writer.write(stringBuilder.toString());
            writer.newLine();
            System.out.println(" Contract saved successfully.");

        } catch (IOException e) {
            System.out.println(" ERROR: Could not save contract to file.");
            e.printStackTrace();
        }
    }
}
