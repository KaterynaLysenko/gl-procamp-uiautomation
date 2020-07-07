package com.klysenko.test.hometask3and4.actions.shop;

import com.klysenko.test.hometask3and4.actions.BaseActions;
import com.klysenko.test.hometask3and4.pages.shop.CartPage;
import com.klysenko.test.hometask3and4.pages.shop.ProductDescriptionPage;
import com.klysenko.test.hometask3and4.pages.shop.ShopBasePage;
import com.klysenko.test.hometask3and4.properties.Properties;
import org.openqa.selenium.WebDriver;

public class BaseShopActions extends BaseActions {
    private ShopBasePage shopBasePage;
    private ProductDescriptionPage productDescriptionPage;
    private CartPage cartPage;

    public BaseShopActions(WebDriver driver) {
        super(driver);
        shopBasePage = new ShopBasePage(driver);
        productDescriptionPage = new ProductDescriptionPage(driver);
        cartPage = new CartPage(driver);
    }

    public void addProductToCartByIndex(int index) {
        shopBasePage.openProductByIndex(index);
        productDescriptionPage.addProductToCart();
    }

    public void goToMainPage() {
        driver.get(Properties.shopUrl);
        waitForPageLoaded();
    }

    public void openCart() {
        shopBasePage.openCart();
    }

    public void removeAllProductsFromCart() {
        cartPage.removeAllProducts();
    }

    public boolean isCartEmpty() {
        return cartPage.isCartEmpty();
    }

}
