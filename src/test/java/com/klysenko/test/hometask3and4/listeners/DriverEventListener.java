package com.klysenko.test.hometask3and4.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.Set;
import java.util.logging.Logger;

public class DriverEventListener extends AbstractWebDriverEventListener {

    private static Logger logger = null;

    static {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        logger = Logger.getLogger("");
    }

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
                logger.log(logEntry.getLevel(), logEntry.getMessage());
            }
        }
    }
}
