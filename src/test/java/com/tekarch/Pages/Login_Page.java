package com.tekarch.Pages;

import com.tekarch.utility.commonUtilities.Set_Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Set_Properties {


    WebDriver driver;
    public Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "email_field")
    WebElement emailField;
    @FindBy(id = "password_field")
    WebElement passwordField;
    @FindBy(xpath = "//button[@onclick='login()']")
    WebElement button_login;
    @FindBy(xpath="//a[contains(text(),'Home')]")
    WebElement buttonHome;

    public void tekarchLogin()  {

        selBase.waitExplicitly(5,emailField, driver);
        selBase.webElementClear(emailField);
        selBase.webElementSendKeys(emailField, "admin123@gmail.com");
        selBase.webElementClear(passwordField);
        selBase.webElementSendKeys(passwordField, "admin123");
        selBase.webElementClick(button_login);
        selBase.waitExplicitly(5,buttonHome, driver);
    }


}
