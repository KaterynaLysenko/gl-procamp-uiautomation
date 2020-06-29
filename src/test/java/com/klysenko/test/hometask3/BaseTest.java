package com.klysenko.test.hometask3;

import com.klysenko.test.hometask3.actions.BaseAdminActions;
import com.klysenko.test.hometask3.actions.ShopActions;
import com.klysenko.test.hometask3.listeners.DriverEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class BaseTest {

    public static EventFiringWebDriver driver;
    static WebDriverWait wait;

    static BaseAdminActions baseAdminActions;
    static ShopActions shopActions;


    @BeforeAll
    static void setUp() {

        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.CLIENT, Level.INFO);
        logs.enable(LogType.DRIVER, Level.INFO);
        logs.enable(LogType.PERFORMANCE, Level.INFO);
        logs.enable(LogType.SERVER, Level.INFO);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, logs);
        options.setExperimentalOption("w3c", false);

        WebDriverManager.chromedriver().setup();
        ChromeDriver pureWebDriver = new ChromeDriver(options);

        driver = new EventFiringWebDriver(pureWebDriver);
        driver.register(new DriverEventListener());

        wait = new WebDriverWait(driver, 10);

    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
