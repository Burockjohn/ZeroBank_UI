package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.HomePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class FindTransactions_Steps {

    HomePage homePage = new HomePage();

    AccountActivityPage activityPage = new AccountActivityPage();

    @When("user clicks Account Activity Page")
    public void user_clicks_account_activity_page() {
        homePage.accountActivityPageLink.click();
    }

    @When("user accesses the Find Transactions tab")
    public void user_accesses_the_find_transactions_tab() {
        activityPage.findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        activityPage.inputFromDate.clear();
        activityPage.inputFromDate.sendKeys(fromDate);
        activityPage.inputToDate.clear();
        activityPage.inputToDate.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() {
        activityPage.searchBtn.click();
        BrowserUtils.sleep(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        LocalDate firstDate = AccountActivityPage.convertStrToDate(fromDate);
        LocalDate lastDate = AccountActivityPage.convertStrToDate(toDate);

        for (WebElement each : activityPage.dates) {
            LocalDate current = AccountActivityPage.convertStrToDate(each.getText());
            Assert.assertTrue((current.isEqual(firstDate) || current.isAfter(firstDate)) && (current.isEqual(lastDate) || current.isBefore(lastDate)));
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        for (int i = 0; i < activityPage.dates.size() - 1; i++) {
            WebElement current = activityPage.dates.get(i);
            WebElement next = activityPage.dates.get(i + 1);
            Assert.assertTrue(AccountActivityPage.convertStrToDate(current.getText()).isAfter(AccountActivityPage.convertStrToDate(next.getText())));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        for (WebElement each : activityPage.dates) {
            Assert.assertFalse(each.getText().equalsIgnoreCase(date));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        activityPage.inputDescription.clear();
        activityPage.inputDescription.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        if (activityPage.descriptions.size() > 0) {
            for (WebElement each : activityPage.descriptions) {
                Assert.assertTrue(each.getText().contains(description));
            }
        } else {
            Assert.fail("No results");
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        for (WebElement each : activityPage.descriptions) {
            Assert.assertFalse(each.getText().contains(description));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_deposit() {
        boolean flag = false;
        for (WebElement each : activityPage.deposits) {
            if (!each.getText().isEmpty()) flag = true;
        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_withdrawal() {
        boolean flag = false;
        for (WebElement each : activityPage.withdrawals) {
            if (!each.getText().isEmpty()) flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select select = new Select(activityPage.selectType);
        select.selectByVisibleText(type);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_withdrawal() {
        boolean flag = true;
        for (WebElement each : activityPage.withdrawals) {
            if (!each.getText().isEmpty()) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        boolean flag = true;
        for (WebElement each : activityPage.deposits) {
            if (!each.getText().isEmpty()) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

}
