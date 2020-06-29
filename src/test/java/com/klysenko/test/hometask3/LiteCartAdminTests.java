package com.klysenko.test.hometask3;

import com.klysenko.test.hometask3.actions.AdminCountriesActions;
import com.klysenko.test.hometask3.actions.BaseAdminActions;
import com.klysenko.test.hometask3.actions.CatalogActions;
import com.klysenko.test.hometask3.data.Product;
import com.klysenko.test.hometask3.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;

public class LiteCartAdminTests extends BaseTest {

  CatalogActions catalogActions = new CatalogActions(driver);
  BaseAdminActions baseAdminActions = new BaseAdminActions(driver);
  AdminCountriesActions adminCountriesActions = new AdminCountriesActions(driver);

    @Test
    public void allMenuItemsShouldBeClickableOnAdmin() {
        baseAdminActions.login();
        Assertions.assertTrue(baseAdminActions.isHeaderDisplayedOnAllPages());
    }

    @Test
    public void linksShouldBeOpenedInNewWindows() {
        baseAdminActions.login();
        baseAdminActions.openCountriesMenu();
        adminCountriesActions.getCountryByIndex(0);
        Assertions.assertTrue(adminCountriesActions.IsAllLinksAreOpenedInNewWindows(), "Not all links are opened in new windows");
    }

    /*
    @ParameterizedTest
    @MethodSource("productProvider")
    public void canCreateNewProduct(Product product) {
        baseAdminActions.login();
        baseAdminActions.openCatalogMenu();
        catalogActions.addNewProduct(product);


    }

    private static Stream<Product> productProvider() {
        return Stream.of(Product.builder().category("Root")
                .defaultCategory("Root")
                .dateValidFrom("28062020")
                .dateValidTo("28063000")
                .name("Valenok" + System.currentTimeMillis())
                .code("123")
                .sku("123456")
                .mpn("7890")
                .gtin("0192")
                .taric("64378579")
                .manufacturer("ACME Corp.")
                .keywords("en")
                .image("valenok")
                .shortDescription("valenok")
                .description("The best valenok!")
                .technicalData("Some technical data")
                .headTitle("Title")
                .metaDescription("desc")
                .purchasePrice("100")
                .currency("US Dollars")
                .price("50").build());
    }

     */

    @AfterEach
    void logout() {
        baseAdminActions.logout();
    }
}