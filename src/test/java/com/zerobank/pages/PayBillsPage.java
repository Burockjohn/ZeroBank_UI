package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {

    public PayBillsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text() = 'Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(css = "input[id='np_new_payee_name']")
    public WebElement payeeName;

    @FindBy(css = "textarea[id$='address']")
    public WebElement payeeAddress;

    @FindBy(css = "input[id$='account']")
    public WebElement account;

    @FindBy(css = "input[id$='details']")
    public WebElement payeeDetails;

    @FindBy(css = "input[id$='payee']")
    public WebElement addBtn;

    @FindBy(css = "div[id$='content']")
    public WebElement successMsg;

    @FindBy(xpath = "//*[text() = 'Purchase Foreign Currency']")
    public WebElement foreignCurrency;

    @FindBy(css = "select[id$='currency']")
    public WebElement selectCurrency;

    @FindBy(css = "input[id='pc_amount']")
    public WebElement inputAmount;

    @FindBy(css = "input[id*='calculate']")
    public WebElement calculateCosts;

    
}
