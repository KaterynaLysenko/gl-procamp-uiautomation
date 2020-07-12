package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class AdminEditCountryPage extends Page {

    @FindBy(xpath = ".//i[@class='fa fa-external-link']")
    private List<WebElement> externalLinkIcons;

    public AdminEditCountryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openExternalLinkByIndex(int index) {
        externalLinkIcons.get(index).click();
    }

    public boolean isExternalLinksAreOpenedInNewWindows() {
        int externalLinksIconsNumber = externalLinkIcons.size();
        if (externalLinksIconsNumber == 0){
            return false;
        }
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
