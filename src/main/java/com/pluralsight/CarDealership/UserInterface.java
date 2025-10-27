package com.pluralsight.CarDealership;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        while(true) {
            System.out.println("""
                    Welcome! Please choose an option:
                        1 - Find vehicles within a price range
                        2 - Find vehicles by make / model
                        3 - Find vehicles by year range
                        4 - Find vehicles by color
                        5 - Find vehicles by mileage range
                        6 - Find vehicles by type (car, truck, SUV, van)
                        7 - List ALL vehicles
                        8 - Add a vehicle
                        9 - Remove a vehicle
                        99 - Quit
                    Enter your choice:""");
            String choice = scanner.nextLine().toUpperCase().trim();
            switch (choice) {
                case "1":
                    processGetByPrice();
                    break;
                case "2":
                    processGetByMakeModel();
                    break;
                case "3":
                    processGetByYear();
                    break;
                case "4":
                    processGetByColor();
                    break;
                case "5":
                    processGetByMileage();
                    break;
                case "6":
                    processGetByType();
                    break;
                case "7":
                    processListAll();
                    break;
                case "8":
                    processAddVehicle();
                    break;
                case "9":
                    processRemoveVehicle();
                    break;
                case "99":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("That's not an option!");
                    break;
            }
        }
    }

    private void processGetByPrice() {
        System.out.print("Enter min price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter max price: ");
        double max = Double.parseDouble(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);
    }

    private void processGetByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);
    }

    private void processGetByYear() {
        System.out.print("Enter min year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter max year: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehiclesByYear(min, max);
        displayVehicles(results);
    }

    private void processGetByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    private void processGetByMileage() {
        System.out.print("Enter min mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter max mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        displayVehicles(results);
    }

    private void processGetByType() {
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByType(type);
        displayVehicles(results);
    }

    private void processListAll() {
        ArrayList<Vehicle> all = dealership.getAllVehicles();
        displayVehicles(all);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
    private void processAddVehicle() {
        // Prompt user for vehicle details and add a new vehicle to the dealership
        System.out.println("Enter the vehicle details: ");
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type (Car, Truck, SUV, Van): ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicle() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicleToRemove = v;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle not found!");
        }
    }
}