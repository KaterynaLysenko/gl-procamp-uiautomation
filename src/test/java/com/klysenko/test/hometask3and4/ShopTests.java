package com.klysenko.test.hometask3and4;

import com.klysenko.test.hometask3and4.actions.shop.BaseShopActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTests extends BaseTest {

    BaseShopActions baseShopActions = new BaseShopActions(driver);

    @Test
     public void canAddAndRemoveItemsFromCart(){
        baseShopActions.goToMainPage();
        int numberOfItemsToBeAddedToCart = 3;
        for (int i=0; i<numberOfItemsToBeAddedToCart; i++){
            baseShopActions.addProductToCartByIndex(i);
            baseShopActions.goToMainPage();
        }
        baseShopActions.openCart();
        baseShopActions.removeAllProductsFromCart();
        Assertions.assertTrue(baseShopActions.isCartEmpty());
    }
}