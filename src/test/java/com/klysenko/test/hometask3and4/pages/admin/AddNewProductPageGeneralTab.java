package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.data.Product;
import com.klysenko.test.hometask3and4.pages.Page;
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

    @FindBy(xpath = "//input[@name='name[en]']")
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

    @FindBy(xpath = "//input[@name='new_images[]']")
    private WebElement imagesInput;

    public AddNewProductPageGeneralTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void populateAllFields(Product product) {
        enabledButton.click();
        selectCategory(product.getCategory());
        dateValidFromInput.sendKeys(product.getDateValidFrom());
        dateValidToInput.sendKeys(product.getDateValidTo());
        nameInput.sendKeys(product.getName());
        codeInput.sendKeys(product.getCode());
        skuInput.sendKeys(product.getSku());
        mpnInput.sendKeys(product.getMpn());
        gtinInput.sendKeys(product.getGtin());
        taricInput.sendKeys(product.getTaric());
        selectManufacturer(product.getManufacturer());
        keywordsInput.sendKeys(product.getKeywords());
        uploadImage(product.getImage());
    }

    private void uploadImage(String imageName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(imageName).getFile());
        imagesInput.sendKeys(file.getAbsolutePath());
    }

    public void selectCategory(String category) {
        new Select(defaultCategorySelect).selectByVisibleText(category);
    }

    public void selectManufacturer(String manufacturer) {
        new Select(manufacturerSelect).selectByVisibleText(manufacturer);
    }

}
