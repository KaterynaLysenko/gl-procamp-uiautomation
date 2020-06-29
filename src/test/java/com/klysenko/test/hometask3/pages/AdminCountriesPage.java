package com.klysenko.test.hometask3.pages;

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

    public List<WebElement> getCountriesNames() {
        return countriesNames;
    }


}
