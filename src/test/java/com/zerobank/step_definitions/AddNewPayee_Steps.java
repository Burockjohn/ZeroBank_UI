package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayee_Steps {

    HomePage home = new HomePage();
    OnlineBankingPage onlineBankingPage = new OnlineBankingPage();
    PayBillsPage billsPage = new PayBillsPage();


    @When("user clicks Pay Bills link under Online Banking module")
    public void user_clicks_pay_bills_link_under_online_banking_module() {
        home.onlineBanking.click();
        onlineBankingPage.payBill.click();
    }

    @Given("Add New Payee tab")
    public void add_new_payee_tab() {
        billsPage.addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {
        for (String each : payeeInfo.keySet()) {
            Driver.getDriver().findElement(By.id("np_new_payee_"+each.replace("Payee ","").toLowerCase())).sendKeys(payeeInfo.get(each));
        }
        billsPage.addBtn.click();

    }

    @Then("message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, billsPage.successMsg.getText());
    }


}
