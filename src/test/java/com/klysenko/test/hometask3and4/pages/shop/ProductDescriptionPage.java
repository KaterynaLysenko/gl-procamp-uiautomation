package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage extends Page {

    @FindBy(xpath = "//button[@name='add_cart_product']\n")
    private WebElement addToCartButton;

    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void addProductToCart() {
        getAddToCartButton().click();
        waitForPageLoaded();
    }
}
