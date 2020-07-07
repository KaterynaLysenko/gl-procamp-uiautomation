package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.data.Product;
import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewProductPricesTab extends Page {

    @FindBy(xpath = "//input[@name='purchase_price']")
    private WebElement purchasePriceInput;

    @FindBy(xpath = "//select[@name='purchase_price_currency_code']")
    private WebElement purchasePriceSelect;

    @FindBy(xpath = "//select[@name='tax_class_id']")
    private WebElement taxClassSelect;

    @FindBy(xpath = "//input[@name='prices[USD]']")
    private WebElement priceInput;

    public AddNewProductPricesTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void populateAllFields(Product product) {
        purchasePriceInput.sendKeys(product.getPurchasePrice());
        selectPricesCurrency(product.getCurrency());
        priceInput.sendKeys(product.getPrice());
    }

    private void selectPricesCurrency(String currency) {
        new Select(purchasePriceSelect).selectByVisibleText(currency);
    }
}
