package org.joseph.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.joseph.stepDefinitions.Hooks.driver;

public class LandingPage {
    public static WebElement buscaTuCarroLabel(){
        return driver.findElement(new By.ByXPath("//span[contains(text(), \"Busca\")]"));
    }
    public static WebElement brandSelect(){
        return driver.findElement(new By.ById("Brand"));
    }
    public static WebElement modelSelect(){
        return driver.findElement(new By.ById("Model"));
    }
    public static WebElement locationSelect(){
        return driver.findElement(new By.ById("Location"));
    }
    public static WebElement searchButton(){
        return driver.findElement(new By.ById("DoSearch"));
    }
}
