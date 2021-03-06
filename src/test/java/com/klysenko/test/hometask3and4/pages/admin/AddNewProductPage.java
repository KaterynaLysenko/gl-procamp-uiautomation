package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProductPage extends Page {

    @Getter
    private AddNewProductPageGeneralTab generalTab;

    @Getter
    private AddNewProductInformationTab informationTab;

    @Getter
    private AddNewProductPricesTab pricesTab;

    @FindBy(xpath = "//a[contains(text(),'General')]")
    private WebElement generalTabLink;

    @FindBy(xpath = "//a[contains(text(),'Information')]")
    private WebElement informationTabLink;

    @FindBy(xpath = "//a[contains(text(),'Prices')]")
    private WebElement pricesTabLink;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteButton;

    public AddNewProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        generalTab = new AddNewProductPageGeneralTab(driver);
        informationTab = new AddNewProductInformationTab(driver);
        pricesTab = new AddNewProductPricesTab(driver);
    }

    public void saveChanges() {
        saveButton.click();
        wait.until(d -> d.findElement(By.xpath("//div[@class='alert alert-success']")));
        waitForPageLoaded();
    }

    public void goToInformationTab() {
        informationTabLink.click();
    }

    public void goToPricesTab() {
        pricesTabLink.click();
    }

    public void deleteProduct() {
        deleteButton.click();
        confirmBrowserAlert();
    }
}
