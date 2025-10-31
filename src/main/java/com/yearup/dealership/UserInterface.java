package com.yearup.dealership;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {

        System.out.println("Dealership App");

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== DEALERSHIP MENU =====");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice:");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    findVehiclesByPrice();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "99":
                    System.out.println("Exiting... Saving changes to file.");

                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Option 1: Price range
    private void findVehiclesByPrice() {
        try {
            System.out.print("Enter minimum price:$");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter maximum price:$");
            double max = Double.parseDouble(scanner.nextLine());


            List<Vehicle> results = new ArrayList<>();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                    results.add(vehicle);
                }
            }

            displayVehicles(results);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("--- No vehicles found ---");
            return;
        }

        System.out.println("\n--- Found " + vehicleList.size() + " vehicle(s) ---");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
            System.out.println("-----------------------------");
        }
    }
}






