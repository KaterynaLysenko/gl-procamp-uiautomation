package com.klysenko.test.hometask3and4.actions.admin;

import com.klysenko.test.hometask3and4.actions.BaseActions;
import com.klysenko.test.hometask3and4.pages.admin.AdminCountriesPage;
import com.klysenko.test.hometask3and4.pages.admin.AdminEditCountryPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class AdminCountriesActions extends BaseActions {

    private AdminCountriesPage countriesPage;
    private AdminEditCountryPage editCountryPage;


    public AdminCountriesActions(WebDriver driver) {
        super(driver);
        countriesPage = new AdminCountriesPage(driver);
        editCountryPage = new AdminEditCountryPage(driver);
    }

    public void openCountryByIndex(int indexOfCountryInTheList) {
        countriesPage.getCountryByIndex(indexOfCountryInTheList);
    }

    public void openExternalLinkByIndex(int index) {
        editCountryPage.openExternalLinkByIndex(index);
    }

    public boolean IsAllLinksAreOpenedInNewWindows() {
        return editCountryPage.isExternalLinksAreOpenedInNewWindows();
    }

}
