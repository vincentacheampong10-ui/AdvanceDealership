package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("vehicle.csv"))) {
            String line = reader.readLine(); // first line = dealership info

            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];
                dealership = new Dealership(name, address, phone);
            }
            // Read remaining lines = vehicles
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    double price = Double.parseDouble(parts[5]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, price);
                    dealership.addVehicle(vehicle);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  // Shows the error type and where it happened
        }
        return dealership;
    }
}
