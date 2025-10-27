package com.pluralsight.CarDealership;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;

        try{
            BufferedReader br = new BufferedReader(new FileReader("files/inventory.csv"));

            String dealershipString = br.readLine();
            String[] parts = dealershipString.split("\\|");

            dealership = new Dealership(parts[0], parts[1], parts[2]);

            String vehicleString;
            while((vehicleString = br.readLine()) != null) {
                String[] vehicleParts = vehicleString.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("files/inventory.csv"));
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();

            for(Vehicle v : dealership.getAllVehicles()) {
                bw.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());;
        }
    }
}
