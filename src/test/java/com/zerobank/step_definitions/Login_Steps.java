package com.zerobank.step_definitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Steps {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login.url"));
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.userNameSection.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordSection.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        loginPage.signBtn.click();
        if (!Driver.getDriver().getCurrentUrl().contains("login"))
            Driver.getDriver().navigate().back();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        BrowserUtils.waitForTitleContains("Banking");
        String expectedUser = ConfigurationReader.getProperty("username");
        //System.out.println(expectedUser);
        String actualUser = basePage.userDropdown.getText();
        //System.out.println(actualUser);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @When("user enters {string} as username and {string} as password")
    public void user_enters_as_username_and_as_password(String username, String password) {
        loginPage.userNameSection.sendKeys(username);
        loginPage.passwordSection.sendKeys(password);
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String message) {
        String expected = message;
        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals(expected, actual);

    }

}
