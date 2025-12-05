package com.pluralsight.CarDealership.Daos;

import com.pluralsight.CarDealership.Models.Vehicle;
import com.pluralsight.CarDealership.User.VehicleInput;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static List<Vehicle> searchByPriceRange() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;")
        ) {

            preparedStatement.setDouble(1, VehicleInput.searchbyPrice());
            preparedStatement.setDouble(2, VehicleInput.searchbyPrice2());

            try(ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    String vin = resultSet.getString("VIN");
                    String color = resultSet.getString("color");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    double price = resultSet.getDouble("price");
                    int year = resultSet.getInt("year");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, price);
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> searchByMake() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE make = ? AND model = ?;")) {

            preparedStatement.setString(1, VehicleInput.searchbyMake());
            preparedStatement.setString(2, VehicleInput.searchbyModel());

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    String vin = resultSet.getString("VIN");
                    String color = resultSet.getString("color");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    double price = resultSet.getDouble("price");
                    int year = resultSet.getInt("year");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, price);
                    vehicles.add(vehicle);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> searchByYearRange() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE year BETWEEN ? AND ?;")) {

            preparedStatement.setInt(1, VehicleInput.searchbyYear());
            preparedStatement.setInt(2, VehicleInput.searchbyYear2());

            try(ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    String vin = resultSet.getString("VIN");
                    String color = resultSet.getString("color");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    double price = resultSet.getDouble("price");
                    int year = resultSet.getInt("year");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, price);
                    vehicles.add(vehicle);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static List<Vehicle> searchByColor() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE color = ?;")) {

            preparedStatement.setString(1, VehicleInput.searchbyColor());

            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String vin = resultSet.getString("VIN");
                    String color = resultSet.getString("color");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    double price = resultSet.getDouble("price");
                    int year = resultSet.getInt("year");

                    Vehicle vehicle = new Vehicle(vin, year, make, model, color, price);
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static void vehicleAdd() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles (VIN, make, model, year, color, price) VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, VehicleInput.addVehicleVin());
            preparedStatement.setString(2, VehicleInput.addVehicleMake());
            preparedStatement.setString(3, VehicleInput.addVehicleModel());
            preparedStatement.setInt(4, VehicleInput.addVehicleYear());
            preparedStatement.setString(5, VehicleInput.addVehicleColor());
            preparedStatement.setDouble(6, VehicleInput.addVehiclePrice());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void vehicleDelete() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE VIN = ?;")) {

            preparedStatement.setString(1, VehicleInput.deleteVehicle());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
