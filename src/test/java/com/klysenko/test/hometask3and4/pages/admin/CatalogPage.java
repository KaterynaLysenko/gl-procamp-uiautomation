package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage extends Page {


    @FindBy(xpath = "//a[contains(text(),'Add New Product')]")
    private WebElement addNewProductButton;

    @FindBy(xpath = "//table[contains(@class, 'data-table')]//tr//a[not(@title='Edit') and not(@title='View')]")
    private List<WebElement> productNames;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToAddingNewProduct() {
        addNewProductButton.click();
        waitForPageLoaded();
    }

    public void openProductByName(String productName) {
        for (WebElement productItem : productNames) {
            if (productItem.getText().equals(productName)) {
                productItem.click();
            }
        }
    }

    public boolean isProductPresentInTheCatalog(String productName) {
        for (WebElement productItem : productNames) {
            if (productItem.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
