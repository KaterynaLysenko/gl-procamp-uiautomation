package com.klysenko.test.hometask3.listeners;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Set;

@Slf4j
public class DriverEventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        getLogs(driver);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        getLogs(driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        getLogs(driver);
    }


    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        getLogs(driver);
    }


    private void getLogs(WebDriver driver) {
        Logs logs = driver.manage().logs();
        Set<String> availableLogTypes = logs.getAvailableLogTypes();

        for (String logType : availableLogTypes) {
            LogEntries logEntries = logs.get(logType);

            for (LogEntry logEntry : logEntries) {
                log.info(logEntry.getMessage());
            }
        }

    }

}
