package com.klysenko.test.hometask3and4;

import com.klysenko.test.hometask3and4.actions.admin.BaseAdminActions;
import com.klysenko.test.hometask3and4.listeners.DriverEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class AdminTestsWithEventFiring {

    EventFiringWebDriver driver;
    WebDriverWait wait;

    BaseAdminActions baseAdminActions;

    @BeforeEach
    void setUp() {

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

        baseAdminActions = new BaseAdminActions(driver);
    }


    @Test
    public void allMenuItemsShouldBeClickableOnAdmin() {
        baseAdminActions.loginToAdmin();
        Assertions.assertTrue(baseAdminActions.isHeaderDisplayedOnAllPages());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
