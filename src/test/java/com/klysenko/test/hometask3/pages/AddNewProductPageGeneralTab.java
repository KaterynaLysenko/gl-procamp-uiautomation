package com.klysenko.test.hometask3.pages;

import com.klysenko.test.hometask3.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class AddNewProductPageGeneralTab extends Page {

    @FindBy(xpath = "//label[@class='btn btn-default']")
    private WebElement enabledButton;

    @FindBy(xpath = " //div[@id='categories']//input")
    private List<WebElement> categoriesCheckButtons;

    @FindBy(xpath = "//select[@name='default_category_id']")
    private WebElement defaultCategorySelect;

    @FindBy(xpath = "//input[@name='date_valid_from']")
    private WebElement dateValidFromInput;

    @FindBy(xpath = "//input[@name='date_valid_to']")
    private WebElement dateValidToInput;

    @FindBy(xpath = "//input[@name='name[en]'")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement codeInput;

    @FindBy(xpath = "//div[@class='form-group']//input[@name='sku']")
    private WebElement skuInput;

    @FindBy(xpath = "//input[@name='mpn']")
    private WebElement mpnInput;

    @FindBy(xpath = "//input[@name='gtin']")
    private WebElement gtinInput;

    @FindBy(xpath = "//input[@name='taric']")
    private WebElement taricInput;

    @FindBy(xpath = "//select[@name='manufacturer_id']")
    private WebElement manufacturerSelect;

    @FindBy(xpath = "//select[@name='supplier_id']")
    private WebElement supplierSelect;

    @FindBy(xpath = "//input[@name='keywords']")
    private WebElement keywordsInput;

    @FindBy(xpath = "//input[@name='new_images[]")
    private WebElement imagesInput;

    public AddNewProductPageGeneralTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public WebElement getEnabledButton() {
        return enabledButton;
    }

    public List<WebElement> getCategoriesCheckButtons() {
        return categoriesCheckButtons;
    }

    public WebElement getDefaultCategorySelect() {
        return defaultCategorySelect;
    }

    public WebElement getDateValidFromInput() {
        return dateValidFromInput;
    }

    public WebElement getDateValidToInput() {
        return dateValidToInput;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getCodeInput() {
        return codeInput;
    }

    public WebElement getSkuInput() {
        return skuInput;
    }

    public WebElement getMpnInput() {
        return mpnInput;
    }

    public WebElement getGtinInput() {
        return gtinInput;
    }

    public WebElement getTaricInput() {
        return taricInput;
    }

    public WebElement getManufacturerSelect() {
        return manufacturerSelect;
    }

    public WebElement getSupplierSelect() {
        return supplierSelect;
    }

    public WebElement getKeywordsInput() {
        return keywordsInput;
    }

    public WebElement getImagesInput() {
        return imagesInput;
    }
}
