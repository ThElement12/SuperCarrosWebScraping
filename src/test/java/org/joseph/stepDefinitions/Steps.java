package org.joseph.stepDefinitions;

import io.cucumber.java.en.Given;
import org.joseph.pageObjects.LandingPage;
import org.junit.Assert;

import static org.joseph.stepDefinitions.Hooks.driver;

public class Steps {

    @Given("Open the SuperCarros URL")
    public void openURL(){
        driver.get("https://www.supercarros.com/");
        Assert.assertTrue(LandingPage.buscaTuCarroLabel().isDisplayed());
    }
}
