package com.klysenko.test.hometask3and4.pages.shop;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

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

    public void openProductByIndex(int index) {
        productsList.get(index).click();
        wait.until(d -> d.findElement(By.xpath("//button[@name='add_cart_product']")));
    }

    public void openCart() {
        cartIcon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Shopping Cart')] | //p[contains(text(),'There are no items in your cart.')]")));
    }

    public int getCountOfItemsOnCartIcon() {
        if (countOfItemsInTheCart.getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(countOfItemsInTheCart.getText());
    }
}
