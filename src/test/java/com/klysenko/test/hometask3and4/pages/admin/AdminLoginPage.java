package com.klysenko.test.hometask3and4.pages.admin;

import com.klysenko.test.hometask3and4.pages.Page;
import com.klysenko.test.hometask3and4.properties.Properties;
import org.openqa.selenium.By;
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

    public void login() {
        driver.get(Properties.adminUrl);
        usernameInput.sendKeys(Properties.user);
        passwordInput.sendKeys(Properties.password);
        loginButton.click();
        wait.until(d -> d.findElement(By.xpath("//ul[@id='box-apps-menu']/li[1]")));
    }
}
