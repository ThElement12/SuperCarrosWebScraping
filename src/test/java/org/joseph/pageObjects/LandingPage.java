package org.joseph.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.joseph.stepDefinitions.Hooks.driver;

public class LandingPage {
    public static WebElement buscaTuCarroLabel(){
        return driver.findElement(new By.ByXPath("//span[contains(text(), \"Busca\")]"));
    }
}
