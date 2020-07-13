package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

    @FindBy(xpath = "//button[@title='Remove']")
    private List<WebElement> removeItemsButtons;

    @FindBy(xpath = "//button[@title='Remove'][1]")
    private WebElement removeFirstItemButton;

    @FindBy(xpath = "//table[contains(@class, 'items table')]")
    private WebElement cartItemsTable;

    @FindBy(xpath = "//tr[@class='item']")
    private List<WebElement> itemsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void removeAllProducts() {
        int countOfItemsInCart = itemsInCart.size();
        while (countOfItemsInCart > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(removeItemsButtons.get(0)));
            Actions builder = new Actions(driver);
            builder.moveToElement(removeItemsButtons.get(0)).click(removeItemsButtons.get(0));
            builder.perform();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tr[@class='item']"), countOfItemsInCart - 1));
            countOfItemsInCart--;
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='There are no items in your cart.']")));
    }

    private int getCountOfItemsInCart() {
        //return removeItemsButtons.size();
        return driver.findElements(By.xpath("//button[@title='Remove']")).size();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//section[@id='box-checkout']//p"),
                "There are no items in your cart."));
    }
}
