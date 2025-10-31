package com.yearup.dealership;


import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);


    public void display() {

        System.out.println("Dealership App");

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        this.dealership = new Dealership(
                "Year Up Motors",
                "123 Main St, Columbus, OH",
                "614-555-1212"
        );

        // Add 10 vehicles to the dealership's inventory
        dealership.addVehicle(new Vehicle(1001, 2020, "Toyota", "Camry", "Sedan", "Silver", 32000, 18995.00));
        dealership.addVehicle(new Vehicle(1002, 2019, "Honda", "Civic", "Sedan", "Blue", 45000, 15995.00));
        dealership.addVehicle(new Vehicle(1003, 2021, "Ford", "F-150", "Truck", "Red", 25000, 29995.00));
        dealership.addVehicle(new Vehicle(1004, 2018, "Chevrolet", "Equinox", "SUV", "White", 60000, 17495.00));
        dealership.addVehicle(new Vehicle(1005, 2022, "Tesla", "Model 3", "Sedan", "Black", 12000, 35995.00));
        dealership.addVehicle(new Vehicle(1006, 2017, "Subaru", "Outback", "Wagon", "Green", 78000, 13995.00));
        dealership.addVehicle(new Vehicle(1007, 2020, "Jeep", "Wrangler", "SUV", "Orange", 31000, 28995.00));
        dealership.addVehicle(new Vehicle(1008, 2019, "BMW", "X5", "SUV", "Gray", 50000, 33995.00));
        dealership.addVehicle(new Vehicle(1009, 2021, "Hyundai", "Elantra", "Sedan", "White", 18000, 17995.00));
        dealership.addVehicle(new Vehicle(1010, 2018, "Nissan", "Altima", "Sedan", "Blue", 67000, 13995.00));


        // Print all vehicles in the inventory
        System.out.println("Inventory for " + dealership.getAllVehicles().size() + " vehicles at " + dealership.getAllVehicles());
        System.out.println("Dealership Inventory:\n");

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
            System.out.println("---------------------------");
        }
    }
}




