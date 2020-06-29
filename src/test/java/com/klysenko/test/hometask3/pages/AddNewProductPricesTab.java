package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProductPricesTab extends Page {

    @FindBy(xpath = "//input[@name='purchase_price']")
    private WebElement purchasePriceInput;

    @FindBy(xpath = "//select[@name='purchase_price_currency_code']")
    private WebElement purchasePriceSelect;

    @FindBy(xpath = "//select[@name='tax_class_id']")
    private WebElement taxClassSelect;

    @FindBy(xpath = "////input[@name='prices[USD]")
    private WebElement priceInput;

    public AddNewProductPricesTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
