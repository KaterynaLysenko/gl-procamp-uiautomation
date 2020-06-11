package com.klysenko.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    WebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        String USERNAME = "bsuser70982";
        String AUTOMATE_KEY = "UcVgFzxkVw1m3TZZpGyx";
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "13");
        caps.setCapability("name", "bsuser70982's First Test");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void simpleTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Assertions.assertEquals("Selenium", driver.findElement(By.tagName("h3")).getText());
    }

    @Test
    void simpleTest2() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("GlobalLogic\n");
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("GlobalLogic"));
    }


}