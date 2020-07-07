package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminCountriesPage extends Page {

    @FindBy(xpath = ".//table[@class='table table-striped table-hover data-table']//tr//a")
    private List<WebElement> countriesNames;


    public AdminCountriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void getCountryByIndex(int indexOfCountryInTheList) {
        countriesNames.get(indexOfCountryInTheList).click();
    }
}
