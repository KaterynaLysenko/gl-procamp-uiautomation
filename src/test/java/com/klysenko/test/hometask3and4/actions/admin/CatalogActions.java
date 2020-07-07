package com.klysenko.test.hometask3and4.actions.admin;

import com.klysenko.test.hometask3and4.actions.BaseActions;
import com.klysenko.test.hometask3and4.data.Product;
import com.klysenko.test.hometask3and4.pages.admin.*;
import org.openqa.selenium.WebDriver;

public class CatalogActions extends BaseActions {

    private CatalogPage catalogPage;
    private AddNewProductPage addNewProductPage;
    private BaseAdminActions baseAdminActions;

    public CatalogActions(WebDriver driver) {
        super(driver);
        catalogPage = new CatalogPage(driver);
        addNewProductPage = new AddNewProductPage(driver);
        baseAdminActions = new BaseAdminActions(driver);
    }

    public void createNewProduct(Product product) {
        baseAdminActions.openCatalogMenu();
        catalogPage.goToAddingNewProduct();
        addNewProductPage.getGeneralTab().populateAllFields(product);
        addNewProductPage.goToInformationTab();
        addNewProductPage.getInformationTab().populateAllFields(product);
        addNewProductPage.goToPricesTab();
        addNewProductPage.getPricesTab().populateAllFields(product);
        addNewProductPage.saveChanges();
    }

    public boolean isProductPresentInTheCatalog(String productName) {
        return catalogPage.isProductPresentInTheCatalog(productName);
    }

    public void deleteProductByName(String productName) {
        catalogPage.openProductByName(productName);
        addNewProductPage.deleteProduct();
    }


}
