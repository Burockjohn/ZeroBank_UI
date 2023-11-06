package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement userDropdown;

    @FindBy(xpath = "//*[. = 'Online Banking']")
    public WebElement onlineBanking;

   



}
