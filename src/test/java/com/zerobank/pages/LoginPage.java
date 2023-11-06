package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_login")
    public WebElement userNameSection;

    @FindBy(id = "user_password")
    public WebElement passwordSection;

    @FindBy(name = "submit")
    public WebElement signBtn;

    @FindBy(css = ".alert-error")
    public WebElement errorMessage;

//    public void login() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("login.url"));
//        userNameSection.sendKeys(ConfigurationReader.getProperty("username"));
//        passwordSection.sendKeys(ConfigurationReader.getProperty("password"));
//        signBtn.click();
//        Driver.getDriver().navigate().back();
//    }

}
