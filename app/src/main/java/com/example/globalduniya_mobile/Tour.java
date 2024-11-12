package com.example.globalduniya_mobile;

public class Tour {
    private String name;
    private String description;
    private double price;
    private int imageResId;
    private String longDescription; // For detailed view

    public Tour(String name, String description, double price, int imageResId, String longDescription) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getLongDescription() {
        return longDescription;
    }
}
