package com.klysenko.test.hometask3and4;

import com.klysenko.test.hometask3and4.actions.admin.AdminCountriesActions;
import com.klysenko.test.hometask3and4.actions.admin.BaseAdminActions;
import com.klysenko.test.hometask3and4.actions.admin.CatalogActions;
import com.klysenko.test.hometask3and4.data.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AdminTests extends BaseTest {

    CatalogActions catalogActions = new CatalogActions(driver);
    BaseAdminActions baseAdminActions = new BaseAdminActions(driver);
    AdminCountriesActions adminCountriesActions = new AdminCountriesActions(driver);


    @Test
    public void linksShouldBeOpenedInNewWindows() {
        baseAdminActions.loginToAdmin();
        baseAdminActions.openCountriesMenu();
        adminCountriesActions.openCountryByIndex(0);
        Assertions.assertTrue(adminCountriesActions.IsAllLinksAreOpenedInNewWindows(), "Not all links are opened in new windows");
    }


    @ParameterizedTest
    @MethodSource("productProvider")
    public void canCreateNewProduct(Product product) {
        baseAdminActions.loginToAdmin();
        String productName = product.getName();
        catalogActions.createNewProduct(product);
        Assertions.assertTrue(catalogActions.isProductPresentInTheCatalog(productName),
                "New product is not present in the catalog");
        catalogActions.deleteProductByName(productName);
    }

    private static Stream<Product> productProvider() {
        return Stream.of(Product.builder().category("Root")
                .defaultCategory("Root")
                .dateValidFrom("28062020")
                .dateValidTo("28063000")
                .name("Valenok" + System.currentTimeMillis())
                .code(String.valueOf(System.currentTimeMillis()))
                .sku(String.valueOf(System.currentTimeMillis()))
                .mpn(String.valueOf(System.currentTimeMillis()))
                .gtin(String.valueOf(System.currentTimeMillis()))
                .taric(String.valueOf(System.currentTimeMillis()))
                .manufacturer("ACME Corp.")
                .keywords("en")
                .image("valenok.jpg")
                .shortDescription("valenok")
                .description("The best valenok!")
                .technicalData("Some technical data")
                .headTitle("Title")
                .metaDescription("desc")
                .purchasePrice("100")
                .currency("US Dollars")
                .price("50").build());
    }


    @AfterEach
    void logout() {
        baseAdminActions.logout();
    }
}