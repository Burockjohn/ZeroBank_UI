package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement selectAccount;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(css = "input[id$='description']")
    public WebElement inputDescription;

    @FindBy(css = "input[id='aa_fromDate']")
    public WebElement inputFromDate;

    @FindBy(css = "input[id$='toDate']")
    public WebElement inputToDate;

    @FindBy(css = "input[id$='fromAmount']")
    public WebElement inputFromAmount;

    @FindBy(css = "input[id$='toAmount']")
    public WebElement inputToAmount;

    @FindBy(css = "select[id$='type']")
    public WebElement selectType;

    @FindBy(css = "button[class$='btn-primary']")
    public WebElement searchBtn;

    @FindBy(xpath = "//td[1]")
    public WebElement td;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> dates;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> descriptions;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> deposits;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> withdrawals;


    public static LocalDate convertStrToDate(String date) {
        String[] dates = date.split("[^0-9]");
        return LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
    }

}
