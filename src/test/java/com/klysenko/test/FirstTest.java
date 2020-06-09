package com.klysenko.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void simpleTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
        Assertions.assertEquals("Selenium",driver.findElement(By.tagName("h3")).getText());
    }

    @Test
    void simpleTest2() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("GlobalLogic\n");
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("GlobalLogic"));
    }


}