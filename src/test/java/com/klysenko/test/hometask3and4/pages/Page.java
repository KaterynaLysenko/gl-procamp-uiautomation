package com.klysenko.test.hometask3and4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void confirmBrowserAlert() {
        driver.switchTo().alert().accept();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        try {
            wait.until(expectation);
        } catch (Throwable error) {
            error.getMessage();
        }
    }


    public void retryingClick(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(by).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    public void retryingClick(WebElement webElement) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                webElement.click();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    public void clickViaJsExec(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            //driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
