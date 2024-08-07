package org.joseph.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.joseph.stepDefinitions.Hooks.driver;

public class SearchResultPage {
    static WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(60));

    public static List<WebElement> resultsObjects(){
        return driver.findElements(By.cssSelector("#bigsearch-results-inner-results ul .normal"));
    }
    public static WebElement priceLbl(WebElement parent){
        WebElement priceElement = parent.findElement(new By.ByClassName("price"));
        wait.until(ExpectedConditions.visibilityOf(priceElement));
        return priceElement;
    }
    public static WebElement nameLbl(WebElement parent){
        WebElement nameElement = parent.findElement(new By.ByCssSelector(".title1"));
        wait.until(ExpectedConditions.visibilityOf(nameElement));
        return nameElement;
    }
    public static WebElement yearLbl(WebElement parent){
        
        WebElement yearElement = parent.findElement(new By.ByCssSelector(".title2"));
        wait.until(ExpectedConditions.visibilityOf(yearElement));
        return yearElement;
    }
    public static List<WebElement> nextButton(){
        return driver.findElements(By.xpath("//a[contains(text(), \"»\")]"));
    }
}
