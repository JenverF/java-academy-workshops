package com.pluralsight.CarDealership.User;

import com.pluralsight.CarDealership.Daos.VehicleDao;
import com.pluralsight.CarDealership.Models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.CarDealership.Daos.VehicleDao.*;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static VehicleDao vehicleDao;

    static void main(String[] args) {
        init(args[0], args[1]);
        runHomeScreen();
    }

    private static void init(String username, String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealership");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        vehicleDao = new VehicleDao(dataSource);
    }

    public static void runHomeScreen() {
        String options = """
                ============================
                What do you want to do?
                    1) Search by Price Range
                    2) Search by Make and Model
                    3) Search by Year Range
                    4) Search by Color
                    5) Add a vehicle
                    6) Remove a vehicle
                    0) End program
                Select an option:
                ============================
                """;

        boolean programRunning = true;
        while(programRunning) {
            System.out.println(options);
            int chosenOption = Integer.parseInt(scanner.nextLine());

            programRunning = handleUserChoice(chosenOption);
        }
    }

    public static boolean handleUserChoice(int choice) {
        switch(choice) {
            case 1:
                displayVehicle(searchByPriceRange());
                break;
            case 2:
                displayVehicle(searchByMake());
                break;
            case 3:
                displayVehicle(searchByYearRange());
                break;
            case 4:
                displayVehicle(searchByColor());
                break;
            case 5:
                VehicleDao.vehicleAdd();
                break;
            case 6:
                VehicleDao.vehicleDelete();
                break;
            case 0:
                return false;
            default:
                System.out.println("Sorry I don't know that option. Please try again.");
                break;
        }
        return true;
    }

    public static void displayVehicle(List<Vehicle> vehicles) {
        for(Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

}