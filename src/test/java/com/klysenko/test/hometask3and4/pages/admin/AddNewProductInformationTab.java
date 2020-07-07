package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.data.Product;
import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProductInformationTab extends Page {

    @FindBy(xpath = "//input[@name='short_description[en]']")
    private WebElement shortDescriptionInput;

    //div[contains(class(), 'trumbowyg-editor')]
    @FindBy(xpath = "//div[@class='trumbowyg-editor trumbowyg-autogrow-on-enter']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//textarea[@name='technical_data[en]']")
    private WebElement technicalDataInput;

    @FindBy(xpath = "//input[@name='head_title[en]']")
    private WebElement headTitleInput;

    @FindBy(xpath = "//input[@name='meta_description[en]']")
    private WebElement metaDescriptionInput;

    public AddNewProductInformationTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void populateAllFields(Product product) {
        shortDescriptionInput.sendKeys(product.getShortDescription());
        descriptionInput.sendKeys(product.getDescription());
        technicalDataInput.sendKeys(product.getTechnicalData());
        headTitleInput.sendKeys(product.getHeadTitle());
        metaDescriptionInput.sendKeys(product.getMetaDescription());
    }
}
