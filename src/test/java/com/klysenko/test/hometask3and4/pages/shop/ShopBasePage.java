package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopBasePage extends Page {

    @FindBy(xpath = "//article[@class='product-column']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='badge quantity']")
    private WebElement countOfItemsInTheCart;

    @FindBy(xpath = "//div[@id='cart']/a")
    private WebElement cartIcon;

    public ShopBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public WebElement getCountOfItemsInTheCart() {
        return countOfItemsInTheCart;
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public void openProductByIndex(int index) {
        getProductsList().get(index).click();

    }

    public void openCart() {
        getCartIcon().click();
        waitForPageLoaded();
    }

    private int getCountOfItemsOnCartIcon() {
        if (getCountOfItemsInTheCart().getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(getCountOfItemsInTheCart().getText());
    }
}
