package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

    @FindBy(xpath = "//button[@title='Remove']")
    private List<WebElement> removeItemsButtons;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void removeAllProducts() {
        int countOfItems = getCountOfItemsInCart();
        if (countOfItems == 0) {
            return;
        }
        while (getCountOfItemsInCart() > 1) {
            removeItemsButtons.get(0).click();
            wait.until(d -> d.findElement(By.xpath("//section[@id='box-checkout-customer']")));
        }
        if (getCountOfItemsInCart() == 1) {
            removeItemsButtons.get(0).click();
            wait.until(d -> d.findElement(By.xpath("//p[contains(text(),'There are no items in your cart.')]")));
        }
    }

    private int getCountOfItemsInCart() {
        return removeItemsButtons.size();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//section[@id='box-checkout']//p"),
                "There are no items in your cart."));
    }
}
