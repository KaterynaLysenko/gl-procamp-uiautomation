package com.klysenko.test.hometask3and4.actions.admin;

import com.klysenko.test.hometask3and4.actions.BaseActions;
import com.klysenko.test.hometask3and4.pages.admin.AdminBasePage;
import com.klysenko.test.hometask3and4.pages.admin.AdminLoginPage;
import org.openqa.selenium.WebDriver;

public class BaseAdminActions extends BaseActions {

    private AdminLoginPage loginPage;
    private AdminBasePage adminBasePage;

    public BaseAdminActions(WebDriver driver) {
        super(driver);
        loginPage = new AdminLoginPage(driver);
        adminBasePage = new AdminBasePage(driver);
    }


    public void loginToAdmin() {
        loginPage.login();
    }

    public boolean isHeaderDisplayedOnAllPages() {
        return adminBasePage.isHeaderDisplayedOnAllPages();
    }

    public void openCountriesMenu() {
        adminBasePage.openCountriesTab();
    }

    public void logout() {
        adminBasePage.logOut();
    }

    public void openCatalogMenu() {
        adminBasePage.openCatalogMenu();
    }

}