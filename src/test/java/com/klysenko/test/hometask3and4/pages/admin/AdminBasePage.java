package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminBasePage extends Page {

    @FindBy(xpath = ".//ul[@id='box-apps-menu']/li")
    private List<WebElement> menuItems;

    @FindBy(xpath = ".//ul[@id='box-apps-menu']/li/ul/li")
    private List<WebElement> subMenuItems;

    @FindBy(xpath = ".//div[@class='panel-heading']")
    private WebElement header;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement signOutButton;

    @FindBy(xpath = ".//li[@data-code='countries']")
    private WebElement countriesTab;

    @FindBy(xpath = ".//span[@title='Catalog']")
    private WebElement catalogTab;

    public AdminBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openCountriesTab() {
        countriesTab.click();
        wait.until(d -> d.findElement(By.xpath(".//table[@class='table table-striped table-hover data-table']//tr//a")));
    }

    public void logOut() {
        signOutButton.click();
        wait.until(d -> d.findElement(By.xpath(".//button[@name='login']")));
    }

    public boolean isHeaderDisplayedOnAllPages() {
        int countOfMenuItems = menuItems.size();
        if (countOfMenuItems == 0){
            return false;
        }
        for (int i = 0; i < countOfMenuItems; i++) {
            menuItems.get(i).click();
            if (!header.isDisplayed()) {
                return false;
            }
            int countOfSubItems = subMenuItems.size();
            for (int j = 0; j < countOfSubItems; j++) {
                subMenuItems.get(j).click();
                if (!header.isDisplayed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void openCatalogMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", catalogTab);
        waitForPageLoaded();
    }
}