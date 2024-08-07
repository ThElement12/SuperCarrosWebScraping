package org.joseph.scrapingObjects;

import static org.joseph.utils.DataParser.convertPrice;
import static org.joseph.utils.DataParser.trimMaker;

public class Car {
    private final String brand;
    private final String model;
    private final String trim;
    private final int year;
    private final float price;
    public Car(String name, int year, String price){
        String[] splittedName = name.split("\\s+");
        this.brand = splittedName[0];
        this.model = splittedName[1];
        this.trim = trimMaker(splittedName);
        this.year = year;
        this.price = convertPrice(price);
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getTrim() {
        return trim;
    }
    public int getYear() {
        return year;
    }
    public float getPrice() {
        return price;
    }
}
