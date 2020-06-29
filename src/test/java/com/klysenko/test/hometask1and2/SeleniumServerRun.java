package com.klysenko.test.hometask1and2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumServerRun {

    static WebDriver driver;

    @BeforeAll
    static void setUp() throws MalformedURLException {

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void simpleTestOnChrome() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Selenium"));
    }

}
