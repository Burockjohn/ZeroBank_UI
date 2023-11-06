package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ForeignCurrency_Steps {

    PayBillsPage billsPage = new PayBillsPage();

    @When("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {
        billsPage.foreignCurrency.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        Select select = new Select(billsPage.selectCurrency);
        List<String> actual = new ArrayList<>();
        for (WebElement each : select.getOptions()) {
            actual.add(each.getText());
        }

        for (String each : currencies) {
            Assert.assertTrue(actual.contains(each));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        billsPage.inputAmount.sendKeys("500");
        billsPage.calculateCosts.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertFalse(alert.getText().isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        billsPage.inputAmount.clear();
        Select select = new Select(billsPage.selectCurrency);
        select.selectByIndex(4);
        billsPage.calculateCosts.click();
    }

}
