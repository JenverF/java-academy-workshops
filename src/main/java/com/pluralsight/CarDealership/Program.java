package com.pluralsight.CarDealership;

public class Program {
    static void main() {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();

        UserInterface ui = new UserInterface(dealership);
        ui.display();
    }
}
