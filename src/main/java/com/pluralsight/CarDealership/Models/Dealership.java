package com.pluralsight.CarDealership.Models;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
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

}
