package org.joseph.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.eo.Se;
import org.joseph.pageObjects.LandingPage;
import org.joseph.pageObjects.SearchResultPage;
import org.joseph.scrapingObjects.Car;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.joseph.stepDefinitions.Hooks.*;
import static org.joseph.utils.Helper.isElementPresentAndDisplayed;
import static org.joseph.utils.Helper.waitForPageLoad;

public class Steps {

    @Given("Open the SuperCarros URL")
    public void openURL(){
        driver.get("https://www.supercarros.com/");
        Assert.assertTrue(LandingPage.buscaTuCarroLabel().isDisplayed());
    }

    @Then("Search car by brand {string} and model {string}")
    public void searchCarByBrandAndModel(String brand, String model) {
        LandingPage.brandSelect().sendKeys(brand);
        LandingPage.modelSelect().sendKeys(model);
    }

    @And("Click search button")
    public void clickSearchButton() {
        LandingPage.searchButton().click();
    }

    @Then("Scrap the data from the results")
    public void scrapTheDataFromTheResults() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            List<WebElement> results = SearchResultPage.resultsObjects();

            for(WebElement carResult:  results){
                WebElement priceElement = SearchResultPage.priceLbl(carResult);
                WebElement nameElement = SearchResultPage.nameLbl(carResult);
                WebElement yearElement = SearchResultPage.yearLbl(carResult);

                String price = priceElement.getText();
                String name = nameElement.getText();
                int year = Integer.parseInt(yearElement.getText().split("\\s+")[0]);

                Car car = new Car(name, year, price);
                webScraping.addCar(car);
            }
            List<WebElement> nextButtonList = SearchResultPage.nextButton();

            if (nextButtonList.isEmpty() || !nextButtonList.getFirst().isDisplayed()) {
                break;
            }
            WebElement nextButton = nextButtonList.getFirst();
            nextButton.click();
            waitForPageLoad();
        }
    }

    @And("Present the scraped data")
    public void presentTheScrapedData() {
        webScraping.printMap();
    }
}
