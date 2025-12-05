package com.pluralsight.CarDealership.User;

import java.util.Scanner;

public class VehicleInput {
    static Scanner scanner = new Scanner(System.in);

    public static double searchbyPrice(){
        String input = ("What is the minimum price you'd like to search for?");
        System.out.println(input);
        return Double.parseDouble(scanner.nextLine());
    }

    public static double searchbyPrice2(){
        String input = ("What is the maximum price you'd like to search for?");
        System.out.println(input);
        return Double.parseDouble(scanner.nextLine());
    }

    public static String searchbyMake(){
        String input = ("What is the make of the vehicle you'd like to search for?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static String searchbyModel(){
        String input = ("What is the model of the vehicle you'd like to search for?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static int searchbyYear(){
        String input = ("What is the minimum year you'd like to search for?");
        System.out.println(input);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int searchbyYear2(){
        String input = ("What is the maximum year you'd like to search for?");
        System.out.println(input);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String searchbyColor(){
        String input = ("What is the color of the vehicle you'd like to search for?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static String addVehicleVin(){
        String input = ("What is the VIN of the car you wish to add?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static String addVehicleMake(){
        String input = ("What is the make of the car you wish to add?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static String addVehicleModel(){
        String input = ("What is the model of the car you wish to add?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static int addVehicleYear(){
        String input = ("What is the year of the car you wish to add?");
        System.out.println(input);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String addVehicleColor(){
        String input = ("What is the color of the car you wish to add?");
        System.out.println(input);
        return scanner.nextLine();
    }

    public static double addVehiclePrice(){
        String input = ("What is the price of the car you wish to add?");
        System.out.println(input);
        return Double.parseDouble(scanner.nextLine());
    }

    public static String deleteVehicle(){
        String input = ("What is the vin of the car you wish to delete from your cart?");
        System.out.println(input);
        return scanner.nextLine();
    }
}
