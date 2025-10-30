package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Dealership() {

    }

    public List<Vehicle> getVehiclesByPrice( double min , double max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make,String model) {

    }
    public List<Vehicle> getVehiclesByYear() {

    }
    public List<Vehicle> getVehiclesByColor() {

    }
    public List<Vehicle> getVehiclesByMileage() {

    }
    public List<Vehicle> getVehiclesByType() {

    }
    public List<Vehicle> getAllVehicles() {

    }

    public void addVehicle(Vehicle vehicle) {

    }
    public void removeVehicle(vehicle vehicle) {

    }
}
