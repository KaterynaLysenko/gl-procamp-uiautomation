package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends Page {


    @FindBy(xpath = "//a[contains(text(),'Add New Product')]")
    private WebElement addNewProductButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddNewProductButton() {
        return addNewProductButton;
    }


}
