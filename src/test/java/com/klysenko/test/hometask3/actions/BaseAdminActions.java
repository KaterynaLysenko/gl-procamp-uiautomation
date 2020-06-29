package com.klysenko.test.hometask3.actions;

import com.klysenko.test.hometask3.pages.AdminBasePage;
import com.klysenko.test.hometask3.pages.AdminLoginPage;
import com.klysenko.test.hometask3.properties.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseAdminActions extends BaseActions {

    AdminLoginPage loginPage = new AdminLoginPage(driver);
    AdminBasePage adminBasePage = new AdminBasePage(driver);

    public BaseAdminActions(WebDriver driver) {
        super(driver);
    }


    public void login() {
        driver.get(Properties.adminUrl);
        loginPage.getUsernameInput().sendKeys(Properties.user);
        loginPage.getPasswordInput().sendKeys(Properties.password);
        loginPage.getLoginButton().click();
        wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));

    }

    public boolean isHeaderDisplayedOnAllPages() {
        int countOfMenuItems = adminBasePage.getMenuItems().size();
        for (int i = 0; i < countOfMenuItems; i++) {
            adminBasePage.getMenuItems().get(i).click();
            if (!adminBasePage.getHeader().isDisplayed()) {
                return false;
            }

            int countOfSubItems = adminBasePage.getSubMenuItems().size();
            for (int j = 0; j < countOfSubItems; j++) {
                adminBasePage.getSubMenuItems().get(j).click();
                if (!adminBasePage.getHeader().isDisplayed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void openCountriesMenu() {
        adminBasePage.getCountriesTab().click();
        wait.until((WebDriver d) -> d.findElement(By.xpath(".//table[@class='table table-striped table-hover data-table']//tr//a")));
    }

    public void logout() {
        adminBasePage.getSignOutButton().click();
    }

    public void openCatalogMenu() {
        adminBasePage.getCatalogTab().click();
        wait.until((WebDriver d) -> d.findElement(By.xpath("//a[contains(text(),'Add New Product')]")));

    }

}