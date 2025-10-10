package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineStore {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = ProductManager.loadProductsFromFile("files/Products.csv");
    static List<Product> cart = new ArrayList<>();

    static void main() {
        boolean endProgram = false;
        while(!endProgram) {
            endProgram = displayHomeScreen();
        }
    }

    // home screen
    // returns true to end program, returns false to repeat
    public static boolean displayHomeScreen() {
        String options = """
                1) Display products
                2) Display cart
                3) Exit out of the application
                """;
        switch (getNumericChoice(options)) {
            case 1:
                displayProductScreen();
                break;
            case 2:
                displayCartScreen();
                break;
            case 3:
                return true;
            default:
                System.out.println("That's not an option.");
                break;
        }
        return false;
    }

    // display products screen
    public static void displayProductScreen() {
        System.out.println("Here are all the products:");
        ProductManager.displayProducts(products);
        String options = """
                1) Search or filter
                2) Add to cart
                3) Go back to home page
                """;

        switch(getNumericChoice(options)) {
            case 1:
                searchOrFilter();
                break;
            case 2:
                addToCart();
                break;
            case 3:
                return;
            default:
                System.out.println("That is not an option.");
                break;
        }
    }

    // display cart screen
    public static void displayCartScreen() {
        System.out.println("Here's your cart:");
        ProductManager.displayProducts(cart);

        String options = """
                1) Check out
                2) Remove product from cart
                3) Go back to home screen
                """;

        switch (getNumericChoice(options)) {
            case 1:
                System.out.println("Checking out your cart...");
                cart.clear();
                break;
            case 2:
                removeProductFromCart();;
                break;
            case 3:
                System.out.println("Returning to home screen...");
                return;
        }
    }

    public static void removeProductFromCart(){
        System.out.println("What product do you want to remove? Enter SKU:");
        String sku = scanner.nextLine();
        Product productToBeRemoved = ProductManager.getProductBySku(cart, sku);
        if(productToBeRemoved != null) {
            cart.remove(productToBeRemoved);
            System.out.println("Product has been removed from cart.");
        } else {
            System.out.println("Product not found in cart");
        }
    }

    public static void searchOrFilter() {
        String options = """
                Do you want to search by:
                1) Name
                2) Price
                3) Department
                4) Released this month
                5) Released last month
                """;

        switch (getNumericChoice(options)) {
            case 1:
                System.out.println("What product name do you want to search for?");
                String nameToSearchFor = scanner.nextLine();
                List<Product> matchesByName = ProductManager.getProductsByName(products, nameToSearchFor);
                ProductManager.displayProducts(matchesByName);
                break;
            case 2:
                System.out.println("What is the minimum price?");
                double min = scanner.nextDouble();
                System.out.println("What is the maximum price?");
                double max = scanner.nextDouble();
                scanner.nextLine();
                List<Product> matchesByPrice = ProductManager.getProductsByPrice(products, min, max);
                ProductManager.displayProducts(matchesByPrice);
                break;
            case 3:
                System.out.println("What department do you want to search for?");
                String depToSearchFor = scanner.nextLine();
                List<Product> matchesByDep = ProductManager.getProductsByDepartment(products, depToSearchFor);
                ProductManager.displayProducts(matchesByDep);
                break;
            case 4:
                LocalDate today = LocalDate.now();
                LocalDate firstDayOfMonth = LocalDate.of(today.getYear(), today.getMonth(), 1);
                System.out.println(firstDayOfMonth);
                List<Product> productsThisMonth = ProductManager.getProductsByDateRange(products, firstDayOfMonth, today);
                ProductManager.displayProducts(productsThisMonth);
                break;
            case 5:
                LocalDate todayDate = LocalDate.now();
                LocalDate lastMonth = todayDate.minusMonths(1);
                LocalDate startLastMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonth(), 1);
                LocalDate endLastMonth = LocalDate.of(todayDate.getYear(), todayDate.getMonth(), 1).minusDays(1);
                List<Product> productsLastMonth = ProductManager.getProductsByDateRange(products, startLastMonth, endLastMonth);
                ProductManager.displayProducts(productsLastMonth);
                break;

        }

    }

    public static void addToCart() {
        System.out.println("What product sku do you want to add?");
        ProductManager.displayProducts(products);
        String sku = scanner.nextLine();
        Product product = ProductManager.getProductBySku(products, sku);
        if(product != null) {
            cart.add(product);
        }
    }

    public static int getNumericChoice(String options) {
        System.out.println(options);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
