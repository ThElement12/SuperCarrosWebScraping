package org.joseph.utils;

import com.sun.source.tree.Tree;
import org.joseph.scrapingObjects.Car;

import java.util.*;

import static org.joseph.utils.DataParser.calculateAverage;

public class WebScraping {
    private final List<Car> listCars;
    private final Map<Integer, Map<String, List<Float>>> carsByYearByTrim;

    public WebScraping(){
        listCars = new ArrayList<Car>();
        carsByYearByTrim = new TreeMap<>();
    }
    public void addCar(Car car){
        listCars.add(car);

        carsByYearByTrim.putIfAbsent(car.getYear(), new HashMap<>());
        Map<String, List<Float>> innerMap = carsByYearByTrim.get(car.getYear());
        innerMap.putIfAbsent(car.getTrim(), new ArrayList<>());
        innerMap.get(car.getTrim()).add(car.getPrice());
    }
    public void printMap(){
        for (Map.Entry<Integer, Map<String, List<Float>>> yearEntry : carsByYearByTrim.entrySet()) {
            System.out.println("Year: " + yearEntry.getKey());
            Map<String, List<Float>> innerMap = yearEntry.getValue();
            for (Map.Entry<String, List<Float>> innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + ": " + calculateAverage(innerEntry.getValue()));
            }
        }
    }
}
