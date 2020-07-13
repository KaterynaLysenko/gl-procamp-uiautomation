package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDescriptionPage extends Page {

    @FindBy(xpath = "//button[@name='add_cart_product']\n")
    private WebElement addToCartButton;

    private ShopBasePage shopBasePage;

    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        shopBasePage = new ShopBasePage(driver);
    }

    public void addProductToCart() {
        int countOfProductsBeforeAdding = shopBasePage.getCountOfItemsOnCartIcon();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='badge quantity']"),
                String.valueOf(1+countOfProductsBeforeAdding)));
    }
}
