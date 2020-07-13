package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminBasePage extends Page {

    @FindBy(xpath = "//ul[@id='box-apps-menu']/li/a")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//ul[@id='box-apps-menu']/li/ul/li/a")
    private List<WebElement> subMenuItems;

    @FindBy(xpath = "//div[@class='panel-heading']")
    private WebElement header;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement signOutButton;

    @FindBy(xpath = "//li[@data-code='countries']")
    private WebElement countriesTab;

    @FindBy(xpath = "//span[@title='Catalog']")
    private WebElement catalogTab;

    public AdminBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openCountriesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(countriesTab));
        Actions builder = new Actions(driver);
        builder.moveToElement(countriesTab).click(countriesTab);
        builder.perform();
        wait.until(d -> d.findElement(By.xpath("//table[@class='table table-striped table-hover data-table']")));
    }

    public void logOut() {
        signOutButton.click();
        wait.until(d -> d.findElement(By.xpath(".//button[@name='login']")));
    }

    public boolean isHeaderDisplayedOnAllPages() {
        int countOfMenuItems = menuItems.size();
        if (countOfMenuItems == 0) {
            return false;
        }
        Actions action = new Actions(driver);
        for (int i = 0; i < countOfMenuItems; i++) {
            action.moveToElement(menuItems.get(i)).click().perform();
            waitForPageLoaded();
            if (!header.isDisplayed()) {
                return false;
            }
            int countOfSubItems = subMenuItems.size();
            for (int j = 0; j < countOfSubItems; j++) {
                action.moveToElement(subMenuItems.get(j)).click().perform();
                waitForPageLoaded();
                if (!header.isDisplayed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void openCatalogMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        clickViaJsExec(catalogTab);
        waitForPageLoaded();
    }
}