package com.klysenko.test.hometask3.actions;

import com.klysenko.test.hometask3.data.Product;
import com.klysenko.test.hometask3.pages.AddNewProduct;
import com.klysenko.test.hometask3.pages.AddNewProductPageGeneralTab;
import com.klysenko.test.hometask3.pages.CatalogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CatalogActions extends BaseActions {

    CatalogPage catalogPage = new CatalogPage(driver);
    AddNewProduct addNewProductPage = new AddNewProduct(driver);
    AddNewProductPageGeneralTab generalTab = new AddNewProductPageGeneralTab(driver);

    public CatalogActions(WebDriver driver) {
        super(driver);
    }


    public void addNewProduct(Product product) {
        catalogPage.getAddNewProductButton().click();
        generalTab.getEnabledButton().click();
       // selectCategory(product.getCategory());
        generalTab.getDateValidFromInput().sendKeys(product.getDateValidFrom());
        generalTab.getDateValidToInput().sendKeys(product.getDateValidTo());
        generalTab.getNameInput().sendKeys(product.getName());
        generalTab.getCodeInput().sendKeys(product.getCode());
        generalTab.getSkuInput().sendKeys(product.getSku());
        generalTab.getMpnInput().sendKeys(product.getMpn());
        generalTab.getGtinInput().sendKeys(product.getGtin());
        generalTab.getTaricInput().sendKeys(product.getTaric());
        selectManufacturer(product.getManufacturer());
        generalTab.getKeywordsInput().sendKeys(product.getKeywords());
        uploadImage(product.getImage());

    }


    private void uploadImage(String imageName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(imageName).getFile());
        generalTab.getImagesInput().sendKeys(file.getAbsolutePath());
    }

    public void selectCategory(String category) {
        new Select(generalTab.getDefaultCategorySelect()).selectByValue(category);
    }

    public void selectManufacturer(String manufacturer) {
        new Select(generalTab.getManufacturerSelect()).selectByValue(manufacturer);
    }

}
