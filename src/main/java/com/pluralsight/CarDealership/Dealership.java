package com.pluralsight.CarDealership;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String phone, String address, String name) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getPrice() >= min && v.getPrice() <= max) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getYear() >= min && v.getYear() <= max) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getColor().equalsIgnoreCase(color)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getOdometer() >= min && v.getOdometer() <= max) {
                matches.add(v);
            }
        }
        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for(Vehicle v : inventory) {
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager.saveDealership(this, "files/dealership.csv");
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
        DealershipFileManager.saveDealership(this, "files/dealership.csv");
    }
}
