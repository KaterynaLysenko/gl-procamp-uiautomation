package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminEditCountryPage extends Page {

    @FindBy(xpath = ".//i[@class='fa fa-external-link']")
    private List<WebElement> externalLinkIcons;

    public AdminEditCountryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getExternalLinkIcons() {
        return externalLinkIcons;
    }

}
