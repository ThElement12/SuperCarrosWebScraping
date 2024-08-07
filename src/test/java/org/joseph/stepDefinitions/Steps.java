package org.joseph.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.jv.Lan;
import org.joseph.pageObjects.LandingPage;
import org.junit.Assert;

import static org.joseph.stepDefinitions.Hooks.driver;

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
}
