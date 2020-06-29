package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = ".//li[@data-code='catalog']")
    private WebElement catalogTab;

    public AdminBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    public List<WebElement> getSubMenuItems() {
        return subMenuItems;
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getSignOutButton() {
        return signOutButton;
    }

    public WebElement getCountriesTab() {
        return countriesTab;
    }

    public WebElement getCatalogTab() {
        return catalogTab;
    }

}