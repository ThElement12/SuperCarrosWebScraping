package org.joseph.utils;

import org.joseph.scrapingObjects.Car;

import java.util.ArrayList;
import java.util.List;

public class WebScraping {
    private List<Car> listCars;

    public WebScraping(){
        listCars = new ArrayList<Car>();
    }
    public void addCar(Car car){
        listCars.add(car);
    }
    public List<Car> getAllCars(){
        return listCars;
    }
    public void printAll(){
        for(Car car: listCars){
            System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getTrim() + " " + car.getYear() + " Cuesta: " + car.getPrice());        }
    }
}
