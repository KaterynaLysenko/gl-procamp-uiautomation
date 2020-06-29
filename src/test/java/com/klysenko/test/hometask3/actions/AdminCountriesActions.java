package com.klysenko.test.hometask3.actions;

import com.klysenko.test.hometask3.pages.AdminCountriesPage;
import com.klysenko.test.hometask3.pages.AdminEditCountryPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class AdminCountriesActions extends BaseActions {

    AdminCountriesPage countriesPage = new AdminCountriesPage(driver);
    AdminEditCountryPage editCountryPage = new AdminEditCountryPage(driver);


    public AdminCountriesActions(WebDriver driver) {
        super(driver);
    }

    public void getCountryByIndex(int indexOfCountryInTheList) {
        countriesPage.getCountriesNames().get(indexOfCountryInTheList).click();

    }

    public void openExternalLinkByIndex(int index) {
        editCountryPage.getExternalLinkIcons().get(index).click();
    }

    public boolean IsAllLinksAreOpenedInNewWindows() {
        int externalLinksIconsNumber = editCountryPage.getExternalLinkIcons().size();
        String parentWindowHandle = driver.getWindowHandle();
        String newWindowHandle = null;
        for (int i = 0; i < externalLinksIconsNumber; i++) {
            openExternalLinkByIndex(i);
            Set<String> windowHandles = driver.getWindowHandles();
            int actualNumberOfWindows = windowHandles.size();
            if (actualNumberOfWindows != 2) {
                return false;
            }
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    newWindowHandle = windowHandle;
                }
            }
            driver.switchTo().window(newWindowHandle);
            driver.close();
            driver.switchTo().window(parentWindowHandle);
        }
        return true;
    }

}
