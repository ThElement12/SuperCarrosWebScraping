package org.joseph.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.joseph.stepDefinitions.Hooks.driver;

public class SearchResultPage {
    public static List<WebElement> resultsObjects(){
        return driver.findElements(By.cssSelector("#bigsearch-results-inner-results ul .normal"));
    }
}
