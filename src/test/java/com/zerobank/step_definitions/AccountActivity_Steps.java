package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivity_Steps {
    HomePage homePage = new HomePage();
    OnlineBankingPage bankingPage = new OnlineBankingPage();
    AccountSummaryPage summaryPage = new AccountSummaryPage();
    AccountActivityPage activityPage = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_savings_link_on_the_account_summary_page(String link) {
        homePage.onlineBanking.click();
        bankingPage.accountSummary.click();
        summaryPage.clickLink(link);

    }

    @Then("the Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        String expectedTitle = "Account Activity";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_savings_selected(String option) {
        Select select = new Select(activityPage.selectAccount);
        String actualLink = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option, actualLink);
    }


}
