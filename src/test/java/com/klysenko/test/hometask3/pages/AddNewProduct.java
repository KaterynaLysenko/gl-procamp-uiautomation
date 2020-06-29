package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProduct extends Page {

    private AddNewProductPageGeneralTab generalTab;
    private AddNewProductInformationTab informationTab;
    private AddNewProductPricesTab pricesTab;

    @FindBy(xpath = "//a[contains(text(),'General')]")
    private WebElement generalTabLink;

    @FindBy(xpath = "//a[contains(text(),'Information')]")
    private WebElement informationTabLink;

    @FindBy(xpath = "//a[contains(text(),'Prices')]")
    private WebElement pricesTabLink;

    public AddNewProduct(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        generalTab = new AddNewProductPageGeneralTab(driver);
        informationTab = new AddNewProductInformationTab(driver);
        pricesTab = new AddNewProductPricesTab(driver);
    }

    public AddNewProductInformationTab getInformationTab() {
        return informationTab;
    }

    public WebElement getGeneralTabLink() {
        return generalTabLink;
    }

    public WebElement getPricesTabLink() {
        return pricesTabLink;
    }


}
