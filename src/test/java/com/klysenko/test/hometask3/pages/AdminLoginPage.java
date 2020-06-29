package com.klysenko.test.hometask3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends Page {

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement usernameInput;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@name='login']")
    private WebElement loginButton;

    public AdminLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginButton() {
        return loginButton;

    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }


}
