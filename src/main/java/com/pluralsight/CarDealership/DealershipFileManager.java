package com.pluralsight.CarDealership;

import java.io.*;

public class DealershipFileManager {
    public static Dealership getDealership(String fileName) {
        Dealership dealership = null;

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // create dealership object
            String[] dealershipArr = br.readLine().split("\\|");
            dealership = new Dealership(dealershipArr[0], dealershipArr[1], dealershipArr[2]);
            String line = null;
            // loop through other lines and set inventory
            while((line = br.readLine()) != null) {
                if(line.isEmpty()) {
                    continue;
                }
                String[] vehicleArr = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleArr[0]), Integer.parseInt(vehicleArr[1]), vehicleArr[2], vehicleArr[3], vehicleArr[4], vehicleArr[5], Integer.parseInt(vehicleArr[6]), Double.parseDouble(vehicleArr[7]));
                dealership.addVehicle(vehicle);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership, String fileName) {
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
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
