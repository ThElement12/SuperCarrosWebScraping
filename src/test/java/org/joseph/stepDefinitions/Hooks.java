package org.joseph.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.joseph.utils.WebScraping;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebScraping webScraping;
    @Before
    public void setupClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webScraping = new WebScraping();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
