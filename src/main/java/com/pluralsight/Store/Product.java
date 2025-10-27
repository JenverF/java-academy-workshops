package com.pluralsight.Store;

import java.time.LocalDate;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String department;
    private LocalDate releaseDate;

    public Product(String sku, String name, double price, String department, LocalDate releaseDate) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return sku + "|" + name + "|" + price + "|" + department + "|" + releaseDate;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

}